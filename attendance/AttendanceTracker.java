package IMIT;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class AttendanceTracker extends JFrame {

    Choice choice1, choice2, choice3;
    JTextField tfusername;
    JButton view, back, update;

    HashSet<String> values = new HashSet<>();


    JTable table;

    AttendanceTracker() {


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(225, 225, 225));


        // Details part
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(29, 59, 85));
        panel1.setBounds(0, 50, 1600, 155);
        add(panel1);

//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imgs/Imitlogo.png"));
//        JLabel imagee = new JLabel(i1);
//        imagee.setBounds(80, 3, 150, 150);
//        panel1.add(imagee);

        // Heading part
        JLabel maintext2 = new JLabel("Attendance Tracker");
        maintext2.setBounds(550, 30, 1000, 70);
        maintext2.setForeground(Color.WHITE);
        maintext2.setFont(new Font("Raleway", Font.BOLD, 45));
        panel1.add(maintext2);

        // IMIT logo
//        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("imgs/Imitlogo.png"));
//        JLabel image1 = new JLabel(i2);
//        image1.setBounds(1280, 3, 150, 150);
//        panel1.add(image1);

        // DropDown1
        JLabel choicename1 = new JLabel("Semester");
        choicename1.setBounds(70, 250, 100, 20);
        choicename1.setBackground(new Color(29, 75, 100));
        choicename1.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename1);

        choice1 = new Choice();
        choice1.add("First");
        choice1.add("Second");
        choice1.add("Third");
        choice1.add("Four");
        choice1.setBounds(70, 273, 150, 80);
        choice1.setBackground(new Color(29, 75, 100));
        choice1.setForeground(Color.WHITE);
        choice1.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice1);

        //DropDown2
        JLabel choicename2 = new JLabel("Date");
        choicename2.setBounds(270, 250, 100, 20);
        choicename2.setBackground(new Color(29, 75, 100));
        choicename2.setFont(new Font("Raleway", Font.BOLD, 15));
        // Get the current date and format it
        java.util.Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);

        // Set the text of choicename2 to display the current date
        choicename2.setText("Date ");
        add(choicename2);

        tfusername = new JTextField();
        tfusername.setBounds(270, 273, 150, 20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setBackground(new Color(29, 75, 100));
        tfusername.setForeground(Color.WHITE);
        tfusername.setFont(new Font("Raleway", Font.BOLD, 15));
        tfusername.setCaretColor(Color.WHITE);
        tfusername.setText(formattedDate);
        add(tfusername);

        //DropDown3
        JLabel choicename3 = new JLabel("Subject");
        choicename3.setBounds(470, 250, 100, 20);
        choicename3.setBackground(new Color(29, 75, 100));
        choicename3.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename3);

        choice2 = new Choice();
        choice2.add("JAVA");
        choice2.add("ADA");
        choice2.add("OOAD");
        choice2.add("CN");
        choice2.add("IWP");
        choice2.setBounds(470, 273, 150, 40);
        choice2.setBackground(new Color(29, 75, 100));
        choice2.setForeground(Color.WHITE);
        choice2.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice2);

        //DropDown4
        JLabel choicename4 = new JLabel("Sections");
        choicename4.setBounds(670, 250, 100, 20);
        choicename4.setBackground(new Color(29, 75, 100));
        choicename4.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename4);

        choice3 = new Choice();
        choice3.add("Sec A");
        choice3.add("Sec B");
        choice3.setBounds(670, 273, 150, 40);
        choice3.setBackground(new Color(29, 75, 100));
        choice3.setForeground(Color.WHITE);
        choice3.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice3);

        // Back Button
        back = new JButton("Back");
        back.setBounds(1400, 266, 100, 30);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        //back.addActionListener(this);
        add(back);

        // view Button
        view = new JButton("View");
        view.setBounds(1230, 265, 110, 30);
        view.setBorder(new LineBorder(new Color(133, 193, 233)));
        view.setBackground(new Color(29, 75, 100));
        view.setForeground(Color.WHITE);
        view.setFont(new Font("Raleway", Font.BOLD, 12));
        view.setCursor(new Cursor(Cursor.HAND_CURSOR));
       // view.addActionListener(this);
        add(view);


        //Scrollable view of the table
        JScrollPane pane = new JScrollPane();
        pane.setBounds(200, 350, 1300, 400);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //Table for the shown of data
        table = new JTable();
        table.setBounds(0, 0, 1150, 400);
        table.setBackground(Color.gray);
        table.getTableHeader().setReorderingAllowed(false);
        pane.getViewport().add(table);


        //Fetching of the data from the data base
        String query = "select * from mca_student_attendance_update where section = 'A'";
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            //Accessing column name directly from the table in the database
            int cols = rsmd.getColumnCount();
            String[] col_name = new String[cols];
            for (int i = 0; i < cols; i++) {
                col_name[i] = rsmd.getColumnName(i + 1);
            }
            model.setColumnIdentifiers(col_name);


            //Accessing the data from the table
            while (rs.next()) {
                Object[] rowData = new Object[cols];
                for (int i = 0; i < cols; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }

            //Changing the Row values into columns
            try{
                String query1 = "SELECT DISTINCT updated_at FROM mca_student_attendance_update";
                ResultSet rs1 = c.s.executeQuery(query1);

                while(rs1.next()){
                    String val = rs1.getString("updated_at");
                    String columnName = val.toString();
                    values.add(val);
                    model.addColumn(columnName);

                    //Assigning values to the temporary columns
                        for(int i = 0; i < model.getRowCount(); i++){
                            Object val1 = model.getValueAt(i, 5);
                            model.setValueAt(val1, i, model.getColumnCount() - 1);
                        }
                }

            }catch(Exception e){
                e.printStackTrace();
            }

            table.setModel(model);

                add(pane);

            }catch(Exception e){
                e.printStackTrace();
            }


            setVisible(true);
        }
//        public void actionPerformed (ActionEvent ae){
//            if (ae.getSource() == back) {
//                setVisible(false);
//                //new Dashboard();
//            } else if (ae.getSource() == update) {
//                //Updation of the attendance
//                for (int row : hs) {
//                    Object changeValue = table.getValueAt(row, 3);
//                    Conn c = new Conn();
//                    String query = "UPDATE student SET attendance = '" + changeValue + "' WHERE regd_no = '220510200" + (row + 1) + "'";
//                    try {
//                        c.s.executeUpdate(query);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }


    public static void main (String[] args){
        new AttendanceTracker();
    }
}
