package Figures;

import java.awt.event.MouseEvent;

public class Point{
    public int x, y;

    public  Point(){}

    public  Point(int x, int y){
        this.x  = x;
        this.y  = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public  Point(MouseEvent event){
        this.x = event.getX();
        this.y = event.getY();
    }
}
