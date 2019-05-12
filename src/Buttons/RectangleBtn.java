package Buttons;

import MouseListeners.RectangleMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectangleBtn extends BasicBtn{
    public RectangleBtn(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
        setEngText("Rectangle");
        setRusText("Прямоугольник");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new RectangleMouseListener(shapeDrawer));
            }
        });
    }
}
