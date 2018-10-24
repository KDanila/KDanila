package ru.job4j.siteparsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

/**
 * HTMLParser class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class HTMLParser {
    /**
     * job offers set.
     */
    private Set<JobOffer> jobOfferSet = new HashSet<>();
    /**
     * properties of parsing.
     */
    private Properties properties = new Properties();
    /**
     * parsing state. while true parsing is going.
     */
    private boolean parsingState = true;
    /**
     * site to parse.
     */
    private String url;
    /**
     * databse.
     */
    private StoreSQL storeSQL;
    /**
     * data format from site.
     */
    private final SimpleDateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", new Locale("ru", "RU"));
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(HTMLParser.class);

    /**
     * Constructor.
     *
     * @param path     - properties settings.
     * @param storeSQL - database.
     */
    public HTMLParser(String path, StoreSQL storeSQL) {
        try {
            properties.load(new FileInputStream(path));
            this.storeSQL = storeSQL;
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.url = properties.getProperty("site.url");
    }

    /**
     * startParsing() method.
     * <p>
     * Checking last date from database and if it is lower then current parsing continue.
     */
    public void startParsing() {
        this.storeSQL.connectingToDB();
        Document doc = connectToSite(this.url);
        int counter = 1;
        Timestamp lastDate = this.storeSQL.getLastDate();
        if (lastDate == null) {
            lastDate = this.setInitialDate();
        }
        while (isNotBlankPage(doc) && parsingState) {
            parseSite(doc, lastDate);
            doc = connectToSite(this.url.concat(String.valueOf(counter++)));
        }
        insertJobOffersInDatabase();
    }

    /**
     * isNotBlankPage() method.
     * <p>
     * Checking page. The blank page has size = 18. At each site from 666 to up at sql.ru
     * are the moderator topic.
     *
     * @param document - jsoap document.
     * @return boolean - true if not blank.
     */
    private boolean isNotBlankPage(Document document) {
        Element table = document.select("table[class = forumTable]").first();
        Elements lines = table.select("tr");
        Elements line = lines.select("td");
        return line.size() == 18 ? false : true;
    }

    /**
     * parseSite() method.
     * <p>
     * parsing site by jsoub library.
     *
     * @param doc      - jsoup doc.
     * @param lastDate - last date from sql database.
     */
    private void parseSite(Document doc, Timestamp lastDate) {
        Element table = doc.select("table[class = forumTable]").first();
        Elements lines = table.select("tr");
        Elements line = lines.select("td");
        for (int i = 19; i < line.size() - 4; i = i + 6) {
            if (i % 6 != 0) {
                Timestamp ts = parseDate(line.get(i + 4).text());
                if (ts.compareTo(lastDate) <= 0) {
                    this.parsingState = false;
                    break;
                }
                String tempName = line.get(i).text().toLowerCase();
                if (tempName.contains("java")
                        && !tempName.contains("javascript")
                        && !tempName.contains("java script")) {
                    this.jobOfferSet.add(new JobOffer(line.get(i).text(),
                            line.get(i + 1).text(),
                            line.get(i + 2).text(),
                            Integer.valueOf(line.get(i + 3).text()),
                            ts));
                }
            }
        }
    }

    /**
     * insertJobOffersInDatabase() method.
     * <p>
     * from jobOfferSet ----> SQL database.
     */
    private void insertJobOffersInDatabase() {
        for (JobOffer jo : this.jobOfferSet) {
            try {
                storeSQL.insert(jo.getTheme(), jo.getAuthor(), jo.getAnswers(), jo.getViews(), jo.getDate());
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }

    /**
     * connectToSite() method.
     *
     * @param url - url.
     * @return json document.
     */
    private Document connectToSite(String url) {
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * override() method.
     *
     * @return String.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (JobOffer jobOffer : this.jobOfferSet) {
            sb.append(jobOffer.getTheme());
            sb.append("\t");
            sb.append(jobOffer.getDate());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Date To Current Year.
     *
     * @return Timestamp.
     */
    private Timestamp setInitialDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(LocalDate.now().getYear(), 0, 1, 0, 0, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * Parsing Date.
     *
     * @param date - job offer date from site.
     * @return timestamp.
     */
    public Timestamp parseDate(String date) {
        Calendar calendar = Calendar.getInstance();
        if (date.contains("сегодня")) {
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(9, 11)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(date.substring(12, 14)));
        } else if (date.contains("вчера")) {
            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(7, 9)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(date.substring(10, 12)));
        } else {
            try {
                calendar.setTime(format.parse(date));
            } catch (ParseException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * Inner Class.
     */
    static class JobOffer {

        /**
         * theme.
         */
        private final String theme;
        /**
         * author.
         */
        private final String author;
        /**
         * answers.
         */
        private final String answers;
        /**
         * views.
         */
        private final int views;
        /**
         * date.
         */
        private final Timestamp date;

        /**
         * Constructor.
         *
         * @param theme   - theme.
         * @param author  - author.
         * @param answers - answers.
         * @param views   - views.
         * @param date    - date.
         */
        JobOffer(String theme, String author, String answers, int views, Timestamp date) {
            this.theme = theme;
            this.author = author;
            this.answers = answers;
            this.views = views;
            this.date = date;
        }


        /**
         * Getter.
         *
         * @return theme.
         */
        public String getTheme() {
            return theme;
        }

        /**
         * Getter.
         *
         * @return author.
         */
        public String getAuthor() {
            return author;
        }

        /**
         * Getter.
         *
         * @return answers.
         */
        public String getAnswers() {
            return answers;
        }

        /**
         * Getter.
         *
         * @return views
         */
        public int getViews() {
            return views;
        }

        /**
         * Getter.
         *
         * @return timestamp.
         */
        public Timestamp getDate() {
            return date;
        }

        /**
         * equals() method.
         *
         * @param o - object.
         * @return boolean - equals.
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            JobOffer jobOffer = (JobOffer) o;
            return views == jobOffer.views
                    && Objects.equals(theme, jobOffer.theme)
                    && Objects.equals(author, jobOffer.author)
                    && Objects.equals(answers, jobOffer.answers)
                    && Objects.equals(date, jobOffer.date);
        }

        /**
         * hashCode().
         *
         * @return hash.
         */
        @Override
        public int hashCode() {
            return Objects.hash(theme, author, answers, views, date);
        }

        /**
         * override() method.
         *
         * @return String.
         */
        @Override
        public String toString() {
            return "author='" + author + '\''
                    + ", date='" + date + '\''
                    + '}';
        }

    }

}

/*
1. Реализовать модуль сборки анализа данных с sql.ru.
2. система должна использовать Jsoup для скачивания страницы.
3. Система должна запускаться раз в день.

Для этого нужно использовать библиотеку quartz.

<!-- https://mvnrepository.com/artifact/org.quartz-scheduler/quartz -->
<dependency>
    <groupId>org.quartz-scheduler</groupId>
    <artifactId>quartz</artifactId>
    <version>2.3.0</version>
</dependency>

Пример использования - http://www.quartz-scheduler.org/documentation/quartz-2.x/tutorials/tutorial-lesson-06.html

Для запуска раз в день нужно использовать cron exression - 0 0 12 * * ?

http://www.quartz-scheduler.org/documentation/quartz-2.x/tutorials/crontrigger.html


4. Система должна собирать данные только про вакансии java. учесть что JavaScript не подходит. как и Java Script.
5. Данные должны храниться в базе данных.
6. Учесть дубликаты.
7. Учитывать время последнего запуска. если это первый запуск. то нужно собрать все объявления с начало года.
8. в системе не должно быть вывода, либо ввода информации. все настройки должны быть в файле. app.properties.

https://docs.oracle.com/javase/tutorial/essential/environment/properties.html

В файл app.properties указываем. настройки к базе данных и периодичность запуска приложения.

jdbc.driver=..

jdbc.url=...

jdbc.username=...

jdbc.password=...

cron.time=...


9. для вывода нужной информации использовать логгер log4j.


<!-- https://mvnrepository.com/artifact/log4j/log4j -->
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>

https://logging.apache.org/log4j/2.0/manual/api.html

10. Пример запуска приложения.

java -jar SqlRuParser app.properties
 */