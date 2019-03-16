package Buttons;

import Figures.BasicFigure;
import Figures.Line;
import Figures.Point;
import MouseListeners.LineMouseListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class LineBtn extends BasicBtn {
    public  LineBtn(ShapeDrawer shapeDrawer){
        super(shapeDrawer);
        getBtn().setText("Line");
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new LineMouseListener(shapeDrawer));
            }
        });
    }
}
