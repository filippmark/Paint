package Buttons;

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

    public CreateFigureBtn(JFrame main, ShapeDrawer shapeDrawer){
        super(shapeDrawer);
        getBtn().setText("User figure");
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
                label.setText("Enter name of user figure:");

                JTextField textField = new JTextField(20);

                JButton buttonAdd = new JButton();
                buttonAdd.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = textField.getText();
                        if (!temp.equals("")) {
                            if ((figuresNames.size() == 0) || (figuresNames.indexOf(temp) == -1)) {
                                figuresNames.add(temp);
                                comboBox.addItem(temp);
                                UserFigure userFigure = new UserFigure(ShapeDrawer.getFigures() , temp);
                            } else {
                                JOptionPane.showMessageDialog(null, "Choose another name please!");
                            }
                        }
                    }
                });
                buttonAdd.setText("Add");

                JButton buttonDel = new JButton();
                buttonDel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String temp = textField.getText();
                        if(!temp.equals("")) {
                            if ((figuresNames.size() == 0) || (figuresNames.indexOf(temp) == -1)) {
                                JOptionPane.showMessageDialog(null, "Choose another name please!");
                            } else {
                                figuresNames.remove(temp);
                                comboBox.removeItem(temp);
                            }
                        }
                    }
                });
                buttonDel.setText("Delete");



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
}
