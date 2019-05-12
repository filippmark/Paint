package Figures;

import java.awt.*;
import java.util.ArrayList;

public abstract class BasicFigure implements Cloneable{
    private Color color = Color.GREEN;

    private int distanceX;

    private int getDistanceY;

    private int deltaX;

    private int deltaY;

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public int getDistanceX() {
        return distanceX;
    }

    public void setDistanceX(int distanceX) {
        this.distanceX = distanceX;
    }

    public void setDistanceY(int getDistanceY) {
        this.getDistanceY = getDistanceY;

    }

    public int getDistanceY() {
        return getDistanceY;
    }

    public BasicFigure clone(){
        try {
            return (BasicFigure) super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public abstract ArrayList<Point> getPoints();

    public abstract void setRefrPoint(Point refrPoint);

    public abstract Point getRefrPoint();

    public abstract void refreshShape(Point point);

}
