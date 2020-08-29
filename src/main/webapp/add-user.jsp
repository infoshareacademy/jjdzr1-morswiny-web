
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>

<h1>Add user</h1>

<form method="post" action="<%=request.getContextPath()%>/add-user">
    <table style="with: 80%">
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Surname</td>
            <td><input type="text" name="surname"></td>
        </tr>
        <tr>
            <td>Login</td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><input type="text" name="userGender"></td>
        </tr>
        <tr>
            <td>Nationality</td>
            <td><input type="text" name="userNationality"></td>
        </tr>
        <tr>
            <td>Type</td>
            <td><input type="text" name="userType"></td>
        </tr>
        <tr>
            <td>Birthday</td>
            <td><input type="text" name="birthday"></td>
        </tr>

    </table>

<input type="submit" name="Add user" value="Add user"><br/><br/>


</form>
</body>
</html>
