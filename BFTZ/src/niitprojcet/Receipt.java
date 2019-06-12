package niitprojcet;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.WindowConstants;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Receipt extends JFrame implements ActionListener {

    public Receipt() {
        Font font = new Font("Arial", Font.BOLD, 20);
        jl = new JLabel("Please enter the receipient's password");
        jl.setBounds(7, 50, 385, 40);
        jl.setFont(font);
        jpf = new JPasswordField();
        jpf.setBounds(75, 120, 250, 40);
        jpf.setFont(new Font("a", Font.BOLD, 24));
        jb = new JButton("Submit");
        jb.setBounds(150, 180, 100, 40);
        jb.setFont(font);
        jb.addActionListener(this);
        jp = new JPanel();
        jp.setLayout(null);
        jp.setBounds(0, 0, 400, 300);
        jp.add(jl);
        jp.add(jb);
        jp.add(jpf);

        jf = new JFrame("Contact Us");
        jf.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(Receipt.this, "Cancel?", "提示", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    jf.dispose();
                }
            }
        });
        jf.setResizable(false);
        jf.setSize(400, 300);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.add(jp);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
    }
    private JFrame jf;
    private JPanel jp;
    private JLabel jl;
    private JButton jb;
    private JPasswordField jpf;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                con = DBUtil.getConnection();
                String sql = "select 1 from users where User_phone=? and user_password=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, Main.ID2);
                ps.setString(2, jpf.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    sql = "update order_forms set Arraval='Yes' where order_ID=?";
                    System.out.println(Main.orderID);
                    ps = con.prepareStatement(sql);
                    ps.setString(1, Main.orderID);
                    ps.execute();
                    JOptionPane.showMessageDialog(jf, "Confirm receipt successfully! click search to refresh");
                    jf.dispose();
                } else {
                    JOptionPane.showMessageDialog(jf, "Error Password");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(jf, ex);
            } finally {
                try {
                    rs.close();
                    ps.close();
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(jf, ex);
                }
            }
        }
    }
}
