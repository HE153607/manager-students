<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            html{
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100vw;
                height: 98vh;
                background-color: white;
            }
            body{
                background-color: yellow;
                text-align: center;
                height: 50vh;
            }
            input{
                height: 30px;
                width: 200px;
            }
            img{
                display: none;
            }
        </style>
    </head>
    <body>
        <%
        if(request.getSession().getAttribute("user")==null)
        response.sendRedirect("login.jsp");
        %>
        <form action="add" method="post" enctype="multipart/form-data">
        <table>
            <tbody><tr>
                <td>your's Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>Date of birth:</td>
                <td><input type="text" name="date"></td>
            </tr>
            <tr>
                <td>image:</td>
                <td>
                    <input type="file" name="file" id="file" accept=".jpg,.png,.jfif" style="display:none;">
                    <label for="file">Choose your image</label>
                    <img src="#" style="width:90px;height: 110px;" name="image">
                </td>
            </tr>
            <tr>
                <td>Code join(send to your student to join):</td>
                <td><input type="text" name="code"></td>
            </tr>
        </tbody>
        </table>
        <button>OK</button>
            <%
            if(request.getAttribute("error")!=null){
            %>
            <p style="color: red;"><%=request.getAttribute("error")%></p>
            <% 
            }
            %>
         <script>
                document.getElementsByName("file")[0].onchange=function (e){
                    document.getElementsByName("image")[0].style.display='block';
                   document.getElementsByName("image")[0].src=URL.createObjectURL(e.target.files[0]);
                };
            </script>
        </form>
    

</body>
</html>