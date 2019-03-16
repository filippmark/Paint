package Buttons;

import MouseListeners.RectangleMouseListener;
import MouseListeners.TriangleMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Triangle extends BasicBtn {

    public Triangle(ShapeDrawer shapeDrawer) {
        super(shapeDrawer);
        getBtn().setText("Triangle");
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new TriangleMouseListener(shapeDrawer));
            }
        });
    }
}
