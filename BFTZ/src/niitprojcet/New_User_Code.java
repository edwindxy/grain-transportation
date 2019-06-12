/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package niitprojcet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class New_User_Code extends JFrame implements ActionListener, MouseListener {

    public void GUI() {
        Font font = new Font("a", Font.BOLD, 20);

//jltfSearch, jltfPho, jltfName, jltfEmail, jltfAdd, jltfDate,
//            jltfPas, jltfRpass;(375, 70, 350, 30);




        jltfDate = new JLabel("Please enter your birthday like YYYY-MM-DD");
//        jltfPho.setFont(font);
        jltfDate.setVisible(false);
        jltfDate.setBounds(375, 470, 550, 20);

        jltfAdd = new JLabel("Please enter your address less than 120 words");
//        jltfPho.setFont(font);
        jltfAdd.setVisible(false);
        jltfAdd.setBounds(375, 420, 550, 20);

        jltfEmail = new JLabel("Please enter a exist Email account");
//        jltfPho.setFont(font);
        jltfEmail.setVisible(false);
        jltfEmail.setBounds(375, 300, 550, 20);

        jltfName = new JLabel("Please enter the name less than 30 words");
//        jltfPho.setFont(font);
        jltfName.setVisible(false);
        jltfName.setBounds(375, 250, 550, 20);

        jltfRpass = new JLabel("Please enter your Password once more");
//        jltfPho.setFont(font);
        jltfRpass.setVisible(false);
        jltfRpass.setBounds(375, 200, 550, 20);

        jltfPas = new JLabel("Please enter your Password less than 50 words");
//        jltfPho.setFont(font);
        jltfPas.setVisible(false);
        jltfPas.setBounds(375, 150, 550, 20);


        jltfPho = new JLabel("Please enter the telephone number in eleven digits");
//        jltfPho.setFont(font);
        jltfPho.setVisible(false);
        jltfPho.setBounds(375, 100, 550, 20);

        //后方输入框
        jbRegi = new JButton("Register");
        jbRegi.setFont(font);
        jbRegi.setBounds(375, 545, 150, 50);
        jbRegi.setBackground(Color.GREEN);
        jbRegi.addActionListener(this);
        jbRegi.addMouseListener(this);

        jcbCountry = new JComboBox();
        jcbCountry.setFont(font);
        jcbCountry.setBounds(375, 490, 150, 30);
        jcbCountry.addItem("China");
        jcbCountry.addItem("Amercian");
        jcbCountry.addItem("Canada");
        jcbCountry.addItem("England");
        jcbCountry.addItem("India");

        jtfDate = new JTextField();
        jtfDate.setFont(font);
        jtfDate.setBounds(375, 440, 350, 30);
        jtfDate.addMouseListener(this);

        jtfAdd = new JTextField();
        jtfAdd.setFont(font);
        jtfAdd.setBounds(375, 370, 350, 50);
        jtfAdd.addMouseListener(this);

        jcbCity = new JComboBox();
        jcbCity.setFont(font);
        jcbCity.setBounds(375, 320, 150, 30);
        jcbCity.addItem("Haikou");
        jcbCity.addItem("Beijing");
        jcbCity.addItem("Shanghai");
        jcbCity.addItem("Guanzhou");

        jtfEmail = new JTextField();
        jtfEmail.setFont(font);
        jtfEmail.setBounds(375, 270, 350, 30);
        jtfEmail.addMouseListener(this);

        jtfName = new JTextField();
        jtfName.setFont(font);
        jtfName.setBounds(375, 220, 350, 30);
        jtfName.addMouseListener(this);

        jtfRpass = new JPasswordField();
        jtfRpass.setFont(font);
        jtfRpass.setBounds(375, 170, 350, 30);
        jtfRpass.addMouseListener(this);

        jtfPas = new JPasswordField();
        jtfPas.setFont(font);
        jtfPas.setBounds(375, 120, 350, 30);
        jtfPas.addMouseListener(this);

        jtfPho = new JTextField();
        jtfPho.setFont(font);
        jtfPho.setBounds(375, 70, 350, 30);
        jtfPho.addMouseListener(this);



        //前端名字
        jbUser_Country = new JButton("Nationality");
        jbUser_Country.setFont(font);
        jbUser_Country.setBounds(175, 490, 140, 30);
        jbUser_Country.setBackground(Color.GREEN);

        jbUser_Date = new JButton("Birthday");
        jbUser_Date.setFont(font);
        jbUser_Date.setBounds(175, 440, 140, 30);
        jbUser_Date.setBackground(Color.GREEN);

        jbUser_Address = new JButton("Address");
        jbUser_Address.setFont(font);
        jbUser_Address.setBounds(175, 370, 140, 50);
        jbUser_Address.setBackground(Color.GREEN);

        jbUser_City = new JButton("City");
        jbUser_City.setFont(font);
        jbUser_City.setBounds(175, 320, 140, 30);
        jbUser_City.setBackground(Color.GREEN);


        jbUser_Email = new JButton("Email");
        jbUser_Email.setFont(font);
        jbUser_Email.setBounds(175, 270, 140, 30);
        jbUser_Email.setBackground(Color.GREEN);

        jbUser_Name = new JButton("Name");
        jbUser_Name.setFont(font);
        jbUser_Name.setBounds(175, 220, 140, 30);
        jbUser_Name.setBackground(Color.GREEN);


        jbUser_Rpass = new JButton("RE-Enter");
        jbUser_Rpass.setFont(font);
        jbUser_Rpass.setBounds(175, 170, 140, 30);
        jbUser_Rpass.setBackground(Color.GREEN);


        jbUser_Pass = new JButton("Password");
        jbUser_Pass.setFont(font);
        jbUser_Pass.setBounds(175, 120, 140, 30);
        jbUser_Pass.setBackground(Color.GREEN);

        jbUser_Pho = new JButton("Phone");
        jbUser_Pho.setFont(font);
        jbUser_Pho.setBounds(175, 70, 140, 30);
        jbUser_Pho.setBackground(Color.GREEN);

        jlTitle = new JLabel("New User Registration");
        jlTitle.setFont(font);
        jlTitle.setBounds(335, 5, 300, 50);


//        jbUser_ID = new JButton("User ID"); 
//        jbUser_ID.setFont(font);
//        jbUser_ID.setBounds(120, 120, 140, 30);        
//        jbUser_ID.setBackground(Color.GREEN);



        //中间部分
        jpInfor = new JLayeredPane();
        jpInfor.setLayout(null);
        jpInfor.setBounds(150, 200, 900, 600);
//        jpInfor.setBackground(new Color(144, 205, 255));
        jpInfor.add(jlTitle);
//        jpInfor.add(jbUser_ID);
        jpInfor.add(jbUser_Pho);
        jpInfor.add(jbUser_Pass);
        jpInfor.add(jbUser_Name);
        jpInfor.add(jbUser_Email);
        jpInfor.add(jbUser_Rpass);
        jpInfor.add(jbUser_City);
        jpInfor.add(jbUser_Address);
        jpInfor.add(jbUser_Date);
        jpInfor.add(jbUser_Country);
        jpInfor.add(jtfPho);
        jpInfor.add(jtfPas);
        jpInfor.add(jtfName);
        jpInfor.add(jtfEmail);
        jpInfor.add(jtfRpass);
        jpInfor.add(jcbCity);
        jpInfor.add(jtfAdd);
        jpInfor.add(jtfDate);
        jpInfor.add(jcbCountry);
        jpInfor.add(jbRegi);
        jpInfor.add(jltfPho);
        jpInfor.add(jltfName);
        jpInfor.add(jltfEmail);
        jpInfor.add(jltfAdd);
        jpInfor.add(jltfDate);
        jpInfor.add(jltfPas);
        jpInfor.add(jltfRpass);



        //上方按钮部分
        jtfSearch = new JTextField();
        jtfSearch.setFont(font);
        jtfSearch.setBounds(410, 15, 350, 40);

        jbSearch = new JButton("Search");
        jbSearch.setFont(font);
        jbSearch.setBounds(800, 15, 100, 40);
        jbSearch.addActionListener(this);

        jlGround = new JLabel();
        jlGround.setBounds(0, 0, 1200, 800);
        jlGround.setIcon(new ImageIcon(getClass().getResource("/Pic/Background.png")));
        jlpBig = new JLayeredPane();
        jlpBig.setLayout(null);
        jlpBig.setBackground(Color.YELLOW);
        jlpBig.setBounds(0, 40, 1200, 800);
        jlpBig.add(jtfSearch);
        jlpBig.add(jbSearch);
        jlpBig.add(jpInfor);
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
        jlDown.setIcon(new ImageIcon(getClass().getResource("/Pic/Down.png")));
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
                int option = JOptionPane.showConfirmDialog(New_User_Code.this, "exit?", "提示", JOptionPane.YES_NO_OPTION);
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
//        jf.add(jpInfor);
    }

    public static void main(String[] args) {
        new New_User_Code().GUI();//运行GUI
    }
    private JFrame jf;
    private JPanel jpUp, jpDown;
    private JLayeredPane jlpBig, jpInfor;
    private JButton jbUCenter, jbContactUs, jbSet, jbSearch, jbBack,
            jbUser_ID, jbUser_Pho, jbUser_Pass, jbUser_Name, jbUser_Email,
            jbUser_Rpass, jbUser_City, jbUser_Address, jbUser_Date, jbUser_Country,
            jbRegi;
    private JLabel jlGround, jlName, jlDown, jlTitle,
            jltfSearch, jltfPho, jltfName, jltfEmail, jltfAdd, jltfDate,
            jltfPas, jltfRpass;
    ;
    private JTextField jtfSearch, jtfPho, jtfName, jtfEmail, jtfAdd, jtfDate;
    private JPasswordField jtfPas, jtfRpass;
    private JComboBox jcbCity, jcbCountry;

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
            new Login().GUI();
        }

        if (e.getSource() == jbRegi) {
            if (jtfPas.getText().equals(jtfRpass.getText())) {
                try {
                    Connection cn = DBUtil.getConnection();//连接数据库
                    String sql = "INSERT INTO Users"
                            + "(User_ID,User_Phone,User_Password,User_Name,User_Email,User_City,User_Address,User_DateOfBirth,User_Country) "
                            + "VALUES (null,?,?,?,?,?,?,?,?)";
                    PreparedStatement pdt = cn.prepareStatement(sql);
                    //获取接口，进行SQL语句的执行

                    pdt.setString(1, jtfPho.getText());
                    pdt.setString(2, jtfPas.getText());
//                    pdt.setString(3, jtfRpass.getText());
                    pdt.setString(3, jtfName.getText());
                    pdt.setString(4, jtfEmail.getText());
                    pdt.setString(5, jcbCity.getSelectedItem().toString());
                    pdt.setString(6, jtfAdd.getText());
                    pdt.setString(7, jtfDate.getText());
                    pdt.setString(8, jcbCountry.getSelectedItem().toString());

                    int count = pdt.executeUpdate();//将数据库更新的数据数量存在count中，
                    if (count > 0) {
                        JOptionPane.showMessageDialog(this, "Inserted Successfully!");
                        jf.dispose();
                        new Login().GUI();
//                      jf.dispose();
//                      Login l = new Login();
//                      l.show();            
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to Insert...");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Data format is wrong or the user phone has already exist.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Passwoed is not same!");
            }

        }
    }

    @Override
    public void mouseEntered(MouseEvent ESearch) {
        if (ESearch.getSource() == jtfPho) {
            jltfPho.setVisible(true);
        }
        if (ESearch.getSource() == jtfName) {
            jltfName.setVisible(true);
        }
        if (ESearch.getSource() == jtfEmail) {
            jltfEmail.setVisible(true);
        }
        if (ESearch.getSource() == jtfAdd) {
            jltfAdd.setVisible(true);
        }
        if (ESearch.getSource() == jtfDate) {
            jltfDate.setVisible(true);
        }
        if (ESearch.getSource() == jtfPas) {
            jltfPas.setVisible(true);
        }
        if (ESearch.getSource() == jtfRpass) {
            jltfRpass.setVisible(true);
        }
    }

    @Override
    public void mouseExited(MouseEvent ESearch) {
        if (ESearch.getSource() == jtfPho) {
            jltfPho.setVisible(false);
        }
        if (ESearch.getSource() == jtfName) {
            jltfName.setVisible(false);
        }
        if (ESearch.getSource() == jtfEmail) {
            jltfEmail.setVisible(false);
        }
        if (ESearch.getSource() == jtfAdd) {
            jltfAdd.setVisible(false);
        }
        if (ESearch.getSource() == jtfDate) {
            jltfDate.setVisible(false);
        }
        if (ESearch.getSource() == jtfPas) {
            jltfPas.setVisible(false);
        }
        if (ESearch.getSource() == jtfRpass) {
            jltfRpass.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
