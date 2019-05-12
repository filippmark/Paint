package Figures;

public class Rectangle extends Polygon {

    public Rectangle(){}

    public Rectangle(Point topLeft, int width, int height){
        addPoint(new Point(topLeft.x, topLeft.y));
        addPoint(new Point(topLeft.x + width, topLeft.y));
        addPoint(new Point(topLeft.x + width, topLeft.y + height));
        addPoint(new Point(topLeft.x, topLeft.y + height));
    }

    public void refreshShape(Point point){
        setRefrPoint(point);

        setPoint(1, new Point(point.x, getPoints().get(0).y));
        setPoint(2, point);
        setPoint(3, new Point(getPoints().get(0).x, point.y));
    }
}
