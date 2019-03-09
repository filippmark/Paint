package Figures;

import java.awt.event.MouseEvent;

public class Point extends BasicFigure{
    public int x, y;

    public void Point(){}

    public void Point(int x, int y){
        this.x  = x;
        this.y  = y;
    }

    public void Point(MouseEvent event){
        this.x = event.getX();
        this.y = event.getY();
    }
}
