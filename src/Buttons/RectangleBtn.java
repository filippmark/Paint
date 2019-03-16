package Buttons;

import Figures.BasicFigure;
import Figures.Rectangle;
import MouseListeners.LineMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectangleBtn extends BasicBtn{
    public RectangleBtn(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
        getBtn().setText("Rectangle");
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new RectangleMouseListener(shapeDrawer));
            }
        });
    }
}
