<%--
  Created by IntelliJ IDEA.
  User: exia
  Date: 11/23/23
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container mt-3">--%>
<%--    <table class="table table-striped">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th>empno</th>--%>
<%--            <th>ename</th>--%>
<%--            <th>job</th>--%>
<%--            <th>mgr</th>--%>
<%--            <th>hiredate</th>--%>
<%--            <th>sal</th>--%>
<%--            <th>comm</th>--%>
<%--            <th>deptno</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--            <tr>--%>
<%--                <td>${emp.empno}</td>--%>
<%--                <td>${emp.ename}</td>--%>
<%--                <td>${emp.job}</td>--%>
<%--                <td>${emp.mgr}</td>--%>
<%--                <td>${emp.hiredate}</td>--%>
<%--                <td>${emp.sal}</td>--%>
<%--                <td>${emp.comm}</td>--%>
<%--                <td>${emp.deptno}</td>--%>
<%--            </tr>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

<%--
  Created by IntelliJ IDEA.
  User: exia
  Date: 11/23/23
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>

<%--<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
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
<section class="pt-5 mt-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <div class="card">
                    <div class="table-responsive">
                        <table class="table align-items-center mb-0">
                            <thead>
                            <tr>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">empno</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">ename</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">job</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">mgr</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">hiredate</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">sal</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">comm</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">deptno</th>
<%--                                <th class="text-secondary opacity-7"></th>--%>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>${emp.empno}</td>
                                <td>${emp.ename}</td>
                                <td>${emp.job}</td>
                                <td>${emp.mgr}</td>
                                <td>${emp.hiredate}</td>
                                <td>${emp.sal}</td>
                                <td>${emp.comm}</td>
                                <td>${emp.deptno}</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>



