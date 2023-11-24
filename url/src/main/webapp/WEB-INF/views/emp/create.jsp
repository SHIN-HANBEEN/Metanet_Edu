<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <title>Create Employee</title>
</head>
<body>
    <div class="container mt-5">
        <h2 class="mb-4">Create Employee</h2>

        <!-- Form to create employee information -->
        <form action="emp.do?action=create" method="post">
            <!-- Action 정보 수정 -->
            <input type="hidden" name="action" value="insert">

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="empno">사원 번호 :</label>
                    <input type="text" class="form-control" id="empno" name="empno" required>
                </div>
                <div class="form-group col-md-6">
                    <label for="ename">사원 이름 :</label>
                    <input type="text" class="form-control" id="ename" name="ename" required>
                </div>

                <div class="form-group col-md-6">
                    <label for="job">직업 :</label>
                    <input type="text" class="form-control" id="job" name="job" required>
                </div>
            </div>

            <div class="form-group col-md-6">
                <label for="mgr">매니저 번호 :</label>
                <input type="text" class="form-control" id="mgr" name="mgr" required>
            </div>

            <div class="form-group col-md-6">
                <label for="hiredate">고용일 :</label>
                <input type="text" class="form-control" id="hiredate" name="hiredate" required>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="sal">월급 :</label>
                    <input type="text" class="form-control" id="sal" name="sal" required>
                </div>

                <div class="form-group col-md-6">
                    <label for="comm">성과금 :</label>
                    <input type="text" class="form-control" id="comm" name="comm" required>
                </div>
            </div>

            <div class="form-group">
                <label for="deptno">부서 번호 :</label>
                <input type="text" class="form-control" id="deptno" name="deptno" required>
                <div id="deptnoToggle">
                    <input type="radio" id="deptno10" name="deptnoToggle" value="10">
                    <label for="deptno10">10</label>

                    <input type="radio" id="deptno20" name="deptnoToggle" value="20">
                    <label for="deptno20">20</label>

                    <input type="radio" id="deptno30" name="deptnoToggle" value="30">
                    <label for="deptno30">30</label>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">Create Employee</button>
        </form>

        <!-- Link to go back to the employee list -->
        <p class="mt-3"><a href="emp.do" class="btn btn-secondary">Back to Employee List</a></p>
    </div>

    <!-- Bootstrap JS and jQuery (required for Bootstrap) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.7/dist/umd/popper.min.js"
            integrity="sha384-7UO9aghQUhU3p5wnfVrTQZqisgk7TMt9QQxSxFKkXypFsXpWJ20JU5OvvLvygcOP"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wy8g/uW8+eWq8vq8L/2Ll5M0q8U5aSkkD"
            crossorigin="anonymous"></script>
    <script>
        // Add an event listener to the deptnoToggle div to handle radio button changes
        document.getElementById('deptnoToggle').addEventListener('change', function () {
            // Get the selected radio button value
            var selectedValue = document.querySelector('input[name="deptnoToggle"]:checked').value;

            // Set the input field value to the selected value
            var deptnoInput = document.getElementById('deptno');
            deptnoInput.value = selectedValue;
        });

        // Add an event listener to the input field to uncheck radio buttons when text is entered
        document.getElementById('deptno').addEventListener('input', function () {
            // Uncheck all radio buttons
            var radioButtons = document.querySelectorAll('input[name="deptnoToggle"]');
            radioButtons.forEach(function (radioButton) {
                radioButton.checked = false;
            });
        });
    </script>
</body>
</html>
