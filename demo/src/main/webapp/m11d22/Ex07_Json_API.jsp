<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-11-22
  Time: 오전 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        /*
        1. XMLHttpRequest 객체 얻기
          2. onreadystatechange 이벤트 핸들러 구현 (함수)
          3. 요청 정보 ( open() )
          4. 요청 보내기 (send() )
          5. 응답 처리 (Text(JSON), xml)
        */

        let xhr = null;

        function getInstance(){
            if(window.XMLHttpRequest){
                xhr = new XMLHttpRequest;
            }else if(window.ActiveXObject){ //IE
                console.log("IE");
            }else{
                throw new Error("Ajax 비동기 지원하지 않아요");
            }
            return xhr;
        }

        function handlerStateChange() {
            if (xhr.readyState == 4) {
                if (xhr.status >= 200 && xhr.status < 300) {
                    const text = xhr.responseText;
                    const data = JSON.parse(text); // Parse JSON string to JavaScript object
                    for (let row of data) {
                        console.log(row);
                        document.getElementById("tbody").innerHTML +=
                            "<tr>" +
                            "<td>" + row.userId + "</td>" +
                            "<td>" + row.id + "</td>" +
                            "<td>" + row.title + "</td>" +
                            "<td>" + row.completed + "</td>" +
                            "</tr>"
                    }
                } else {
                    console.log("비정상 응답 : " + xhr.status);
                }
            }
        }

        function sendData(){
            xhr = getInstance();
            xhr.onreadystatechange = handlerStateChange;
            xhr.open("GET","https://jsonplaceholder.typicode.com/todos/");
            xhr.send(); //여행시작.....
        }

    </script>
</head>
<body>
<button id="select_menu" onclick="sendData()">비동기 가져오기</button>
<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>userId</th>
            <th>id</th>
            <th>Title</th>
            <th>completed</th>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
    </table>
</div>



<!--<h3>Ajax param 값 처리하기</h3>-->
<!--<div style="background-color:gray; width: 500px; text-align: center;">-->
<!--    <hr style="color: red">-->
<!--    <select id="select_menu" onchange="sendData()">-->
<!--        <option>0번 index</option>-->
<!--        <option>1번 index</option>-->
<!--        <option>2번 index</option>-->
<!--    </select>-->
<!--</div>-->
<!--<span id="div_view"></span>-->
</body>
</html>
