
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        let xhr = null;

        function getInstance() {
            if (window.XMLHttpRequest) {
                xhr = new XMLHttpRequest;
            } else if (window.ActiveXObject) {
                console.log("IE");
            } else {
                throw new Error("Ajax 비동기 지원하지 않아요");
            }
            return xhr;
        }

        function handlerStateChange() {
            if (xhr.readyState == 4) {
                if (xhr.status >= 200 && xhr.status < 300) {
                    const text = xhr.responseText;
                    // console.log(text);
                    const parsedText = JSON.parse(text);
                    console.log(parsedText);
                    console.log(parsedText.DATA[0]);

                    for (let index = 0; index < 10; index++) {
                        document.getElementById("tbody").innerHTML +=
                            "<tr>" +
                            "<td>" + parsedText.DATA[index].aname + "</td>" +
                            "<td>" + parsedText.DATA[index].fname + "</td>" +
                            "<td>" + parsedText.DATA[index].center_x1 + "</td>" +
                            "<td>" + parsedText.DATA[index].center_y1 + "</td>" +

                            "</tr>"
                    }

                    // for (const poop of parsedText.DATA) {
                    //     // console.log(poop);
                    //     document.getElementById("tbody").innerHTML +=
                    //         "<tr>" +
                    //         "<td>" + poop.aname + "</td>" +
                    //         // "<td>" + item.aname + "</td>" +
                    //         // "<td>" + item.center_x1 + "</td>" +
                    //         // "<td>" + item.center_y1 + "</td>" +
                    //         // "<td>" + item.updatedate + "</td>" +
                    //         "</tr>"
                    // }

                    // console.log(parsedText.DATA);
                    // let data = parsedText.DATA;
                    // for (let index in parsedText.DATA) {
                    //     document.getElementById("tbody").innerHTML +=
                    //         "<tr>" +
                    //         "<td>" + parsedText.DATA[index].aname + "</td>" +
                    //         // "<td>" + item.aname + "</td>" +
                    //         // "<td>" + item.center_x1 + "</td>" +
                    //         // "<td>" + item.center_y1 + "</td>" +
                    //         // "<td>" + item.updatedate + "</td>" +
                    //         "</tr>"
                    // }
                } else {
                    console.log("비정상 응답 : " + xhr.status);
                }
            }
        }

        function sendData() {
            xhr = getInstance();
            xhr.onreadystatechange = handlerStateChange;
            xhr.open("GET", "lib.json");
            xhr.send();
        }
    </script>
</head>
<body>
<button id="select_menu" onclick="sendData()">비동기 가져오기</button>
<div class="container mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>화장실종류</th>
            <th>건물이름</th>
            <th>중앙좌표X1</th>
            <th>중앙좌표Y1</th>
        </tr>
        </thead>
        <tbody id="tbody">
        </tbody>
    </table>
</div>
</body>
</html>