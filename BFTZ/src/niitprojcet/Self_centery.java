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
import javax.swing.border.BevelBorder;

public class Self_centery extends JFrame implements ActionListener {

    public void GUI() {

        Font font = new Font("a", Font.BOLD, 20);

        jti = new JLabel(" ");
        jti.setBounds(90, 210, 150, 150);
//        jt1.setBackground(Color.green);
        //星星
        jlID2 = new JLabel("*");
        jlID2.setBounds(720, 100, 30, 30);

        jlPho2 = new JLabel("*");
        jlPho2.setBounds(720, 150, 30, 30);

        jlName2 = new JLabel("*");
        jlName2.setBounds(720, 200, 30, 30);

        jlEmail2 = new JLabel("*");
        jlEmail2.setBounds(720, 250, 30, 30);



        //文本框
        jtID = new JTextField();
        jtID.setBounds(350, 100, 360, 30);
        jtID.setEditable(false);
        jtPho = new JTextField();
        jtPho.setBounds(350, 150, 360, 30);
        jtPho.setEditable(false);
        jtName = new JTextField();
        jtName.setBounds(350, 200, 360, 30);

        jtEmail = new JTextField();
        jtEmail.setBounds(350, 250, 360, 30);

        jtAge = new JTextField();
        jtAge.setBounds(350, 300, 360, 30);

        jtCity = new JTextField();
        jtCity.setBounds(350, 350, 360, 30);

        jtAdd = new JTextField();
        jtAdd.setBounds(350, 400, 360, 30);

        jtCountry = new JTextField();
        jtCountry.setBounds(350, 450, 360, 30);

        jtBirth = new JTextField();
        jtBirth.setBounds(350, 500, 360, 30);
        jtID.setText("" + Login.ID);
        jtPho.setText("" + Login.Phone);
        jtName.setText("" + Login.Name);
        jtEmail.setText("" + Login.Email);
        jtAge.setText("" + Login.Age);
        jtCity.setText("" + Login.City);
        jtAdd.setText("" + Login.Add);
        jtCountry.setText("" + Login.Country);
        jtBirth.setText("" + Login.Birth);

        jtName.setEditable(false);
        jtEmail.setEditable(false);
        jtAge.setEditable(false);
        jtCity.setEditable(false);
        jtAdd.setEditable(false);
        jtCountry.setEditable(false);
        jtBirth.setEditable(false);





        jtitle = new JLabel(" Personal Center");
        jtitle.setBounds(370, 10, 140, 60);
        jtitle.setFont(new Font("serif", Font.PLAIN, 20));
        jtitle.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlID = new JLabel("· ID:");
        jlID.setFont(new Font("serif", Font.PLAIN, 20));
        jlID.setBounds(150, 100, 140, 30);
        jlID.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlPho = new JLabel("· Phone:");
        jlPho.setFont(new Font("serif", Font.PLAIN, 20));
        jlPho.setBounds(150, 150, 140, 30);
        jlPho.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlName3 = new JLabel("· Name:");
        jlName3.setFont(new Font("serif", Font.PLAIN, 20));
        jlName3.setBounds(150, 200, 140, 30);
        jlName3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlEmail = new JLabel("· Email:");
        jlEmail.setFont(new Font("serif", Font.PLAIN, 20));
        jlEmail.setBounds(150, 250, 140, 30);
        jlEmail.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlAge = new JLabel("· Age:");
        jlAge.setFont(new Font("serif", Font.PLAIN, 20));
        jlAge.setBounds(150, 300, 140, 30);
        jlAge.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlCity = new JLabel("· City:");
        jlCity.setFont(new Font("serif", Font.PLAIN, 20));
        jlCity.setBounds(150, 350, 140, 30);
        jlCity.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlAdd = new JLabel("· Address");
        jlAdd.setFont(new Font("serif", Font.PLAIN, 20));
        jlAdd.setBounds(150, 400, 140, 30);
        jlAdd.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlCountry = new JLabel("· DateOfBirth:");
        jlCountry.setFont(new Font("serif", Font.PLAIN, 20));
        jlCountry.setBounds(150, 450, 140, 30);
        jlCountry.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jlBirth = new JLabel("· Country:");
        jlBirth.setFont(new Font("serif", Font.PLAIN, 20));
        jlBirth.setBounds(150, 500, 140, 30);
        jlBirth.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jbChange = new JButton("Change Information");
        jbChange.setBounds(355, 545, 220, 50);
        jbChange.setFont(font);
        jbChange.addActionListener(this);

        jbSubmit = new JButton("Submit");
        jbSubmit.setBounds(355, 545, 220, 50);
        jbSubmit.setFont(font);
        jbSubmit.addActionListener(this);

        //面板
        jpMain = new JLayeredPane();
        jpMain.setLayout(null);
        jpMain.setBounds(150, 200, 900, 600);

        jpMain.add(jtitle);
        jpMain.add(jti);
        //添加标签
        jpMain.add(jlID);
        jpMain.add(jlPho);
        jpMain.add(jlName3);
        jpMain.add(jlEmail);
        jpMain.add(jlAge);
        jpMain.add(jlCity);
        jpMain.add(jlAdd);
        jpMain.add(jlCountry);
        jpMain.add(jlBirth);
        //添加文本框
        jpMain.add(jtID);
        jpMain.add(jtPho);
        jpMain.add(jtName);
        jpMain.add(jtEmail);
        jpMain.add(jtAge);
        jpMain.add(jtCity);
        jpMain.add(jtAdd);
        jpMain.add(jtCountry);
        jpMain.add(jtBirth);
        //添加星星
        jpMain.add(jlID2);
        jpMain.add(jlPho2);
        jpMain.add(jlName2);
        jpMain.add(jlEmail2);

        jpMain.add(jbChange);



        //上方按钮部分
        jtfSearch = new JTextField();
        jtfSearch.setFont(font);
        jtfSearch.setBounds(410, 15, 350, 40);

        jbSearch = new JButton("Search");
        jbSearch.setFont(font);
        jbSearch.setBounds(800, 15, 100, 40);

        jlGround = new JLabel();
        jlGround.setBounds(0, 0, 1200, 800);
        jlGround.setIcon(new ImageIcon(getClass().getResource("/Pictures/Background2.png")));
        jlpBig = new JLayeredPane();
        jlpBig.setLayout(null);
        jlpBig.setBackground(Color.YELLOW);
        jlpBig.setBounds(0, 40, 1200, 800);
        jlpBig.add(jtfSearch);
        jlpBig.add(jbSearch);
        jlpBig.add(jpMain);
        jlpBig.add(jlGround, -1);



        //上面一部分
        jbBack = new JButton("Back");
        jbBack.setBounds(10, 5, 120, 30);
        jbBack.addActionListener(this);
        jlName = new JLabel();
        jlName.setBounds(100, 0, 250, 40);
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
        jpUp.add(jbUCenter);
        jpUp.add(jbSet);
        jpUp.add(jbContactUs);
        jpUp.add(jlName);
        jpUp.add(jbBack);




        //下面一部分
        jlDown = new JLabel();
        jlDown.setIcon(new ImageIcon(getClass().getResource("/Pictures/Down.png")));
        jlDown.setBounds(0, 0, 1200, 160);
        jpDown = new JPanel();
        jpDown.setBounds(0, 840, 1200, 160);
//        jpDown.setBackground(Color.GREEN);
        jpDown.add(jlDown);



        jf = new JFrame("Grain Transportation System");
        jf.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "exit?", "提示", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }//关闭窗口
        });
        jf.setResizable(false);
        jf.setSize(1200, 1000);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.add(jpUp);
        jf.add(jlpBig);
        jf.add(jpDown);
//        jf.add(jpMain);

    }

    public static void main(String[] args) {
        new Self_centery().GUI();
    }
    private JFrame jf;
    private JPanel jpUp, jpDown;
    private JLayeredPane jlpBig;
    private JButton jbUCenter, jbContactUs, jbSet, jbSearch, jbChange, jbSubmit, jbBack;
    private JLabel jlGround, jlName, jlDown;
    private JTextField jtfSearch;
    private JLayeredPane jpMain;
    private JLabel jtitle, jlID, jlPho, jlName3, jlEmail, jlAge, jlCity, jlAdd, jlCountry, jlBirth, jti;
    private JTextField jtID, jtPho, jtName, jtEmail, jtAge, jtCity, jtAdd, jtCountry, jtBirth;
    private JLabel jlID2, jlPho2, jlName2, jlEmail2;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbUCenter) {
            JOptionPane.showMessageDialog(this, "Sorry ,please Login in first!");
        }
        if (e.getSource() == jbContactUs) {
            JOptionPane.showMessageDialog(this, "Sorry ,please Login in first!");
        }
        if (e.getSource() == jbSet) {
            JOptionPane.showMessageDialog(this, "Sorry ,please Login in first!");
        }
        if (e.getSource() == jbSearch) {
            JOptionPane.showMessageDialog(this, "Sorry ,please Login in first!");
        }
        if (e.getSource() == jbBack) {
            jf.dispose();
            Main main = new Main();
            main.GUI();
            new Thread(main).start();
        }
        if (e.getSource() == jbChange) {
            jtName.setEditable(true);
            jtAge.setEditable(true);
            jtCity.setEditable(true);
            jtAdd.setEditable(true);
            jtCountry.setEditable(true);
            jtBirth.setEditable(true);
            jpMain.remove(jbChange);
            jpMain.add(jbSubmit);
//            try {
//                 Connection cn=DBClass.getConnection();//连接数据库
//                 String sql="Select * from Users where User_Phone = '"+Login.ID+"'";
//                 PreparedStatement pdt = cn.prepareStatement(sql);
//                 Result rs = pdt 


        }
        if (e.getSource() == jbSubmit) {

            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                con = (Connection) DBUtil.getConnection();
                String sql = "update users set user_name=?,user_age=?,user_city=?,user_address=?,user_country=?,user_dateofbirth=? where user_id=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, jtName.getText());
                ps.setInt(2, Integer.parseInt(jtAge.getText()));
                ps.setString(3, jtCity.getText());
                ps.setString(4, jtAdd.getText());
                ps.setString(5, jtCountry.getText());
                ps.setString(6, jtBirth.getText());
                ps.setInt(7, Login.ID);
                ps.execute();
                sql = "select * from Users where user_ID=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, Login.ID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Login.Name = rs.getString(4);
                    Login.Email = rs.getString(5);
                    Login.Age = rs.getInt(6);
                    Login.City = rs.getString(7);
                    Login.Add = rs.getString(8);
                    Login.Birth = rs.getString(9);
                    Login.Country = rs.getString(10);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex);
            } finally {
                try {
                    ps.close();
                    con.close();//jtID,jtPho,jtName,jtEmail,jtAge,jtCity,jtAdd,jtCountry,jtBirth;
                } catch (SQLException ex) {
                    Logger.getLogger(Self_centery.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            jtName.setEditable(false);
            jtAge.setEditable(false);
            jtCity.setEditable(false);
            jtAdd.setEditable(false);
            jtCountry.setEditable(false);
            jtBirth.setEditable(false);
            jpMain.remove(jbSubmit);
            jpMain.add(jbChange);

        }
    }
}
