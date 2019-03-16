package Buttons;

import Figures.BasicFigure;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasicBtn extends MouseAdapter {
    protected ShapeDrawer shapeDrawer;
    private JButton btn = new JButton();

    public BasicBtn(ShapeDrawer shapeDrawer){ this.shapeDrawer = shapeDrawer;}

    public JButton getBtn(){
        return this.btn;
    }

}
