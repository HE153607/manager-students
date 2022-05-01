<%-- 
    Document   : Plogin
    Created on : Mar 4, 2022, 12:10:01 PM
    Author     : hoanganhPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>parent login</title>
    </head>
    <body>
        <style>
            html,body{
                width: 99vw;
                height: 98vh;

            }
            body{
                background-color: #ffffcc;
                display: flex;
                justify-content: center;
            }
            .a{
                background-color: #ffffff;
                width: 400px;
                height: 10px;
            }
        </style>

        <form action="homestudent" method="post">
            <h1>Student Login</h1>
            <table>
                <tr>
                    <td>
                        <p>chọn campus:</p>
                    </td>
                    <td>
                        <select name="campus">
                            <option>FU-Hòa Lạc</option>
                            <option>FU-Hồ Chí Minh</option>
                            <option>FU-Đà Nẵng</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        your Email:
                    </td>
                    <td>
                        <input type="text" name="mail" placeholder="enter your email"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Số điện thoại:
                    </td>
                    <td>
                        <input type="text" name="phone" placeholder="enter your phone number"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        
                    </td>
                    <td>
                        <button>Login</button>
                    </td>
                </tr>
            </table>
            <c:if test="${er!=null}"><p style="color: red;">${er}</p></c:if>

        </form>
    </body>
</html>
