package niitprojcet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Main extends JFrame implements Runnable, ActionListener {

    public void GUI() {
        //中间一大块
        Font font = new Font("a", Font.BOLD, 20);

        jtfSearch = new JTextField();
        jtfSearch.setFont(font);
        jtfSearch.setBounds(400, 15, 350, 40);
        jtfSearch.setText("please enter order ID");

        jbSearch = new JButton("Search");
        jbSearch.setFont(font);
        jbSearch.setBounds(800, 15, 100, 40);
        jbSearch.addActionListener(this);

        jpLeft = new JLabel("Transaction dynamics");
        jpLeft.setFont(new Font("a", Font.BOLD, 16));
        jpLeft.setBounds(150, 210, 200, 40);
        jpLeft.setBackground(Color.ORANGE);

        jlTime = new JLabel();
        jlTime.setBounds(450, 0, 240, 40);
        jlTime.setBackground(Color.ORANGE);
        jlTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        jlTime.setFont(font);

        jpRight = new JPanel();
        jpRight.setLayout(null);
        jpRight.setBounds(370, 210, 680, 40);
        jpRight.setBackground(Color.ORANGE);
        jpRight.add(jlTime);
        
        jlPic =new JLabel(new ImageIcon(getClass().getResource("/pic/Ad.png")));
        jpPic = new JPanel();
        jpPic.setBounds(150, 260, 200, 450);
        jpPic.add(jlPic);

        jbPut = new JButton(new ImageIcon(getClass().getResource("/pic/send.png")));
        jbPut.setBounds(60, 20, 250, 250);
        jbPut.addActionListener(this);

        jbGet = new JButton(new ImageIcon(getClass().getResource("/pic/check.png")));
        jbGet.setBounds(375, 20, 250, 250);
        jbGet.addActionListener(this);

        jpMain = new JPanel();
        jpMain.setLayout(null);
        jpMain.setBounds(370, 260, 680, 290);
        jpMain.setBackground(new Color(229,229,229));
        jpMain.add(jbPut);
        jpMain.add(jbGet);

        jlLeftAd = new JLabel();
        jlLeftAd.setBounds(0, 0, 330, 150);
        jlLeftAd.setIcon(new ImageIcon(getClass().getResource("/pic/Airplane.png")));
        jpLeftAd = new JLayeredPane();
        jpLeftAd.setLayout(null);
        jpLeftAd.setBounds(370, 560, 330, 150);
        jpLeftAd.add(jlLeftAd);
        
        jlRightAd = new JLabel();
        jlRightAd.setBounds(0, 0, 330, 150);
        jlRightAd.setIcon(new ImageIcon(getClass().getResource("/pic/Train.png")));
        jpRightAd = new JLayeredPane();
        jpRightAd.setLayout(null);
        jpRightAd.setBounds(720, 560, 330, 150);
        jpRightAd.add(jlRightAd);
        
        jlGround = new JLabel();
        jlGround.setBounds(0, 0, 1200, 800);
        jlGround.setIcon(new ImageIcon(getClass().getResource("/pic/Background.png")));

        jlpBig = new JLayeredPane();
        jlpBig.setLayout(null);
        jlpBig.setBounds(0, 40, 1200, 800);
        jlpBig.add(jpMain);
        jlpBig.add(jpLeft);
        jlpBig.add(jpRight);
        jlpBig.add(jpLeftAd);
        jlpBig.add(jpRightAd);
        jlpBig.add(jtfSearch);
        jlpBig.add(jbSearch);
        jlpBig.add(jpPic);
        jlpBig.add(jlGround, -1);

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
                int option = JOptionPane.showConfirmDialog(Main.this, "exit?", "提示", JOptionPane.YES_NO_OPTION);
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
        Main main = new Main();
        new Thread(main).start();
        main.GUI();
        
    }
    public static int Flag = 0, Price,X1,X2,Y1,Y2;
    public static String Arr, Type;
    public static String orderID;
    public static String Info;
    public static String ID1;
    public static String ID2;
    public static String Name1, HName;
    public static String Name2;
    public static String City1;
    public static String City2;
    private JFrame jf;
    private JPanel jpUp, jpMain, jpRight,  jpPic, jpDown;
    private JLayeredPane jlpBig, jpLeftAd,jpRightAd;
    private JButton jbUCenter, jbContactUs, jbSet, jbPut, jbGet, jbSearch, jbBack;
    private JLabel jlTime, jlGround, jlUserName, jlLeftAd,jlRightAd, jlDown,jlPic, jpLeft;
    private JTextField jtfSearch;
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                jlTime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

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

        
        if (e.getSource() == jbPut) {
            jf.dispose();
            new Deliver().GUI();
        }
        if(e.getSource()==jbGet){
            jf.dispose();
            new Get().GUI();
        }
        if (e.getSource() == jbBack) {
            jf.dispose();
            new Login().GUI();
        }
        if (e.getSource() == jbContactUs) {
            new ContactUs();
        }
        if (e.getSource() == jbSearch) {
            if (jtfSearch.getText().length() > 0) {
                orderID = jtfSearch.getText();
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
                        HName = rs.getString(8);
                        Info = rs.getString(9);
                        ID1 = rs.getString(2);
                        Name1 = rs.getString(3);
                        City1 = rs.getString(4);
                        ID2 = rs.getString(5);
                        Name2 = rs.getString(6);
                        City2 = rs.getString(7);
                        Arr = rs.getString(13);
                        Price = rs.getInt(11);
                        Type = rs.getString(10);
                        Flag = 1;
                    } else {
                        Flag = 0;
                    }
                    sql = "select * from Citys where city_Neme=?";
                            ps = con.prepareStatement(sql);
                            ps.setString(1, City1);
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                X1 = rs.getInt(4);
                                Y1 = rs.getInt(5);
                            }
                            sql = "select * from Citys where City_neme=?";
                            ps = con.prepareStatement(sql);
                            ps.setString(1,City2 );
                            rs = ps.executeQuery();
                            while (rs.next()) {
                                X2 = rs.getInt(4);
                                Y2 = rs.getInt(5);
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
    }
}
