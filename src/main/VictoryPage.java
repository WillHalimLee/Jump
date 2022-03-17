package main;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VictoryPage extends JFrame{
    JFrame frame;
    Container con;

    JButton logInButton, signUpButton;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6;
    JLabel label1;

    public VictoryPage() {
        frame = new JFrame();
        frame.setSize(528, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Jumping Mania");

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 528, 192);
        panel1.setBackground(new Color(254, 247, 220));
        panel1.setLayout(null);
        frame.add(panel1);

        label1 = new JLabel();
        label1.setText("VICTORY!!! NOW IM GOING TO CRASH THE GAME!!!");
        label1.setHorizontalTextPosition(JLabel.CENTER); //set text Left, Center, Right of image-icon
        label1.setVerticalTextPosition(JLabel.BOTTOM); //set text Top, center, bottom of image-icon
        label1.setForeground(new Color(234, 92, 43)); //set font color of text
        label1.setFont(new Font("MV Boli", Font.BOLD, 72)); //set font of text
        label1.setBounds(45, 0, 528, 192);
        panel1.add(label1);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}

