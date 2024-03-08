<%@ page import="org.example.ketan.Employee" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ketanshahare
  Date: 3/7/24
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
<%
    List<Employee> list=(List<Employee>)request.getAttribute("emp");
    System.out.println(list);
%>
</body>
</html>
