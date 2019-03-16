package Buttons;

import Figures.BasicFigure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ShapeDrawer extends JPanel {
    private ArrayList <BasicFigure> figures = new ArrayList<BasicFigure>();
    MouseAdapter lastListener = null;
    public ShapeDrawer(){
        setBackground(Color.BLACK);
    }

    private JButton undoButton = new JButton("Отмена");
    {
        undoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                removeLast();
            }
        });
    }

    public JButton getUndoButton(){
        return undoButton;
    }

    public void setMouseListener(MouseAdapter mouseAdapter) {
        this.removeMouseListener(lastListener);
        this.removeMouseMotionListener(lastListener);

        this.addMouseListener(mouseAdapter);
        this.addMouseMotionListener(mouseAdapter);

        lastListener = mouseAdapter;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (BasicFigure figure : figures){
            figure.draw(g);
        }
    }

    public void removeLast(){
        if (figures.size() > 0) {
            figures.remove(figures.size() - 1);
        }
        repaint();
    }

    public void addShape(BasicFigure f) {
        figures.add(f);
        repaint();
    }


}
