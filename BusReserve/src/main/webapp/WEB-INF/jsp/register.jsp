<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <link rel="stylesheet" href="css/registerr.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>バス</title>
</head>
<body>
<form action="http://localhost:8080/bus/bin"action="http://localhost:8080/bus/seet" method="POST">
<p>日付</p>
<input type="date" name="date">
<br>
<p>場所</p>
	<select name="place" size="1" >
        <option value="0" label="鹿児島～博多">鹿児島～博多</option>
        <option value="1" label="博多～鹿児島">博多～鹿児島</option>
    </select>
    <br>
<p>人数</p>
<input name="HC">
        
<br>
        <input type="submit" value="確認" id="btn">
        
</form>
</body>
</html>