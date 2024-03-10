<%@ page import="org.example.ketan.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<h2>Welcome <%= session.getAttribute("username") %></h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Phone Number</th>
        <th>Age</th>
    </tr>
    </thead>
    <tbody>
    <% List<Employee> employees = (List<Employee>)session.getAttribute("employees");
        for(Employee e: employees) { %>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getUsername() %></td>
        <td><%= e.getPhone_no() %></td>
        <td><%= e.getAge() %></td>
    </tr>
    <% } %>
    </tbody>
</table>

<form action="logout" method="post">
    <input type="submit" value="Logout">
</form>
</body>
</html>
