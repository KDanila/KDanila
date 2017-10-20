package ru.job4j.loop;

public class Board {
    public String paint(int width, int height){
        StringBuilder text=null;
        boolean change =false;
        for (int i = 0; i <width ; i++) {
            for (int j = 0; j <height ; j++) {
                String n=(change)?"x":" ";
                change=!change;
                text.append(n);
            }
            text.append("\n");
        }
        return text.toString();
    }
}
