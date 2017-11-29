package ru.job4j.checkmate;

public class OccupiedWayException extends RuntimeException {
    OccupiedWayException(){
        super("Cell is occupied");
    }
}
