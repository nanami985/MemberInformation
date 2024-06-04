<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>

<p><strong>会員情報登録</strong></p>


<form action="/MemberInformation/servlet/RegisterServlet" method="post">

	<ul>
		<li>■ユーザID<br><input type="text" name="userID" required></li><br>
		<li>■パスワード<br><input type="password" name="password" required></li><br>
		<li>■名前<br>
			姓<input type="text" name="last_name" required>
			名<input type="text" name="first_name" required></li><br>
		<li>■性別<br>
			<input type="radio" name="sex" value="男" required>男
			<input type="radio" name="sex" value="女" required>女</li><br>
		<li>■生年月日<br>
        	<input type="text" name="birth_year" required>年
        	<input type="text" name="birth_month" required>月
        	<input type="text" name="birth_day" required>日</li><br>
        <li>■電話番号<br><input type="text" name="phone_number" required></li><br>
        <li>■メールアドレス<br><input type="text" name="mail_address" required></li><br>
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
		<input type="submit" value="登録">
		<input type="reset" value="リセット">
		<a href=login.jsp><input type="button" value="戻る"></a>
	</div>
	
</form>

</body>
</html>

