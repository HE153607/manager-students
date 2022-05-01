<%-- 
    Document   : parent
    Created on : Mar 21, 2022, 7:13:32 AM
    Author     : HOANG ANH
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home parent</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    </head>
    <body>
        <style>
           
            td,th{
                text-align: center;
            }
        </style>
        <%
        if(request.getAttribute("student")==null)
        response.sendRedirect("Plogin.jsp");
        %>
            <div class="jumbotron" style="height: 300px;background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQmgzB56Foibq0Zz1djdQIu2Q3wQ96DcFYSIQ&usqp=CAU');
                 background-repeat: no-repeat;background-size: 100%;">
                <h1 style="margin: 0px;">FPT University</h1>
                <h2>Website for parents</h2>
                <h3 style="margin-top: 65px;margin-left: 220px;">${student.name}</h3>
                <h3 style="margin-left:220px;">MSSV: ${student.id}</h3>
                <img style="position: absolute;width: 190px;height: 190px;top:160px;" src="image/${student.img}">
                <div style="position: absolute;top: 320px;left: 250px;"><a style="padding: 7px 15px 7px 15px;background-color: #6699ff;color: black;text-decoration: none;" href="logout">Logout</a>
                    
                </div>
            </div>
        <div class="container mt-3" style="margin-left: 20px;" >
            <form action="parent" method="get" class="r">
                <select style="margin-top: 30px;" name="tid" onchange="document.getElementsByClassName('r')[0].submit()">
                        <option>Choose Teachers</option>
      <c:if test="${teacher.size()>0}">
          <c:forEach items="${teacher}" var="n">
              <option value="${n.id}" <c:if test="${param.tid!=null}"><c:if test="${n.id==param.tid}">selected</c:if></c:if>>${n.name}</option>
    </c:forEach>
      </c:if>
    <c:if test="${teacher.size()<=0}">
     <option class="dropdown-item">Data Empty</option>   
    </c:if>
  </select>
  </form>
  <br>
  <br>
  <!-- Nav tabs -->
  <ul style="margin-left: 200px;" class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#home">Báo cáo điểm danh</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="#menu1">Nhận xét từ giáo viên</a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div style="margin-left: 200px;" class="tab-content">
    <div id="home" class="container tab-pane active"><br>
      <c:if test="${attend!=null}">
                <table>
                    <tr>
                        <th><p>Ngày</p></th>
                        <th><p>Trạng thái</p></th>
                    </tr>
                    <c:forEach items="${attend}" var="a">
                        <tr>
                            <td><p style="margin-right: 40px;"><fmt:formatDate pattern="dd-MM-yyyy" value="${a.dob}"/></p></td>
                            <td>
                     <c:if test="${a.attend==true}"><p>có mặt</p></c:if>   
                     <c:if test="${a.attend==false}"><p>vắng</p></c:if> 
                            </td>
                        </tr>
                </div>   
                </c:forEach>
                </table>
            </c:if>
      <c:if test="${attend==null||attend.size()<=0}">have no update!</c:if>
    </div>
    <div id="menu1" class="container tab-pane fade"><br>
      <c:if test="${comment!=null}">
                    <c:forEach items="${comment}" var="a">
                        <div style="display:flex;">
                            <p><fmt:formatDate pattern="dd-MM-yyyy" value="${a.dob}"/> :</p>
                            <p>${a.comment}</p>
                        </div>  
                </c:forEach>
                </table>
            </c:if>
            <c:if test="${comment==null||comment.size()<=0}">no comment!</c:if>
    </div>
  </div>
</div>
     <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>   
    </body>
</html>
