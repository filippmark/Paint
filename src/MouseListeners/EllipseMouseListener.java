package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.Ellipse;
import Figures.Point;

import java.awt.event.MouseEvent;

public class EllipseMouseListener extends FigureMouseListener {
    Ellipse ellipse;

    public  EllipseMouseListener(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
    }

    public void mousePressed(MouseEvent e) {
        ellipse = new Ellipse(new Point(e), 2, 1);
        shapeDrawer.addShape(ellipse);
    }


    public void mouseDragged(MouseEvent e) {
        ellipse.refreshShape(new Point(e));
        ellipse.setRefrPoint(new Point(e));
        shapeDrawer.removeLast();
        shapeDrawer.addShape(ellipse);
    }

}
