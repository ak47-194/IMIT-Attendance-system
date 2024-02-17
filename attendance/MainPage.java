import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainPage extends JFrame implements ActionListener {

    JButton attendance;
    MainPage(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel header = new JPanel();
        header.setBounds(0,0, 1550, 150);
        header.setBackground(Color.BLUE);
        header.setLayout(null);
        add(header);

        JLabel lblname = new JLabel("INSTITUTE OF MANAGEMENT AND INFORMATION TECHNOLOGY,");
        lblname.setBounds(600, 10, 800, 60);
        lblname.setForeground(Color.WHITE);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        header.add(lblname);

        JLabel lblplace = new JLabel("CUTTACK");
        lblplace.setBounds(840, 30, 200, 60);
        lblplace.setForeground(Color.WHITE);
        lblplace.setFont(new Font("Tahoma", Font.PLAIN, 18));
        header.add(lblplace);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img1.gif"));
        Image i24 = i1.getImage().getScaledInstance(600, 20, Image.SCALE_DEFAULT);
        ImageIcon i25 = new ImageIcon(i24);
        JLabel image = new JLabel(i25);
        image.setBounds(580, 70, 600, 20);
        header.add(image);

        JLabel lbltext1 = new JLabel("(A Constituent college of BPUT, Govt. of Odisha)");
        lbltext1.setBounds(660, 90, 600, 20);
        lbltext1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbltext1.setForeground(Color.WHITE);
        header.add(lbltext1);

        JLabel lbltext2 = new JLabel("(Perfection Through Practice)");
        lbltext2.setBounds(750, 100, 500, 60);
        lbltext2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbltext2.setForeground(Color.WHITE);
        header.add(lbltext2);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/imitlogo3.png"));
        JLabel image1 = new JLabel(i2);
        image1.setBounds(150, 0, 200, 150);
        header.add(image1);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/IMITIMAGES/sideimage1.jpeg"));
        Image i4 =  i3.getImage().getScaledInstance(1550, 500, Image.SCALE_DEFAULT);
        ImageIcon i5 = new ImageIcon(i4);
        JLabel image2 = new JLabel(i5);
        image2.setBounds(0, 152, 1550, 300);
        add(image2);
        image2.setVisible(false);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icons/IMITIMAGES/sideimage2.jpg"));
        Image i7 =  i6.getImage().getScaledInstance(1550, 300, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel image3 = new JLabel(i8);
        image3.setBounds(0, 152, 1550, 300);
        add(image3);
        image3.setVisible(false);

        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("icons/IMITIMAGES/sideimage3.jpeg"));
        Image i10 =  i9.getImage().getScaledInstance(1550, 300, Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(i10);
        JLabel image4 = new JLabel(i11);
        image4.setBounds(0, 152, 1550, 300);
        add(image4);
        image4.setVisible(false);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("icons/IMITIMAGES/sideimage4.jpg"));
        Image i13 =  i12.getImage().getScaledInstance(1550, 300, Image.SCALE_DEFAULT);
        ImageIcon i14 = new ImageIcon(i13);
        JLabel image5 = new JLabel(i14);
        image5.setBounds(0, 152, 1550, 300);
        add(image5);
        image5.setVisible(false);

        ImageIcon i15 = new ImageIcon(ClassLoader.getSystemResource("icons/IMITIMAGES/sideimage5.png"));
        Image i16 =  i15.getImage().getScaledInstance(1550, 300, Image.SCALE_DEFAULT);
        ImageIcon i17 = new ImageIcon(i16);
        JLabel image6 = new JLabel(i17);
        image6.setBounds(0, 152, 1550, 300);
        add(image6);
        image6.setVisible(false);

        ImageIcon i18 = new ImageIcon(ClassLoader.getSystemResource("icons/IMITIMAGES/sideimage6.jpeg"));
        Image i19 =  i18.getImage().getScaledInstance(1550, 300, Image.SCALE_DEFAULT);
        ImageIcon i20 = new ImageIcon(i19);
        JLabel image7 = new JLabel(i20);
        image7.setBounds(0, 152, 1550, 300);
        add(image7);
        image7.setVisible(false);

        ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("icons/IMITIMAGES/sideimage7.png"));
        Image i22 =  i21.getImage().getScaledInstance(1550, 300, Image.SCALE_DEFAULT);
        ImageIcon i23 = new ImageIcon(i22);
        JLabel image8 = new JLabel(i23);
        image8.setBounds(0, 152, 1550, 300);
        add(image8);
        image8.setVisible(false);

//        JPanel midpan = new JPanel();
//        midpan.setBounds(0, 452, 1550, 248);
//        midpan.setBackground(Color.CYAN);
//        add(midpan);

        String about = "IMIT\n" +
                "\n" +
                "The Institute of Management and Information Technology(IMIT), formerly known as College of Accountancy and Management Studies (CAMS), Cuttack was founded way back in 1962. It is a unique prestigious institution of the Government of Odisha, and has positioned itself as a premier institute offering various professional and technical courses that groom the students to cater to the expectations of modern industry.\n" +
                "\n" +
                "\n" +
                "The college offers Post Graduate and Research programmes in computer science and Business Administration. The College campus is located at Gourav Palace, Matha Sahi, Tulsipur, Cuttack, on the bank of the river Mahanadi. Being twin to the state capital, Bhubaneswar, the Cyber heart of Odisha, it enjoys many advantages.Its close proximity to many large scale industries, central and state public sector undertaking and technical institutions has provided opportunities to its students for project work, practical training and research. While strengthening human resource development efforts in the country, this college lays greater emphasis on qualitative sense of education and not merely quantitative one. +" +
                "\n" + "Mission of IMIT :\n" +
                "\n" +
                "- To inspire the students and create a climate of learning.\n" +
                "- To empower the students with Knowledge and Professional skill to face the challenges of changing environment.\n" +
                "- To maintain the high standards of professional education with a value orientation.\n" +
                "- To provide a broad range of career-oriented programs to meet the needs of society in general and professional education in particular.";

        TextArea taAbout = new TextArea(about, 30, 185, Scrollbar.VERTICAL);
        taAbout.setEditable(false);
        taAbout.setBounds(0, 452, 1550, 220);
        taAbout.setBackground(Color.WHITE);
        taAbout.setForeground(Color.red);
        add(taAbout);

        attendance = new JButton("Attendance");
        attendance.setBackground(Color.WHITE);
        attendance.setForeground(Color.BLACK);
        attendance.addActionListener(this);
        attendance.setBounds(20, 670, 200, 30);
        add(attendance);

        JPanel footer  = new JPanel();
        footer.setBounds(0, 700, 1550, 150);
        footer.setBackground(Color.BLUE);
        footer.setLayout(null);
        add(footer);

        JLabel heading = new JLabel("Contact Us ");
        heading.setBounds(50, 2, 100, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 12));
        heading.setForeground(Color.WHITE);
        footer.add(heading);

        JLabel clgName = new JLabel("Institute Of Management And Information Technology");
        clgName.setBounds(50, 22, 600, 30);
        clgName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        clgName.setForeground(Color.WHITE);
        footer.add(clgName);

        JLabel clgAdd = new JLabel("Gourav Palace, Matha sahi, Post-Tulsipur, Cuttack - 753008, Odisha,India");
        clgAdd.setBounds(50, 42, 600, 30);
        clgAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
        clgAdd.setForeground(Color.WHITE);
        footer.add(clgAdd);

        JLabel phoneNo = new JLabel("Phone No.- +91-671-2506711, Email: imitcuttack@rediffmail.com");
        phoneNo.setBounds(50, 62, 600, 30);
        phoneNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        phoneNo.setForeground(Color.WHITE);
        footer.add(phoneNo);

        JLabel copyright = new JLabel("Copyright (c) Institute Of Managenent And Information Technology. All rights reserved.");
        copyright.setBounds(1020, 62, 600, 30);
        copyright.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyright.setForeground(Color.WHITE);
        footer.add(copyright);

        setBounds(0, 0 , 1550, 900);
        setVisible(true);
        while(true) {
                image2.setVisible(true);
                try{
                    Thread.sleep(4000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                image2.setVisible(false);
                image3.setVisible(true);
                 try{
                    Thread.sleep(4000);
                 }catch(Exception e){
                    e.printStackTrace();
                }
                 image3.setVisible(false);
                 image4.setVisible(true);
                 try{
                     Thread.sleep(4000);
                 }catch(Exception e){
                     e.printStackTrace();
                 }
                 image4.setVisible(false);
            image5.setVisible(true);
            try{
                Thread.sleep(4000);
            }catch(Exception e){
                e.printStackTrace();
            }
            image5.setVisible(false);
            image6.setVisible(true);
            try{
                Thread.sleep(4000);
            }catch(Exception e){
                e.printStackTrace();
            }
            image6.setVisible(false);
            image7.setVisible(true);
            try{
                Thread.sleep(4000);
            }catch(Exception e){
                e.printStackTrace();
            }
            image7.setVisible(false);
            image8.setVisible(true);
            try{
                Thread.sleep(4000);
            }catch(Exception e){
                e.printStackTrace();
            }
            image8.setVisible(false);
        }

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args){
        new MainPage();
    }
}
