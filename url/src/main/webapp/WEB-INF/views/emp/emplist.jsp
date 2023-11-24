<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <!-- Bootstrap CSS link -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Employee List</h2>

        <!-- Search Form -->
        <form action="emp.do" method="get" class="mt-3">
            <div class="input-group mb-3">
                <input type="text" class="form-control" id="searchName" name="searchName" placeholder="Search by Name">
                <div class="input-group-append">
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </div>
        </form>

        <table class="table table-striped mt-4">
            <thead class="thead-dark">
                <tr>
                    <th>EMPNO</th>
                    <th>ENAME</th>
                    <th>JOB</th>
                    <th>MGR</th>
                    <th>HIREDATE</th>
                    <th>SAL</th>
                    <th>COMM</th>
                    <th>DEPTNO</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="employee" items="${empList}">
                    <tr>
                        <td>${employee.EMPNO}</td>
                        <td>${employee.ENAME}</td>
                        <td>${employee.JOB}</td>
                        <td>${employee.MGR}</td>
                        <td>${employee.HIREDATE}</td>
                        <td>${employee.SAL}</td>
                        <td>${employee.COMM}</td>
                        <td>${employee.DEPTNO}</td>
                        <td>
                            <a href="emp.do?action=updateEmp&empno=${employee.EMPNO}" class="btn btn-warning btn-sm">Update</a>
                            <a href="emp.do?action=delete&empno=${employee.EMPNO}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <!-- Link to create new employee -->
        <p><a href="emp.do?action=createEmp" class="btn btn-primary">Create New Employee</a></p>
    </div>

    <!-- Bootstrap JS and jQuery (make sure to include jQuery before Bootstrap's JS) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
