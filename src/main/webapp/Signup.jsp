<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <script>
        function signUp() {
            document.getElementById("signupForm").submit();
        }

        function goBack() {
            window.location.href = "index.jsp";
        }
    </script>
</head>
<body>
<h1>Sign up form</h1>
<form id="signupForm" action="SignUpServlet" method="post">
    <table>
        <tr>
            <td>
                <label for="username">Username</label>
            </td>
            <td>
                <input type="text" id="username" name="username" required><br>
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Password</label>
            </td>
            <td>
                <input type="password" id="password" name="password" required><br>
            </td>
        </tr>
        <tr>
            <td>
                <label for="age">Age</label>
            </td>
            <td>
                <input type="number" id="age" name="age" required><br>
            </td>
        </tr>
        <tr>
            <td>
                <label for="phone">Phone</label>
            </td>
            <td>
                <input type="number" id="phone" name="phone" required><br>
            </td>
        </tr>
    </table>
    <input type="submit" value="Sign Up">
    <input type="reset" value="Reset">
    <button onclick="goBack()">Go Back</button>
</form>
</body>
</html>
