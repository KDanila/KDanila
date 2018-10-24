package ru.job4j.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Board class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class Board {
    /**
     * board.
     */
    private final ReentrantLock[][] board;

    /**
     * Constructor.
     *
     * @param height - height.
     * @param weight - weight.
     */
    public Board(int height, int weight) {
        this.board = new ReentrantLock[height][weight];
        initBoard(this.board);
    }

    /**
     * initBoard method().
     *
     * @param board - board.
     */
    private void initBoard(ReentrantLock[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

    /**
     * move() method.
     *
     * @param source - cell.
     * @param dist   - cell.
     * @return boolean - true if move was doing.
     */
    boolean move(Cell source, Cell dist) {
        boolean isMove = false;
        if (isCellExisting(dist)) {
            try {
                if (board[dist.getX()][dist.getY()].tryLock(500, TimeUnit.MILLISECONDS)) {
                    try {
                        isMove = true;
                        board[dist.getX()][dist.getY()].lock();
                    } finally {
                        board[source.getX()][source.getY()].unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return isMove;
    }

    /**
     * isCellExisting method().
     *
     * @param dist - cell.
     * @return boolean - true if exist.
     */
    private boolean isCellExisting(Cell dist) {
        if (dist != null && dist.getX() >= 0 && dist.getX() < board.length && dist.getY() >= 0 && dist.getY() < board[0].length) {
            return true;
        }
        return false;
    }
}
