<%--
  Created by IntelliJ IDEA.
  User: ketanshahare
  Date: 3/11/24
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Index</title>
    <style>
        .inlineform{
            display: inline;
        }
    </style>
</head>
<body>
<h1>Login Form</h1>
<form action="login" class="inlineform">
<table>
    <tr>
        <td>
            <label for="Username">Username</label>
        </td>
        <td>
            <input type="text" name="Username" id="Username">
        </td>
    </tr>
    <tr>
        <td>
            <label for="Password">Password</label>
        </td>
        <td>
            <input type="Password" name="Password" id="Password">
        </td>
    </tr>
</table>
<input type="submit" value="Submit">
<input type="reset" value="Clear">
</form>
<a href="Signup.jsp"><button>Sign Up</button></a>
<a href="index.jsp"><button>Go Back</button></a>
</body>
</html>
