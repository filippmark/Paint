package Buttons;

import Figures.BasicFigure;
import Figures.UserFigure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Main.Main.comboBox;

public class CreateFigureBtn extends BasicBtn{
    private ArrayList<String> figuresNames = new ArrayList<String>();
    private ArrayList<UserFigure> userFigures = new ArrayList<UserFigure>();

    public CreateFigureBtn(){

    }
    public CreateFigureBtn(JFrame main, ShapeDrawer shapeDrawer){
        super(shapeDrawer);
        setEngText("User figure");
        setRusText("Пользовательская фигура");
        setLanguage(shapeDrawer.getLanguage());
        getBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(main, "dialog");
                dialog.setSize(new Dimension(370, 100));
                dialog.setVisible(true);
                Container container = dialog.getContentPane();
                container.setLayout(new BorderLayout());


                JPanel panel = new JPanel();
                panel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));


                JLabel label = new JLabel();
                label.setText(shapeDrawer.getLanguage()?"Enter name of user figure:":"Введите имя фигуры:");

                JTextField textField = new JTextField(20);

                JButton buttonAdd = new JButton();
                buttonAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = textField.getText();
                        if (!temp.equals("")) {
                            if ((figuresNames.size() == 0) || (figuresNames.indexOf(temp) == -1)) {
                                figuresNames.add(temp);
                                ArrayList<BasicFigure> figures = new ArrayList<BasicFigure>();
                                for(int j = 0; j < ShapeDrawer.getFigures().size(); j++)
                                    figures.add(ShapeDrawer.getFigures().get(j).clone());
                                UserFigure userFigure = new UserFigure(figures, temp);
                                userFigures.add(userFigure);
                                comboBox.addItem(temp);
                            } else {
                                JOptionPane.showMessageDialog(null, shapeDrawer.getLanguage()?"Choose another name please!": "Выберите другое имя фигуры!");
                            }
                        }
                    }
                });
                buttonAdd.setText(shapeDrawer.getLanguage()? "Add" : "Добавить");

                JButton buttonDel = new JButton();
                buttonDel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = textField.getText();
                        if(!temp.equals("")) {
                            if ((figuresNames.size() == 0) || (figuresNames.indexOf(temp) == -1)) {
                                JOptionPane.showMessageDialog(null, shapeDrawer.getLanguage()?"Choose another name please!": "Выберите другое имя фигуры!");
                            } else {
                                userFigures.remove(figuresNames.indexOf(temp));
                                figuresNames.remove(temp);
                                comboBox.removeItem(temp);
                            }
                        }
                    }
                });
                buttonDel.setText(shapeDrawer.getLanguage()? "Delete" : "Удалить");



                panel.add(label);
                panel.add(textField);

                JPanel btnPanel = new JPanel();
                btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
                btnPanel.add(buttonAdd);
                btnPanel.add(buttonDel);

                container.add(panel, BorderLayout.NORTH);
                container.add(btnPanel, BorderLayout.SOUTH);
            }
        });
    }

    public ArrayList<UserFigure> getUserFigures(){
        return this.userFigures;
    }

    public ArrayList<String> getFiguresNames() {
        return figuresNames;
    }

    public void setFiguresNames(ArrayList<String> figuresNames) {
        this.figuresNames = figuresNames;
        for (String  item: figuresNames) {
            comboBox.addItem(item);
        }
    }

    public void setUserFigures(ArrayList<UserFigure> userFigures) {
        this.userFigures = userFigures;
    }
}
