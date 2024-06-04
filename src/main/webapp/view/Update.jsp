<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報変更</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

<p><strong>会員情報変更</strong></p>

<form action="<%= request.getContextPath() %>/servlet/UpdateServlet" method="post">

	<ul>
		<li>■ユーザID<br><input type="text" name="userID"></li><br>
		<li>■パスワード<br><input type="password" name="password"></li><br>
		<li>■名前<br>
			姓<input type="text" name="last_name">
			名<input type="text" name="first_name"></li><br>
		<li>■性別<br>
			<input type="radio" name="sex" value="男">男
			<input type="radio" name="sex" value="女">女</li><br>
		<li>■生年月日<br>
        	<input type="text" name="birth_year">年
        	<input type="text" name="birth_month">月
        	<input type="text" name="birth_day">日</li><br>
        <li>■電話番号<br><input type="text" name="phone_number"></li><br>
        <li>■メールアドレス<br><input type="text" name="mail_address"></li><br>
        <li>■職業<br>
            <select name="job">
            	<option></option>
                <option value="会社員">会社員</option>
                <option value="自営業">自営業</option>
                <option value="学生">学生</option>
                <option value="その他">その他</option>
            </select></li><br>
	</ul>
	
	<div class="button-container">
		<input type="submit" value="変更">
		<input type="reset" value="リセット">
		<a href="<%= request.getContextPath() %>/view/login.jsp"><input type="button" value="戻る"></a>
	</div>
	
</form>

</body>
</html>
