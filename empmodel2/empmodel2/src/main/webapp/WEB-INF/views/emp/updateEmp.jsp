<%--
  Created by IntelliJ IDEA.
  User: exia
  Date: 11/23/23
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
                <h3 class="text-center">EMP 수정하기</h3>
                <form role="form" id="contact-form" action="${pageContext.request.contextPath}/emp.do?cmd=updateEmp.do" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-dynamic mb-4">
                                    <input class="form-control" name="empno" placeholder="empno" value="${requestScope.emp.empno}" type="text" readonly >
                                </div>
                            </div>
                            <div class="col-md-6 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="ename" value="${requestScope.emp.ename}" placeholder="ename" aria-label="ename..." >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-dynamic mb-4">
                                    <input class="form-control" name="job" value="${requestScope.emp.job}" placeholder="job" aria-label="job..." type="text" >
                                </div>
                            </div>
                            <div class="col-md-6 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="mgr" value="${requestScope.emp.mgr}" placeholder="mgr" aria-label="mgr..." >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-dynamic mb-4">
                                    <input class="form-control" name="hiredate" value="${requestScope.emp.hiredate}" placeholder="hiredate (ex. 2000-10-10)" aria-label="hiredate..." type="text" >
                                </div>
                            </div>
                            <div class="col-md-6 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="sal" value="${requestScope.emp.sal}" placeholder="sal" aria-label="sal..." >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-dynamic mb-4">
                                    <input class="form-control" name="comm" value="${requestScope.emp.comm}" placeholder="comm" aria-label="comm..." type="text" >
                                </div>
                            </div>
                            <div class="col-md-6 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="deptno" value="${requestScope.emp.deptno}" placeholder="deptno" aria-label="deptno..." >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn bg-gradient-dark w-100">수정하기</button>
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








