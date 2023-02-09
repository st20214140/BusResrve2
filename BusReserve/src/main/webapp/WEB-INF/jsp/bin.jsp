<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String place = (String)session.getAttribute("place");
    String HC = (String)session.getAttribute("HC");
    String date = (String)session.getAttribute("date");
    System.out.println(date);
    String Place = "";
    int air = 10;
    String Time = "0";
    
    
    if(place=="0"){
    	Place="鹿児島～博多";
    }else{
    	Place="博多～鹿児島";
    }
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bin.css">
<meta charset="UTF-8">
<title>予約日程</title>
</head>
<body>

	<h3>予約便</h3>
	<h3>場所 [<%=Place%>]</h3>
	<h3>人数　<%=HC%></h3>
	<h3>日付<%=date%></h3>
	
	<form action="http://localhost:8080/BusReserve/seet" method="POST">
	<h4 >1便</h4>
	<dv class="info info1" name="Time" value="06:00~10:00"><h4>06:00~10:00</h4>
	<a>空席：<%=40-air %></a>
	<c:set var="message" value="Hello">
	<input type="submit"value="確認">
	</dv>
	</form>
	
	<form action="http://localhost:8080/BusReserve/seet" method="POST">
	<h4>2便</h4>
	<dv class="info2"  value="10:00~14:00"><h4>10:00~14:00</h4>
	<a>空席：<%=40-air %></a>
	<%Time="10:00~14:00"; %>
	<input type="submit" value="確認">
	</dv>
	</form>
	
	<form action="http://localhost:8080/BusReserve/seet" method="POST">
	<h4>3便</h4>
	<dv class="info3" value="14:00~18:00"><h4>14:00~18:00</h4>
	<a>空席：<%=40-air %></a>
	<%Time="14:00~18:00"; %>
	<input type="submit" value="確認">
	</dv>
	</form>
	
	<form action="http://localhost:8080/BusReserve/seet" method="POST">
	<h4>4便</h4>
	<dv class="info4" value="18:00~22:00"><h4>18:00~22:00</h4>
	<a>空席：<%=40-air %></a>
	<%Time="18:00~22:00"; %>
	<input type="submit" value="確認">
	</dv>
	</form>
	
	<form action="http://localhost:8080/BusReserve/seet" method="POST">
	<h4>5便</h4>
	<dv class="info5" value="22:00~02:00"><h4>22:00~02:00</h4>
	<a>空席：<%=40-air %></a>
	<%Time="22:00~02:00"; %>
	<input type="submit" value="確認">
	</dv>
	</form>
</body>
</html>