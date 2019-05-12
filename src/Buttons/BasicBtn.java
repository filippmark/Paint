package Buttons;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class BasicBtn extends MouseAdapter {
    protected ShapeDrawer shapeDrawer;
    private JButton btn = new JButton();
    private String engText;
    private String rusText;

    public String getEngText() {
        return engText;
    }

    public String getRusText() {
        return rusText;
    }

    public void setRusText(String rusText) {
        this.rusText = rusText;
    }

    public void setEngText(String engText) {
        this.engText = engText;
    }

    public BasicBtn(){}

    public BasicBtn(ShapeDrawer shapeDrawer){ this.shapeDrawer = shapeDrawer;}

    public JButton getBtn(){
        return this.btn;
    }

    public void setLanguage(boolean flag){
        getBtn().setText(shapeDrawer.getLanguage()? engText: rusText);
    }

}
