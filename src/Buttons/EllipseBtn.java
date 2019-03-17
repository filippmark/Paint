package Buttons;

import Figures.BasicFigure;
import MouseListeners.EllipseMouseListener;
import MouseListeners.LineMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EllipseBtn extends BasicBtn{
    public EllipseBtn(ShapeDrawer shapeDrawer){
        super(shapeDrawer);
        getBtn().setText("Ellipse");
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new EllipseMouseListener(shapeDrawer));
            }
        });
   }
}
