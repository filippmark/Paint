package Buttons;

import MouseListeners.CircleMouseListener;
import MouseListeners.EllipseMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircleBtn extends BasicBtn{
    public CircleBtn(ShapeDrawer shapeDrawer){
        super(shapeDrawer);
        getBtn().setText("Circle");
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new CircleMouseListener(shapeDrawer));
            }
        });
    }
}
