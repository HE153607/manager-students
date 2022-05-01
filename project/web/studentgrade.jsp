<%-- 
    Document   : Profile
    Created on : Mar 7, 2022, 11:22:18 AM
    Author     : hoanganhPC
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Teacher"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>view teachers</title>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Bootstrap  -->
       

    </head>
    <body>
        <style>
            .menu-1{
             font-family: Lucida Console
                 Monaco;
            }
            select{
                height: 30px;
                background-color: #66ff66;
                margin-bottom: 20px;
                margin-left: 50px;
            }
            th{
                background-color: #99ade9;
                color: black;
            }
            td,th{
                border-bottom: 1px solid black;
            }
            table{
                margin-left: 200px;
            }
            html{
                overflow: hidden;
            }
        </style>
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
                                <div style="margin-right: 300px;" id="fh5co-logo"><a href="../homestudent"><i class="icon-study"></i>Educ<span>.</span></a></div>
                            </div>
                            
                            <div class="col-xs-10 text-right menu-1">
                                 <ul>
                                    <li class="active"><a style="color:  #b3afaf;" href="homestudent">Home</a></li>
                                    <li><a  href="profilestudent" style="color:  #b3afaf;"> profile individual</a></li>
                                    <li><a style="color:  #b3afaf;" href="homestudent/teacher">teacher information</a></li>
                                    <li><a style="color:  #b3afaf;" href="listdate">attendance</a></li>
                                    <li><a style="font-weight: bold;" href="studentgrade">mark</a></li>   
                                    <c:if test="${sessionScope.studentid==null}">
                                        <li class="btn-cta"><a href="loginstudent"><span>Login</span></a></li>
                                    </c:if>
                                    <c:if test="${sessionScope.studentid!=null}">
                                        <li class="btn-cta"><a href="logout"><span>Logout</span></a></li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </nav>
        </div>
        <div style="height: 8px;background-color: #00ffff;margin-bottom: 30px;"></div> 
        <form action="studentgrade" method="get" class="a">
        <select onchange="document.getElementsByClassName('a')[0].submit()" name="stt">
            <% for(int i=0;i<((ArrayList<String>)request.getAttribute("subject")).size();i++) {%>
            <option <%if(((String)request.getAttribute("stt")).split("=")[0].equals(((ArrayList<String>)request.getAttribute("subject")).get(i).split("=")[0])){%><%= "selected" %><% }%> value="<%= i%>">
                <%= ((ArrayList<String>)request.getAttribute("subject")).get(i).split("=")[0] %>
            </option>
            <% }%>
        </select>
        </form>
        <div style="height: 575px;background-color: #fbfffe;">
            <c:if test="${subject.size()>0}">
                <h3 style="margin-left: 100px;padding-top: 20px;width: 100%;margin-bottom:0px;"><%= "Grade report for "+ new Controller.ControllDao().getstudentbyids((String)request.getSession().getAttribute("studentid")).getName().split("=")[0]+"("+new Controller.ControllDao().getstudentbyids((String)request.getSession().getAttribute("studentid")).getId()+")" %></h3>
            <h3 style="margin-left: 100px;margin-bottom: 0;width: 100%;margin-top: 5px;">Teacher is teaching <%= new Controller.ControllDao().getteacherbyid(((ArrayList<String>)request.getAttribute("list")).get(0).split("=")[3]).getName() %></h3> 
            <div style="display: flex;"><img style="width: 300px;height: 250px;margin-left: 200px;" src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxAPEBAQEA8QEBUVDw8ODxUPDw8PFRUQFRUWFxURFRUYHSkgGholHxcVITEiJSkrLi4uFx8zODMsNygtLisBCgoKDg0OGxAQGy0mICUuLTAuMjAtLSsrLSstKy0tLy0tNS0tLzItLS8tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLf/AABEIAMkA+wMBIgACEQEDEQH/xAAbAAEAAgMBAQAAAAAAAAAAAAAABQYBAgcDBP/EAEgQAAIBAwAGBgQKBwUJAAAAAAABAgMEEQUGEiExQRNRYXGBoQcikbEyM0JSYnJzkrLBFCM0dILC0iVjoqOzFjVDU2R1k9Hw/8QAGgEBAAMBAQEAAAAAAAAAAAAAAAIEBQMBBv/EADcRAAIBAgIGCAUEAQUAAAAAAAABAgMRBCESMUFRobEFcYGRwdHh8BMUIjJhUrLC8UIVJDNygv/aAAwDAQACEQMRAD8A7iAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQ+m9YbezX6yWZtZjThhzfbjku1nsYuTtFXZGU4wWlJ2RMHyXd7SorNWrCmv7ycY+zPE5ppbXW6r5VN/o8Oqm8zx2ze/wBmCtzk5Nyk3Jvi5Nyb72zQp9HSf3u3H3xM2p0nBZQV+vL3wOr19dbCG5V9t/Qp1H54x5nyv0gWfza77oQ/qOY4GCyuj6O2/f6FX/Uq/wCO5+Z1Knr5YPjOpD61Nv8ADklbPT9pWaVO4ptvhFy2JfdlhnGMBo8l0dTf2trufgSj0nVX3JPvXizvYOL6L09dWuOirS2fmTe1DHVsvh4YLxoPXmjWxC4SoT4KWcwb738Hx3dpSq4KpDNZr8eReo9IUqjs8n+fP+i4AxnP5GSmXgAAAAAAAAAAAAAAAAAAAAAAAAAAAAUzXjWR0F+jUZYqSXryXGnF8l9J+S380dKVOVSSjE51asaUHOWo01t1v6FyoWzUqiyqk9zUH81Z3OXku18OeVJynJylJyk3mTk2231tviapG2Deo0IUo2j2vefOV8ROtK8uxbjGDbASNsHYrtmmDJvgyDw8zGD0wYwBc88GGjdoxgErk/qzrTVtGoTzUo845y4dsG/w8O46jZXdOvTjVpyU4yWYtf8A25nDsE5qnrBKzqYll0ZtdJHjh/Piutc+teBQxWDU/rh93P15mjg8a6bUJ/by9OXUdeB5UqinFSi1JNKUWnlNPemmepjG6AAAAAAAAAAAAAAAAAAAAAAAAResGlI2lvOs97S2aa+dUfwY/m+xM43XrSqTlUnJylKTlJvnJ8WWz0j6S6SvG3T9WktqX2klnyWPvMqKNvA0dCnpPW+WwwOkK3xKuitUee3yCN0jWJ6IumewkMGUjZAhc99H6Pq3EtijTlN88cF2yb3LxLlY6gR2H09aW216qp42YvtyvW8j69B6y20cW8qcbdrZw4LNOTaT70+/2lrhNNJppp7008prrTMjE4usnZLRXF9puYTBUGrt6T5dmvv7DlOmtV7i1zJx6Sn8+CbSXbHjH3dpB4Ou6Y0/QtF+sltS5QgtqT7+S8cHM9MXsbiq6kaMaKfyabe/tfLPckW8JXqVF9Uct+rh5FLG4ejSl9Es92u3b55keatG7RhlwonkzVno0YYJJl79HWms5s6j4JzoZ+bxlT8OK8eovpwuyupUKtOrD4UJqa7ccu5rK8TttpcRq04VIPMZwjOPdJZRi4+joT01qfP3mb3Rtdzp6D1x5emo9wAUTRAAAAAAAAAAAAAAAAAABpOSim3uSTb7kbkXrJW6O0uZLj0M0u+SwveeqOk0ltPJPRTe449eXTrValV5zOcqm/ltPKXhw8DyRhGyPp7WyR8ldvNm6MoIkdHaLnV2JtONOVenb7X0pPfs9eFnyPJSUVdnkYyk7RR8CRsXit6P/mXPhOlnzUvyIPSOqt3QTfR9JHD9ak9v2xwpeRwhiqM3ZS8OZ2q4OvBXcX2Z8ia1Ls4zuq9WSy6caSh2Ocd8u/EceLLXPR0Mtxc6Se+apz2Yy8Pkvtjh9pRtGawU6V5UqxpuFGooxlFb3HZSSlhccNPd1NnQLe7p1IqcKkZx64yTMvFxnGak1k0uWo2cDKlKDjFq6lLi3Z9VrEXrHo6nOyrRUYx2YSqwwksTinLPe96fezlhf9cNYafRSoUpKcp+rNxaajDms888Md5TbDRde4eKNKU9+HLhFd8nuLuBThScp5Jvb6md0jKNSso01dpbM9urLcfAzVlytdQ6ksdJcQh2Qg5+baPi05qq6NSjSozlVlUjXklJKPxaTwu1ps7rFUW7KXPZmcJYOvGOk48VfN22P8lYZqzeSx2cnndv6jVlgrpnmzqPo7vOks1BvfTnKH8LxOP4mvA5ey8ei6t69zDrVKa705J+9FPHQ0qLe6z428S/0fPRrpb7rhfwOhAAwz6EAAAAAAAAAAAAAAAAAAEFrp+wXHdD8cSdIrWelt2dyv7mUvu+t+ROk7Tj1rmc6qvTkvw+RxpGyRoj2tobU4RfypRg8dUnjPmfSs+UPehbSalLDcVKMJPHByzhZ69x0rWGjCnTsqdOKjGN9bqKXJJyPi1ssoW9lTp04qMVc0sdbb2syb5t9ZI61LEbT/uFv57RkzrOrKElvlyRt0sOqMakXrtHi3wJ3bMdIY2X1DZfAzTUIbTWr1C6y3Ho6n/MglnP0lwl7+0oektDVreoqcobTk8QccyU/q9vZx8jquy9/cfFfrFS1+3kvHoarLeHxdSnlrRn4vA0q31anv8AP31lc0FqfFYndLafFUk9y+s1x7lu7y20UopRjFJLclFJJLqSR6RjxyYUGcatadV3ky1Qw9OjHRgvN9ZrFLj1MhNKvOkNHPqjef6aJxwe/vRB6WX9oaPXZdv/AC0KP3Pql+1nlf7V/wBo/uRWde9HL9Ki6UN86Lq1FFZy4t5ljuW8qEjqF+v7UtF/09X3TKpr9o2nQrwlTWz0kHOUV8FSTw2lyyamFr2UKb3Zd7MjGYfOdVfqz7ln36yrlw9GH7RW+w/miU9l29F1LNS6n1Rpw+82/wCU7Yz/AIJe9qOOCX+4h28mdEABgH0gAAAAAAAAAAAAAAAAAAPOrTU4yi+EouL7msM9AAcIr0HSnOnLjCcqcu+LafuPbR/xtL7SHvJ/0h6N6G66VL1a0dr+OOFJfhfiyA0f8bS+0h7z6OFT4lPT3rwz4ny06fw6rhufDZwOl6/fs1P95o/zHtrhKUadvOMJVNm7o1JKEHOWzHab3I+f0iPFpF9VxTfsUiEp63aRrb6NtFrlsUatT/FnBlUaU5U4SjbJvW7bjZxFaEKs4Nu7StZXeuRPPXO2XxkLil9ejj3NkjZadta2FTrwbfCLbhJ90ZYbKn/tPpOHxlrlc9q3qx884PFaesLjMbqzVPO5ypZb73s4fhvJPCXWUX2NS4O3M5/PWecl/wCoyjxu+R0Y+C/+Mtf3iX+hWK/ZxrUo9LY3CvKK40akvWiuqMuKfZhdzJClpalcfo1SD2dm4mqkZ+rKElQr5UlyKzp6LbTus+zLatnjsLiqqdk1Z5PffPY1k/d7E+fLdXtKitqrUjTXLbko57s8SCnpK4vHKNo1RoptTuKiznHHo4Pj3vyIW4r6MtpNzc76r8qU5OUc9rb2cfeJQw7bs733JXfbsRCpiklpK1t7dk+ra+zJ7yeq65WUXiM51H1U6bfszg+KOkf0u+spwo14Rpq5UpVKbivXhu3rK5c+sjaWtlzJYtbKnCPJQhUn+FJGZaxaWjvds8dttUx7yx8s4X0Uk7NZyW1W1WRV+aU7Xk2rp5QaWTT1tvcTekP972n7vV90yB9J/wAbb/Un7zbQemal5pG3lVhGEoU6tNqO0vkSfB71xNPSj8bb/Zz95OlBwrwjLWov+RGvUjUw1ScdTkv4lKZ0v0cWmxauq/8AiVJNfUh6q81P2nN6FGVScacFmUpRhFdcm8I7Zo20jQo0qUeEIRgu3C3vx4nTpGpaChvfBepy6Mp3qOe5cX6H1gAxzcAAAAAAAAAAAAAAAAAAAAAIXWnRCvLeVNY24/rKTfz1y7mm14nJbT9XVht+ripDbyvg4a2srswzuhQNfdW3mV5RjnnXil/mL8/b1mhga6i/hy1PV1+vvWZnSGHckqsda19XpyPo0vrpZyxGNGV1syU47aUI7SylJZy+b+SR1T0g3D+BQpQX0nUqe5opqMl6OCopWav1mfLH15O6lbqS/viWxa93nzaH/jn/AFGlXXCdXdWtLasu2Ek/BtvBV0zbJP5Wj+lcfM5/OYjVpvg/AnaWkreMnUpQr2c+To1FXX3JYfhnHYZ0jpGlXqQqTfrN7Nw6W1BVYJbpOL+DPGYvit/gQWTOSXwlfSu79/F3fE5/Hk46NlbqSXcsuGZY7zTdKstirKfRxSUKFuuipJLgnOW+X3e7B52+sNGj8TY0YtcHVnOs/a8eRX8jJ4sPBLR2br5cLEvmqmlpZJ77Z8b8C0vXy75QoLup1P6jMNf7pcadCX8FRee0VJsZI/KUP0L32k1jcR+t8PIu1vrzSlUjUr2iUo5UalOcZSSaw0lJLdv4ZIzXfS9G8lQnRk2lCcZKUXFxe54efyK0Ser2hal5WUI5UFh1Z4+DHs+k+S/9EVh6NJ/EWVu73uJvE1qy+E87/jPhxfEsXo50Ntzd3NerDMKOec+Ep+Cyu9vqOinz2ltClCNOnFRjGKjFLkkfQY9es6s3L3Y3MPRVGmoLt/LAAOJ3AAAAAAAAAAAAAAAAAAAAABhmQAc71s1PcXKvaRzHfKpSit663TXNfR5cupUhM72VrWDVGhd5mv1VV73KK3Sf048+9YZpYbHaK0anf57zKxXR+k9Klr3eW45UZySuldXLq1y50nKK+XDMoY62+MfFIiEzUjKM1eLuZE4Si7SVmb5M5PPJnJIhY2yYyYyYyD2xtkxk9rKzq15bFGnOo+qCbx3vgvEumgtQnundy7eipy8pzXuj7TlVr06X3Pz99Z2o4epWf0Lt2e+q5WtX9AVr2eILZgn69Rr1Y9i+dLs9uDq2iNF0rSkqVKOEt7b3ylLnKT5s+ihQhTjGEIxhGKxGMUopLsSPcxcRiZVnuW7zN3C4SFBb3v8AIAArFsAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAENpDVyzr5dS3hl8ZQzTl3txxnxJkHsZOLunYjKKkrSV0U2v6PrZ74Va0OxunNfhz5nyP0cLldvxoZ/nL6CwsXXX+XLyK7wWHf+K4rkykUvR3S+XcVH9SEYe/JKWepdjSw+ilVfXUnJ/4ViPkWMEZYmtLXJko4SjHNRR40KEKcVGEYwiuChFRXsR7AHAsAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH/2Q=="/>
            <table>
            <tr>
                <th><p style="margin-right: 50px;">Category items</p></th>
                <th><p style="margin-right: 50px;">Grade Weight</p></th>
            <th><p>Value</p></th>
            </tr>
            <% int t=0;int count=0;float y=0; ArrayList<String> a=(ArrayList<String>)request.getAttribute("list"); for(int i=0;i<a.size();i++){ %>
            <tr>
                <td><%= a.get(i).split("=")[1] %></td>
                <td><%= a.get(i).split("=")[0]+"%" %></td>
                <td><%= a.get(i).split("=")[2] %></td>
            </tr>
            <% if(!a.get(i).split("=")[2].trim().equals("")){
                count++;
            y+=Float.parseFloat(a.get(i).split("=")[2]);
            }%>
            <% if(a.get(i).split("=")[2].trim().equals("")){
            t=1;
            } }%>
            <tr>
                <td><p style="padding-top: 6px;margin-bottom: 5px;color: #00ff00;">Course Total</p></td>
                <td><p style="padding-top: 6px;margin-bottom: 6px;color: #00ff00;">Average</p></td>
                <td style="color: black;"><% if(t==0){ %><%= (double)Math.round((y/count)*100)/100 %><% }%></td>
            </tr>
            <tr>
                <td style="color: #33cc00;">Status</td>
                <td style="color: #33cc00;"><% if(t==0){%><%= "Done" %><% }%><% if(t==1){%><%= "Studying" %><% }%></td>
                <td></td>
            </tr>
        </table>
            </div>
        </c:if>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>