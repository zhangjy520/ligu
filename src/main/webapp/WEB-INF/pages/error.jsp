<%@ include file="common/common.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="login">
<meta name="author" content="lexi">

<title>错误</title>
</head>
<body>

<h1>error:</h1> <br/>
<h3>
    ${sessionScope.error_handler_result_msg}
</h3>

</body>
</html>