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

public class Dashboard extends JFrame implements ActionListener {

    Choice choice1, choice2, choice3;
    JTextField tfusername;
    JButton view, logout, tracker, present, absent, update;
    JLabel nameofstaff, roleofstaff, emailofstaff;

    JTable table;

    HashSet<Integer> hs = new HashSet<>();

    Dashboard() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        getContentPane().setBackground(new Color(225, 225, 225));

        // Heading part
        JLabel maintext2 = new JLabel("Attendance Record for MCA Students");
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
        nameofstaff = new JLabel("Dr. Suvendu Ku Jaysingh");
        nameofstaff.setBounds(20, 20, 1000, 80);
        nameofstaff.setForeground(Color.white);
        nameofstaff.setFont(new Font("Railway", Font.BOLD, 35));
        panel1.add(nameofstaff);

        roleofstaff = new JLabel("HOD, MBA & MCA");
        roleofstaff.setBounds(20, 60, 1000, 80);
        roleofstaff.setForeground(Color.white);
        roleofstaff.setFont(new Font("Railway", Font.BOLD, 25));
        panel1.add(roleofstaff);

        emailofstaff = new JLabel("sjayasingh@gmail.com");
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
        JLabel choicename2 = new JLabel("Date");
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
        choice3.add("Sec A");
        choice3.add("Sec B");
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
        JScrollPane pane = new JScrollPane();
        pane.setBounds(250, 400, 1250, 350);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //Table for the shown of data
        table = new JTable();
        table.setBounds(0, 0, 1100, 400);
        table.setBackground(Color.gray);
        table.getTableHeader().setReorderingAllowed(false);
        table.setDragEnabled(false);
        table.setRowSelectionAllowed(false);
        pane.getViewport().add(table);

        //Fetching of the data from the database
        String query = "select regd_no, student_name, semester, attendance from mca_student_details";
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
            table.setModel(model);

            //For selecting rows of the table
            ListSelectionModel selectionModel = table.getSelectionModel();
            selectionModel.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

            selectionModel.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    // Ignore extra selection events
                    if (!e.getValueIsAdjusting()) {
                        int columnToModify = 3; // Index of the column to modify (0-based index)
                        int[] selectedRows = table.getSelectedRows();
                        for (int row : selectedRows) {
                            // Get the current value of the column
                            Object currentValue = table.getValueAt(row, columnToModify);
                            // Toggle the value between "Yes" and "No"
                            Object newValue = currentValue.equals("Yes") ? "No" : "Yes";
                            // Update the value in the table
                            table.setValueAt(newValue, row, columnToModify);
                            hs.add(row);
                            /* By using this code we can directly update the database by changing in the attendance column by clicking the specific rows
                              Object changedValue = table.getValueAt(row, columnToModify);
                              String query = "UPDATE student SET attendance = '" + changedValue + "' WHERE regd_no = '220510200" + (row + 1) + "'";
                              try{
                                  c.s.executeUpdate(query);
                              }catch(Exception ae){
                                  ae.printStackTrace();
                              }
                             */
                        }
                    }
                }
            });
            add(pane);

            setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == tracker) {
//            setVisible(false);
            new TrackerPage();
        }else if(ae.getSource() == update){
            //Updation of the attendance
            for(int row : hs){
                Object changeValue = table.getValueAt(row, 3);
                Conn c = new Conn();
                String query = "UPDATE student SET attendance = '" + changeValue + "' WHERE regd_no = '220510200" + (row + 1) + "'";
                try{
                    c.s.executeUpdate(query);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        else if (ae.getSource() == logout) {
            setVisible(false);
            new SelectBranch();
        }
    }
}


