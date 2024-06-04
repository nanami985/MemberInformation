<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>

    <form action="/MemberInformation/LoginAction" method="post">
        <p>ログイン名：<input type="text" name="userID" value="<%= (request.getAttribute("login") != null) ? request.getAttribute("login") : "" %>" required></p>
        <p>パスワード：<input type="password" name="password" required></p>
        <p><input type="submit" value="ログイン"></p>
    </form>
    
    <p><a href="Touroku.jsp">新規会員登録はこちら</a></p>
    
    <% 
        String error = (String)request.getAttribute("error");
        if(error != null) {
    %>
        <p style="color: red;"><%= error %></p>
    <% } %>

    <% 
        String registrationLink = (String)request.getAttribute("registrationLink");
        if(registrationLink != null) {
    %>
        <p><%= registrationLink %></p>
    <% } %>

</body>
</html>
