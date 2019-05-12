package Buttons;

import MouseListeners.LineMouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LineBtn extends BasicBtn {
    public  LineBtn(ShapeDrawer shapeDrawer){
        super(shapeDrawer);
        setEngText("Line");
        setRusText("Линия");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapeDrawer.setMouseListener(new LineMouseListener(shapeDrawer));
            }
        });
    }
}
