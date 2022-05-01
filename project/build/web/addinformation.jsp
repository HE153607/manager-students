<%-- 
    Document   : addinformation
    Created on : Jan 28, 2022, 7:25:56 AM
    Author     : hoanganhPC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>student add information</title>
    </head>
    <body>
        <style>
            body,html{
                width: 98vw;
                height: 98vh;
                display: flex;
                background-color: bisque;
            }
            .a,form{
                align-items: center;
                text-align: center;
                background-color: #BFD641;
                width: 60%;
                margin: auto;
                height: 80%;
            }
            input{
                height: 30px;
                width: 220px;
            }
            select{
              height: 30px;
                width: 230px;  
            }
            button{
                width: 70px;
                border: none;
                background-color: #0066ff;
                height: 30px;
            }
            td img{
                display: none;
            }
        </style>
        <form method="post" action="newstudent" enctype="multipart/form-data">
            <div class="a">
                <table>
                    <tr>
                        <td>select campus:</td> 
                        <td><select name="campus">
                                <option>FU-Hòa Lạc</option>
                                <option>FU-Đà Nẵng</option>
                                <option>FU-Hồ Chí Minh</option>
                            </select> 
                        </td>             
                    </tr>
                    <tr>      
                        <td>Student's name:</td><td><input type="text" name="name"/></td>
                    </tr>
                    <tr>      
                        <td>Parent's name:</td><td><input type="text" name="namep"/></td>
                    </tr>
                    <tr>      
                        <td>student's Gender:</td><td>
                            male<input style="height: 18px;width: 18px;" checked type="radio" value="male" name="gender"/>
                            female<input style="height: 18px;width: 18px;" type="radio" value="female" name="gender"/>
                        </td>
                    </tr>
                    <tr><td>phonenumber:</td><td><input type="text" name="phone"/></td></tr>
                    <tr><td>parent's phonenumber:</td><td><input type="text" name="phonep"/></td></tr>

                    <tr><td>Student's email:</td><td><input type="text" name="mail"/></td></tr>    

                    <tr><td>Student's address:</td><td><input type="text" name="address"/></td></tr>   
 
                    <tr><td>Date of birth:</td><td><input type="text" name="date" placeholder="day-month-year"/></td></tr>  
                    <tr><td>parent's ID card:</td><td><input type="text" name="idcard" placeholder="số chứng minh nhân dân bố/mẹ"/></td></tr>  
                    <tr>
                        <td>Student's Image:</td><td><input type="file" name="file" id="file" size="60"  accept=".jpg,.png,.jfif" style="display:none;"/>
                            <label for="file" style="cursor: pointer;" >Upload Student's Image(if have)</label>
                        </td>
                    </tr>  
                    <tr>
                       <td></td> <td><img style="width:90px;height: 110px;" src="#" name="image"/></td>
                    </tr>
                    <tr><td>Enter code join:</td><td><input type="text" name="code"/></td></tr>   

                    <tr><td><button value="Upload">Add</button></td><td style="color: red;"><c:if test="${param.error!=null}">${param.error}</c:if></td></tr> 
                </table>
            </div>
            <script>
                document.getElementsByName("file")[0].onchange=function (e){
                    document.getElementsByName("image")[0].style.display='block';
                   document.getElementsByName("image")[0].src=URL.createObjectURL(e.target.files[0]);
                };
            </script>
        </form>
    </body>
</html>
