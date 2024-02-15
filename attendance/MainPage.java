package imit.attendance;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class MainPage extends JFrame implements ActionListener{
    
    JButton attendancebuton;
    
    MainPage(){
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
       // Add Design in this page
  
       attendancebuton = new JButton("Attendance Record");
       attendancebuton.setBounds(60, 200, 135, 35);
       attendancebuton.setBackground(new Color(29,75,100));
       attendancebuton.setForeground(Color.WHITE);
       attendancebuton.setBorder(new LineBorder(new Color(133, 193, 233)));
       attendancebuton.addActionListener(this);
       add(attendancebuton);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new MainPage();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == attendancebuton){
             new SelectBranch();
        } 
    }
}