package Mini_Project;

import java.sql.*;
import javax.swing.*;

public class New_customer {
    JFrame frame;
    JLabel name1;
    JTextField l1, l2, l3, l4, l5, l6;
    JLabel address;
    JLabel phone;
    JLabel meter_no;
    JLabel c_id;
    JLabel username;

    New_customer() {
        frame = new JFrame("New Customer");
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        name1 = new JLabel("Name");
        name1.setBounds(50, 50, 100, 30);
        frame.add(name1);

        l1 = new JTextField();
        l1.setBounds(250, 50, 100, 30);
        frame.add(l1);

        address = new JLabel("Address");
        address.setBounds(50, 100, 100, 30);
        frame.add(address);

        l2 = new JTextField();
        l2.setBounds(250, 100, 100, 30);
        frame.add(l2);

        phone = new JLabel("Phone");
        phone.setBounds(50, 150, 100, 30);
        frame.add(phone);

        l3 = new JTextField();
        l3.setBounds(250, 150, 100, 30);
        frame.add(l3);

        meter_no = new JLabel("Meter_no");
        meter_no.setBounds(50, 200, 100, 30);
        frame.add(meter_no);

        l4 = new JTextField();
        l4.setBounds(250, 200, 100, 30);
        frame.add(l4);

        c_id = new JLabel("Customer_id");
        c_id.setBounds(50, 250, 100, 30);
        frame.add(c_id);

        l5 = new JTextField();
        l5.setBounds(250, 250, 100, 30);
        frame.add(l5);

        username = new JLabel("Renter Your Username");
        username.setBounds(50, 300, 200, 30);
        frame.add(username);

        l6 = new JTextField();
        l6.setBounds(250, 300, 100, 30);
        frame.add(l6);

        JButton submit = new JButton("Submit");
        submit.setBounds(50, 400, 100, 30);
        frame.add(submit);

        JButton back = new JButton("Back");
        back.setBounds(150, 400, 100, 30);
        frame.add(back);
        back.addActionListener(e -> {
            frame.dispose();
            new Signup();
        });
        submit.addActionListener(e -> {
            String name1 = l1.getText();
            String address1 = l2.getText();
            String phone1 = l3.getText();
            String meter_no1 = l4.getText();
            String c_id1 = l5.getText();
            String username1 = l6.getText();
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mini_project", "root", "");
                Statement stmt = con.createStatement();
                String query = "insert into customer_info values('" + c_id1 + "','" + name1 + "','" + address1 + "','" + phone1 + "','" + meter_no1 + "','" + username1 + "')";
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Added");
                frame.dispose();
                new Home_page(username1).frame.setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

    }

    public static void main(String[] args) {
        new New_customer();
    }
}