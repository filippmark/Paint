package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.Line;
import Figures.Point;

import java.awt.event.MouseEvent;

public class LineMouseListener extends  FigureMouseListener{
    Line line;

    public LineMouseListener(ShapeDrawer shapeDrawer){
        super(shapeDrawer);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        line = new Line(new Point(e));
        shapeDrawer.addShape(line);
    }


    public void mouseDragged(MouseEvent e) {
        line.refreshShape(new Point(e));
        line.setRefrPoint(new Point(e));
        shapeDrawer.removeLast();
        shapeDrawer.addShape(line);
    }
}
