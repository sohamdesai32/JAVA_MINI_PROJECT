package Mini_Project;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Login1 {
    JFrame frame;
    JLabel label1, label2, label3, label4, label5, label6;
    JTextField text1;
    JPasswordField text2;
    JButton button1, button2, button3;

    public Login1() {

        frame = new JFrame("Login");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        label1 = new JLabel("Login");
        label1.setBounds(150, 20, 100, 30);
        label1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        frame.add(label1);

        label2 = new JLabel("Username");
        label2.setBounds(50, 100, 100, 30);
        frame.add(label2);

        label3 = new JLabel("Password");
        label3.setBounds(50, 150, 100, 30);
        frame.add(label3);

        label4 = new JLabel("");
        label4.setBounds(50, 200, 100, 30);
        frame.add(label4);

        label5 = new JLabel("");
        label5.setBounds(50, 250, 100, 30);
        frame.add(label5);

        label6 = new JLabel("");
        label6.setBounds(50, 300, 100, 30);
        frame.add(label6);

        text1 = new JTextField();
        text1.setBounds(150, 100, 150, 30);
        frame.add(text1);

        text2 = new JPasswordField();
        text2.setBounds(150, 150, 150, 30);
        frame.add(text2);

        button1 = new JButton("Login");
        button1.setBounds(50, 200, 80, 25);
        frame.add(button1);

        button2 = new JButton("Sign Up");
        button2.setBounds(165, 200, 80, 25);
        frame.add(button2);

        button3 = new JButton("Cancel");
        button3.setBounds(275, 200, 80, 25);
        frame.add(button3);

        button1.addActionListener(e -> {
            String user = text1.getText();
            String pass = text2.getText();
            if (user.equals("") || pass.equals("")) {
                JOptionPane.showMessageDialog(frame, "Please fill all the fields");
            } else {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mini_project", "root", "");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select * from login where username='" + user + "' and password='" + pass + "'");
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successful");
                        String name = rs.getString("username");
                        new Home_page(name).frame.setVisible(true);
                        frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                        text1.setText("");
                        text2.setText("");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        button2.addActionListener(e -> {
            frame.dispose();
            new Signup().frame.setVisible(true);
        });

        button3.addActionListener(e -> {
            frame.dispose();
        });
    }

    public static void main(String[] args) {
        Login1 l = new Login1();
        l.frame.setVisible(true);
    }
}
