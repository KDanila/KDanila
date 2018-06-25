package ru.job4j.pingpong;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

/**
 * Player move class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class PlayerMove implements Runnable {
    /**
     * rectangle.
     */
    private final Rectangle player1;
    /**
     * rectangle.
     */
    private final Rectangle player2;
    /**
     * Scene.
     */
    private final Scene scene;

    /**
     * Constructor.
     *
     * @param player1 - rectangle.
     * @param player2 - rectangle.
     * @param scene   -scene.
     */
    public PlayerMove(Rectangle player1, Rectangle player2, Scene scene) {
        this.player1 = player1;
        this.player2 = player2;
        this.scene = scene;
    }

    /**
     * run method.
     */
    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                break;
            }
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    switch (event.getCode()) {
                        case UP:
                            player1.setY(player1.getY() - 10);
                            break;
                        case DOWN:
                            player1.setY(player1.getY() + 10);
                            break;
                        case W:
                            player2.setY(player2.getY() - 10);
                            break;
                        case S:
                            player2.setY(player2.getY() + 10);
                            break;
                        default:
                            break;
                    }
                }
            });
        }

    }
}
