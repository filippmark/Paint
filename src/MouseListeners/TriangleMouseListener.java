package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.Point;
import Figures.Rectangle;
import Figures.Triangle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TriangleMouseListener extends FigureMouseListener {
    Triangle triangle;

    public TriangleMouseListener(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
    }
    public void mousePressed(MouseEvent e) {
        triangle = new Triangle(new Point(e), new Point(e));
        shapeDrawer.addShape(triangle);
    }


    public void mouseDragged(MouseEvent e) {
        triangle.refreshShape(new Point(e));
        shapeDrawer.removeLast();
        shapeDrawer.addShape(triangle);
    }

}
