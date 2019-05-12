package Figures;

public class Line extends Polyline{

    public Line(){}

    public Line(Point p){
        addPoint(p);
        addPoint(p);
    }

    public Line(Point a, Point b){
        addPoint(a);
        addPoint(b);
    }

    public void refreshShape(Point point){
        setRefrPoint(point);

        setFinishPoint(point);
    }

}
