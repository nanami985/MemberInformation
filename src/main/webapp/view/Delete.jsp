<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報削除</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

<p><strong>会員情報削除</strong></p>

<form action="/MemberInformation/servlet/DeleteServlet" method="post">

	<ul>
		<li>■ユーザID<br><input type="text" name="userID" required></li><br>
		<li>■パスワード<br><input type="password" name="password" required></li><br>
		<li>■名前<br>
			姓<input type="text" name="last_name" required>
			名<input type="text" name="first_name" required></li><br>
	</ul>
	
	<div class="button-container">
		<input type="submit" value="削除">
		<input type="reset" value="リセット">
		<a href="login.jsp"><input type="button" value="戻る"></a>
	</div>
	
</form>

</body>
</html>
