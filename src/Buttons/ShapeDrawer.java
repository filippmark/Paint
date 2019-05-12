package Buttons;

import Figures.BasicFigure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class ShapeDrawer extends JPanel {
    private static ArrayList <BasicFigure> figures = new ArrayList<BasicFigure>();
    MouseAdapter lastListener = null;
    private boolean language = false;
    public ShapeDrawer(){
        setBackground(Color.BLACK);
    }

    public void setLanguage(boolean language) {
        this.language = language;
        undoButton.setText(language?"Remove last": "Убрать последнюю");
        clearButton.setText(language?"Remove all": "Убрать всё");
    }

    public boolean getLanguage() {
        return language;
    }

    private JButton undoButton = new JButton(language?"Remove last": "Убрать последнюю");
    {
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeLast();
                repaint();
            }
        });

    }

    private JButton clearButton = new JButton(language?"Remove all": "Убрать всё");
    {
        clearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                repaint();
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

    public BasicFigure removeLast(){
        if (figures.size() > 0) {
            return figures.remove(figures.size() - 1);
        }
        repaint();
        return null;
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

    public static ArrayList <BasicFigure> getFigures(){
        return figures;
    }

}
