package niitprojcet;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;

public class Deliver extends JFrame implements ActionListener, MouseListener {

    public void GUI() {
        Font font = new Font("a", Font.PLAIN, 20);



        jltRName2 = new JLabel(" receiver's name");
        jltRName2.setVisible(false);
        jltRName2.setBounds(760, 390, 140, 30);

        jltRName1 = new JLabel("Please enter the");
        jltRName1.setVisible(false);
        jltRName1.setBounds(760, 350, 140, 30);

        jltRPhone3 = new JLabel(" number");
        jltRPhone3.setVisible(false);
        jltRPhone3.setBounds(760, 430, 140, 30);

        jltRPhone1 = new JLabel("receiver's telephone");
        jltRPhone1.setVisible(false);
        jltRPhone1.setBounds(760, 390, 140, 30);

        jltRPhone2 = new JLabel("Please enter the");
        jltRPhone2.setVisible(false);
        jltRPhone2.setBounds(760, 350, 140, 30);

        jltRemarks2 = new JLabel(" of the goods");
        jltRemarks2.setVisible(false);
        jltRemarks2.setBounds(720, 250, 190, 30);

        jltRemarks1 = new JLabel("Please enter information");
        jltRemarks1.setVisible(false);
        jltRemarks1.setBounds(720, 220, 190, 30);

        jltName = new JLabel("Please enter what you send");
        jltName.setVisible(false);
        jltName.setBounds(720, 170, 190, 30);

        jltWight = new JLabel("Please send less than 10⁶KG");
        jltWight.setVisible(false);
        jltWight.setBounds(720, 130, 190, 30);



        jlAsk = new JLabel("Fill in information");
        jlAsk.setBounds(320, 20, 260, 40);
        jlAsk.setFont(new Font("Arial", Font.BOLD, 26));

        jlType = new JLabel("Vehicle:");
        jlType.setBounds(320, 90, 120, 30);
        jlType.setFont(font);

        jcbType = new JComboBox();
        jcbType.setBounds(460, 90, 250, 30);
        jcbType.setFont(font);

        jcbType.addItem("Sea(0.0001 yuan/(Kg*Km))");
        jcbType.addItem("Land(0.0002 yuan/(Kg*Km))");
        jcbType.addItem("Air(0.0003 yuan/(Kg*Km))");

        jlWeight = new JLabel("Weight(Kg):");
        jlWeight.setBounds(320, 130, 120, 30);
        jlWeight.setFont(font);

        jtfWeight = new JTextField();
        jtfWeight.setBounds(460, 130, 250, 30);
        jtfWeight.setFont(font);
        jtfWeight.addMouseListener(this);

        jlHName = new JLabel("Food Name:");
        jlHName.setBounds(320, 170, 120, 30);
        jlHName.setFont(font);

        jtfHName = new JTextField();
        jtfHName.setBounds(460, 170, 250, 30);
        jtfHName.setFont(font);
        jtfHName.addMouseListener(this);

        jlRemark = new JLabel("Remarks:");
        jlRemark.setBounds(320, 210, 120, 30);
        jlRemark.setFont(font);




        //  contentPane.add(textArea);


        jtaRemark = new JTextArea();
        jtaRemark.setBounds(460, 210, 250, 50);
        jtaRemark.setLineWrap(true);
        jtaRemark.setWrapStyleWord(true);
        jtaRemark.setFont(font);
        jtaRemark.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jtaRemark.addMouseListener(this);
        scrollPane_1 = new JScrollPane(jtaRemark);
        scrollPane_1.setBounds(460, 210, 250, 50);
        scrollPane_1.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane_1.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jlAdr = new JLabel("Addresser:");
        jlAdr.setFont(font);
        jlAdr.setBounds(200, 280, 130, 30);

        jlRec = new JLabel("Recipients:");
        jlRec.setFont(font);
        jlRec.setBounds(570, 280, 130, 30);

        jlID = new JLabel("Phone:");
        jlID.setFont(font);
        jlID.setBounds(90, 350, 130, 30);

        jtfID1 = new JTextField();
        jtfID1.setFont(font);
        jtfID1.setBounds(170, 350, 220, 30);
        jtfID1.setText(Login.Phone);
        jtfID1.setEditable(false);
        jtfID1.addMouseListener(this);

        jtfID2 = new JTextField();
        jtfID2.setFont(font);
        jtfID2.setBounds(540, 350, 220, 30);
        jtfID2.addMouseListener(this);

        jlName = new JLabel("Name:");
        jlName.setFont(font);
        jlName.setBounds(90, 390, 60, 30);

        jtfName1 = new JTextField();
        jtfName1.setFont(font);
        jtfName1.setBounds(170, 390, 220, 30);
        jtfName1.setText(Login.Name);
        jtfName1.setEditable(false);
        jtfName1.addMouseListener(this);

        jtfName2 = new JTextField();
        jtfName2.setFont(font);
        jtfName2.setBounds(540, 390, 220, 30);
        jtfName2.addMouseListener(this);


        jlCity = new JLabel("City:");
        jlCity.setFont(font);
        jlCity.setBounds(90, 430, 60, 30);
        jcbCity1 = new JComboBox();
        jcbCity1.setFont(font);
        jcbCity1.setBounds(170, 430, 220, 30);
        jcbCity1.addItem("Haikou");
        jcbCity1.addItem("Beijing");
        jcbCity1.addItem("Shanghai");
        jcbCity1.addItem("Guangzhou");
        jcbCity2 = new JComboBox();
        jcbCity2.setFont(font);
        jcbCity2.setBounds(540, 430, 220, 30);
        jcbCity2.addItem("Haikou");
        jcbCity2.addItem("Beijing");
        jcbCity2.addItem("Shanghai");
        jcbCity2.addItem("Guangzhou");

        jbSubmit = new JButton("Submit");
        jbSubmit.setFont(font);
        jbSubmit.setBounds(560, 475, 200, 40);
        jbSubmit.addActionListener(this);

        jlPic1 = new JLabel(new ImageIcon(getClass().getResource("/pic/p1.png")));
        jlPic1.setBounds(100, 70, 200, 200);
        jpMain = new JLayeredPane();
        jpMain.setLayout(null);
        jpMain.setBounds(150, 200, 900, 600);
        jpMain.add(jlID);
        jpMain.add(jtfID1);
        jpMain.add(jtfID2);
        jpMain.add(jlName);
        jpMain.add(jtfName1);
        jpMain.add(jtfName2);
        jpMain.add(jlCity);
        jpMain.add(jcbCity1);
        jpMain.add(jcbCity2);
        jpMain.add(jlAdr);
        jpMain.add(jlRec);
        jpMain.add(jbSubmit);
        jpMain.add(jlAsk);
        jpMain.add(jlType);
        jpMain.add(jcbType);
        jpMain.add(jlWeight);
        jpMain.add(jtfWeight);
        jpMain.add(jlHName);
        jpMain.add(jtfHName);
        jpMain.add(jlRemark);
        jpMain.add(jtaRemark);
        jpMain.add(scrollPane_1);
        jpMain.add(jlPic1);
        jpMain.add(jltWight);
        jpMain.add(jltName);
        jpMain.add(jltRemarks1);
        jpMain.add(jltRemarks2);
        jpMain.add(jltRPhone1);
        jpMain.add(jltRPhone2);
        jpMain.add(jltRPhone3);
        jpMain.add(jltRName1);
        jpMain.add(jltRName2);



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
                int option = JOptionPane.showConfirmDialog(Deliver.this, "exit?", "提示", JOptionPane.YES_NO_OPTION);
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
        new Deliver().GUI();
    }
    public static int juli, orderID, s;
    public static int weight, price;
    public static int X1, Y1, X2, Y2;
    public static String ID1, Name1, ID2, Name2, City1, City2, Cargo_Infor, Cargo_Name, type;
    public static String phone1, phone2, name1, name2;
    private JFrame jf;
    private JPanel jpUp, jpDown;
    private JLayeredPane jlpBig, jpMain;
    private JButton jbUCenter, jbContactUs, jbSet, jbSearch, jbBack, jbSubmit;
    private JLabel jlGround, jlUserName, jlDown, jlPic1, jlAdr, jlRec, jlType,
            jlHName, jlWeight, jlRemark, jlAsk, jlID, jlName, jlCity,
            jltWight, jltName, jltRemarks1, jltRemarks2, jltRPhone1, jltRPhone2, jltRPhone3, jltRName1, jltRName2;
    private JTextField jtfSearch, jtfID1, jtfID2, jtfName1, jtfName2, jtfHName, jtfWeight;
    private JTextArea jtaRemark;
    private JComboBox jcbCity1, jcbCity2, jcbType;
    private JScrollPane scrollPane_1;

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
            if (jtfWeight.getText().length() == 0 || jtfHName.getText().length() == 0
                    || jtaRemark.getText().length() == 0
                    || jtfID2.getText().length() == 0
                    || jtfName2.getText().length() == 0) {
                JOptionPane.showMessageDialog(jf, "Please enter full information!");
            } else if (jcbCity1.getSelectedIndex() == jcbCity2.getSelectedIndex()) {
                JOptionPane.showMessageDialog(jf, "Please select two different cities!");
            } else {
                boolean flag2 = true;
                try {
                    weight = Integer.parseInt(jtfWeight.getText());
                    if (weight <= 1000 || weight > 1000000) {
                        weight = weight / 0;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(jf, "Weight must be a integer and between 1000 and 1000000 ");
                    flag2 = false;
                }
                if (flag2) {
                    Connection con = null;
                    PreparedStatement ps = null;
                    ResultSet rs = null;
                    try {
                        con = DBUtil.getConnection();
                        String sql = "select 1 from Users where User_phone=?";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, jtfID2.getText());
                        rs = ps.executeQuery();
                        {
                            if (!rs.next()) {
                                JOptionPane.showMessageDialog(jf, "Recipient's ID does not exist");
                            } else {
                                sql = "select * from Citys where city_Id=?";
                                ps = con.prepareStatement(sql);
                                ps.setInt(1, jcbCity1.getSelectedIndex());
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    X1 = rs.getInt(4);
                                    Y1 = rs.getInt(5);
                                }
                                sql = "select * from Citys where city_Id=?";
                                ps = con.prepareStatement(sql);
                                ps.setInt(1, jcbCity2.getSelectedIndex());
                                rs = ps.executeQuery();
                                while (rs.next()) {
                                    X2 = rs.getInt(4);
                                    Y2 = rs.getInt(5);
                                }
                                Deliver.orderID = new Random().nextInt(900001) + 100000;
                                juli(jcbCity1.getSelectedIndex() + 1, jcbCity2.getSelectedIndex() + 1);
                                price = weight * (jcbType.getSelectedIndex() + 1) * juli / 10000;
                                ID1 = jtfID1.getText();
                                ID2 = jtfID2.getText();
                                Name1 = jtfName1.getText();
                                Name2 = jtfName2.getText();
                                City1 = (String) jcbCity1.getSelectedItem();
                                City2 = (String) jcbCity2.getSelectedItem();
                                Cargo_Name = jtfHName.getText();
                                Cargo_Infor = jtaRemark.getText();
                                type = (String) jcbType.getSelectedItem();
                                s = jcbType.getSelectedIndex();
                                Payment payment = new Payment();
                            }
                        }
                    } catch (Exception ex1) {
                        JOptionPane.showMessageDialog(jf, "Please enter the correct information");
                    } finally {
                        try {
                            rs.close();
                            ps.close();
                            con.close();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(jf, "Please enter the correct information");
                        }
                    }
                }
            }
        }
    }

    private void juli(int a, int b) {
        if ((a == 1 && b == 2) || (a == 2 && b == 1)) {
            juli = 2200;
        }
        if ((a == 1 && b == 3) || (a == 3 && b == 1)) {
            juli = 1700;
        }
        if ((a == 1 && b == 4) || (a == 4 && b == 1)) {
            juli = 460;
        }
        if ((a == 2 && b == 3) || (a == 3 && b == 2)) {
            juli = 1100;
        }
        if ((a == 2 && b == 4) || (a == 4 && b == 2)) {
            juli = 1900;
        }
        if ((a == 3 && b == 4) || (a == 4 && b == 3)) {
            juli = 1200;
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

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == jtfWeight) {
            jltWight.setVisible(true);
        }

        if (e.getSource() == jltName) {
            jltName.setVisible(true);
        }

        if (e.getSource() == jtaRemark) {
            jltRemarks1.setVisible(true);
        }
        if (e.getSource() == jtaRemark) {
            jltRemarks2.setVisible(true);
        }

        if (e.getSource() == jtfID2) {
            jltRPhone1.setVisible(true);
        }
        if (e.getSource() == jtfID2) {
            jltRPhone2.setVisible(true);
        }

        if (e.getSource() == jtfID2) {
            jltRPhone3.setVisible(true);
        }

        if (e.getSource() == jtfName2) {
            jltRName1.setVisible(true);
        }


        if (e.getSource() == jtfName2) {
            jltRName2.setVisible(true);
        }

    }
//  private JTextField jtfSearch, jtfID1, jtfID2, jtfName1, jtfName2, jtfHName, jtfWeight;
//    jltWight,jltName,jltRemarks,jltSPhone,jltSName,jltRPhone,jltRName;

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == jtfWeight) {
            jltWight.setVisible(false);
        }
        if (e.getSource() == jltName) {
            jltName.setVisible(false);
        }

        if (e.getSource() == jtaRemark) {
            jltRemarks1.setVisible(false);
        }
        if (e.getSource() == jtaRemark) {
            jltRemarks2.setVisible(false);
        }

        if (e.getSource() == jtfID2) {
            jltRPhone1.setVisible(false);
        }
        if (e.getSource() == jtfID2) {
            jltRPhone2.setVisible(false);
        }
        if (e.getSource() == jtfID2) {
            jltRPhone3.setVisible(false);
        }

        if (e.getSource() == jtfName2) {
            jltRName1.setVisible(false);
        }

        if (e.getSource() == jtfName2) {
            jltRName2.setVisible(false);
        }
    }
}
