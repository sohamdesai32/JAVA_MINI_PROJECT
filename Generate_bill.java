package Mini_Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Generate_bill extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextArea ta;
    JButton b1, b2;
    Choice c2;
    JPanel p1;
    String name;

    Generate_bill(String name) {
        this.name = name;
        setSize(500, 900);
        setLayout(new BorderLayout());
        setTitle("Generate Bill");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        p1 = new JPanel();

        l1 = new JLabel("Generate Bill");

        ta = new JTextArea(50, 15);
        ta.setText("\n\n\t------- Click on the -------\n\t Generate Bill Button to get\n\tthe bill of the Selected Month\n\n");
        JScrollPane jsp = new JScrollPane(ta);
        ta.setFont(new Font("Senserif", Font.ITALIC, 18));

        b1 = new JButton("Generate Bill");
        b1.setBounds(0, 0, 100, 50);

        b2 = new JButton("Back");
        b2.setBounds(200, 850, 100, 50);

        p1.add(l1);

        add(p1, "North");
        add(jsp, "Center");
        add(b1, "South");

        b1.addActionListener(this);
//        add(b2, ta);
//        b2.addActionListener(e -> {
//            new Home_page(name);
//            setVisible(false);
//        });
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mini_project", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customer_info where username='" + name + "'");
            while (rs.next()) {
                ta.append("\n Customer Name: " + rs.getString(2) + "\n");
                ta.append("\n Address:        " + rs.getString(3) + "\n");
                ta.append("\n Phone:            " + rs.getString(4) + "\n");
                ta.append("\n Meter NO:            " + rs.getString(5) + "\n");
                ta.append("\n Customer ID:            " + rs.getString(1) + "\n");
                ta.append("\n-------------------------------------------------------------");
                ta.append("\n");
            }
            rs = stmt.executeQuery("select * from MeterInfo where username ='" + name + "'");
            if (rs.next()) {
                ta.append("\n Meter No :            " + rs.getString(1) + "\n");
                ta.append("\n Meter Location :            " + rs.getString(3) + "\n");
                ta.append("\n Phase Code :            " + rs.getString(4) + "\n");
                ta.append("\n Days :            " + rs.getString(5) + "\n");
                ta.append("\n-------------------------------------------------------------");
                ta.append("\n");
            }
            rs = stmt.executeQuery("select * from charges");
            if (rs.next()) {
                ta.append("\n GST :            " + rs.getString("GST") + "\n");
                ta.append("\n Service charge :            " + rs.getString("Service_tax") + "\n");
                ta.append("Swatch Bharat Cess:                " + rs.getString("SwacchBharatCess") + "\n");
                ta.append("Cost per unit:                        " + rs.getInt("Cost_per_unit") + "\n");
                ta.append("Service charge:            " + rs.getInt("service_charge") + "\n");
                ta.append("Meter rent:            " + rs.getInt("meter_rent") + "\n");
                ta.append("\n-------------------------------------------------------------");
                ta.append("\n");
            }
             rs = stmt.executeQuery("select * from bill where username ='" + name + "'");
            if (rs.next()) {
                ta.append("\n Bill Month :            " + rs.getString(1) + "\n");
                ta.append("\n Units Consumed :            " + rs.getString(4) + "\n");
                ta.append("\n-------------------------------------------------------------");
                ta.append("\n Bill Amount :            " + rs.getString(3) + "\n");
                ta.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Generate_bill("").setVisible(true);
    }
}