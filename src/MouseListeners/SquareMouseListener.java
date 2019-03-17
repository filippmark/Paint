package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.Point;
import Figures.Rectangle;
import Figures.Square;

import java.awt.event.MouseEvent;

public class SquareMouseListener extends FigureMouseListener{
    Square square;

    public SquareMouseListener(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
    }
    public void mousePressed(MouseEvent e) {
        square = new Square(new Point(e), 2);
        shapeDrawer.addShape(square);
    }


    public void mouseDragged(MouseEvent e) {
        square.refreshShape(new Point(e));
        shapeDrawer.removeLast();
        shapeDrawer.addShape(square);
    }
}
