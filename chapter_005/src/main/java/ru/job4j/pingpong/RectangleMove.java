package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * Rectangle move class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class RectangleMove implements Runnable {
    /**
     * rectangle.
     */
    private final Rectangle rect;
    /**
     * rectangle.
     */
    private final Rectangle player;
    /**
     * rectangle.
     */
    private final Rectangle player2;

    /**
     * @param rectangle - rectangle.
     * @param player1 - rectangle.
     * @param player2 - rectangle.
     */

    public RectangleMove(Rectangle rectangle, Rectangle player1, Rectangle player2) {
        this.rect = rectangle;
        this.player = player1;
        this.player2 = player2;

    }

    /**
     * run method.
     */
    @Override
    public void run() {
        boolean directionX = true;
        boolean directionY = true;
        double movementSpeedX = 5;
        double movementSpeedY = 5;
        while (true) {
            if (directionX && directionY) {
                this.rect.setX(this.rect.getX() + movementSpeedX);
                this.rect.setY(this.rect.getY() + movementSpeedY);
            } else if (directionX && !directionY) {
                this.rect.setX(this.rect.getX() + movementSpeedX);
                this.rect.setY(this.rect.getY() - movementSpeedY);
            } else if (!directionX && directionY) {
                this.rect.setX(this.rect.getX() - movementSpeedX);
                this.rect.setY(this.rect.getY() + movementSpeedY);
            } else if (!directionX && !directionY) {
                this.rect.setX(this.rect.getX() - movementSpeedX);
                this.rect.setY(this.rect.getY() - movementSpeedY);
            }
            directionX = checkDirectionX(this.rect.getX(), directionX);
            directionY = checkDirectionY(this.rect.getY(), directionY);
            if (checkContactWithPlayer1() || checkContactWithPlayer2()) {
                directionX = !directionX;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * Проверяем на соприкосновение с игроком 1.
     * @return true - if contact present.
     */
    private boolean checkContactWithPlayer1() {
        boolean isContact = false;
        double x1 = player.getX() + player.getWidth();
        double x2 = rect.getX();
        double y1 = player.getY();
        double y2 = player.getY() + player.getHeight();
        double y3 = rect.getY();
        double y4 = rect.getY() + rect.getHeight();
        if (y1 <= y4 && y2 >= y3 && x1 >= x2) {
            isContact = true;
        }
        return isContact;
    }

    /**
     * Проверяем на соприкосновение с игроком 2.
     * @return true - if contact present.
     */
    private boolean checkContactWithPlayer2() {
        boolean isContact = false;
        double x1 = rect.getX() + rect.getWidth();
        double x2 = player2.getX();
        double y1 = rect.getY();
        double y2 = rect.getY() + rect.getHeight();
        double y3 = player2.getY();
        double y4 = player2.getY() + player2.getHeight();
        if (y1 <= y4 && y2 >= y3 && x1 >= x2) {
            isContact = true;
        }
        return isContact;
    }


    /**
     * check direction method.
     *
     * @param x          - coordinate
     * @param directionX - direction.
     * @return - boolean true if in bandth.
     */
    private boolean checkDirectionX(double x, boolean directionX) {
        boolean direction = directionX;
        if (x > 500 || x < 0) {
            direction = !directionX;
        }
        return direction;
    }

    /**
     * check direction method.
     *
     * @param y          - coordinate
     * @param directionY - direction.
     * @return - boolean true if in bandth.
     */
    private boolean checkDirectionY(double y, boolean directionY) {
        boolean direction = directionY;
        if (y > 300 || y < 0) {
            direction = !directionY;
        }
        return direction;
    }
}



