package niitprojcet;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Logistics extends JFrame implements ActionListener, Runnable {

    public void GUI() {
        jlTran = new JLabel();
        if ((Main.Type).equalsIgnoreCase("Sea(0.0001 yuan/(Kg*Km))")) {
            jlTran.setIcon(new ImageIcon(getClass().getResource("/pic/pp2.png")));
        }
        else if ((Main.Type).equalsIgnoreCase("Land(0.0002 yuan/(Kg*Km))")) {
            jlTran.setIcon(new ImageIcon(getClass().getResource("/pic/p3.png")));
        }
        else if ((Main.Type).equalsIgnoreCase("Air(0.0003 yuan/(Kg*Km))")) {
            jlTran.setIcon(new ImageIcon(getClass().getResource("/pic/pp1.png")));
        }       
        jlTran.setBounds(Main.X1, Main.Y1, 32, 24);
        jl1 = new JLabel("●");
        jl1.setBounds(Main.X1, Main.Y1, 12, 12);
        jl1.setFont(new Font("宋体", Font.PLAIN, 12));
        jl1.setForeground(Color.RED);
        jl2 = new JLabel("●");
        jl2.setBounds(Main.X2, Main.Y2, 12, 12);
        jl2.setFont(new Font("宋体", Font.PLAIN, 12));
        jl2.setForeground(Color.RED);
        jlMap = new JLabel();
        jlMap.setBounds(0, 0, 700, 600);
        jlMap.setIcon(new ImageIcon(getClass().getResource("/pic/Map1.png")));
        jlTrip = new JLabel("In transit");
        jlTrip.setBounds(730, 200, 160, 40);
        jlTrip.setFont(new Font("Arial", Font.PLAIN, 30));
        jb = new JButton("Confirm receipt");
        jb.setBounds(700, 300, 195, 40);
        jb.setFont(new Font("Arial", Font.PLAIN, 20));
        jb.addActionListener(this);
        jlpMain = new JLayeredPane();
        jlpMain.setLayout(null);
        jlpMain.setBounds(150, 200, 900, 600);
        jlpMain.add(jlTran);
        jlpMain.add(jl1);
        jlpMain.add(jl2);
        jlpMain.add(jlMap);
        jlpMain.add(jlTrip);
        jlpMain.add(jb);
        Font font = new Font("Arial", Font.PLAIN, 20);
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
        jlpBig.add(jlpMain);
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
        jlUserName = new JLabel("Welcome!" + Login.Name);
        jlUserName.setBounds(200, 0, 250, 40);
        jbUCenter = new JButton("UCenter");
        jbUCenter.setBounds(800, 5, 120, 30);
        jbContactUs = new JButton("ContactUs");
        jbContactUs.setBounds(930, 5, 120, 30);
        jbContactUs.addActionListener(this);
        jbSet = new JButton("Set");
        jbSet.setBounds(1060, 5, 120, 30);
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
                int option = JOptionPane.showConfirmDialog(Logistics.this, "exit?", "提示", JOptionPane.YES_NO_OPTION);
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
        Logistics l = new Logistics();
        l.GUI();
        new Thread(l).start();
    }
    private JFrame jf;
    private JPanel jpUp, jpDown;
    private JLayeredPane jlpBig, jlpMain;
    private JButton jbUCenter, jbContactUs, jbSet, jbSearch, jbBack, jb;
    private JLabel jlGround, jlUserName, jlDown, jlMap, jl1, jl2, jlTran, jlTrip;
    private JTextField jtfSearch;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb) {
            if ("Yes".equalsIgnoreCase(Main.Arr)) {
                JOptionPane.showMessageDialog(jf, "This order was recevied, do not confirm it again");
            } else {
                Receipt receipt = new Receipt();
            }
        }
        if (e.getSource() == jbBack) {
            jf.dispose();
            new Search().GUI();
        }
        if (e.getSource() == jbContactUs) {
            new ContactUs();
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
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        rs.close();
                        ps.close();
                        con.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        int x = (Main.X2 - Main.X1) / 5;
        int y = (Main.Y2 - Main.Y1) / 5;
        try {
            while (true) {
                int x1 = Main.X1;
                int y1 = Main.Y1;
                jlTran.setBounds(x1, y1, 32, 24);
                for (int i = 0; i <= 5; i++) {
                    x1 = x1 + x;
                    y1 = y1 + y;
                    if ((Main.Type).equalsIgnoreCase("Sea(0.0001 yuan/(Kg*Km))")) {
                        Thread.sleep(900);
                        jlTran.setBounds(x1, y1, 32, 24);
                    }
                    if ((Main.Type).equalsIgnoreCase("Land(0.0002 yuan/(Kg*Km))")) {
                        Thread.sleep(600);
                        jlTran.setBounds(x1, y1, 32, 24);
                    }
                    if ((Main.Type).equalsIgnoreCase("Air(0.0003 yuan/(Kg*Km))")) {
                        Thread.sleep(300);
                        jlTran.setBounds(x1, y1, 32, 24);
                    }
                }
            }
        } catch (Exception ex1) {
             JOptionPane.showMessageDialog(jf,ex1);
        }
    }
    
}
