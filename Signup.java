package Mini_Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Signup {
    JFrame frame;
    JLabel label, label2, label3,label4,l;
    JPasswordField pass;
    JTextField username, meter_id,name;
    JButton button, button2;

    public Signup() {
        frame = new JFrame("Signup");
        frame.setSize(400, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        l = new JLabel("Signup");
        l.setBounds(150, 10, 100, 30);
        l.setFont(new java.awt.Font("TIMES NEW ROMAN", 1, 20));
        frame.add(l);

        label = new JLabel("Username");
        label.setBounds(50, 50, 100, 30);
        frame.add(label);

        label2 = new JLabel("Password");
        label2.setBounds(50, 100, 100, 30);
        frame.add(label2);

        label3 = new JLabel("Meter ID");
        label3.setBounds(50, 150, 100, 30);
        frame.add(label3);

        label4 = new JLabel("Name");
        label4.setBounds(50, 200, 100, 30);
        frame.add(label4);

        username = new JTextField();
        username.setBounds(150, 50, 150, 30);
        frame.add(username);

        meter_id = new JTextField();
        meter_id.setBounds(150, 150, 150, 30);
        frame.add(meter_id);

        pass = new JPasswordField();
        pass.setBounds(150, 100, 150, 30);
        frame.add(pass);

        name = new JTextField();
        name.setBounds(150, 200, 150, 30);
        frame.add(name);

        button = new JButton("Signup");
        button.setBounds(100, 300, 100, 30);
        frame.add(button);

        button2 = new JButton("Back");
        button2.setBounds(250, 300, 100, 30);
        frame.add(button2);

        frame.setVisible(true);

        button.addActionListener(e -> {
            String user = username.getText();
            String passw = pass.getText();
            String meter = meter_id.getText();
            String nam = name.getText();
            if (user.equals("") || passw.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please fill all the fields");
            } else {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mini_project", "root", "");
                    Statement st = con.createStatement();
                    String query = "insert into login values('" + user + "','" + passw + "','" + meter + "','" + nam + "')";
                    st.executeUpdate(query);
                    JOptionPane.showMessageDialog(frame, "Signup Successful Please enter your details");
                    frame.dispose();
                    new New_customer();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        button2.addActionListener(e -> {
                    frame.dispose();
                    new Login1().frame.setVisible(true);
                });
    }
    public static void main(String[] args) {
        new Signup();
    }
}
