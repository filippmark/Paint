package Main;

import Buttons.*;
import Figures.BasicFigure;
import Figures.UserFigure;
import ModuleLoader.ModuleLoader;
import ModuleLoader.Module;
import MouseListeners.UserFigureMouseListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class Main{
    static ShapeDrawer shapeDrawer = new ShapeDrawer();
    public static JComboBox comboBox = new JComboBox();
    public static JComboBox chColor = new JComboBox();

    public static void main(String[] args) {

        JFrame mainFrame = new JFrame("Paint 2.0");
        mainFrame.setVisible(true);
        mainFrame.setMinimumSize(new Dimension(1000, 600));
        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(mainFrame.DO_NOTHING_ON_CLOSE);
        Container container = mainFrame.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel btnPanel = new JPanel();


        JScrollPane scrollPane = new JScrollPane(btnPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(50, 30, 300, 50);
        JPanel contentPane = new JPanel();
        contentPane.add(scrollPane);

        container.add(contentPane, BorderLayout.NORTH);
        container.add(shapeDrawer,  BorderLayout.CENTER);

        mainFrame.repaint();
        mainFrame.revalidate();

        btnPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        ArrayList <BasicBtn> btns = new ArrayList<BasicBtn>();
        btns.add(new LineBtn(shapeDrawer));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        btns.add(new RectangleBtn(shapeDrawer));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        btns.add(new Triangle(shapeDrawer));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        btns.add(new SquareBtn(shapeDrawer));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        btns.add(new EllipseBtn(shapeDrawer));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        btns.add(new CircleBtn(shapeDrawer));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        btnPanel.add(shapeDrawer.getUndoButton());
        btnPanel.add(shapeDrawer.getClearButton());
        CreateFigureBtn createFigureBtn = new CreateFigureBtn(mainFrame, shapeDrawer);
        btns.add(createFigureBtn);


        String path = "C:\\Users\\lenovo\\Desktop\\4 сем\\ООП\\ЛР1\\plugins\\";
        ModuleLoader moduleLoader = new ModuleLoader(path,
                ClassLoader.getSystemClassLoader());
        File dir = new File(path);
        String[] modules = dir.list();

        Module infoBtn = null;
        try{
            Class clazz = moduleLoader.loadClass("InfoBtn");
            infoBtn = (Module) clazz.newInstance();
            infoBtn.load();
            btnPanel.add(infoBtn.getJButton());
        }catch (Exception exp){
            exp.printStackTrace();
        }

        btns.add(new ChangeLangBtn(shapeDrawer, btns));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        btns.add(new OpenSettings(shapeDrawer, (ChangeLangBtn) btns.get(btns.size() - 1), infoBtn));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        btns.add(new SaveSettings(shapeDrawer, infoBtn));
        btnPanel.add(btns.get(btns.size() - 1).getBtn());
        mainFrame.addWindowListener(new WindLsnr(createFigureBtn));
        ComboBoxListener comboBoxListener = new ComboBoxListener(createFigureBtn, shapeDrawer);
        btnPanel.add(createFigureBtn.getBtn());
        comboBox.addActionListener(comboBoxListener);
        btnPanel.add(comboBox);
        ChangeColorCB changeColorCB = new ChangeColorCB(chColor, shapeDrawer);
        chColor.addActionListener(changeColorCB);
        btnPanel.add(chColor);

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
        UserFigure uF = new UserFigure(new ArrayList<BasicFigure>(userFigure.getFigures()), userFigure.getName());
        shapeDrawer.setMouseListener(new UserFigureMouseListener(shapeDrawer, uF));
    }
}

class ChangeColorCB implements ActionListener{
    ArrayList<ColorAndName> colors = new ArrayList<ColorAndName>();
    ArrayList<String> names = new ArrayList<String>();
    JComboBox chColor;
    ShapeDrawer shapeDrawer;

    public ChangeColorCB(JComboBox chColor, ShapeDrawer shapeDrawer){
        this.chColor = chColor;
        this.shapeDrawer = shapeDrawer;
        names.add("black");
        colors.add(new ColorAndName(Color.BLACK, "black"));
        names.add("blue");
        colors.add(new ColorAndName(Color.BLUE, "blue"));
        names.add("red");
        colors.add(new ColorAndName(Color.red, "red"));
        for(int i = 0; i < names.size(); i++)
            chColor.addItem(names.get(i));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox box = (JComboBox) e.getSource();
        String item = (String)box.getSelectedItem();
        shapeDrawer.setBackground(colors.get(names.indexOf(item)).getColor());
    }
}

class ColorAndName{
    public Color color;
    public String name;

    public ColorAndName(Color color, String name){
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}



class WindLsnr implements WindowListener{
    CreateFigureBtn createFigureBtn;

    public WindLsnr(CreateFigureBtn createFigureBtn){
        this.createFigureBtn = createFigureBtn;
        try {
            File file = new File("Figure.xml");
            if(file.exists()){
                XMLDecoder d = new XMLDecoder(
                        new BufferedInputStream(
                                new FileInputStream("Figure.xml")));
                CreateFigureBtn result = (CreateFigureBtn) d.readObject();
                createFigureBtn.setUserFigures(result.getUserFigures());
                createFigureBtn.setFiguresNames(result.getFiguresNames());
                d.close();
            }
        }catch (Exception exp){
            exp.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream("Figure.xml")));
            encoder.writeObject(createFigureBtn);
            encoder.close();

        }catch (Exception exp){
            exp.printStackTrace();
        }
        e.getWindow().setVisible(false);
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}