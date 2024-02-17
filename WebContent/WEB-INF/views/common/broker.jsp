<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- login.jsp에서 모든 동작에 대한 완료 표시를 또 안적게끔 -->
<script type="text/javascript">
	//컨트롤러에서 보낸 메세지가 있을 경우
	window.onload = function(e){
		var resultMsg = '${resultMsg}';
		var resultCode = '${resultCode}';
		if(resultMsg.length > 0){
			alert(resultMsg);
		}
		if(resultCode == 'OK'){
			window.location.href= '<c:url value="${nextUrl}"/>';
		}
	}
</script>
<body>

</body>
</html>