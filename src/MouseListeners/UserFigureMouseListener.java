package MouseListeners;

import Buttons.ShapeDrawer;
import Figures.UserFigure;

import java.awt.event.MouseEvent;

public class UserFigureMouseListener extends FigureMouseListener{
    UserFigure userFigure;


    public UserFigureMouseListener(ShapeDrawer shapeDrawer, UserFigure userFigure) {
        super(shapeDrawer);
        this.userFigure = userFigure;
    }

    public void mousePressed(MouseEvent e) {
        /*ArrayList<BasicFigure> figures = userFigure.getFigures();
        for (int i = 0; i < figures.size(); i++) {
            shapeDrawer.addShape(figures.get(i));
        }*/
        shapeDrawer.addShape(userFigure);
    }

}
