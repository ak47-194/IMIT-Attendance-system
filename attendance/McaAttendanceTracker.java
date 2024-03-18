package IMIT;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class McaAttendanceTracker extends JFrame implements ActionListener {


    Choice choice1, choice2, choice3;
    JTextField tfStartDate, tfEndDate;
    JButton view, back, update;
    ResultSetMetaData rsmd;
    DefaultTableModel model;
    JScrollPane pane;
    String[] col_name;
    int rowCount;
    static String staffname;
    static String Designation;
    static String department;
    static String email_id;

    HashSet<String> values = new HashSet<>();


    JTable table;


    McaAttendanceTracker(String staffname,String Designation,String department,String email_id) {
        this.staffname = staffname;
        this.Designation = Designation;
        this.department = department;
        this.email_id = email_id;


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
        JLabel maintext2 = new JLabel("MCA Attendance Tracker");
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


        //DropDown3
        JLabel choicename3 = new JLabel("Subject");
        choicename3.setBounds(270, 250, 100, 20);
        choicename3.setBackground(new Color(29, 75, 100));
        choicename3.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename3);

        choice2 = new Choice();
        choice2.add("JAVA");
        choice2.add("ADA");
        choice2.add("OOAD");
        choice2.add("CN");
        choice2.add("IWP");
        choice2.setBounds(270, 273, 150, 20);
        choice2.setBackground(new Color(29, 75, 100));
        choice2.setForeground(Color.WHITE);
        choice2.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice2);

        //DropDown4
        JLabel choicename4 = new JLabel("Sections");
        choicename4.setBounds(470, 250, 100, 20);
        choicename4.setBackground(new Color(29, 75, 100));
        choicename4.setFont(new Font("Raleway", Font.BOLD, 15));
        add(choicename4);

        JLabel startDate = new JLabel("From");
        startDate.setBounds(670, 250, 100, 20);
        startDate.setBackground(new Color(29, 75, 100));
        startDate.setFont(new Font("Raleway", Font.BOLD, 15));
        add(startDate);


        tfStartDate = new JTextField("YYYY-MM-DD");
        tfStartDate.setBounds(670, 273, 150, 20);
        tfStartDate.setBorder(BorderFactory.createEmptyBorder());
        tfStartDate.setBackground(new Color(29, 75, 100));
        tfStartDate.setForeground(Color.WHITE);
        tfStartDate.setFont(new Font("Raleway", Font.BOLD, 15));
        tfStartDate.setCaretColor(Color.WHITE);
        add(tfStartDate);

        JLabel endDate = new JLabel("To");
        endDate.setBounds(870, 250, 100, 20);
        endDate.setBackground(new Color(29, 75, 100));
        endDate.setFont(new Font("Raleway", Font.BOLD, 15));
        add(endDate);


        tfEndDate = new JTextField("YYYY-MM-DD");
        tfEndDate.setBounds(870, 273, 150, 20);
        tfEndDate.setBorder(BorderFactory.createEmptyBorder());
        tfEndDate.setBackground(new Color(29, 75, 100));
        tfEndDate.setForeground(Color.WHITE);
        tfEndDate.setFont(new Font("Raleway", Font.BOLD, 15));
        tfEndDate.setCaretColor(Color.WHITE);
        add(tfEndDate);

        choice3 = new Choice();
        choice3.add("A");
        choice3.add("B");
        choice3.setBounds(470, 273, 150, 40);
        choice3.setBackground(new Color(29, 75, 100));
        choice3.setForeground(Color.WHITE);
        choice3.setFont(new Font("Raleway", Font.BOLD, 13));
        add(choice3);

        // Login Button
        back = new JButton("Log out");
        back.setBounds(1400, 266, 100, 30);
        back.setBorder(new LineBorder(new Color(133, 193, 233)));
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.addActionListener(this);
        add(back);

        // view Button
        view = new JButton("View");
        view.setBounds(1230, 265, 110, 30);
        view.setBorder(new LineBorder(new Color(133, 193, 233)));
        view.setBackground(new Color(29, 75, 100));
        view.setForeground(Color.WHITE);
        view.setFont(new Font("Raleway", Font.BOLD, 12));
        view.setCursor(new Cursor(Cursor.HAND_CURSOR));
        view.addActionListener(this);
        add(view);


        //Scrollable view of the table
        pane = new JScrollPane();
        pane.setBounds(200, 350, 1300, 400);
        pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //Table for the shown of data
        table = new JTable();
        table.setBounds(0, 0, 1150, 400);
        table.setBackground(Color.gray);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        pane.getViewport().add(table);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new McaDashboard(staffname,Designation,department,email_id);
        } else if (ae.getSource() == view) {
            table.setModel(new DefaultTableModel(null, col_name));
            String startdate=  tfStartDate.getText();
            String enddate = tfEndDate.getText();
            if (!isValidDateFormat(startdate)) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please enter From date in YYYY-MM-DD format.");
            } else if (!isValidDateFormat(enddate)) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please enter To date in YYYY-MM-DD format.");
            } else {

                String sem = choice1.getSelectedItem();
                String sub = choice2.getSelectedItem();
                String sec = choice3.getSelectedItem();

                //Fetching of the data from the database
                String query = "select distinct regd_no, student_name, semester, section, subject from mba_student_attendance_update where section = '" + sec + "' and subject = '" + sub + "' and semester = '" + sem + "'";
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    rsmd = rs.getMetaData();
                    model = (DefaultTableModel) table.getModel();

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

                    //Changing the Row values into columns
                    try {
                        // Create Calendar instances for start and end dates
                        String[] startDateParts = startdate.split("-");
                        int startYear = Integer.parseInt(startDateParts[0]);
                        int startMonth = Integer.parseInt(startDateParts[1]);
                        int startDay = Integer.parseInt(startDateParts[2]);

                        Calendar startDate = Calendar.getInstance();
                        startDate.set(startYear, startMonth - 1, startDay);

                        String[] endDateParts = enddate.split("-");
                        int endYear = Integer.parseInt(endDateParts[0]);
                        int endMonth = Integer.parseInt(endDateParts[1]);
                        int endDay = Integer.parseInt(endDateParts[2]);

                        Calendar endDate = Calendar.getInstance();
                        endDate.set(endYear,endMonth - 1, endDay);


                        Calendar current = (Calendar) startDate.clone();

                        while (current.before(endDate) || current.equals(endDate)) {
                            int year = current.get(Calendar.YEAR);
                            int month = current.get(Calendar.MONTH) + 1;
                            int day = current.get(Calendar.DATE);
                            String formattedMonth = String.format("%02d", month);
                            String formattedDay = String.format("%02d", day);
                            String col_day = year+ "-" + formattedMonth +"-"+ formattedDay;
                            model.addColumn(col_day);
                            current.add(Calendar.DATE, 1);
                            String query1 = "select attendance from mba_student_attendance_update where section = '" + sec + "' and subject = '" + sub + "' and semester = '" + sem + "' and updated_at = '"+col_day+"'";
                            rs = c.s.executeQuery(query1);
                            int i = 0;
                            while(rs.next()){
                                Object val = rs.getString("attendance");
                                model.setValueAt(val, i, model.getColumnCount() - 1);
                                i++;
                            }
                        }

                        //Adding  new columns
                        model.addColumn("Total Attendance");
                        model.addColumn("Total classes");
                        model.addColumn("Total Percentage");
                        for(int i = 0; i < model.getRowCount(); i++){
                            int count = 0;
                            int classes = 0;
                            for(int j = 5; j < model.getColumnCount() - 1; j++){
                                Object value = model.getValueAt(i, j);

                                if(value == null){
                                    continue;
                                } else {
                                    classes++;
                                }
                                if(value.equals("Yes")){
                                    count++;
                                }
                            }

                            float percentage = 0;
                            if (classes > 0) {
                                percentage = (count / (float) classes) * 100;
                            }
                            //setting attendance percentage of each student in total percentage column
                            model.setValueAt(count, i, model.getColumnCount() - 3);
                            model.setValueAt(classes, i, model.getColumnCount() - 2);
                            model.setValueAt(percentage, i, model.getColumnCount() - 1);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Set width for all columns
                    for (int columnIndex = 0; columnIndex < model.getColumnCount(); columnIndex++) {
                        table.getColumnModel().getColumn(columnIndex).setPreferredWidth(200); // Set width for all columns to 200 pixels
                    }

                    table.setModel(model);

                    add(pane);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main (String[]args){

        new McaAttendanceTracker("","","","");
    }
    // Method to validate the date format using regular expression
    public static boolean isValidDateFormat(String dateString) {
        String regex = "\\d{4}-(0?[1-9]|1[0-2])-\\d{2}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateString);
        return matcher.matches();
    }
}