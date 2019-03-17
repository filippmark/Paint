package Main;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import Buttons.*;
import Figures.Ellipse;
import Figures.Line;
import Figures.Rectangle;

public class Main extends JPanel{
    static ShapeDrawer shapeDrawer = new ShapeDrawer();


    public static void main(String[] args)
    {

        JFrame mainFrame = new JFrame("Paint 2.0");
        mainFrame.setVisible(true);
        mainFrame.setMinimumSize(new Dimension(800, 600));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        Container container = mainFrame.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel btnpanel = new JPanel();
        btnpanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        btnpanel.add(new LineBtn(shapeDrawer).getBtn());
        btnpanel.add(new RectangleBtn(shapeDrawer).getBtn());
        btnpanel.add(new Triangle(shapeDrawer).getBtn());
        btnpanel.add(new SquareBtn(shapeDrawer).getBtn());
        btnpanel.add(new EllipseBtn(shapeDrawer).getBtn());
        btnpanel.add(new CircleBtn(shapeDrawer).getBtn());
        btnpanel.add(shapeDrawer.getUndoButton());
        btnpanel.add(shapeDrawer.getClearButton());

        container.add(btnpanel, BorderLayout.NORTH);
        container.add(shapeDrawer,  BorderLayout.CENTER);
    }
}
