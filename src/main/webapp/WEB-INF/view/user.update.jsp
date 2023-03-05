<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/14/2023
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="app.dao.UserDao, app.models.User,app.helper.MyHelper,java.util.*" %>
<%@ page import="org.springframework.ui.Model" %>
<jsp:include page="navbar.jsp"/>
<jsp:include page="header.jsp"/>

<h1 style="text-align: Center">Edit Profile</h1>
<jsp:useBean id="user" class="app.models.User" scope="request"></jsp:useBean>
<%
    Model model = null;
    String id = (String) model.getAttribute("id");
    Integer myId = Integer.valueOf(id);
    UserDao userDao = new UserDao();
    userDao.FindUser(myId);
%>
<div class="container">
    <form action="/user/update" method ="post">
        <div class="form-group">
            <label for="id">Id</label>
            <input type="text" class="form-control" id="id"  disabled
                   value="<%=user.getId()%>">
            <input type="hidden" class="form-control" name="id" value="<%=user.getId()%>">
        </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name"
                   value="<%=user.getName()%>" >
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email"
                   aria-describedby="emailHelp"  value="<%=user.getEmail()%>" >
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone"value="<%=user.getPhone()%>">
        </div>
        <div class="form-group">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city" value="<%=user.getCity()%>">
        </div>

        <button type="submit" class="btn btn-primary">Update User!</button>
    </form>
</div>
<jsp:include page="footer.jsp"/>
