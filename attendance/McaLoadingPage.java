package IMIT;

import javax.swing.*;
import java.awt.*;

public class McaLoadingPage extends JFrame implements Runnable{

    Thread thread;
    JProgressBar pbar;
    String staffname,Designation,department,email_id;
    
    McaLoadingPage( String staffname,String Designation,String department,String email_id ){
        //used for store local variable into global variable
        this.staffname = staffname;
        this.Designation = Designation;
        this.department = department;
        this.email_id = email_id;
        
        thread = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(new Color(29, 59, 85));
        setLayout(null);
        
        JLabel titletext = new JLabel ("IMIT ATTENDANCE APPLICATION");
        titletext.setBounds(90, 20, 600, 40);
        titletext.setForeground(Color.white);
        titletext.setFont(new Font("Railway", Font.BOLD, 30));
        add(titletext);
        
        //Used for displaying Progressbar
        pbar = new JProgressBar();
        pbar.setBounds(150, 100, 300, 30);
        pbar.setStringPainted(true);// used for show progress value 0%
        add(pbar);
        
        JLabel loadingmessgae = new JLabel ("Loading, please wait");
        loadingmessgae.setBounds(230, 130, 150, 30);
        loadingmessgae.setForeground(Color.GRAY);
        loadingmessgae.setFont(new Font("Railway", Font.BOLD, 14));
        add(loadingmessgae);
        
        JLabel welcomemessage = new JLabel ("Welcome " + staffname);
        welcomemessage.setBounds(20, 310, 400, 40);
        welcomemessage.setForeground(new Color(0, 255, 0));
        welcomemessage.setFont(new Font("Railway", Font.BOLD, 16));
        add(welcomemessage);
        
        thread.start();
        setVisible(true);
    }
    
    public static void main (String args[]){
        new McaLoadingPage("", "", "", "");
    }

    // for running progressbar from 0% to 100%, multithreadung concept is used by using Runnable interface
    @Override
    public void run() {
        try{
            for(int i = 1; i <= 101; i++){
                int maximum = pbar.getMaximum(); //it's 100
                int value = pbar.getValue();
                
                if(value < maximum){ // upto 100 <101
                    pbar.setValue(pbar.getValue() + 1); // increment the value by 1
                }else {
                    setVisible(false);
                    new McaDashboard(staffname,Designation,department,email_id);
                }
                Thread.sleep(30);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

