package org.example.ketan;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        String Username=request.getParameter("Username");
        String Password=request.getParameter("Password");
        if (Username.equals("Admin")&& Password.equals("Admin")){
             EmployeeData ed=new EmployeeData();
             try {
                 List<Employee>list=ed.fetchEmployeeData();
                 request.setAttribute("emp",list);

                 HttpSession session = request.getSession();
                 session.setAttribute("username", Username);
                 session.setAttribute("employees", list);

                 RequestDispatcher rd= request.getRequestDispatcher("Employee.jsp");
                 rd.forward(request,response);
                 System.out.println(ed.fetchEmployeeData());
             } catch (Exception e) {
                 System.out.println(e.getLocalizedMessage());
                 e.printStackTrace();
             }
        }
     else {
        // Handle invalid login
    }


}
}
