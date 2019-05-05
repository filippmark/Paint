package Main;

import Buttons.*;
import Figures.UserFigure;
import MouseListeners.UserFigureMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        CreateFigureBtn createFigureBtn = new CreateFigureBtn(mainFrame, shapeDrawer);
        ComboBoxListener comboBoxListener = new ComboBoxListener(createFigureBtn, shapeDrawer);
        btnPanel.add(createFigureBtn.getBtn());
        comboBox.addActionListener(comboBoxListener);
        btnPanel.add(comboBox);

        container.add(btnPanel, BorderLayout.NORTH);
        container.add(shapeDrawer,  BorderLayout.CENTER);
    }
}

class ComboBoxListener implements ActionListener{
    ShapeDrawer shapeDrawer;
    CreateFigureBtn createFigureBtn;

    public ComboBoxListener(CreateFigureBtn createFigureBtn, ShapeDrawer shapeDrawer){
        this.shapeDrawer = shapeDrawer;
        this.createFigureBtn = createFigureBtn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox box = (JComboBox) e.getSource();
        String item = (String)box.getSelectedItem();
        UserFigure userFigure = createFigureBtn.getUserFigures().get(createFigureBtn.getFiguresNames().indexOf(item));
        shapeDrawer.setMouseListener(new UserFigureMouseListener(shapeDrawer, userFigure));
    }
}