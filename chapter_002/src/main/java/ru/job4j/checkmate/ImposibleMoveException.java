package ru.job4j.checkmate;

public class ImposibleMoveException extends RuntimeException {
    ImposibleMoveException(){
        super("Imposible move");
    }
}
