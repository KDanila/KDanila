package ru.job4j.siteparsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * HTMLParser class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class HTMLParser {

    //todo jsoap

    //todo read DOM

    public static void main(String[] args) throws IOException {
        String url = "http://www.sql.ru/forum/job-offers/";
        Document doc = Jsoup.connect(url).get();
        List<Line> lineClasses = new ArrayList<>();
        Element table = doc.select("table[class = forumTable]").first();
        Elements lines = table.select("tr");
        //System.out.println(lines);
        Elements line = lines.select("td");
        //  System.out.println(line);
        for (int i = 0; i < line.size() - 6; i++) {
            if (i % 6 != 0) {
                lineClasses.add(new Line(line.get(i).text(),
                        line.get(i+1).text(),
                        line.get(i+2).text(),
                        line.get(i+3).text(),
                        line.get(i+4).text()));
                i+=5;
                //System.out.println(line.get(i).text());
            }
        }
        lineClasses.forEach(System.out::println);
    }

    public void startParsing() {
/*        4. Система должна собирать данные только про вакансии java. учесть что JavaScript не подходит. как и Java Script.
        5. Данные должны храниться в базе данных.
        6. Учесть дубликаты.
        7. Учитывать время последнего запуска. если это первый запуск. то нужно собрать все объявления с начало года.
        8. в системе не должно быть вывода, либо ввода информации. все настройки должны быть в файле. app.properties.
*/
    }


    static class Line {
        @Override
        public String toString() {
            return "author='" + author + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }

        //Тема	Автор	Ответов	Просм.	Дата
        private final String theme;
        private final String author;
        private final String answers;
        private final String views;
        private final String date;

        public Line(String theme, String author, String answers, String views, String date) {
            this.theme = theme;
            this.author = author;
            this.answers = answers;
            this.views = views;
            this.date = date;
        }


        public String getTheme() {
            return theme;
        }

        public String getAuthor() {
            return author;
        }

        public String getAnswers() {
            return answers;
        }

        public String getViews() {
            return views;
        }

        public String getDate() {
            return date;
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