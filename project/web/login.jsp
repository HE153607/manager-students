<%-- 
    Document   : login
    Created on : Feb 17, 2022, 7:11:24 PM
    Author     : hoanganhPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{
                height: 97vh;
                width: 98vw;
                background-image:linear-gradient(
140deg, #EADEDB 0%, #BC70A4 50%, #BFD641 75%);
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .frame{
                border-radius: 10px;
                background-color: #ffffff;
                width: 100%;
                height: 100%;
                display: flex;
                flex-direction: column;
            }
            form{
                width: 40%;
                height: 55%;  
            }

            h2{
                width: 130px;
                margin-left: 20px;
            }
            table{
                margin-top: 45px;
            }
            tr td:nth-of-type(1){
                width: 20%;
            } 
            input{
                width: 90%;
                height: 30px;
            }
            td{
                padding-top: 15px;
            }
            button{
                text-decoration: none;
                color: black;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 30px;
                width: 80px;
                background-color: rgb(66, 66, 247);
            }
            button:hover{
                background-color: rgb(157, 157, 197);
            }
            button:nth-of-type(1){
                margin-right: 100px;
            }
            p{
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            #id{
                display: none;
            }
        </style>
    </head>
    <body>
        <form method="post" onsubmit="return false">
            <div class="frame" >
                <table>
                    <tr>
                        <td><p style="margin-left: 20px;">CamPus FPT:</p></td>
                        <td><select name="campus">
                                        <option>FU-Hòa Lạc</option>
                                        <option>FU-Đà Nẵng</option>
                                        <option>FU-Hồ Chí Minh</option>
                            </select></td>
                    </tr>
                    <tr><td></td><td><strong>Teacher,manager FPT</strong></td></tr>
                    <tr>
                        <td><h2 style="margin-top: 0px;">User name:</h2></td>
                        <td><input name="user" id="user" type="text"/></td>
                    </tr>  
                    <tr>
                        <td><h2>Password:</h2></td>
                        <td><input id="pass" name="pass" type="password"/></td>
                    </tr>
                </table>
                <p id="a" style="margin: 0;color: red;"><c:if test="${requestScope.er!=null}">${requestScope.er}</c:if></p>
                <nav style="display: flex;width: 250px;padding-top: 20px;margin-left: 26%;">
                    <button>LOGIN</button>
                    <button>REGISTER</button>
                    
                </nav >
                <nav style="display: flex;width: 450px;padding-top: 20px;margin-left: 26%;">
                <a href="redeem.jsp">Forgot password</a>
                <a href="parent" style="margin-left: 60px;">Parent login</a>
                <a href="homestudent" style="margin-left: 30px;">Student login</a></nav>
            </div>
            
        </form>
        <script>
                var a = document.getElementById("user");
                var b = document.getElementById("pass");
                var c=document.getElementById("a");
                document.getElementsByTagName("button")[0].onclick = function () {
                    if(a.value.trim() === "" || b.value.trim() === ""){
                    c.style.display="flex";
                   c.innerHTML="thông tin đăng nhập không chính xác";
               }
                    if (a.value.trim() !== "" && b.value.trim() !== "") {
                        document.getElementsByTagName("form")[0].action = "list";
                        document.getElementsByTagName("form")[0].onsubmit = "return true";
                }
            };
                document.getElementsByTagName("button")[1].onclick = function () {
                    if(a.value.trim() === "" || b.value.trim() === ""){
                       c.style.display="flex";
                       c.innerHTML="thông tin không hợp lệ";
                   }
                    if (a.value.trim() !== "" && b.value.trim() !== "") {
                        document.getElementsByTagName("form")[0].action = "register";
                        document.getElementsByTagName("form")[0].onsubmit = "return true";
                }
            };
            </script>
    </body>
</html>

