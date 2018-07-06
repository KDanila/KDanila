package ru.job4j.pingpong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Pin Pong class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class PingPong extends Application {
    /**
     * Title name.
     */
    private static final String JOB4J = "Пинг-понг www.job4j.ru";

    /**
     * Start method.
     *
     * @param stage - stage.
     */
    @Override
    public void start(Stage stage) {
        int limitX = 500;
        int limitY = 300;
        Group group = new Group();
        Rectangle rect = new Rectangle(250, 100, 10, 10);
        Rectangle player1 = new Rectangle(50, 150, 10, 50);
        Rectangle player2 = new Rectangle(450, 150, 10, 50);
        group.getChildren().add(rect);
        group.getChildren().add(player1);
        group.getChildren().add(player2);
        Scene scene = new Scene(group, limitX, limitY);
        RectangleMove rectangleMove = new RectangleMove(rect, player1, player2);
        Thread rectangleThread = new Thread(rectangleMove);
        rectangleThread.start();
        //Thread playersThread = new Thread(new PlayerMove(player1, player2, scene));
        // playersThread.start();
        stage.setScene(scene);
        stage.setTitle(JOB4J);
        stage.setResizable(false);
        stage.setOnCloseRequest(
                event -> rectangleThread.interrupt());
        stage.show();
    }
}
