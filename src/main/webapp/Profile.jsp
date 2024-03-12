<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <style>
        .button{
            align-items: center;
        }
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
    </style>
</head>
<body>
<h2>User Profile</h2>
<table>
    <tr>
        <th>Field</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>Username</td>
        <td><%= session.getAttribute("username") %></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><%= session.getAttribute("password") %></td>
    </tr>
    <tr>
        <td>Age</td>
        <td><%= session.getAttribute("age") %></td>
    </tr>
    <tr>
        <td>ID</td>
        <td><%= session.getAttribute("id") %></td>
    </tr>
    <tr>
        <td>Phone Number</td>
        <td><%= session.getAttribute("phone") %></td>
    </tr>
</table>
<div class="button">
    <a href="homepage.jsp"><button>Homepage</button></a>
    <a href="logout"><button>Log out</button></a>
</div>
</body>
</html>
