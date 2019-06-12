package niitprojcet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Fapiao {

    public void GUI() {
        Font font = new Font("Arial", Font.PLAIN, 20);
        jlTitle = new JLabel("BFTZ Company Invoice");
        jlTitle.setFont(new Font("宋体", Font.BOLD, 30));
        jlTitle.setBounds(20, 20, 360, 50);

        jlTime = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        jlTime.setBounds(200, 150, 200, 30);
        jlTime.setFont(font);

        jlFen1 = new JLabel("------------------------------------------------------------------------------------------------");
        jlFen1.setBounds(5, 180, 390, 20);

        jlShou = new JLabel("Recipients' name:               " + Deliver.Name2);
        jlShou.setBounds(5, 200, 390, 20);
        jlShou.setFont(font);
 
        jlFa = new JLabel("Addresser's name:             " + Deliver.Name1);
        jlFa.setBounds(5, 220, 390, 20);
        jlFa.setFont(font);

        jlCity1 = new JLabel("From:                                " + Deliver.City1);
        jlCity1.setBounds(5, 240, 390, 20);
        jlCity1.setFont(font);

        jlCity2 = new JLabel("To:                                    " + Deliver.City2);
        jlCity2.setBounds(5, 260, 390, 20);
        jlCity2.setFont(font);


        jlOrder = new JLabel("Order ID:                          " + Deliver.orderID);
        jlOrder.setBounds(5, 280, 390, 20);
        jlOrder.setFont(font);
  
        jlWeight = new JLabel("Weight:                             " + Deliver.weight);
        jlWeight.setBounds(5, 300, 390, 20);
        jlWeight.setFont(font);

        jlType = new JLabel("Mode of transportation:      " + Deliver.type);
        jlType.setBounds(5, 320, 390, 20);
        jlType.setFont(font);

        jlName = new JLabel("Food name:                       " + Deliver.Cargo_Name);
        jlName.setBounds(5, 340, 390, 20);
        jlName.setFont(font);

        jlFen2 = new JLabel("------------------------------------------------------------------------------------------------");
        jlFen2.setBounds(5, 360, 390, 20);

        jlMoney1 = new JLabel("Payment should be:            " + Deliver.price);
        jlMoney1.setBounds(5, 380, 390, 20);
        jlMoney1.setFont(font);

        jlMoney2 = new JLabel("Paid:                                 " + Deliver.price);
        jlMoney2.setBounds(5, 400, 390, 20);
        jlMoney2.setFont(font);


        jf = new JFrame("Invoice");
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.setResizable(false);
        jf.setSize(400, 600);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.add(jlTitle);
        jf.add(jlFen1);
        jf.add(jlFen2);
        jf.add(jlCity1);
        jf.add(jlCity2);
        jf.add(jlShou);
        jf.add(jlFa);
        jf.add(jlName);
        jf.add(jlOrder);
        jf.add(jlWeight);
        jf.add(jlType);
        jf.add(jlMoney1);
        jf.add(jlMoney2);
        jf.add(jlTime);
    }

    public static void main(String[] args) {
        new Fapiao().GUI();
    }
    private JFrame jf;
    private JLabel jlTitle, jlFen1, jlFen2, jlCity1, jlCity2, jlShou,
            jlFa, jlName, jlOrder, jlWeight, jlType, jlMoney1, jlMoney2, jlTime; 
}
