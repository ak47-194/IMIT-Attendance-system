
package IMIT;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;


public class MBALogin extends JFrame implements ActionListener{
    
    JTextField tfusername, tfpassword;
    JButton login, back;


    MBALogin(){
        
       setSize(900, 400);
       setLocation(350, 200);
       setLayout(null);
       
       getContentPane().setBackground(new Color(29,59,85));
    
       JPanel jpanel = new JPanel();// Used for divide page into multiple parts
       jpanel.setBackground(new Color(29,75,100));
       jpanel.setBounds(0, 0, 400, 400);
       add(jpanel);
       
       ImageIcon imageicon = new ImageIcon(ClassLoader.getSystemResource("imgs/MbaLoading.jpg"));
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
       JLabel password = new JLabel("Password");
       password.setBounds(60, 110, 100, 25);
       password.setForeground(new Color(29,75,100));
       password.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
       jpanel2.add(password);
       
       tfpassword = new JPasswordField();
       tfpassword.setBounds(60, 150, 300, 30);
       tfpassword.setBorder(BorderFactory.createEmptyBorder());
       jpanel2.add(tfpassword);
       
       //Creating Login button
       login = new JButton("Login");
       login.setBounds(60, 200, 130, 30);
       login.setBackground(new Color(29,75,100));
       login.setForeground(Color.WHITE);
       login.setBorder(new LineBorder(new Color(29,75,100)));
       login.addActionListener(this);
       jpanel2.add(login);
       
       //Creating back button
       back = new JButton("Back");
       back.setBounds(230, 200, 130, 30);
       back.setBackground(new Color(29,75,100));
       back.setForeground(Color.WHITE);
       back.setBorder(new LineBorder(new Color(29,75,100)));
       back.addActionListener(this);
       jpanel2.add(back);
    
        setVisible(true);
    }
    
    
    
    public static void main(String[] args){
    new MBALogin();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == login) {
            try {

                String username = tfusername.getText();
                String password = tfpassword.getText();


                // used query for getting username and password
                String query = "select department from staff where username = '" + username + "' AND password = '" + password + "'";
                Conn c = new Conn();
                ResultSet result = c.s.executeQuery(query);
                if (result.next() ) {
                    String department = result.getString("department");
                    String staffname = result.getString("staffname");
                    if (department.equals("MBA")) {
                        setVisible(false);
                        new LoadingPage(staffname);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "galu hauchhi kire");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                    //text.setVisible(true); // show the error message
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new SelectBranch();
        }
        
    }
    
}
