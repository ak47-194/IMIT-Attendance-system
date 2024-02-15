package imit.attendance;

import java.awt.event.*;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard(){
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        // Add Design in this page
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
