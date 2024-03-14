package IMIT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class TrackerPage extends JFrame implements ActionListener{

    Choice choice1, choice2, choice3;
    JTextField tfusername;
    JButton view, back;

    TrackerPage(){

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(225,225,225));


        // Details part
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(29, 59, 85));
        panel1.setBounds(0, 50, 1600, 155);
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/Imitlogo.png"));
        JLabel imagee = new JLabel(i1);
        imagee.setBounds(80, 3, 150, 150);
        panel1.add(imagee);

        // Heading part
        JLabel maintext2 = new JLabel("Attendance Tracker");
        maintext2.setBounds(550, 30, 1000, 70);
        maintext2.setForeground(Color.WHITE);
        maintext2.setFont(new Font("Raleway", Font.BOLD, 45));
        panel1.add(maintext2);

        // IMIT logo
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("imgs/Imitlogo.png"));
        JLabel image1 = new JLabel(i2);
        image1.setBounds(1280, 3, 150, 150);
        panel1.add(image1);

        // DropDown1
        JLabel choicename1 = new JLabel("Semester");
        choicename1.setBounds(70, 300, 100, 20);
        choicename1.setBackground(new Color(29, 75, 100));
        choicename1.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename1);

        choice1 = new Choice();
        choice1.add("First");
        choice1.add("Second");
        choice1.add("Third");
        choice1.add("Four");
        choice1.setBounds(70, 323, 150, 80);
        choice1.setBackground(new Color(29, 75, 100));
        choice1.setForeground(Color.WHITE);
        choice1.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice1);

        //DropDown2
        JLabel choicename2 = new JLabel("Date");
        choicename2.setBounds(270, 300, 100, 20);
        choicename2.setBackground(new Color(29, 75, 100));
        choicename2.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename2);

        tfusername = new JTextField();
        tfusername.setBounds(270, 323, 150, 20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setBackground(new Color(29, 75, 100));
        tfusername.setForeground(Color.WHITE);
        tfusername.setFont(new Font("Raleway", Font.BOLD, 15));
        tfusername.setCaretColor(Color.WHITE);
        add(tfusername);

        //DropDown3
        JLabel choicename3 = new JLabel("Subject");
        choicename3.setBounds(470, 300, 100, 20);
        choicename3.setBackground(new Color(29, 75, 100));
        choicename3.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename3);

        choice2 = new Choice();
        choice2.add("JAVA");
        choice2.add("ADA");
        choice2.add("OOAD");
        choice2.add("CN");
        choice2.add("IWP");
        choice2.setBounds(470, 323, 150, 40);
        choice2.setBackground(new Color(29, 75, 100));
        choice2.setForeground(Color.WHITE);
        choice2.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice2);

        //DropDown4
        JLabel choicename4 = new JLabel("Sections");
        choicename4.setBounds(670, 300, 100, 20);
        choicename4.setBackground(new Color(29, 75, 100));
        choicename4.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename4);

        choice3 = new Choice();
        choice3.add("Sec A");
        choice3.add("Sec B");
        choice3.setBounds(670, 323, 150, 40);
        choice3.setBackground(new Color(29, 75, 100));
        choice3.setForeground(Color.WHITE);
        choice3.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice3);

        // Login Button
        back = new JButton("Bhak");
        back.setBounds(1400, 316, 100, 25);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        add(back);

        // view Button
        view = new JButton("View");
        view.setBounds(1230, 315, 110, 30);
        view.setBorder(new LineBorder(new Color(133, 193, 233)));
        view.setBackground(new Color(29, 75, 100));
        view.setForeground(Color.WHITE);
        view.setFont(new Font("Raleway", Font.BOLD, 12));
        view.setCursor(new Cursor(Cursor.HAND_CURSOR));
        view.addActionListener(this);
        add(view);



        setVisible(true);
    }

    public static void main(String[] args){
        new TrackerPage();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == back){
                setVisible(false);
                new Dashboard();
            }
    }

}

