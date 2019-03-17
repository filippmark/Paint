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

    private JButton undoButton = new JButton("Remove last");
    {
        undoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                removeLast();
            }
        });
    }

    private JButton clearButton = new JButton("Remove all");
    {
        clearButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                removeAll();
            }
        });
    }

    public JButton getUndoButton(){
        return undoButton;
    }

    public JButton getClearButton() {
        return clearButton;
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

    public void removeAll(){
        if (figures.size() > 0)
            figures.clear();
        repaint();
    }


}
