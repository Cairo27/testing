<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 1/29/2023
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="navbar.jsp"></jsp:include>
<h1 style="text-align: Center">Create</h1>
<div class="container">
    <form action="/user/create" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="Email" name="email"
                   aria-describedby="emailHelp" >
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="text" class="form-control" id="phone" name="phone">
        </div>
        <div class="form-group">
            <label for="city">City</label>
            <input type="text" class="form-control" id="city" name="city">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
