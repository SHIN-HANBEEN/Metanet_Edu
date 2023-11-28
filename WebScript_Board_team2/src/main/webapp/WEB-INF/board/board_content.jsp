<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>board_content</title>
	<link rel="Stylesheet"
		href="../../style/default.css" />
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<jsp:include page="/include/header.jsp"/>
	<div id="pageContainer">
		<div style="padding-top: 30px; text-align: center">
			<center>
				<b>게시판 글내용</b>
				<table width="80%" border="1">
					<tr>
						<td width="20%" align="center"><b> 글번호 </b></td>
						<td width="30%">${requestScope.board.idx}</td>
						<td width="20%" align="center"><b>작성일</b></td>
						<td>${requestScope.board.writedate}</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>글쓴이</b></td>
						<td width="30%">${requestScope.board.writer}</td>
						<td width="20%" align="center"><b>조회수</b></td>
						<td>${requestScope.board.readnum}</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>홈페이지</b></td>
						<td>${requestScope.board.homepage}</td>
						<td width="20%" align="center"><b>첨부파일</b></td>
						<td>${requestScope.board.filename}</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>제목</b></td>
						<td colspan="3">${requestScope.board.subject}</td>
					</tr>
					<tr height="100">
						<td width="20%" align="center"><b>글내용</b></td>
						<td colspan="3">
							${requestScope.board.content}<br>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center">
							<a href="list.do?cp=${requestScope.cpage}&ps=${requestScope.pagesize}">목록가기</a> |
							<a href="boardEditContent.do?idx=${requestScope.board.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}">편집</a> |
							<a href="boardDeleteContent.do?idx=${requestScope.board.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}">삭제</a> |
							<a href="rewriteContent.do?idx=${requestScope.board.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}&subject=${requestScope.board.subject}">답글</a>
						</td>
					</tr>
<%--					<tr>--%>
<%--						<td colspan="4" align="center">--%>
<%--						<a href="list.do?cp=${requestScope.cpage}&ps=${requestScope.pagesize}">목록가기</a> |--%>
<%--						<a href="boardEdit.do?idx=${requestScope.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}">편집</a>	|--%>
<%--						<a href="boardDelete.do?idx=${requestScope.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}">삭제</a> |--%>
<%--						<a href="rewriteok.do?idx=${requestScope.idx}&cp=${requestScope.cpage}&ps=${requestScope.pagesize}&subject=${requestScope.subject}">답글</a>--%>
<%--						</td>--%>
<%--					</tr>--%>
				</table>
				<!--  꼬리글 달기 테이블 -->
				<form name="reply" action="replyWrite.do" method="POST" id="replyForm">
						<!-- hidden 태그  값을 숨겨서 처리  -->
						<input type="hidden" name="idx" value="${requestScope.board.idx}">
						<input type="hidden" name="userid" value=""><!-- 추후 필요에 따라  -->
						<!-- hidden data -->
						<table width="80%" border="1">
							<tr>
								<th colspan="2">덧글 쓰기</th>
							</tr>
							<tr>
								<td align="left">작성자 :
								 	<input type="text" name="reply_writer"><br /> 
								 	내&nbsp;&nbsp;용 : 
								 	<textarea name="reply_content" rows="2" cols="50"></textarea>
								</td>
								<td align="left">
									비밀번호:
									<input type="password" name="reply_pwd" size="4"> 
									<input type="button" value="등록" onclick="reply_check()">
								</td>
							</tr>
						</table>
				</form>
				<!-- 유효성 체크	 -->

				<script type="text/javascript">
					let idx = "";

					function loadComments(){

						let commentsHtml ='';
						idx = ${requestScope.board.idx};
						console.log(idx);
						fetch('board/GetComments.jsp?idx=' + idx)
								.then(response => response.json())
								.then(comments => {
									comments.forEach(comment => {
										console.log(comment);
										commentsHtml += '<tr align="left">' +
												'<td width="80%">' +
												'<span>' + comment.writer + ' : ' + comment.content + '</span>' +
												'<br><span>작성일: ' + comment.writedate + '</span>' +
												'</td>' +
												'<td width="20%">' +
												'<form action="replyDelete.do" method="POST" name="replyDel">' +
												'<input type="hidden" name="no" value="' + comment.no + '">' +
												'<input type="hidden" name="idx" value="' + idx + '">' +
												'password : <input type="password" name="delPwd" size="4">' +
												'<input type="button" value="삭제" onclick="reply_del(event, this.form)">' +
												'</form>' +
												'</td>' +
												'</tr>';
									});
									console.log("empty before start");
									$('#commentsTable').empty();
									$('#commentsTable').append(commentsHtml);
								})
								.catch(error => console.error('Error:', error));
					}
					window.onload = function() {
						loadComments();
					};

					function reply_check() {
						var frm = document.reply;
						if (frm.reply_writer.value == "" || frm.reply_content.value == ""
								|| frm.reply_pwd.value == "") {
							alert("리플 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
							return false;
						}
						var formData = $('#replyForm').serialize();

						fetch('replyWrite.do', {
							method: 'POST',
							headers: {
								'Content-Type': 'application/x-www-form-urlencoded'
							},
							body: formData
						})
								.then(response => response.json())
								.then(data => {
									if(data.success) {
										loadComments();
										alert("댓글이 성공적으로 등록되었습니다.");
									}
								})
								.catch(error => {
									console.error('Error',error);
									alert("댓글 등록에 실패했습니다");
								});

					}
					function reply_del(e, form) {
						e.preventDefault();
						var formData = $(form).serialize();
						fetch('replyDelete.do',{
							method: "POST",
							headers: {
								'content-type': 'application/x-www-form-urlencoded'
							},
							body:formData
						})
								.then(response => response.json())
								.then(data => {
											alert(data.message);
											if(data.success) {
												loadComments();
											}
										}
								)
					}
				</script>


				<!--
				<script type="text/javascript">
					document.addEventListener('DOMContentLoaded', function () {
						getCommentListAsync();
					});

					function getCommentListAsync() {
						const urlParams = new URL(location.href).searchParams;
						let idx = urlParams.get("idx");

						fetch(`WriteReplyServlet?idx=${idx}`, {
							method: 'GET',
							headers: {
								'Content-Type': 'application/json',
							},
						})
								.then(response => {
									if (!response.ok) {
										throw new Error('Network response was not ok');
									}
									return response.json();
								})
								.then(data => {
									data.forEach(obj => {
										addComment(obj.writer, obj.content, obj.writedate, obj.no, obj.idx_fk);
									});
								})
								.catch(error => {
									console.error('Error fetching data:', error);
									alert("덧글불러오기에 실패했습니다.");
								});
					}

					function reply_check() {
						var frm = document.reply;
						if (frm.reply_writer.value == "" || frm.reply_content.value == "" || frm.reply_pwd.value == "") {
							alert("리플 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
							return false;
						}

						resetTable();
						const urlParams = new URL(location.href).searchParams;
						let p = {
							"idx": urlParams.get("idx"),
							"reply_writer": frm.reply_writer.value,
							"reply_content": frm.reply_content.value,
							"reply_pwd": frm.reply_pwd.value
						};

						fetch(`WriteReplyServlet`, {
							method: 'POST',
							headers: {
								'Content-Type': 'application/json',
							},
							body: JSON.stringify(p),
						})
								.then(response => {
									if (!response.ok) {
										throw new Error('Network response was not ok');
									}
									return response.json();
								})
								.then(data => {
									data.forEach(obj => {
										addComment(obj.writer, obj.content, obj.writedate, obj.no, obj.idx_fk);
									});
								})
								.catch(error => {
									console.error('Error fetching data:', error);
									alert("덧글입력에 실패했습니다.");
								});

						frm.reply_writer.value = "";
						frm.reply_content.value = "";
						frm.reply_pwd.value = "";
					}

					function resetTable() {
						$("#dynamicComments").empty();
					}

					function reply_del(frm) {
						if (frm.delPwd.value == "") {
							alert("비밀번호를 입력하세요");
							frm.delPwd.focus();
							return false;
						}

						const urlParams = new URL(location.href).searchParams;
						let p = {
							"idx": urlParams.get("idx"),
							"no": frm.no.value,
							"delPwd": frm.delPwd.value
						};

						fetch(`DelReplyServlet`, {
							method: 'POST',
							headers: {
								'Content-Type': 'application/json',
							},
							body: JSON.stringify(p),
						})
								.then(response => {
									if (!response.ok) {
										throw new Error('Network response was not ok');
									}
									return response.text();
								})
								.then(data => {
									resetTable();
									getCommentListAsync();
								})
								.catch(error => {
									console.error('Error fetching data:', error);
									alert('덧글삭제에 실패했습니다.');
									resetTable();
									getCommentListAsync();
								});
					}

					function addComment(writer, content, writedate, no, idx_fk) {
						var dynamicCommentsContainer = $("#dynamicComments");
						var newRow = $("<tr>").attr("align", "left");
						var newCell1 = $("<td>").attr("width", "80%").html("[" + writer + "]" + ":" + content + "<br>작성일:" + writedate);
						var newCell2 = $("<td>").attr("width", "20%");
						var deleteForm = $("<form>").attr({
							action: "replyDelete.do",
							method: "POST",
							name: "replyDel"
						});
						var hiddenNo = $("<input>").attr({
							type: "hidden",
							name: "no",
							value: no
						});
						deleteForm.append(hiddenNo);
						var hiddenIdx = $("<input>").attr({
							type: "hidden",
							name: "idx",
							value: idx_fk
						});
						deleteForm.append(hiddenIdx);
						var passwordInput = $("<input>").attr({
							type: "password",
							name: "delPwd",
							size: "4"
						});
						var passwordLabel = $("<label>").html("password:");
						deleteForm.append(passwordLabel);
						deleteForm.append(passwordInput);
						var deleteButton = $("<input>").attr({
							type: "button",
							value: "삭제"
						}).click(function () {
							reply_del(this.form);
						});
						deleteForm.append(deleteButton);
						newCell2.append(deleteForm);
						newRow.append(newCell1, newCell2);
						dynamicCommentsContainer.append(newRow);
					}
				</script>
-->


<!--
				<script type="text/javascript">
					function reply_insert() {
						console.log("reply_insert start");
						var frm = document.reply;

						if (frm.reply_writer.value == "" || frm.reply_content.value == "" || frm.reply_pwd.value == "") {
							alert("리플 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
							return false;
						}

						var endpoint = 'replyWrite.do';

						fetch(endpoint, {
							method: 'POST',
							body: formData
						})
								.then(response => {
									if (!response.ok) {
										console.log("response.ok = false");
										throw new Error('Network response was not ok');
									}
									console.log("response.ok = true");
									return response.json(); // Assuming the server returns a JSON response
								})
								.then(data => {
									// Handle the response data and update the DOM
									console.log("data start")
									console.log("data = " + data);

									reply_check();
								})
								.catch(error => {
									console.error('Error during fetch operation:', error);
									console.error('Server response:', error.response); // Check if there's a response object
								});
						console.log("reply_insert end");
						return false;
					}

					// function reply_check() {
					// 	var frm = document.reply;
					// 	if (frm.reply_writer.value == "" || frm.reply_content.value == ""
					// 		|| frm.reply_pwd.value == "") {
					// 				alert("리플 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
					// 		return false;
					// 	}
					// frm.submit();
					// }
					// function reply_check() {
					// 	var frm = document.reply;
					//
					// 	if (frm.reply_writer.value == "" || frm.reply_content.value == "" || frm.reply_pwd.value == "") {
					// 		alert("리플 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
					// 		return false;
					// 	}
					//
					// 	// Assuming you have an endpoint to handle the form submission
					// 	var endpoint = 'replyWrite.do';
					//
					// 	// Create a FormData object to send the form data
					// 	var formData = new FormData(frm);
					//
					// 	// Make a POST request using the fetch API
					// 	fetch(endpoint, {
					// 		method: 'POST',
					// 		body: formData
					// 	})
					// 			.then(response => {
					// 				if (!response.ok) {
					// 					throw new Error('Network response was not ok');
					// 				}
					// 				return response.json(); // Assuming the server returns a JSON response
					// 			})
					// 			.then(data => {
					// 				// Handle the response data if needed
					// 				console.log(data);
					//
					// 			})
					// 			.catch(error => {
					// 				console.error('There was a problem with the fetch operation:', error);
					// 			});
					//
					// 	return false; // Prevent the form from submitting the traditional way
					// }
					function reply_check() {
						console.log("reply_check start");
						var frm = document.reply;

						if (frm.reply_writer.value == "" || frm.reply_content.value == "" || frm.reply_pwd.value == "") {
							alert("리플 내용, 작성자, 비밀번호를 모두 입력해야합니다.");
							return false;
						}

						// Assuming you have an endpoint to handle the form submission
						var endpoint = '/WriteReplyServlet';

						// Create a FormData object to send the form data
						var formData = new FormData(frm);

						// Make a POST request using the fetch API
						fetch(endpoint, {
							method: 'POST',
							body: formData
						})
								.then(response => {
									if (!response.ok) {
										throw new Error('Network response was not ok');
									}
									return response.json(); // Assuming the server returns a JSON response
								})
								.then(data => {
									// Handle the response data and update the DOM
									console.log(data)
									updateReplyList(data);
								})
								.catch(error => {
									console.error('Error during fetch operation:', error);
									console.error('Server response:', error.response); // Check if there's a response object
								});
						console.log("reply_check end");
						return false; // Prevent the form from submitting the traditional way
					}

					function updateReplyList(replyList) {
						var replyContainer = document.getElementById('replyContainer');
						var tableHtml = '<table width="80%" border="1"><tr><th colspan="2">REPLY LIST</th></tr>';

						replyList.forEach(function(reply) {
							tableHtml += '<tr align="left"><td width="80%">';
							tableHtml += '[' + reply.writer + '] : ' + reply.content + '<br> 작성일:' + reply.writedate;
							tableHtml += '</td><td width="20%"><form action="replyDelete.do" method="POST" name="replyDel">';
							tableHtml += '<input type="hidden" name="no" value="' + reply.no + '">';
							tableHtml += '<input type="hidden" name="idx" value="' + reply.idx_fk + '">';
							tableHtml += 'password :<input type="password" name="delPwd" size="4">';
							tableHtml += '<input type="button" value="삭제" onclick="reply_del(this.form)"></form></td></tr>';
						});

						tableHtml += '</table>';

						// Update the content of the replyContainer
						replyContainer.innerHTML = tableHtml;
					}


					function reply_del(frm) {
						//alert("del");
						//var frm = document.replyDel;
						//alert(frm);
						if (frm.delPwd.value == "") {
							alert("비밀번호를 입력하세요");
							frm.delPwd.focus();
							return false;
						}
						frm.submit();
					}
				</script>-->
				<br>

				<!-- 꼬리글 목록 테이블 -->
<%--				<div id="dynamicComments">--%>

<%--				</div>--%>

				<c:if test="${not empty replylist}">
					<table width="80%" border="1" id="commentsTable">
						<tr>
							<th colspan="2">REPLY LIST</th>
						</tr>
<%--						<c:forEach var="reply" items="${replylist}">--%>
<%--							<tr align="left">--%>
<%--								<td width="80%">--%>
<%--									[${reply.writer}] : ${reply.content}--%>
<%--									<br> 작성일:${reply.writedate}--%>
<%--								</td>--%>
<%--								<td width="20%">--%>
<%--									<form action="replyDelete.do" method="POST" name="replyDel">--%>
<%--										<input type="hidden" name="no" value="${reply.no}">--%>
<%--										<input type="hidden" name="idx" value="${reply.idx_fk}">--%>
<%--										password :<input type="password" name="delPwd" size="4">--%>
<%--										<input type="button" value="삭제" onclick="reply_del(this.form)">--%>
<%--									</form>--%>
<%--								</td>--%>
<%--							</tr>--%>
<%--						</c:forEach>--%>
					</table>
				</c:if>
			</center>
		</div>
	</div>
</body>
</html>





