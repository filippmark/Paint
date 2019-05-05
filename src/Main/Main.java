package Main;

import Buttons.*;

import javax.swing.*;
import java.awt.*;

public class Main{
    static ShapeDrawer shapeDrawer = new ShapeDrawer();
    public static JComboBox comboBox = new JComboBox();

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Paint 2.0");
        mainFrame.setVisible(true);
        mainFrame.setMinimumSize(new Dimension(1000, 600));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        Container container = mainFrame.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        btnPanel.add(new LineBtn(shapeDrawer).getBtn());
        btnPanel.add(new RectangleBtn(shapeDrawer).getBtn());
        btnPanel.add(new Triangle(shapeDrawer).getBtn());
        btnPanel.add(new SquareBtn(shapeDrawer).getBtn());
        btnPanel.add(new EllipseBtn(shapeDrawer).getBtn());
        btnPanel.add(new CircleBtn(shapeDrawer).getBtn());
        btnPanel.add(shapeDrawer.getUndoButton());
        btnPanel.add(shapeDrawer.getClearButton());
        btnPanel.add(new CreateFigureBtn(mainFrame, shapeDrawer).getBtn());
        btnPanel.add(comboBox);

        container.add(btnPanel, BorderLayout.NORTH);
        container.add(shapeDrawer,  BorderLayout.CENTER);
    }
}
