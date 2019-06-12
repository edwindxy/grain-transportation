
package niitprojcet;

import java.util.Date;
import java.sql.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.*;


public class Payment extends JFrame implements ActionListener {

    public Payment() {
        Font font = new Font("Arial", Font.PLAIN, 18);
        jl3 = new JLabel("Click QR code to switch the payment methon");
        jl3.setBounds(10, 300, 380, 30);
        jl3.setFont(font);

        jb2 = new JButton(new ImageIcon(getClass().getResource("/pic/Alipay.png")));
        jb2.setBounds(50, 350, 297, 297);
        jb2.addActionListener(this);

        jl1 = new JLabel("Is expceted to pay:");
        jl1.setBounds(110, 50, 180, 40);
        jl1.setFont(font);
        jl2 = new JLabel(Deliver.price + " yuan");
        jl2.setBounds(130, 110, 240, 40);
        jl2.setFont(new Font("a", Font.BOLD, 24));
        jb = new JButton("Submit");
        jb.setBounds(150, 180, 100, 40);
        jb.setFont(font);
        jb.addActionListener(this);
        jp = new JPanel();
        jp.setLayout(null);
        jp.setBounds(0, 0, 400, 700);
        jp.add(jl1);
        jp.add(jl2);
        jp.add(jb);
        jp.add(jb2);
        jp.add(jl3);

        jf = new JFrame("Payment");
        jf.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(Payment.this, "Cancel?", "提示", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    jf.dispose();
                }
            }
        });
        jf.setResizable(false);
        jf.setSize(400, 700);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.add(jp);
    }

    public static void main(String[] args) {
        Payment payment = new Payment();
    }
    private JFrame jf;
    private JPanel jp;
    private JLabel jl1, jl2, jl3;
    private JButton jb, jb2;
    private static int x = 1;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb2) {
            if (x == 1) {
                jb2.setIcon(new ImageIcon(getClass().getResource("/pic/Wechat.png")));
                x = 0;
            } else {
                jb2.setIcon(new ImageIcon(getClass().getResource("/pic/Alipay.png")));
                x = 1;
            }
        }
        if (e.getSource() == jb) {
            Connection con = null;
            PreparedStatement ps = null;
            try {
                con = (Connection) DBUtil.getConnection();
                String sql = "insert into order_forms values(?,?,?,?,?,?,?,?,?,?,?,?,'No')";
                ps = (PreparedStatement) con.prepareStatement(sql);
                ps.setString(1, Integer.toString(Deliver.orderID));
                ps.setLong(2, Long.parseLong(Deliver.ID1));
                ps.setString(3, Deliver.Name1);
                ps.setString(4, Deliver.City1);
                ps.setLong(5, Long.parseLong(Deliver.ID2));
                ps.setString(6, Deliver.Name2);
                ps.setString(7, Deliver.City2);
                ps.setString(8, Deliver.Cargo_Name);
                ps.setString(9, Deliver.Cargo_Infor);
                ps.setString(10, Deliver.type);
                ps.setInt(11, Deliver.price);
                java.sql.Date time = new java.sql.Date(new Date().getTime());
                ps.setDate(12, time);
                ps.execute();
                JOptionPane.showMessageDialog(jf, "Your order ID is " + Deliver.orderID);
                jf.dispose();
                new Fapiao().GUI();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jf, "Please don't repeat the click");
            } finally {
                try {
                    ps.close();
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(jf, ex);
                }
            }
        }
    }
}
