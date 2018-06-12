package ru.job4j.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        boolean directionX = true;
        boolean directionY = true;
        while (true) {
            if (directionX && directionY) {
                this.rect.setX(this.rect.getX() + 1);
                this.rect.setY(this.rect.getY() + 1);

            } else if (directionX && !directionY) {
                this.rect.setX(this.rect.getX() + 1);
                this.rect.setY(this.rect.getY() - 1);
            } else if (!directionX && directionY) {
                this.rect.setX(this.rect.getX() - 1);
                this.rect.setY(this.rect.getY() + 1);
            } else if (!directionX && !directionY) {
                this.rect.setX(this.rect.getX() - 1);
                this.rect.setY(this.rect.getY() - 1);
            }
            directionX = checkDirection(this.rect.getX(), directionX);
            directionY = checkDirection(this.rect.getY(), directionY);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean checkDirection(double x, boolean directionX) {
        boolean direction = directionX;
        if (x > 300 || x < 0) {
            direction = !directionX;
        }
        return direction;
    }
}



