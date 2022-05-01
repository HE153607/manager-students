<%-- 
    Document   : information
    Created on : Jan 8, 2022, 9:12:33 PM
    Author     : hoanganhPC
--%>
<%@page import="Controller.ControllDao"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.TreeMap"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Teacher"%>
<%@page import="Model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>information</title>
    </head>
    <body>
        <form action="mark" method="post" name="form-l">
            <style>
                body{
                    position: relative;
                    overflow-x:  hidden;
                }
                header{
                    display: flex;
                    justify-content: space-between;
                    position: fixed;
                    top: 0;
                    width: 99vw;
                    height: 167px;
                    background-color: beige;
                }
                .head{
                    background-color: gainsboro;
                    width: 99vw;position: fixed;
                    top:22.3%;
                    height: 100px;

                    text-align: center;
                }
                .head h1{
                    margin-bottom: 20px;
                }
                .head a{ 
                    margin-left: 20px;
                }
                .out{
                    margin-left: 9vw;
                    width: 80vw;
                    margin-top: 270px;

                }
                .outin{
                    background-color: #f7f7f7;
                    width: 100%;
                    height: 130px;
                    display: flex;
                    justify-content: space-between;
                    border-radius: 7px;
                    margin-bottom: 10px;
                    border: 1px solid black;
                }
                .frame{
                    width: 20%;
                    height: 185px;
                }
                .frame img{
                    border-radius: 7px;
                    width: 90%;
                    height: 130px;
                }
                .in4 a{
                    text-decoration: none;
                    background-color: #bad1fa;
                    border-radius: 4px;
                    padding: 10px 7px;
                    color: black;vertical-align: middle;
                }
                .in4 button{
                    margin-left: 10px;
                    margin-right: 10px;
                    background-color: #bad1fa;
                    border-radius: 4px;
                    padding: 11px 7px;  
                    color: black;
                    border: none;
                    cursor: pointer;
                }
                .in4{
                    align-items: center;
                    width: 70%;
                    display: flex;
                    justify-content: space-between;
                    padding-right: 60px;
                }
                li{
                    border-bottom: 1px solid black;
                    height: 20px;
                    width: 100%;
                    list-style-type: none;
                    background-color: #ffffff;
                    cursor: pointer;
                }ul{
                    position: absolute;
                    top:115px;
                    right: 138px;

                    display: block;
                    background-color: #cccccc;

                }
                li:hover{

                    background-color: #ccffff;
                }
                .set{
                    display: none;
                }
                .cd input{
                    border-radius: 5px;
                    margin-top: 10px;
                    height: 25px;
                }
                .cd input:nth-of-type(2){
                    height: 31px; 
                }
                nav{
                    margin-top: 15px;
                }
                nav a{
                    background-color: #cccccc;
                    padding: 5px 15px 5px 15px;
                    text-decoration: none;
                    font-size: 20px;
                    font-weight: bold;
                    margin-right: 10px;
                }
                .adds input,.add2 input{
                    width: 90px;
                    height:28px;
                    margin-top:7px;
                    margin-right: 10px;
                }
                table ,td,th{
                    border: 1px solid black;
                }
                td{
                    text-align: center;
                }
                td input{
                    border: none;
                }
            </style>
            <% if (request.getAttribute("delete") != null || request.getAttribute("add") != null || request.getAttribute("update") != null || request.getAttribute("comment") != null) {%>
            <div class="pupup" style="width: 200px;height: 100px;background-color: #ccffcc;position: absolute;z-index: 1;
                 top: -260px;right:670px;text-align: center;">
                <c:if test="${delete!=null}">
                    <p>${delete}</p>  
                </c:if>
                <c:if test="${comment!=null}">
                    <p>${comment}</p>  
                </c:if>
                <c:if test="${add!=null}">
                    <p>${add}</p>  
                </c:if>
                <c:if test="${update!=null}">
                    <p>${update}</p>  
                </c:if>
            </div>   
            <% }%>     
            <c:if test="${exist!=null}">
                <div class="out">
                    <div class="sj" style="display:flex;width:100%;">
                        <div style="border-radius: 3px;display:block;padding-top:5px;width:50%;height:30px;margin-top:7px;">
                            Enter subject:<input name="subject" type="text" placeholder="enter subject"/>
                        </div>

                    </div>
                    <div class="adds" style="display:flex;width:100%;">

                        <div style="background-color:aquamarine ;border-radius: 3px;display:block;padding-top:5px;
                             text-align:center;width:140px;height:30px;margin-top:7px;" class="add">new grade category</div>
                    </div>
                    <div class="add2" style="display:flex;width:100%;">
                        <div style="background-color:aquamarine ;border-radius: 3px;display:block;padding-top:5px;
                             text-align:center;width:140px;height:30px;margin-top:7px;" class="add1">create weight</div>
                    </div>
                    <button style="background-color: #3366ff;border-radius: 3px;display:block;padding-top:3px;
                            text-align:center;width:140px;height:30px;margin-top:7px;border:none;" class="save">save</button>
                    <p style="color:red;" class="run"></p>
                </div>  
            </c:if>
            <c:if test="${exist==null}">
                <%Controller.ControllDao c = new ControllDao();
                    String id = (String) request.getSession().getAttribute("id");
                    List<Student> l = (List<Student>) request.getAttribute("list");
                    ArrayList<String> a1 = c.getsubject(l.get(0).getId(), id);
                %>
   
                        <h2>Subject : <%= a1.get(0).split("=")[2]%></h2>
                <table>
                    <tr>
                        <th><p style="color: green;">Category Grade</p></th>
                        <% for(int i=0;i<a1.size();i++){ %>
                        <th><Strong style="padding-left:10px;padding-right:10px;"><%= a1.get(i).split("=")[1]%></Strong></th>
                        <% }%>
                        <th><Strong style="padding-left:10px;padding-right:10px;">total</Strong></th>
                    </tr>
                    <tr>
                        <td><p style="color: green;">Grade Weight</p></td>
                        <% for(int i=0;i<a1.size();i++){ %>
                        <td><%= a1.get(i).split("=")[0]%>%</td>
                        <% }%>
                        <td></td>
                    </tr>
                    <%for (int i = 0; i < l.size(); i++) {
                            ArrayList<String> a = c.getsubject(l.get(i).getId(), id); %>
                    <tr>
                        <td><h3><%= l.get(i).getName() %></h3><h3><%= l.get(i).getId() %></h3></td>
                        <%for (int j = 0; j < a.size(); j++) {%>
                        <td><input type="text" name="<%= l.get(i).getId() %>-<%= a.get(j).split("=")[1]%>" value="<%= a.get(j).split("=")[3]%>"></td>
                        <% }%>
                        <td></td>
                    </tr>
                    <% }%>
                </table>
            </c:if>
        </form>
        <script>
            var cou = 1, cou1 = 1;
            document.getElementsByClassName("add")[0].onclick = function () {
                if (cou <= 10) {
                    var input = document.createElement("input");
                    input.placeholder = "grade category";
                    input.name = "cat" + cou;
                    document.getElementsByClassName("adds")[0].appendChild(input);
                }
                if (cou > 10) {
                    document.getElementsByClassName("run")[0].innerHTML = "you just add limit 10 column!";
                }
                cou++;
            };
            document.getElementsByClassName("add1")[0].onclick = function () {
                if (cou1 <= 10) {
                    var input = document.createElement("input");
                    input.type = "number";
                    input.placeholder = "weight grade";
                    input.name = "we" + cou1;
                    document.getElementsByClassName("add2")[0].appendChild(input);
                }
                if (cou1 > 10) {
                    document.getElementsByClassName("run")[0].innerHTML = "you just add limit 10 column!";
                }
                cou1++;
            };
            document.getElementsByClassName("save")[0].onclick = function (e) {
                if (document.getElementsByName("subject")[0].value.trim() === "") {
                    e.preventDefault();
                    document.getElementsByClassName("run")[0].innerHTML = "subject empty!";
                } else if (cou !== cou1) {
                    e.preventDefault();
                    document.getElementsByClassName("run")[0].innerHTML = "category not match grade weight!";
                } else if (cou < 2 || cou1 < 2) {
                    e.preventDefault();
                    document.getElementsByClassName("run")[0].innerHTML = "add grade category and grade weight!";
                } else if (cou === cou1 && cou >= 2 && cou1 >= 2) {
                    for (let h = 1; h < cou1; h++) {
                        if (document.getElementsByName("we" + h)[0].value.trim() === "") {
                            e.preventDefault();
                            document.getElementsByClassName("run")[0].innerHTML = "grade weight can not empty!";
                            break;
                        }
                    }
                    for (let h = 1; h < cou; h++) {
                        if (document.getElementsByName("cat" + h)[0].value.trim() === "") {
                            e.preventDefault();
                            document.getElementsByClassName("run")[0].innerHTML = "category can not empty!";
                            break;
                        }
                    }
                }
            };
            var pup = document.getElementsByClassName("pupup");
            if (pup !== null) {
                var time = setTimeout(function () {
                    pup[0].style.display = "none";
                }, 2500);
            }
            let u = 0;
            document.getElementById("set").onclick = function () {
                if (u === 1) {
                    document.getElementsByName("set")[0].style.display = "block";
                    u = 0;
                } else {
                    document.getElementsByName("set")[0].style.display = "none";
                    u = 1;
                }
            };
            document.getElementsByName("logout")[0].onclick = function () {
                var input1 = document.createElement("input");
                input1.type = "text";
                input1.value = "logout";
                input1.name = "out";
                input1.style.visibility = 'hidden';
                document.getElementsByName("logout")[0].appendChild(input1);
                document.getElementsByName("form-l")[0].submit();
            };
        </script>
    </body>
</html>
