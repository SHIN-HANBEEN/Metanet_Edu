

function checkEmp() {
    let empno = document.getElementById("empnoinput").value;
    let apiUrl = `/emp.do?cmd=checkEmp.do&empno=`+empno;

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${requestScope.status}`);
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            if(data.isNull) {
                //alert here
                alert('검색하신 empno로 생성 가능합니다.');
            } else {
                alert('검색하신 empno 가 이미 있습니다.');
            }
        })
        .catch(error => {
            // Handle errors during the fetch
            console.error('Fetch error:', error);
        });
}