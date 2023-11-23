<%--
  Created by IntelliJ IDEA.
  User: KOSA
  Date: 2023-11-22
  Time: 오전 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
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
                    const parsedText = JSON.parse(text); // Parse JSON string to JavaScript object
                    console.log(parsedText);
                    console.log(parsedText.data);
                    let champions = parsedText.data;
                    const championKeys = Object.keys(champions);
                    console.log(championKeys);

                    totalnum = championKeys.length; //전체 챔피언 수 계산
                    if (totalnum%10 === 0) { //마지막 페이지 maxpagenum 계산
                        maxpagenum = totalnum / 10;
                    } else {
                        maxpagenum = (totalnum / 10) + 1;
                    }

                    if (activated === 1) {
                        document.getElementById("tbody").innerHTML = "";
                        activated = 0;
                    }

                    document.getElementById("paginationList").innerHTML = "";

                    for (let index = currentpagenum * 10; index < Math.min((currentpagenum + 1) * 10, totalnum); index++) {
                        const championKey = championKeys[index];
                        const champion = champions[championKey];
                        console.log(champion);
                        document.getElementById("tbody").innerHTML +=
                            "<tr>" +
                            "<td>" + champion.key + "</td>" +
                            "<td>" + champion.name + "</td>" +
                            "<td>" + champion.stats.hp + "</td>" +
                            "<td>" + champion.stats.hpperlevel + "</td>" +
                            "<td>" + champion.stats.mp + "</td>" +
                            "<td>" + champion.stats.mpperlevel + "</td>" +
                            "<td>" + champion.stats.movespeed + "</td>" +
                            "</tr>";

                        document.getElementById("paginationList").innerHTML +=
                            "<li class='page-item'><a class='page-link' onclick=''>" +
                            index +
                            "</a></li>";
                    }

                    activated = 1; //activate 이후에는 1로 수정

                    // for (let index in championKeys) {
                    //     const championKey = championKeys[index];
                    //     const champion = champions[championKey];
                    //
                    //     // Your logic here
                    //     console.log(champion);
                    //     document.getElementById("tbody").innerHTML +=
                    //         "<tr>" +
                    //         "<td>" + champion.key + "</td>" +
                    //         "<td>" + champion.name + "</td>" +
                    //         "<td>" + champion.stats.hp + "</td>" +
                    //         "<td>" + champion.stats.hpperlevel + "</td>" +
                    //         "<td>" + champion.stats.mp + "</td>" +
                    //         "<td>" + champion.stats.mpperlevel + "</td>" +
                    //         "<td>" + champion.stats.movespeed + "</td>" +
                    //         "</tr>";
                    // }

                    // for(let championKey of championKeys) {
                    //     console.log(champions[championKey]);
                    //     document.getElementById("tbody").innerHTML +=
                    //     "<tr>" +
                    //     "<td>" + champions[championKey].key + "</td>" +
                    //     "<td>" + champions[championKey].name + "</td>" +
                    //     "<td>" + champions[championKey].stats.hp + "</td>" +
                    //     "<td>" + champions[championKey].stats.hpperlevel + "</td>" +
                    //     "<td>" + champions[championKey].stats.mp + "</td>" +
                    //     "<td>" + champions[championKey].stats.mpperlevel + "</td>" +
                    //     "<td>" + champions[championKey].stats.movespeed + "</td>" +
                    //     "</tr>"
                    // }
                } else {
                    console.log("비정상 응답 : " + xhr.status);
                }
            }
        }

        function changePage() {
            document.getElementById("paginationList").innerHTML +=
                "<li class='page-item'><a class='page-link' onclick=''>1</a></li>";
        }

        function sendData(){
            xhr = getInstance();
            xhr.onreadystatechange = handlerStateChange;
            xhr.open("GET","https://ddragon.leagueoflegends.com/cdn/13.23.1/data/en_US/champion.json");
            xhr.send(); //여행시작.....
        }


        let totalnum = 0;
        let maxpagenum = 0;
        let currentpagenum = 0;
        let activated = 0;
        let pagingnumber = 0;

        function previous() {
            if(currentpagenum !== 0) {
                currentpagenum--;
            }
        }
        function next() {
            if (currentpagenum < maxpagenum - 1) {
                currentpagenum++;
            }
        }
    </script>
</head>
<body>
<button id="select_menu" onclick="sendData()">비동기 가져오기</button>
<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>챔피언 고유번호</th>
            <th>이름</th>
            <th>기초 체력</th>
            <th>레벨당 체력</th>
            <th>기초 마나</th>
            <th>레벨당 마나</th>
            <th>이동속도</th>
        </tr>
        </thead>
        <tbody id="tbody">

        </tbody>
    </table>
    <ul class="pagination">
        <li class="page-item"><a class="page-link" onclick="previous(); sendData();">Previous</a></li>
        <span id="paginationList"></span>
<%--        <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--        <li class="page-item active"><a class="page-link" href="#">2</a></li>--%>
<%--        <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
        <li class="page-item"><a class="page-link" onclick="next(); sendData();">Next</a></li>
    </ul>
</div>

</body>
</html>
