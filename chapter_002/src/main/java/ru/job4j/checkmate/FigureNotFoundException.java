package ru.job4j.checkmate;

public class FigureNotFoundException extends RuntimeException {
    FigureNotFoundException() {
        super("Figure not found");
    }
}

