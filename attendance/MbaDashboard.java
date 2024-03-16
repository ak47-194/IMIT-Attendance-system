package IMIT;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class MbaDashboard extends JFrame implements ActionListener {

    Choice choice1, choice2, choice3;
    JTextField tfusername;
    JButton view, logout, tracker, present, absent, update;
    JLabel nameofstaff, roleofstaff, emailofstaff, choicename2;
    ResultSetMetaData rsmd;
    DefaultTableModel model;
    String[] col_name;
    int rowCount;

    JTable table;
    JScrollPane pane;
    String staffname,Designation,department,email_id;

    HashSet<Integer> hs = new HashSet<>();

    MbaDashboard(String staffname,String Designation,String department,String email_id ) {

        this.staffname = staffname;
        this.Designation = Designation;
        this.department = department;
        this.email_id = email_id;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(225, 225, 225));

        // Heading part
        JLabel maintext2 = new JLabel("Attendance Record for MBA Students");
        maintext2.setBounds(360, 6, 1000, 70);
        maintext2.setBackground(new Color(29, 75, 100));
        maintext2.setFont(new Font("Raleway", Font.BOLD, 45));
        add(maintext2);

        // Details part
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(new Color(29, 59, 85));
        panel1.setBounds(0, 80, 1600, 200);
        add(panel1);

        // Staff Details
        nameofstaff = new JLabel(staffname);
        nameofstaff.setBounds(20, 20, 1000, 80);
        nameofstaff.setForeground(Color.white);
        nameofstaff.setFont(new Font("Railway", Font.BOLD, 35));
        panel1.add(nameofstaff);

        roleofstaff = new JLabel(Designation+", "+department);
        roleofstaff.setBounds(20, 60, 1000, 80);
        roleofstaff.setForeground(Color.white);
        roleofstaff.setFont(new Font("Railway", Font.BOLD, 25));
        panel1.add(roleofstaff);

        emailofstaff = new JLabel(email_id);
        emailofstaff.setBounds(20, 90, 1000, 80);
        emailofstaff.setForeground(Color.white);
        emailofstaff.setFont(new Font("Railway", Font.BOLD, 17));
        panel1.add(emailofstaff);

        // IMIT logo
//        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("imgs/Imitlogo.png"));
//        JLabel image1 = new JLabel(i2);
//        image1.setBounds(1280, 5, 200, 200);
//        panel1.add(image1);

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
        choicename2 = new JLabel("Date");
        choicename2.setBounds(270, 300, 100, 20);
        choicename2.setBackground(new Color(29, 75, 100));
        choicename2.setFont(new Font("Raleway", Font.BOLD, 15));

        // Get the current date and format it
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(currentDate);

        // Set the text of choicename2 to display the current date
        choicename2.setText("Date ");
        add(choicename2);

        tfusername = new JTextField();
        tfusername.setBounds(270, 323, 150, 20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setBackground(new Color(29, 75, 100));
        tfusername.setForeground(Color.WHITE);
        tfusername.setFont(new Font("Raleway", Font.BOLD, 15));
        tfusername.setCaretColor(Color.WHITE);
        // Set the current date as the default value of the text field
        tfusername.setText(formattedDate);
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
        choice3.add("A");
        choice3.add("B");
        choice3.setBounds(670, 323, 150, 40);
        choice3.setBackground(new Color(29, 75, 100));
        choice3.setForeground(Color.WHITE);
        choice3.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice3);

        // Login Button
        logout = new JButton("Log Out");
        logout.setBounds(1420, 320, 100, 35);
        logout.setBorder(new LineBorder(new Color(133, 193, 233)));
        logout.setBackground(new Color(29, 75, 100));
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Raleway", Font.BOLD, 12));
        logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logout.addActionListener(this);
        add(logout);

        // view Button
        view = new JButton("View Record");
        view.setBounds(1230, 320, 130, 35);
        view.setBorder(new LineBorder(new Color(133, 193, 233)));
        view.setBackground(new Color(29, 75, 100));
        view.setForeground(Color.WHITE);
        view.setFont(new Font("Raleway", Font.BOLD, 12));
        view.setCursor(new Cursor(Cursor.HAND_CURSOR));
        view.addActionListener(this);
        add(view);

        // view Button
        tracker = new JButton("Attendance Tracker");
        tracker.setBounds(70, 430, 130, 35);
        tracker.setBorder(new LineBorder(new Color(133, 193, 233)));
        tracker.setBackground(new Color(29, 75, 100));
        tracker.setForeground(Color.WHITE);
        tracker.setFont(new Font("Raleway", Font.BOLD, 13));
        tracker.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tracker.addActionListener(this);
        add(tracker);

        // update Button
        update = new JButton("update");
        update.setBounds(70, 530, 130, 35);
        update.setBorder(new LineBorder(new Color(133, 193, 233)));
        update.setBackground(new Color(29, 75, 100));
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Raleway", Font.BOLD, 13));
        update.setCursor(new Cursor(Cursor.HAND_CURSOR));
        update.addActionListener(this);
        add(update);

        // absent Button
//        absent = new JButton("Absent");
//        absent.setBounds(75, 590, 130, 35);
//        absent.setBorder(new LineBorder(new Color(133, 193, 233)));
//        absent.setBackground(new Color(29, 75, 100));
//        absent.setForeground(Color.WHITE);
//        absent.setFont(new Font("Raleway", Font.BOLD, 13));
//        absent.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        absent.addActionListener(this);
//        add(absent);

        //Scrollable view of the table
        pane = new JScrollPane();
        pane.setBounds(250, 400, 1250, 350);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //Table for the shown of data
        table = new JTable();
        table.setBounds(0, 0, 1100, 400);
        table.setBackground(Color.gray);
        table.getTableHeader().setReorderingAllowed(false);
        table.setDragEnabled(false);

        pane.getViewport().add(table);

        //Fetching of the data from the database
        String query ="select regd_no, student_name, semester, section, attendance from mba_student_details where section = 'A'";
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            //Accessing column name directly from the table in the database
            int cols = rsmd.getColumnCount();
            col_name = new String[cols];
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
            rowCount = model.getRowCount();
            table.setModel(model);

            //For selecting rows of the table
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = table.rowAtPoint(e.getPoint());
                    int column = 4;
                    if (row >= 0 && column == 4) { // Check if click is within bounds and in the Attendance column
                        // Toggle the value between "Yes" and "No"
                        String currentValue = (String) table.getValueAt(row, column);
                        String newValue = currentValue.equals("Yes") ? "No" : "Yes";
                        hs.add(row);
                        // Update the value in the table
                        table.setValueAt(newValue, row, column);
                    }
                }
            });
            //add(pane);

            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MbaDashboard("","", "", "");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == tracker) {
            setVisible(false);
            new AttendanceTracker();
        }else if(ae.getSource() == update){
//            //Updation of the attendance
//            for(int row : hs){
//                Object changeValue = table.getValueAt(row, 3);
//                Conn c = new Conn();
//                String query = "UPDATE mca_student_details SET attendance = '" + changeValue + "' WHERE sl_no = "+ Integer.toString(row + 1) ;
//                try{
//                    c.s.executeUpdate(query);
//                }catch(Exception e){
//                    e.printStackTrace();
//                }
//            }

            //inserting in new table
            for(int i = 0;i < rowCount; i++){
                Object regdno = table.getValueAt(i, 0);
                Object name = table.getValueAt(i, 1);
                Object sem = table.getValueAt(i, 2);
                Object sec = table.getValueAt(i, 3);
                Object sub = choice2.getSelectedItem();
                Object attendance = table.getValueAt(i, 4);
                Object date = tfusername.getText();
                String query = "insert into mba_student_attendance_update (regd_no, student_name, semester, section, subject, attendance, updated_at) values (\""+regdno+"\", \""+name+"\", \""+sem+"\",\""+sec+"\",\""+sub+"\", \""+attendance+"\", \""+date+"\")" + "ON DUPLICATE KEY UPDATE\n" +
                        "    attendance = VALUES(attendance);";
                Conn c = new Conn();
                try{
                    c.s.executeUpdate(query);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }else if(ae.getSource() == view) {

            table.setModel(new DefaultTableModel(null, col_name));
            String sem = choice1.getSelectedItem();
            String sec = choice3.getSelectedItem();
            String query = "select regd_no, student_name, semester, section, attendance from mba_student_details where semester = '" + sem + "' and section = '" + sec + "'";
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery(query);
                rsmd = rs.getMetaData();
                model = (DefaultTableModel) table.getModel();
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
                rowCount = model.getRowCount();
                table.setModel(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
            add(pane);
        } else if (ae.getSource() == logout) {
            setVisible(false);
             new SelectBranch();
        }
    }
}



