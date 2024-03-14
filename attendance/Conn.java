package IMIT;

import java.sql.*;

public class Conn {

    Connection c;//used for connect JDBC
    Statement s;
    Conn(){

        try{
            // step-1 Resister the Driver Class by using JAR file
            Class.forName("com.mysql.cj.jdbc.Driver");
            // step-2 Creating Connection string
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/imit_attendance","root","1234");
            // step-3 Creating the statement
            s = c.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

