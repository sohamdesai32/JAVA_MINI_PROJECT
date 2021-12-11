package Mini_Project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Customer_details {
    String name;
    JFrame f;
    JLabel label, l1, l11, l2, l22, l3, l33, l4, l44, l5, l55,x,y,z,a;
    JButton b;

    Customer_details(String name) {
        f = new JFrame("Customer Details");
        f.setBounds(0, 0, 600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        label = new JLabel("CUSTOMER DETAILS");
        label.setSize(300, 30);
        label.setBounds(180, 25, 300, 30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        f.add(label);

        l1 = new JLabel("Customer :");
        l1.setBounds(20, 150, 100, 30);
        l1.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l1);

        x=new JLabel("Name");
        x.setBounds(20, 163, 100, 30);
        x.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(x);

        l11 = new JLabel();
        l11.setBounds(120, 150, 200, 30);
        l11.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l11);
        l11.setVisible(true);

        l2 = new JLabel("Customer ID:");
        l2.setBounds(350, 150, 100, 30);
        l2.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l2);

        l22 = new JLabel();
        l22.setBounds(450, 150, 200, 30);
        l22.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l22);
        l22.setVisible(true);

        l3 = new JLabel("Customer :");
        l3.setBounds(20, 270, 100, 30);
        l3.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l3);

        y=new JLabel("Address");
        y.setBounds(20, 283, 100, 30);
        y.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(y);

        l33 = new JLabel();
        l33.setBounds(120, 270, 200, 30);
        l33.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l33);
        l33.setVisible(true);

        l4 = new JLabel("Customer :");
        l4.setBounds(350, 270, 100, 30);
        l4.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l4);

        z=new JLabel("Contact");
        z.setBounds(350, 283, 100, 30);
        z.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(z);

        l44 = new JLabel();
        l44.setBounds(450, 270, 200, 30);
        l44.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l44);
        l44.setVisible(true);

        l5 = new JLabel("Meter  :");
        l5.setBounds(20, 400, 100, 30);
        l5.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l5);

        a=new JLabel("Number");
        a.setBounds(20, 413, 100, 30);
        a.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(a);

        l55 = new JLabel();
        l55.setBounds(120, 400, 200, 30);
        l55.setFont(new Font("Serif", Font.BOLD, 15));
        f.add(l55);
        l55.setVisible(true);

        b = new JButton("Back");
        b.setBounds(250, 480, 100, 30);
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        f.add(b);
        b.addActionListener(e -> {
            f.dispose();
            new Home_page("");
        });

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mini_project", "root", "");
            Statement stmt = con.createStatement();
            String query = "select * from customer_info where username = '" + name + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                l22.setText(rs.getString(1));
                l11.setText(rs.getString(2));
                l33.setText(rs.getString(3));
                l44.setText(rs.getString(4));
                l55.setText(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void  main(String[] args) {
        new Customer_details("").f.setVisible(true);
    }
}
