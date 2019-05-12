package Buttons;

import MouseListeners.EllipseMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EllipseBtn extends BasicBtn{
    public EllipseBtn(ShapeDrawer shapeDrawer){
        super(shapeDrawer);
        setEngText("Ellipse");
        setRusText("Эллипс");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new EllipseMouseListener(shapeDrawer));
            }
        });
   }
}
