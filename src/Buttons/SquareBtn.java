package Buttons;

import MouseListeners.SquareMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SquareBtn extends BasicBtn{
    public SquareBtn(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
        setEngText("Square");
        setRusText("Квадрат");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new SquareMouseListener(shapeDrawer));
            }
        });
    }
}