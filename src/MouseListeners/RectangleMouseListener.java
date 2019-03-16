package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.Line;
import Figures.Point;
import Figures.Rectangle;

import java.awt.event.MouseEvent;

public class RectangleMouseListener extends LineMouseListener {
    Rectangle rectangle;

    public RectangleMouseListener(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
    }
    public void mousePressed(MouseEvent e) {
        rectangle = new Rectangle(new Point(e), 1, 1);
        shapeDrawer.addShape(rectangle);
    }


    public void mouseDragged(MouseEvent e) {
        rectangle.refreshShape(new Point(e));
        shapeDrawer.removeLast();
        shapeDrawer.addShape(rectangle);
    }
}
