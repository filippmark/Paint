package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.BasicFigure;

import java.awt.event.MouseAdapter;

public class FigureMouseListener extends MouseAdapter {
    protected boolean isDrawing;
    protected ShapeDrawer shapeDrawer;

    public FigureMouseListener(ShapeDrawer shapeDrawer){
        this.shapeDrawer = shapeDrawer;
    }


}
