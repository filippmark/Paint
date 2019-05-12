package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.Circle;
import Figures.Point;

import java.awt.event.MouseEvent;

public class CircleMouseListener extends FigureMouseListener{
    Circle circle;

    public  CircleMouseListener(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
    }

    public void mousePressed(MouseEvent e) {
        circle = new Circle(new Point(e), 3);
        shapeDrawer.addShape(circle);
    }


    public void mouseDragged(MouseEvent e) {
        Point point = new Point(e);
        circle.refreshShape(point);
        circle.setRefrPoint(point);
        shapeDrawer.removeLast();
        shapeDrawer.addShape(circle);
    }

}
