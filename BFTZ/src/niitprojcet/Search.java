package niitprojcet;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Search extends JFrame implements ActionListener {

    public void GUI() {
        font = new Font("Arial", Font.PLAIN, 20);
        jtfSearch = new JTextField();
        jtfSearch.setFont(font);
        jtfSearch.setBounds(400, 15, 350, 40);
        jtfSearch.setText(Main.orderID);

        jbSearch = new JButton("Search");
        jbSearch.setFont(font);
        jbSearch.setBounds(800, 15, 100, 40);
        jbSearch.addActionListener(this);

        jlTrip = new JLabel();
        jlTrip.setBounds(250, 10, 400, 40);
        jlTrip.setFont(new Font("Arial", Font.ITALIC, 26));
        jlTrip.setForeground(Color.red);

        jlPic1 = new JLabel();
        jlPic1.setBounds(160, 80, 120, 120);
        jlPic1.setIcon(new ImageIcon(getClass().getResource("/pic/p2.png")));

        jlInfo = new JLabel("Logistics Information:");
        jlInfo.setFont(font);
        jlInfo.setBounds(300, 80, 230, 30);

        jtaInfo = new JTextArea();
        jtaInfo.setFont(font);
        jtaInfo.setLineWrap(true);
        jtaInfo.setWrapStyleWord(true);
        jtaInfo.setBounds(300, 120, 370, 80);
        jtaInfo.setEditable(false);
        jtaInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        jlAdr = new JLabel("Addressr:");
        jlAdr.setFont(font);
        jlAdr.setBounds(200, 280, 130, 30);

        jlRec = new JLabel("Recipients:");
        jlRec.setFont(font);
        jlRec.setBounds(570, 280, 130, 30);

        jlID = new JLabel("Phone:");
        jlID.setFont(font);
        jlID.setBounds(90, 350, 65, 30);

        jlID1 = new JLabel();
        jlID1.setFont(font);
        jlID1.setBounds(170, 350, 220, 30);

        jlID2 = new JLabel();
        jlID2.setFont(font);
        jlID2.setBounds(540, 350, 220, 30);

        jlName = new JLabel("Name:");
        jlName.setFont(font);
        jlName.setBounds(90, 390, 60, 30);
        jlName1 = new JLabel();
        jlName1.setFont(font);
        jlName1.setBounds(170, 390, 220, 30);

        jlName2 = new JLabel();
        jlName2.setFont(font);
        jlName2.setBounds(540, 390, 220, 30);
        jlCity = new JLabel("City:");
        jlCity.setFont(font);
        jlCity.setBounds(90, 430, 60, 30);
        jlCity1 = new JLabel();
        jlCity1.setFont(font);
        jlCity1.setBounds(170, 430, 220, 30);

        jlCity2 = new JLabel();
        jlCity2.setFont(font);
        jlCity2.setBounds(540, 430, 220, 30);

        jb1 = new JButton("Check the logistics");
        jb1.setFont(font);
        jb1.setBounds(350, 475, 200, 40);
        jb1.addActionListener(this);
        jb2 = new JButton("Confirm receipt");
        jb2.setFont(font);
        jb2.setBounds(560, 475, 200, 40);
        jb2.addActionListener(this);


        jpMain = new JLayeredPane();
        jpMain.setLayout(null);
        jpMain.setBounds(150, 200, 900, 600);
        jpMain.add(jlID);
        jpMain.add(jlID1);
        jpMain.add(jlID2);
        jpMain.add(jlName);
        jpMain.add(jlName1);
        jpMain.add(jlName2);
        jpMain.add(jlCity);
        jpMain.add(jlCity1);
        jpMain.add(jlCity2);
        jpMain.add(jlAdr);
        jpMain.add(jlRec);
        jpMain.add(jlPic1);
        jpMain.add(jlInfo);
        jpMain.add(jtaInfo);
        jpMain.add(jb1);
        jpMain.add(jb2);
        jpMain.add(jlTrip);

        if (Main.Flag == 1) {
            jtaInfo.setText("Food Name: " + Main.HName + "  Freight: " + Main.Price + "  Tpye of transport: " + Main.Type + "  Remark: " + Main.Info);
            jlID1.setText(Main.ID1);
            jlID2.setText(Main.ID2);
            jlName1.setText(Main.Name1);
            jlName2.setText(Main.Name2);
            jlCity1.setText(Main.City1);
            jlCity2.setText(Main.City2);
        }
        if (Main.Flag == 0) {
            jlTrip.setText("The order number does not exist !");
        }
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
        jlUserName = new JLabel("Welcome!" + Login.Name);
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
                int option = JOptionPane.showConfirmDialog(Search.this, "exit?", "提示", JOptionPane.YES_NO_OPTION);
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
        new Search().GUI();
    }
    private JFrame jf;
    private JPanel jpUp, jpDown;
    private JLayeredPane jlpBig, jpMain;
    private JButton jbUCenter, jbContactUs, jbSet, jbSearch, jb1, jb2, jbBack;
    private JLabel jlGround, jlUserName, jlDown, jlPic1, jlInfo, jlAdr, jlRec, jlTrip,
            jlID, jlID1, jlID2, jlName, jlName1, jlName2, jlCity, jlCity1, jlCity2;
    private JTextField jtfSearch;
    private JTextArea jtaInfo;
    private Font font;
    public static int Flag = 0;
    public static String Info;
    public static String ID1;
    public static String ID2;
    public static String Name1;
    public static String Name2;
    public static String City1;
    public static String City2;
    public static String Arr;

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
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                con = (Connection) DBUtil.getConnection();
                String sql = "select * from order_forms where Order_id=?";
                ps = (PreparedStatement) con.prepareStatement(sql);
                ps.setString(1, jtfSearch.getText());
                Main.orderID = jtfSearch.getText();
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
                sql = "select * from Citys where city_Neme=?";
                ps = (PreparedStatement) con.prepareStatement(sql);
                ps.setString(1, Main.City1);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Main.X1 = rs.getInt(4);
                    Main.Y1 = rs.getInt(5);
                }
                sql = "select * from Citys where City_neme=?";
                ps = (PreparedStatement) con.prepareStatement(sql);
                ps.setString(1, Main.City2);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Main.X2 = rs.getInt(4);
                    Main.Y2 = rs.getInt(5);
                }
                if (Main.Flag == 1) {
                    jtaInfo.setText("Food Name: " + Main.HName + "  Freight: " + Main.Price + "  Tpye of transport: " + Main.Type + "  Remark: " + Main.Info);
                    jlID1.setText(Main.ID1);
                    jlID2.setText(Main.ID2);
                    jlName1.setText(Main.Name1);
                    jlName2.setText(Main.Name2);
                    jlCity1.setText(Main.City1);
                    jlCity2.setText(Main.City2);
                    jlTrip.setText("");
                }
                if (Main.Flag == 0) {
                    jlTrip.setText("The  order number does not exist !");
                    jtaInfo.setText("");
                    jlID1.setText("");
                    jlID2.setText("");
                    jlName1.setText("");
                    jlName2.setText("");
                    jlCity1.setText("");
                    jlCity2.setText("");
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
        if (e.getSource() == jb2) {
            if ("Yes".equalsIgnoreCase(Main.Arr)) {
                JOptionPane.showMessageDialog(jf, "This order was recevied, do not confirm it again");
            } else {
                Receipt receipt = new Receipt();
            }
        }
        if (e.getSource() == jb1) {
            if ("Yes".equalsIgnoreCase(Main.Arr)) {
                JOptionPane.showMessageDialog(jf, "This order was recevied");
            } else {
                jf.dispose();
                Logistics l = new Logistics();
                l.GUI();
                new Thread(l).start();
            }
        }
    }
}
