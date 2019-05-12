package Buttons;

import MouseListeners.TriangleMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Triangle extends BasicBtn {

    public Triangle(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
        setEngText("Triangle");
        setRusText("Треугольник");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new TriangleMouseListener(shapeDrawer));
            }
        });
    }
}
