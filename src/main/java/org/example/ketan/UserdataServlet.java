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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/userdata")
public class UserdataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String Username = (String) session.getAttribute("username");
        PrintWriter pw = response.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/User1", "root", "rootroot");
            String sql = "SELECT * FROM UserData WHERE Username='" + Username + "'";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            ResultSet resultSet = stmt.getResultSet();
            while (resultSet.next()){
                session.setAttribute("username",resultSet.getString("Username"));
                session.setAttribute("password",resultSet.getString("Password"));
                session.setAttribute("age",resultSet.getInt("Age"));
                session.setAttribute("id",resultSet.getInt("id"));
                session.setAttribute("phone",resultSet.getLong("Phone_no"));
                RequestDispatcher rd=request.getRequestDispatcher("Profile.jsp");
                rd.forward(request,response);
            }
        }catch (Exception e){
            pw.write("<h1>"+  e.getLocalizedMessage() + "</h1>");
        }
    }
}
