<%-- 
    Document   : sendmail
    Created on : Feb 10, 2022, 3:59:15 PM
    Author     : hoanganhPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Send mail</title>
    </head>
    <body>
        <style>
            html{
                width: 100vw;
                height: 100vh;
                overflow: hidden;
            }
            body{
                width: 100%;
                height: 100%;
            }
            form{
              width: 100%;
                height: 100%;
                display: flex;
                justify-content: center;
                align-items: center;
                background:linear-gradient(to bottom left, white, yellow);
            }
            table{
                background:linear-gradient(to bottom left, #ccffff, #ccffcc);  
            }
            input{
                width: 250px;
            }
            textarea{
                width: 252px;
            }
        </style>
        <form method="post" action="mail" enctype="multipart/form-data">
            <%
            if(request.getSession().getAttribute("id")==null){
            response.sendRedirect("login.jsp");
        }
            %>
            <table>
                <tr>
                    <td>Your email:</td>  
                    <td><input type="mail" name="mail"/></td>
                </tr>
                <tr>
                    <td>password:</td>  
                    <td><input type="password" name="pass"/></td>
                </tr>
                <tr>
                    <td>Subject:</td>  
                    <td><textarea name="subject"></textarea></td>
                </tr>
                <tr>
                    <td>Content:</td>  
                    <td><textarea name="content"></textarea></td>
                </tr>
                <tr>
                    <td>file:</td>  
                    <td><input type="file" id="file" name="file"/></td>
                </tr>
                <tr>
                    <td></td>  
                    <td><button>Send</button></td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
