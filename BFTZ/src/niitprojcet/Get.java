package niitprojcet;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Get extends JFrame implements ActionListener {

    public void GUI() {
        Font font = new Font("Arial", Font.PLAIN, 20);
        jcb = new JComboBox();
        jcb.setBounds(250, 50, 200, 40);
        jcb.setFont(new Font("Arial", Font.BOLD, 24));
        jcb.addItem("All");
        jcb.addItem("I sent");
        jcb.addItem("I received");
        jbSubmit = new JButton("Submit");
        jbSubmit.setFont(new Font("Arial", Font.BOLD, 24));
        jbSubmit.setBounds(500, 50, 150, 40);
        jbSubmit.addActionListener(this);
        jtInfo = new JTable();
        jtInfo.setBounds(0, 120, 890, 480);
        jtInfo.setFont(new Font("Arial", Font.PLAIN, 16));
        jpMain = new JLayeredPane();
        jpMain.setBounds(150, 200, 900, 600);
        jpMain.add(jcb);
        jpMain.add(jbSubmit);
        jpMain.add(jtInfo);

        jtfSearch = new JTextField();
        jtfSearch.setFont(font);
        jtfSearch.setBounds(400, 15, 350, 40);
        jtfSearch.setText("please enter order ID");

        jbSearch = new JButton("Search");
        jbSearch.setFont(font);
        jbSearch.setBounds(800, 15, 100, 40);
        jbSearch.addActionListener(this);

        jlGround = new JLabel();
        jlGround.setBounds(0, 0, 1200, 800);
        jlGround.setIcon(new ImageIcon(getClass().getResource("/pic/网页背景2.png")));

        jlpBig = new JLayeredPane();
        jlpBig.setLayout(null);
        jlpBig.setBackground(Color.YELLOW);
        jlpBig.setBounds(0, 40, 1200, 800);
        jlpBig.add(jtfSearch);
        jlpBig.add(jbSearch);
        jlpBig.add(jpMain);
        jlpBig.add(jlGround);
        
        //下面一部分
        jlDown = new JLabel();
        jlDown.setIcon(new ImageIcon(getClass().getResource("/pic/Down.png")));
        jlDown.setBounds(0, 0, 1200, 160);
        jpDown = new JPanel();
        jpDown.setLayout(null);
        jpDown.setBounds(0, 840, 1200, 160);
        jpDown.setBackground(Color.GREEN);
        jpDown.add(jlDown);

        //上面一部分
        jbBack = new JButton("Back");
        jbBack.setBounds(10, 5, 120, 30);
        jbBack.addActionListener(this);
        jlUserName = new JLabel("Welcome! " + Login.Name);
        jlUserName.setBounds(200, 0, 250, 40);

        jbUCenter = new JButton("UCenter");
        jbUCenter.setBounds(800, 5, 120, 30);
        jbUCenter.addActionListener(this);

        jbContactUs = new JButton("ContactUs");
        jbContactUs.setBounds(930, 5, 120, 30);
        jbContactUs.addActionListener(this);

        jbSet = new JButton("Set");
        jbSet.setBounds(1060, 5, 120, 30);
        jbSet.addActionListener(this);

        jpUp = new JPanel();
        jpUp.setLayout(null);
        jpUp.setBounds(0, 0, 1200, 40);
        jpUp.setBackground(new Color(144, 205, 255));
        jpUp.add(jbBack);
        jpUp.add(jbUCenter);
        jpUp.add(jbSet);
        jpUp.add(jbContactUs);
        jpUp.add(jlUserName);

        jf = new JFrame("Grain Transportation System");
        jf.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(Get.this, "exit?", "提示", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        jf.setResizable(false);
        jf.setSize(1200, 1000);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.add(jpUp);
        jf.add(jlpBig);
        jf.add(jpDown);
    }

    public static void main(String[] args) {
        new Get().GUI();
    }
    private JFrame jf;
    private JPanel jpUp, jpDown;
    private JLayeredPane jlpBig, jpMain;
    private JButton jbUCenter, jbContactUs, jbSet, jbSearch, jbBack, jbSubmit;
    private JLabel jlGround, jlUserName, jlDown;
    private JTextField jtfSearch;
    private JTable jtInfo;
    private JComboBox jcb;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jbUCenter) {
//            JOptionPane.showMessageDialog(jf, "This function is not currently on……");
            Self_centery s = new Self_centery();
            jf.dispose();
            s.GUI();
        }
        
        if (e.getSource() == jbSet) {
            JOptionPane.showMessageDialog(jf, "This function is not currently on……");
        }


        if (e.getSource() == jbBack) {
                        jf.dispose();
            Main main = new Main();
            main.GUI();
            new Thread(main).start();
        }
        if (e.getSource() == jbContactUs) {
            ContactUs contactUs = new ContactUs();
        }
        if (e.getSource() == jbSearch) {
            if (jtfSearch.getText().length() > 0) {
                Main.orderID = jtfSearch.getText();
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;
                try {
                    con = DBUtil.getConnection();
                    String sql = "select * from Order_forms where Order_id=?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, jtfSearch.getText());
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        Main.HName = rs.getString(8);
                        Main.Info = rs.getString(9);
                        Main.ID1 = rs.getString(2);
                        Main.Name1 = rs.getString(3);
                        Main.City1 = rs.getString(4);
                        Main.ID2 = rs.getString(5);
                        Main.Name2 = rs.getString(6);
                        Main.City2 = rs.getString(7);
                        Main.Arr = rs.getString(13);
                        Main.Price = rs.getInt(11);
                        Main.Type = rs.getString(10);
                        Main.Flag = 1;
                    } else {
                        Main.Flag = 0;
                    }
                    sql = "select * from Citys where city_Name=?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, Main.City1);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Main.X1 = rs.getInt(4);
                        Main.Y1 = rs.getInt(5);
                    }
                    sql = "select * from Citys where City_name=?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, Main.City2);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Main.X2 = rs.getInt(4);
                        Main.Y2 = rs.getInt(5);
                    }
                    jf.dispose();
                    new Search().GUI();
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
        if (e.getSource() == jbSubmit) {
            Connection con = null;
            Statement st = null;
            ResultSet rs = null;
            try {
                con = DBUtil.getConnection();
                Object[] object;
                String sql = null;
                if (jcb.getSelectedIndex() == 0) {
                    sql = "select * from order_forms where Addresser_ID=" + Login.Phone + " or Recipient_ID=" + Login.Phone;
                }
                if (jcb.getSelectedIndex() == 1) {
                    sql = "select * from order_forms where Addresser_ID=" + Login.Phone;
                }
                if (jcb.getSelectedIndex() == 2) {
                    sql = "select * from order_forms where Recipient_ID=" + Login.Phone;
                }
                st = (Statement) con.createStatement();
                rs = st.executeQuery(sql);
                ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                DefaultTableModel tm = (DefaultTableModel) jtInfo.getModel();
                tm.setColumnCount(9);
                tm.setRowCount(0);
                object = new Object[9];
                object[0] = (rsmd.getColumnName(1));
                object[1] = (rsmd.getColumnName(2));
                object[2] = (rsmd.getColumnName(5));
                object[3] = (rsmd.getColumnName(8));
                object[4] = (rsmd.getColumnName(9));
                object[5] = (rsmd.getColumnName(10));
                object[6] = (rsmd.getColumnName(11));
                object[7] = (rsmd.getColumnName(12));
                object[8] = (rsmd.getColumnName(13));
                tm.addRow(object);
                while (rs.next()) {
                    object[0] = (rs.getString(1));
                    object[1] = (rs.getLong(2));
                    object[2] = (rs.getLong(5));
                    object[3] = (rs.getString(8));
                    object[4] = (rs.getString(9));
                    object[5] = (rs.getString(10));
                    object[6] = (rs.getInt(11));
                    object[7] = (rs.getDate(12));
                    object[8] = (rs.getString(13));
                    tm.addRow(object);
                }
                tm.fireTableDataChanged();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jf, ex);
            } finally {
                try {
                    rs.close();
                    st.close();
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(jf, "Please enter the correct information");
                }
            }
        }
    }
}
