
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <h3 class="text-center">EMP 등록하기</h3>
                <form role="form" id="contact-form" action="${pageContext.request.contextPath}/emp.do?cmd=addEmp.do" method="post" autocomplete="off">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-dynamic mb-4">
                                    <input id="empnoinput" class="form-control" name="empno" placeholder="empno" type="text" >
                                    <div onclick="checkEmp()" class="btn bg-gradient-dark w-100">중복확인하기</div>
                                </div>
                            </div>
                            <div class="col-md-6 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="ename" placeholder="ename" aria-label="ename..." >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-dynamic mb-4">
                                    <input class="form-control" name="job" placeholder="job" aria-label="job..." type="text" >
                                </div>
                            </div>
                            <div class="col-md-6 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="mgr" placeholder="mgr" aria-label="mgr..." >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-dynamic mb-4">
                                    <input class="form-control" name="hiredate" placeholder="hiredate (ex. 2000-10-10)" aria-label="hiredate..." type="text" >
                                </div>
                            </div>
                            <div class="col-md-6 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="sal" placeholder="sal" aria-label="sal..." >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="input-group input-group-dynamic mb-4">
                                    <input class="form-control" name="comm" placeholder="comm" aria-label="comm..." type="text" >
                                </div>
                            </div>
                            <div class="col-md-6 ps-2">
                                <div class="input-group input-group-dynamic">
                                    <input type="text" class="form-control" name="deptno" placeholder="deptno" aria-label="deptno..." >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <button type="submit" class="btn bg-gradient-dark w-100">등록하기</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>

<%--<script>--%>
<%--    function checkEmp() {--%>
<%--        let empno = document.getElementById("empnoinput").value;--%>
<%--        let apiUrl = `/emp.do?cmd=checkEmp.do&empno=`+empno;--%>

<%--        fetch(apiUrl)--%>
<%--            .then(response => {--%>
<%--                if (!response.ok) {--%>
<%--                    throw new Error(`HTTP error! Status: ${requestScope.status}`);--%>
<%--                }--%>
<%--                return response.json();--%>
<%--            })--%>
<%--            .then(data => {--%>
<%--                console.log(data);--%>
<%--                if(data.isNull) {--%>
<%--                    //alert here--%>
<%--                    alert('검색하신 empno로 생성 가능합니다.');--%>
<%--                } else {--%>
<%--                    alert('검색하신 empno 가 이미 있습니다.');--%>
<%--                }--%>
<%--            })--%>
<%--            .catch(error => {--%>
<%--                // Handle errors during the fetch--%>
<%--                console.error('Fetch error:', error);--%>
<%--            });--%>
<%--    }--%>
<%--</script>--%>
<!-- Import your JavaScript file -->
<script src="js/emp.js"></script>
</html>

