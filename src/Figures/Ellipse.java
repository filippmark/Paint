package Figures;

import java.awt.*;
import java.util.ArrayList;

public class Ellipse extends BasicFigure{
    private Point fixedPoint, movingPoint;

    private Point refrPoint;

    public void setFixedPoint(Point point){
        this.fixedPoint = point;
    }

    public Point getMovingPoint() {
        return movingPoint;
    }

    public void setMovingPoint(Point movingPoint) {
        this.movingPoint = movingPoint;
    }

    public Ellipse(){

    }

    public Ellipse(Point topLeft, int width, int height) {
        setFixedPoint(topLeft);
        setMovingPoint(new Point(topLeft.x + width, topLeft.y + height));
    }

    public Point getFixedPoint(){
        return this.fixedPoint;
    }

    protected Point getTopLeft(){
        int xMin = Math.min(getFixedPoint().x, getMovingPoint().x);
        int yMin = Math.min(getFixedPoint().y, getMovingPoint().y);

        return new Point(xMin, yMin);
    }

    public void refreshShape(Point point) {
        this.movingPoint = point;
    }

    protected Point getBottomRight(){
        int xMax = Math.max(getFixedPoint().x, getMovingPoint().x);
        int yMax = Math.max(getFixedPoint().y, getMovingPoint().y);

        return new Point(xMax, yMax);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());

        Point topLeft = getTopLeft();
        Point bottomRight = getBottomRight();

        g.drawOval(topLeft.x, topLeft.y, bottomRight.x - topLeft.x, bottomRight.y - topLeft.y);
    }

    @Override
    public ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<Point>();
        points.add(getTopLeft());
        return points;
    }

    @Override
    public void setRefrPoint(Point refrPoint) {
        this.refrPoint = refrPoint;
    }

    @Override
    public Point getRefrPoint() {
        return this.refrPoint;
    }
}
