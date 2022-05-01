<%-- 
    Document   : redeem
    Created on : Feb 19, 2022, 3:31:23 PM
    Author     : hoanganhPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>redeem password</title>
    </head>
    <body>
        <style>
            html,body{
                height: 100vh;
                width: 100vw;
                overflow: hidden;
            }
            form{
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;
                height: 100%;
                background-image: linear-gradient(to bottom left,yellow,green);
            }
            table{
                background-color: #ffffcc;
                border-radius: 10px;
                
            }
            input{
                height: 30px;
                width: 250px;
                margin-top: 20px;
                border-radius: 5px;
            }
            
        </style>
        <form action="redeem" method="post">
            <table>
                <caption>
                    
                <p>Để xác thực là bạn thì mọi thông tin cần chính xác</p>
                </caption>
                <tr>
                    <td>enter username:</td>
                    <td><input type="text" name="user"/></td>
                </tr>
                <tr>
                    <td>enter your id:</td>
                    <td><input type="text" name="id"/></td>
                </tr>
                <tr>
                    <td>your date of birth:</td>
                    <td><input type="text" name="date" placeholder="day-mounth-year"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><p style="color:red;"><c:if test="${requestScope.er!=null}">${er}</c:if></p></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button>submit</button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
