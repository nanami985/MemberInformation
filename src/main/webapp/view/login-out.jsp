<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功</title>
</head>
<body>

    <p>こんにちは、<c:out value="${customer.getUserId()}"/>さん。</p>
    
	<p><a href="${pageContext.request.contextPath}/view/Update.jsp">登録内容の変更はこちら</a></p>
	<p><a href="${pageContext.request.contextPath}/view/Delete.jsp">登録内容の削除はこちら</a></p>
    
    <form action="${pageContext.request.contextPath}/LogoutAction" method="post">
        <input type="submit" value="ログアウト">
    </form>

</body>
</html>
