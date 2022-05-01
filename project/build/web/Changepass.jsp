<%-- 
    Document   : Changepass
    Created on : Feb 25, 2022, 7:16:16 AM
    Author     : hoanganhPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
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
            <%
            if(request.getAttribute("log")==null)
            response.sendRedirect("change");
            %>
            <form action="change" method="post">
            <table>
                <tr>
                    <td>username:</td>
                    <td><input name="user" type="text" placeholder="username"/></td>
                </tr>
             <tr>
                    <td>old password:</td>
                    <td><input name="old" type="password" placeholder="old password"/></td>
                </tr>
                <tr>
                    <td>new password:</td>
                    <td><input name="pass1" type="password" placeholder="new password"/></td>
                </tr>
                <tr>
                    <td>confirm password:</td>
                    <td><input name="pass2" type="password" placeholder="confirm password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button>save</button></td>
                </tr>
                <tr>
                    <td></td>
                    <td style="color: red;"><c:if test="${er!=null}">${er}</c:if></td>
                </tr>
            </table>
        </form>
    </body>
</html>
