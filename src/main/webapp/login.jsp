<%--
  Created by IntelliJ IDEA.
  User: Nasr
  Date: 11/12/2018
  Time: 00:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>LOGIN</title>
</head>
<body>

<h1>EAS COPY PAST</h1>
<h4>Login</h4>

<form action='<spring:url value="/loginAction"/>' method="post">
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><button type="submit">Login</button></td>
        </tr>
    </table>
</form>
<br/>
</body>
</html>
