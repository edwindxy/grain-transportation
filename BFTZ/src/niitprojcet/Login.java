package niitprojcet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.*;

public class Login extends JFrame implements MouseListener {

    public void GUI() {
        Font font = new Font("a", Font.BOLD, 30);
        Font font1 = new Font("a", Font.BOLD, 15);

        
        jltPass = new JLabel("Please enter your Password");
        jltPass.setVisible(false);
        jltPass.setFont(font1);
        jltPass.setBounds(800, 245, 300, 30);
        
        jltID = new JLabel("Please enter your Telephone Number");
        jltID.setVisible(false);
        jltID.setFont(font1);
        jltID.setBounds(800, 145, 300, 30);
        
        
        jtfID = new JTextField();
        jtfID.setBounds(800, 100, 300, 40);
        jtfID.setFont(font);
        jtfID.addMouseListener(this);

        jpfPassword = new JPasswordField();
        jpfPassword.setBounds(800, 200, 300, 40);
        jpfPassword.setFont(font);
        jpfPassword.addMouseListener(this);

        jbLogin = new JButton("LOGIN");
        jbLogin.setBounds(800, 300, 100, 40);
        jbLogin.addMouseListener(this);

        jbCancel = new JButton("CANCEL");
        jbCancel.setBounds(1000, 300, 100, 40);
        jbCancel.addMouseListener(this);

        jlID = new JLabel();
        jlID.setText("userID");
        jlID.setFont(font);
        jlID.setBounds(600, 100, 200, 30);

        jlPassword = new JLabel();
        jlPassword.setText("password");
        jlPassword.setFont(font);
        jlPassword.setBounds(600, 200, 200, 30);

        jlTrip = new JLabel();
        jlTrip.setBounds(800, 250, 300, 20);
        jlTrip.setFont(new Font("b", Font.BOLD, 20));
        jlTrip.setForeground(Color.red);


        jlNewUser = new JLabel();
        jlNewUser.setText("New user?");
        jlNewUser.setFont(new Font("b", Font.ITALIC, 30));
        jlNewUser.setBounds(600, 300, 150, 30);
        jlNewUser.addMouseListener(this);

        jlBack = new JLabel();
        jlBack.setIcon(new ImageIcon(getClass().getResource("/pic/Logo_1.png")));
        jlBack.setBounds(0, 0, 1200, 500);


        jlUp = new JLabel();
        jlUp.setIcon(new ImageIcon(getClass().getResource("/pic/Up.png")));
        jlUp.setBounds(0, 0, 1200, 200);
        jlDown = new JLabel(new ImageIcon(getClass().getResource("/pic/Down1.png")));
        jlDown.setBounds(265, 50, 675, 160);

        jpMain = new JLayeredPane();
        jpMain.setBounds(0, 200, 1200, 500);
        jpMain.setLayout(null);
        jpMain.add(jlID);
        jpMain.add(jlPassword);
        jpMain.add(jltID);
        jpMain.add(jltPass);
        jpMain.add(jlNewUser);
        jpMain.add(jbLogin);
        jpMain.add(jbCancel);
        jpMain.add(jtfID);
        jpMain.add(jpfPassword);
        jpMain.add(jlTrip);
        jpMain.add(jlBack, -1);

        jpUp = new JPanel();
        jpUp.setBounds(0, 0, 1200, 200);
        jpUp.setBackground(Color.BLUE);
        jpUp.setLayout(null);
        jpUp.add(jlUp);

        jpDown = new JPanel();
        jpDown.setLayout(null);
        jpDown.setBounds(0, 700, 1200, 300);
        jpDown.setBackground(new Color(197, 225, 181));
        jpDown.add(jlDown);


        jf = new JFrame("Grain Transportation System");
        jf.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        jf.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(Login.this, "exit?", "提示", JOptionPane.YES_NO_OPTION);
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
        jf.add(jpMain);
        jf.add(jpMain);
        jf.add(jpUp);
        jf.add(jpDown);
    }

    public static void main(String args[]) {
        Login login = new Login();
        login.GUI();
    }
    public static String Name,Email,Add,Birth,City,Country;
    public static String Phone;
    public static int ID,Age;
    private JFrame jf;
    private JPanel jpUp, jpDown;
    private JLayeredPane jpMain;
    private JLabel jlID, jlPassword, jlUp, jlDown, jlNewUser, jlTrip, jlBack,
            jltID,jltPass;
    private JButton jbLogin, jbCancel;
    private JTextField jtfID;
    private JPasswordField jpfPassword;

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == jbLogin) {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            String input1 = jtfID.getText();
            String input2 = jpfPassword.getText();
            try {
                con = DBUtil.getConnection();
                String sql = "select * from Users where user_phone=? and user_password=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, input1);
                ps.setString(2, input2);
                rs = ps.executeQuery();
                if (input1.length() == 0) {
                    jlTrip.setText("empty userID");
                } else if (input2.length() == 0) {
                    jlTrip.setText("empty password");
                } else if (rs.next()) {
                    ID=rs.getInt(1);
                    Phone = input1;
                    Name = rs.getString(4);
                    Email=rs.getString(5);
                    Age=rs.getInt(6);
                    City=rs.getString(7);
                    Add=rs.getString(8);
                    Birth=rs.getString(9);
                    Country=rs.getString(10);
                    jf.setVisible(false);
                    Main main = new Main();
                    new Thread(main).start();
                    main.GUI();
                } else {
                    jlTrip.setText("error userID or password");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(jf, "Please enter the correct information");
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
        if (e.getSource() == jbCancel) {
            System.exit(0);
        }
        if (e.getSource() == jlNewUser) {
            new New_User_Code().GUI();
            jf.dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == jlNewUser) {
            jlNewUser.setForeground(Color.BLUE);
        }
        if (e.getSource() == jtfID) {
            jltID.setVisible(true);
        }
        if (e.getSource() == jpfPassword) {
            jltPass.setVisible(true);
        }
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == jlNewUser) {
            jlNewUser.setForeground(Color.BLACK);
        }
        if (e.getSource() == jtfID) {
             jltID.setVisible(false);
        }
        if (e.getSource() == jpfPassword) {
            jltPass.setVisible(false);
        }
    }
}
