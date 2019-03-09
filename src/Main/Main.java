package Main;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel{

    public static void main(String[] args)
    {
        JFrame mainFrame = new JFrame("Paint 2.0");
        mainFrame.setVisible(true);
        mainFrame.setMinimumSize(new Dimension(800, 600));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

        JPanel btnpanel = new JPanel();
        btnpanel.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
        btnpanel.add(new JButton("knopka1"));
        mainFrame.setContentPane(btnpanel);

    }
}
