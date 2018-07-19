package ru.job4j.Bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Board {
    private final ReentrantLock[][] board;

    public Board(int height, int weight) {
        this.board = new ReentrantLock[height][weight];
        initBoard(this.board);
    }

    private void initBoard(ReentrantLock[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
    }

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

    private boolean isCellExisting(Cell dist) {
        if (dist != null && dist.getX() >= 0 && dist.getX() < board.length && dist.getY() >= 0 && dist.getY() < board[0].length) {
            return true;
        }
        return false;
    }
}
