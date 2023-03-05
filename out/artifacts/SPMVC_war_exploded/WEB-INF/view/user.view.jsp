<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/30/2023
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="app.dao.UserDao,app.models.User,java.util.*" %>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>
<h1 style="text-align: Center">All User</h1>
<%
    UserDao dao=new UserDao();
    List<User> users=dao.getAllUser();
%>
<div class="container">
    <a href="user.create.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="true" >Add New User!</a>
    <br> <br>
    <table border="2" width="100%" class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>City</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.getId()}</td>
                <td>${u.getName()}</td>
                <td>${u.getEmail()}</td>
                <td>${u.getPhone()}</td>
                <td>${u.getCity()}</td>
                <td><a href="/user/update?id=${u.getId()}">Edit</a></td>
                <td><a href="/user/delete?id=${u.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="footer.jsp"></jsp:include>
