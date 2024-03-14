
package IMIT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

class MailVerification extends JFrame implements ActionListener{

    JTextField tfusername, tfotp;
    JButton verify, back, get;
    String genOtp;

    MailVerification(){

        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);

        getContentPane().setBackground(new Color(29,59,85));

        JPanel jpanel = new JPanel();// Used for divide page into multiple parts
        jpanel.setBackground(new Color(29,75,100));
        jpanel.setBounds(0, 0, 400, 400);
        add(jpanel);

        ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("imgs/McaLoading.jpg"));
        Image image = imageicon.getImage().getScaledInstance(375, 375, Image.SCALE_DEFAULT);
        ImageIcon imageicon2 = new ImageIcon(image);
        JLabel jlabel = new JLabel(imageicon2);
        jlabel.setBounds(90, 120, 200, 200);
        jpanel.add(jlabel);

        JPanel jpanel2 = new JPanel();
        jpanel2.setLayout(null);
        jpanel2.setBounds(400, 30, 450, 300);
        add(jpanel2);

        //Creating Username
        JLabel username = new JLabel("Username"); // The main uses of JLabel is for creating text formate in frame
        username.setBounds(60, 20, 100, 25);
        username.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        username.setForeground(new Color(29,75,100));
        jpanel2.add(username);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        jpanel2.add(tfusername);

        //Creating Password
        JLabel otp = new JLabel("Enter OTP");
        otp.setBounds(60, 110, 100, 25);
        otp.setForeground(new Color(29,75,100));
        otp.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        jpanel2.add(otp);

        tfotp = new JTextField();
        tfotp.setBounds(60, 150, 300, 30);
        tfotp.setBorder(BorderFactory.createEmptyBorder());
        jpanel2.add(tfotp);

        //Creating verify button
        verify = new JButton("Verify");
        verify.setBounds(60, 200, 130, 30);
        verify.setBackground(new Color(29,75,100));
        verify.setForeground(Color.WHITE);
        verify.setBorder(new LineBorder(new Color(29,75,100)));
        verify.addActionListener(this);
        jpanel2.add(verify);

        //Creating back button
        back = new JButton("Back");
        back.setBounds(230, 200, 130, 30);
        back.setBackground(new Color(29,75,100));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(29,75,100)));
        back.addActionListener(this);
        jpanel2.add(back);

        get = new JButton("Get OTP");
        get.setBounds(60, 250, 130, 30);
        get.setBackground(new Color(29,75,100));
        get.setForeground(Color.WHITE);
        get.setBorder(new LineBorder(new Color(29,75,100)));
        get.addActionListener(this);
        jpanel2.add(get);

        setVisible(true);
    }



    public static void main(String[] args){
        new MailVerification();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == verify){
            //Verification of the otp
            String verifiedOTP = genOtp;
            String otp = tfotp.getText();
            if(otp.equals(verifiedOTP)){
                JOptionPane.showMessageDialog(null, "Verified Successfully.");
                // next class ---
            }else{
                JOptionPane.showMessageDialog(null, "Access denied.");
            }


            //new LoadingPage("");
        }else if(ae.getSource() == get){
            Conn c = new Conn();
            String email = null;
            String name = tfusername.getText();
            String query = "select email_id from staff where Name = '" + name +"'";
            try{
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()) {
                    email = rs.getString("email_id");
                }
            }catch(Exception e){
                e.printStackTrace();
            }

            OtpGenerator og = new OtpGenerator();
            genOtp = og.generateOTP();
            try {
                og.setupServerProperties();
                og.draftEmail(genOtp, email);
                og.sendEmail();         //Sending mail to the user email
            }catch(Exception e){
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "OTP has been sent to your Email.");
        }
    }
}
