
<%@page session="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User login</title>
    <style>
        body{
            background-image:url(new.gif);
            background-size: 80%;
        }
        form{
            margin-top: 280px;
        }
        label{
            color: #ff0000;
        }
    </style>
</head>

<body>
    <center>
        <form action="login" method="get">
            <label for="user">User-Name:</label>
            <input type="text" name="email">
            <br> <br>
            <label for="pass"> Password  :</label>
            <input type="text" name="pass">
            <br> <br>
            <input style="color: blue;" type="submit" value="Login">
            <button><a href="register.html" style="text-decoration: none; color: blue;">New-Register</a></button>
        </form>
    </center>
</body>

</html>