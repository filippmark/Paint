package Figures;

public class Rectangle extends Polyline {
    public Rectangle(Point topLeft, int width, int height){
        addPoint(new Point(topLeft.x, topLeft.y));
        addPoint(new Point(topLeft.x + width, topLeft.y));
        addPoint(new Point(topLeft.x + width, topLeft.y + height));
        addPoint(new Point(topLeft.x, topLeft.y + height));
    }

    public void refreshShape(Point point){
        setPoint(1, new Point(point.x, points.get(0).y));
        setPoint(2, point);
        setPoint(3, new Point(points.get(0).x, point.y));
    }
}
