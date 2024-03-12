package org.example.ketan;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

@WebServlet("/login")public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        PrintWriter pw = response.getWriter();
        if (Username.equals("Admin") && Password.equals("Admin")) {
            EmployeeData ed=new EmployeeData();
            try {
                List<Employee>list=ed.fetchEmployeeData();
                HttpSession session = request.getSession();
                session.setAttribute("emp",list);
                session.setAttribute("Username", Username);
                session.setAttribute("employees", list);

                RequestDispatcher rd= request.getRequestDispatcher("Employee.jsp");
                rd.forward(request,response);
                System.out.println(ed.fetchEmployeeData());
            } catch (Exception e) {
                pw.write("<h1>" + e.getLocalizedMessage() + "</h1>");
            }
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/User1", "root", "rootroot");
                String sql = "SELECT Username, Password FROM UserData WHERE Username='" + Username + "'";
                Statement stmt = conn.createStatement();
                stmt.executeQuery(sql);
                ResultSet resultSet = stmt.getResultSet();
                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("Password");
                    if (Password.equals(storedPassword)) {
                        HttpSession session = request.getSession();
                        session.setAttribute("username", Username);
                        RequestDispatcher rd = request.getRequestDispatcher("userdata");
                        rd.forward(request, response);
                    } else {
                        pw.write("<h1>Incorrect Password</h1>");
                    }
                } else {
                    pw.write("<h1>User not Found</h1>");
                    pw.write("<a href='Signup.jsp'>Register Here</a> <a href='login.jsp'><button>Go Back</button></a>");
                }
            } catch (Exception e) {
                pw.write("<h1>" + e.getLocalizedMessage() + "</h1>");
            }
        }
    }
}