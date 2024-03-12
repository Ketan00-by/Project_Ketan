package org.example.ketan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {


    public List<Employee> fetchEmployeeData() throws ClassNotFoundException, SQLException {
            List<Employee> List = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/User1","root","rootroot");
            Statement stmt= conn.createStatement();
            String sqlQuery="Select * from UserData";
            ResultSet rs=stmt.executeQuery(sqlQuery);
            while (rs.next()){
                int id= rs.getInt("id");
                String Username= rs.getString("Username");
                int Age= rs.getInt("Age");
                long Phone_no= rs.getLong("Phone_no");
                Employee e=new Employee();
                e.setId(id);
                e.setUsername(Username);
                e.setPhone_no(Phone_no);
                e.setAge(Age);
                List.add(e);
            }
            return List;

        }
    }

