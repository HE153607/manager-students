<%-- 
    Document   : phuhuynh
    Created on : Mar 5, 2022, 8:25:36 AM
    Author     : hoanganhPC
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>information student</title>
    </head>
    <body>
        <style>
            html,body{
                width: 100vw;
                height: 98vh;
                overflow-x: hidden;
            }
            body{
               
            }
            .head{
                width: 100%;
                height: 250px;
                text-align: center;
            }
            img{
                width: 200px;
                height: 150px;
            }
            .attend{
                float: left;
                width: 35%;
                margin-right: 50px;
                margin-left: 50px;
            }
            .comment{
                float: left;
                width: 55%;
            
            }p{
                margin-top: 0;
            }
            table{
             border: 1px solid black;   
             width: 100%;
            }
            td{
                border: 1px solid black;
            }
        </style>
        <%
        if(request.getAttribute("student")==null)
        response.sendRedirect("Plogin.jsp");
        %>
        <section class="head">
            <img style="border-radius: 50%;height: 170px;" src="image/${student.getImg()}"/> 
            <h3>${student.getName()}</h3>
            <h3>MSSV:${student.getId()}</h3>
        </section>
        <section class="attend">
            <h1>*Báo cáo điểm danh</h1>
            <c:if test="${attend!=null}">
                <table>
                    <tr>
                        <td>Ngày</td>
                        <td>Trạng thái</td>
                    </tr>
                    <c:forEach items="${attend}" var="a">
                        <tr>
                            <td><p><fmt:formatDate pattern="dd-MM-yyyy" value="${a.dob}"/></p></td>
                            <td>
                     <c:if test="${a.attend==true}"><p>có mặt</p></c:if>   
                     <c:if test="${a.attend==false}"><p>vắng</p></c:if> 
                            </td>
                        </tr>
                </div>   
                </c:forEach>
                </table>
            </c:if>
            <c:if test="${attend==null}"><p>chưa cập nhật báo cáo điểm danh nào!</p></c:if>
        </section>
        <section class="comment">
            <h1>*Nhận xét từ giáo viên</h1>
            <c:if test="${comment!=null}">
            
                    <c:forEach items="${comment}" var="a">
                        <div style="display:flex;">
                            <p><fmt:formatDate pattern="dd-MM-yyyy" value="${a.dob}"/> :</p>
                            <p>${a.comment}</p>
                        </div>  
                         
                </div>   
                </c:forEach>
                </table>
            </c:if>
            <c:if test="${comment==null}"><p>không có nhận xét nào!</p></c:if>
        </section>
    </body>
</html>
