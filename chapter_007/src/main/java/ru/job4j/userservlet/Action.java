package ru.job4j.userservlet;

interface Action {

    StoreAction type();

    enum StoreAction {

        ADD, UPDATE, DELETE
    }
}
