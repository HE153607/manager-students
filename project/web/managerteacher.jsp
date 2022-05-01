<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page pageEncoding="UTF-8" %>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Teacher Details</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/style.css">
        <!-- Animate.css -->
        <link rel="stylesheet" href="../css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="../css/icomoon.css">
<style>
body {
    color: #404E67;
    background: #F5F7FA;
    font-family: 'Open Sans', sans-serif;
}
.table-wrapper {
    width: 700px;
    margin: 30px auto;
    background: #fff;
    padding: 20px;	
    box-shadow: 0 1px 1px rgba(0,0,0,.05);
}
.table-title {
    padding-bottom: 10px;
    margin: 0 0 10px;
}
.table-title h2 {
    margin: 6px 0 0;
    font-size: 22px;
}
.table-title .add-new {
    float: right;
    height: 30px;
    font-weight: bold;
    font-size: 12px;
    text-shadow: none;
    min-width: 100px;
    border-radius: 50px;
    line-height: 13px;
}
.table-title .add-new i {
    margin-right: 4px;
}
table.table {
    table-layout: fixed;
}
table.table tr th, table.table tr td {
    border-color: #e9e9e9;
}
table.table th i {
    font-size: 13px;
    margin: 0 5px;
    cursor: pointer;
}
table.table th:last-child {
    width: 100px;
}
table.table td a {
    cursor: pointer;
    display: inline-block;
    margin: 0 5px;
    min-width: 24px;
}    
table.table td a.add {
    color: #27C46B;
}
table.table td a.edit {
    color: #FFC107;
}
table.table td a.delete {
    color: #E34724;
}
table.table td i {
    font-size: 19px;
}
table.table td a.add i {
    font-size: 24px;
    margin-right: -1px;
    position: relative;
    top: 3px;
}    
table.table .form-control {
    height: 32px;
    line-height: 32px;
    box-shadow: none;
    border-radius: 2px;
}
table.table .form-control.error {
    border-color: #f50000;
}
table.table td .add {
    display: none;
}
th{
    width: 190px;
}
tbody input{
    border: none;
   margin: 0;
}
</style>
</head>
<body>
    <div id="page" >
            <nav class="fh5co-nav" role="navigation">
                <div style="width: 100%;" class="top">
                    <div class="container">
                        <div  class="row">
                            <div class="col-xs-12 text-right">
                                <p class="site">anhh34711@gmail.com</p>
                                <p style="margin-left: 625px;" class="num">Call: +01 123 456 7890</p>
                                <ul class="fh5co-social">
                                    <li><a href="#"><i class="icon-facebook2"></i></a></li>
                                    <li><a href="#"><i class="icon-twitter2"></i></a></li>
                                    <li><a href="#"><i class="icon-dribbble2"></i></a></li>
                                    <li><a href="#"><i class="icon-github"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="margin-left: 310px;" class="top-menu">
                    <div class="container">
                        <div class="row">
                            <div class="col-xs-2">
                                <div style="margin-right: 370px;" id="fh5co-logo"><a href="../homeadmin"><i class="icon-study"></i>Educ<span>.</span></a></div>
                            </div>
                            
                            <div class="col-xs-10 text-right menu-1">
                                 <ul>
                                    <li class="active"><a style="color:  #b3afaf;" href="../homeadmin">Home</a></li>
                                    <li><a  href="../manager/teacher" style="color:  black;">Teacher Details</a></li>
                                    <li><a style="color:  #b3afaf;" href="../manager/student">Student Details</a></li>  
                                    <c:if test="${sessionScope.admin==null}">
                                        <li class="btn-cta"><a href="../login.jsp"><span>Login</span></a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.admin!=null}">
                                        <li class="btn-cta"><a href="../logout"><span>Logout</span></a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
     <div style="height: 8px;background-color: #00ffff;margin-bottom: 30px;"></div> 
     <% if(request.getAttribute("delete")!=null||request.getAttribute("add")!=null||request.getAttribute("update")!=null||request.getAttribute("comment")!=null){%>
            <div class="pupup" style="width: 170px;height: 90px;background-color: #ccffcc;position: absolute;z-index: 1;
                 top: 30px;right:800px;text-align: center;padding-top: 30px;">
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
     <div class="container-lg">
         <form action="../manager/teacher" method="get" id="s">
         <select name="campus" onchange="document.getElementById('s').submit()" style="margin-left: -100px;margin-bottom: 30px;background-color: #00ff66;height: 30px;border-radius: 5px;">
             <option value="all">All Campus</option>
             <option value="1"<c:if test="${param.campus==1}">selected</c:if> >FU - Hòa Lạc</option>
             <option value="2"<c:if test="${param.campus==2}">selected</c:if>>FU - Đà Nẵng</option>
         <option value="3"<c:if test="${param.campus==3}">selected</c:if>>FU - Hồ Chí Minh</option>
     </select>
               </form>
    <div class="table-responsive" style="width: 1400px;margin-left: -150px;">
        <div class="table-wrapper" style="width: 1300px;">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2>Teacher <b>Details</b></h2></div>
                    <div class="col-sm-4">
                        <a href="../login.jsp" style="margin-left: 230px;" type="button" class="btn btn-info"><i class="fa fa-plus"></i> Add New</a>
                    </div>
                </div>
            </div>
            <form action="../manager/teacher" method="post">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th style="width: 120px;">ID</th>
                        <th>Email</th>
                        <th style="width: 160px;">Date of birth</th>
                        <th style="width: 120px;">Code join</th>
                        <th  style="width: 120px;">User name</th>
                        <th  style="width: 120px;">Password</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${list.size()<=0}"> there are not any teachers!</c:if>
                    <c:forEach items="${list}" var="n">
                    <tr>
                        <td><input type="text" name="name${n.id}" value="${n.name}"></td>
                        <td><input style="width: 120px;" type="text" name="id" readonly value="${n.id}"></td>
                        <td><input type="text" name="mail${n.id}" value="${n.email}"></td>
                        <td><input style="width: 150px;" type="text" name="date${n.id}" value="<fmt:formatDate value="${n.dob}" pattern="dd-MM-yyyy"/>"></td>
                        <td> <input style="width: 120px;" type="text" name="code${n.id}" value="${n.code}"></td>
                        <td> <input style="width: 120px;" type="text" name="user${n.id}" value="${n.userlogin}"></td>
                        <td> <input style="width: 120px;" type="text" name="pass${n.id}" value="${n.pass}"></td>
                        <td>
                            <a class="add" title="Add" data-toggle="tooltip"><i class="material-icons">&#xE03B;</i></a>
                            <button value="${n.id}" name="submit" class="edit" title="Edit" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></button>
                            <button class="delete" name="delete" value="${n.id}" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></button>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
                    <script>
                        
                        var pup =document.getElementsByClassName("pupup");
            if(pup!==null){
               var time = setTimeout(function (){
                   pup[0].style.display="none";
               },2500);
           }
    document.getElementsByClassName("delete")[0].onclick=function (e){
    var t=confirm("Are you sure want to delete "+document.getElementsByClassName("delete")[0].value);
    if(t===false)
    e.preventDefault();
};
</script>
           </form>
        </div>
    </div>
</div>     
</body>
</html>