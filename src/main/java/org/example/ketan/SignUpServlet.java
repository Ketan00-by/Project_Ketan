package org.example.ketan;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        String phone = request.getParameter("phone");

        // Database connection parameters
        String dbUrl = "jdbc:mysql://localhost:3306/User1";
        String dbUsername = "root";
        String dbPassword = "rootroot";

        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // Prepare SQL statement to insert user data into the database
            String sql = "INSERT INTO UserData (Username, Password, Age, Phone_no) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setInt(3, age);
            statement.setString(4, phone);

            // Execute SQL statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("login.jsp"); // Redirect to login page after successful signup
            } else {
                response.getWriter().println("Failed to sign up. Please try again.");
            }

            // Close database connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database error: " + e.getMessage());
        }
    }
}
