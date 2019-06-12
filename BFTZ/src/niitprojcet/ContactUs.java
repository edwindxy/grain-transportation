package niitprojcet;

import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class ContactUs implements ActionListener {

    public ContactUs() {
        Font font = new Font("Arial", Font.BOLD, 20);
        jlTrip = new JLabel("Please enter your comments or Suggestions");
        jlTrip.setBounds(35, 40, 530, 40);
        jlTrip.setFont(new Font("Arial", Font.BOLD, 24));
        jlTrip.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        jtaComment = new JTextArea();
        jtaComment.setBounds(100, 100, 400, 280);
        jtaComment.setLineWrap(true);
        jtaComment.setWrapStyleWord(true);
        jtaComment.setFont(new Font("Arial", Font.PLAIN, 20));

        jbSubmit = new JButton("Submit");
        jbSubmit.setBounds(100, 400, 150, 40);
        jbSubmit.setFont(font);
        jbSubmit.addActionListener(this);

        jbCancel = new JButton("Cancel");
        jbCancel.setBounds(350, 400, 150, 40);
        jbCancel.setFont(font);
        jbCancel.addActionListener(this);

        jp = new JPanel();
        jp.setLayout(null);
        jp.setBounds(0, 0, 600, 500);
        jp.add(jbSubmit);
        jp.add(jbCancel);
        jp.add(jtaComment);
        jp.add(jlTrip);

        jf = new JFrame("Contact Us");
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setResizable(false);
        jf.setSize(600, 500);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.add(jp);
    }

    public static void main(String[] args) {
        new ContactUs();
    }
    private JFrame jf;
    private JPanel jp;
    private JButton jbSubmit, jbCancel;
    private JLabel jlTrip;
    private JTextArea jtaComment;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbSubmit) {
            if (jtaComment.getText().length() == 0) {
                JOptionPane.showMessageDialog(jf, "The information is too short");
            } else if (jtaComment.getText().length() > 199) {
                JOptionPane.showMessageDialog(jf, "The information is too long");
            } else {
                Connection con = null;
                PreparedStatement ps = null;
                try {
                    con = (Connection) DBUtil.getConnection();
                    String sql = "insert into user_feedback values(null,?,?,now())";
                    ps = (PreparedStatement) con.prepareStatement(sql);
                    ps.setLong(1, Long.parseLong(Login.Phone));
                    ps.setString(2, jtaComment.getText());
                    ps.execute();
                    JOptionPane.showMessageDialog(jf, "Submit successfully!");
                    jf.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(jf, ex);
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

        if (e.getSource() == jbCancel) {
            jf.dispose();
        }
    }
}
