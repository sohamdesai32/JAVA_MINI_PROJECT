package Mini_Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home_page implements ActionListener{
String name;
    JFrame frame;
    JPanel panel;
    JLabel label;
    JMenuBar menuBar;
    JMenu menu,menu2,menu3;
    JMenuItem m1, m2, m3;

    Home_page(String name) {
        this.name = name;
//        ImageIcon ic = new ImageIcon("C\\Users\\soham\\Downloads\\electricity_Reuters_0_1200x768(1).jpg");
//        Image i = ic.getImage();
//        Image newi = i.getScaledInstance(500, 450, java.awt.Image.SCALE_SMOOTH);
//        ImageIcon ic1 = new ImageIcon(newi);
//        JLabel l = new JLabel(ic1);
//        l.setVisible(true);
//        frame.add(l);

        frame = new JFrame("Home Page");
        panel = new JPanel();
        label = new JLabel("Welcome to Electricity Billing System");
        panel.add(label);
        frame.add(panel);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        menu = new JMenu("Information");
        menu2 = new JMenu("View Bills");
        menu3 = new JMenu("Log out");
        m1 = new JMenuItem("Customer Details");
        m2 = new JMenuItem("Generate Bill");
        m3 = new JMenuItem("logout");
        menu.add(m1);
        menu2.add(m2);
        menu3.add(m3);
        menuBar.add(menu);
        menuBar.add(menu2);
        menuBar.add(menu3);
        frame.setJMenuBar(menuBar);
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m1) {
            new Customer_details(name).f.setVisible(true);
            frame.setVisible(false);
        }
         if (e.getSource() == m2) {
            frame.dispose();
            new Generate_bill(name).setVisible(true);
        }
        else if (e.getSource() == m3) {
            frame.dispose();
            new Login1().frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Home_page("").frame.setVisible(true);
    }

}
