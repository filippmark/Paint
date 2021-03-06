package Figures;

import java.util.ArrayList;
import java.awt.*;

public class Polyline extends BasicFigure{
    private ArrayList<Point> points = new ArrayList<>();

    private Point refrPoint;

    public Polyline(){}

    public Point getRefrPoint() {
        return refrPoint;
    }

    @Override
    public void refreshShape(Point point) {

    }

    public void setRefrPoint(Point refrPoint) {
        this.refrPoint = refrPoint;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public int[] getXs(){
        return points.stream().mapToInt((s) -> s.x).toArray();
    }

    public int[] getYs() {
        return points.stream().mapToInt((s) -> s.y).toArray();
    }

    protected void setPoint(int i, Point newPoint){
        if (i < points.size()){
            points.set(i, newPoint);
        } else {
            if (i == points.size()){
                addPoint(newPoint);
            }
        }
    }

    public void setFinishPoint(Point point){
        if (points.size() < 2){
            addPoint(point);
        } else {
            setPoint(points.size() - 1, point);
        }
    }

    public void removeLastPoint(){
        if (points.size() > 0){
            points.remove(points.size() - 1);
        }
    }

    public void draw(Graphics g){
        g.setColor(getColor());
        g.drawPolyline(getXs(), getYs(), points.size());
    }

}
