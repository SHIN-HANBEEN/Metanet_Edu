
<%--
  Created by IntelliJ IDEA.
  User: exia
  Date: 11/23/23
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Example</title>
    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
    <!-- Material Kit CSS -->
    <link href="./css/material-kit.min.css" rel="stylesheet" />

</head>
<body>
<br><br><br><br><br>
<section>
    <div class="container py-4">
        <div class="row">
            <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                <h3 class="text-center">EMP 삭제하기</h3>
                <form role="form" id="contact-form"action="${pageContext.request.contextPath}/emp.do?cmd=deleteEmp.do" method="post" autocomplete="off">
                    <div class="card-body">
                        <br><br><br>
                        <div class="row">
                            <div class="col-md-12 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="empno" placeholder="empno (ex. 7499)" aria-label="ename..." >
                                </div>
                            </div>
                        </div>
                        <br><br>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn bg-gradient-dark w-100">삭제하기</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>


