<%@ page import="org.example.ketan.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <style>
        h2{
            text-align: center;
        }
        table {
            border-collapse: collapse;
            width: 50%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .logoutb{
            text-align: center;

        }
    </style>
</head>
<body>
<h2>Welcome <%= session.getAttribute("Username") %></h2>
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
<a href="logout" class="logoutb"><button>Logout</button></a>
</body>
</html>
