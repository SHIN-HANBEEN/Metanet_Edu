<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Example</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
    <!-- Material Kit CSS -->
    <link href="./css/material-kit.min.css" rel="stylesheet" />

</head>
<body>
    <div id="scrollTarget" class="card card-body shadow-xl pt-12 mx-3 mx-md-4 mt-n6">
        <div class="container border-bottom">
            <h2 class="mb-4 korean">KOSA - EMP Table 기능구현 by 2조</h2>
        </div>
        <section class="py-5">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-10 col-10 d-flex align-items-md-center justify-content-sm-center flex-column mx-auto text-lg-start text-center">
                        <div class="btn-group col-12" role="group">
                            <a href="/empadd.jsp" class="btn btn-primary">등록</a>
                            <a href="/empfindone.jsp" class="btn btn-primary">단건조회</a>
                            <a href="/empfindall.jsp" class="btn btn-primary">전체조회</a>
                            <a href="/empupdate.jsp" class="btn btn-primary">수정</a>
                            <a href="/empdelete.jsp" class="btn btn-primary">삭제</a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</body>
</html>
