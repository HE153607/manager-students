<%@page import="Model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<%@page errorPage="access.jsp" %>
    <sql:setDataSource driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" 
                       url="jdbc:sqlserver://localhost:1433;databaseName=Manager" user="sa" password="anh" var="data"/>
    <sql:query dataSource="${data}" var="n" sql="select djoin from datejoin where id='${studentid}'" />
    
        <c:forEach var="p" items="${n.rows}">
            <fmt:formatDate value="${p.djoin}" pattern="yyyy" var="dt"/>
            <fmt:formatDate value="${p.djoin}" pattern="dd-MM-yyyy" var="date"/>
            <fmt:formatDate value="<%= new Date()%>" pattern="yyyy" var="end"/>
        </c:forEach>
        <c:set var="year1" value="<%= new Date().getYear() + 1900%>"/>
        <form action="listdate" method="post" name="djk" id="djk" >
            <select onchange="document.getElementById('djk').submit()" name="id">
                <c:if test="${param.id==null}"><option>select name teacher</option></c:if>
                <% for(int i=0;i<((ArrayList<String>)request.getAttribute("listteacher")).size();i++){%>
                <option <%if(request.getParameter("id")!=null&&request.getParameter("id").trim().equals(((ArrayList<String>)request.getAttribute("listteacher")).get(i).split("=")[0])){%><%="selected"%><% }%> value="<%= ((ArrayList<String>)request.getAttribute("listteacher")).get(i).split("=")[0] %>"><%= ((ArrayList<String>)request.getAttribute("listteacher")).get(i).split("=")[1] %></option>
                <% }%>
            </select>
            <select onchange="sub()" name="year">
                <c:forEach begin="${dt}" end="${end+1}" var="year">
                    <option value="${year}" <c:if test="${year==year1 and requestScope.year==null}">selected</c:if><c:if test="${requestScope.year!=null and requestScope.year==year}">selected</c:if>><c:out value="${year}" /></option>  
                </c:forEach>
            </select>
            <% if (request.getAttribute("list") == null) {
                    response.sendRedirect("access.jsp");
                } %>
            <select name="time" onchange="document.getElementById('djk').submit()">
                <c:forEach items="${list}" var="out" varStatus="count">
                    <option value="${count.count}" <c:if test="${stt!=null and stt==count.count}">selected</c:if>>${out}</option> 
                </c:forEach>   
            </select>
            <table>
                <tr>
                    <th style="background-color: #ffffff;"></th>
                        <% SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
                            SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
                            ArrayList<Student> st = (ArrayList<Student>) request.getAttribute("attend");
                            SimpleDateFormat s1 = new SimpleDateFormat("EEEE");
                            ArrayList<String> a = (ArrayList<String>) request.getAttribute("sche");
                            for (int i = 0; i < a.size(); i++) {%>
                    <th >
                        <%= s1.format(s.parse(a.get(i)))%><br/>
                        <p style="width: 100px;"> <%= s.format(s.parse(a.get(i)))%></p>
                    </th>    
                    <% }%>
                </tr>
                <tr>
                    <td>Status</td>
                    <%for (int i = 0; i < a.size(); i++) {%>
                    <td>
                        <%      for (int j = 0; j < st.size(); j++) {
                        %>

                        <%if (s.format(st.get(j).getDob()).equals(s.format(s.parse(a.get(i))))) {
                                if (st.get(j).isAttend()) {
                        %>
                        Attended
                        <% } else {%>
                        <%= "Absent"%>
                        <%
                                }
                            }
                        %>

                        <% }%>
                    </td>
                    <%}%>
                </tr>
            </table>

            <script>
                function sub() {
                    var d = document.createElement('input');
                    d.name = 'iden';
                    d.value = 'iden';
                    d.style.display = "none";
                    document.getElementsByTagName('form')[0].appendChild(d);
                    document.getElementById('djk').submit();
                }
                //        var x=new XMLHttpRequest();
                //        x.open("get","listdate",true);
                //        x.send();
                //         x.onreadystatechange=function (){
                //                if(this.readyState === 4){
                //                  document.getElementsByTagName("section")[0].innerHTML=this.responseText;  
                //                }
                //            }
            </script>
        </form>
