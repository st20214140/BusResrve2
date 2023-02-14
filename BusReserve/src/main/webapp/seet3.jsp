<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int[][] seetFlag = new int[10][4];
	String[] state = {"○", "×"};
	char[] charmap = {'A', 'B', 'C', 'D'};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1</title>
</head>
<body>
	<table border="10">
	<tr>
	<th>　</th>
	<th>A</th>
	<th>B</th>
	<th>C</th>
	<th>D</th>
	</tr>
	
	<% for(int i = 0; i < seetFlag.length; i++) { %>
		<tr>
		<th><%= i + 1 %></th>
		<% for(int j = 0; j < seetFlag[i].length; j++) { %>
			<%if(state[seetFlag[i][j]]=="○"){%>
			<input class="hiddenValue" type="hidden" value=<%=state[seetFlag[i][j]]%> >
			
			<%System.out.println(seetFlag[i][j]); %>
			<td><button name="<%=charmap[j] %><%= i + 1 %>" value="<%=state[seetFlag[i][j]] %>" type="submit" class="button"></button></td>
			<%}else if(state[seetFlag[i][j]]=="×"){%>
			<input class="hiddenValue" type="hidden" value=<%=state[seetFlag[i][j]]%> >
			<td><button name="<%=charmap[j] %><%= i + 1 %>" value="<%=state[seetFlag[i][j]] %>" type="submit" class="button"></button></td>
			<%} %>
			
		<% } %>
		</tr>
	<% } %>
	

	</table>
	
	<script type="text/javascript">
	const buttonState = true;
	const button = document.querySelector("#button");
	const buttons = document.querySelectorAll(".button");
	console.log("value: ", buttons.length);
	for(let i = 0; i < buttons.length; i++) {
		console.log(buttons[i].value);
		buttons[i].innerHTML = buttons[i].value;
		buttons[i].addEventListener("click", function(e) {
			console.log(e.target.value);
			if(e.target.value === "○") {
				buttons[i].value = "×";
				buttons[i].innerHTML = "×";
			}else if(e.target.value === "×") {
				buttons[i].value = "○";
				buttons[i].innerHTML = "○";
			}
		})
	}
	console.log(button);
	if(buttonState) {
		button.innerHTML = "○"
	}else {
		button.innerHTML = "×"
	}
	const handleClick = (e) => {
		e.preventDefault();
		console.log(e.target.value);
		buttonState = !buttonState;
		if(buttonState) {
			button.innerHTML = "○"
		}else {
			button.innerHTML = "×"
		}
	}
</script>

<form actio="SeatCheckServlet" method="POST">
<input type="hidden"  name="seatId" value="<%=charmap[j] %><%= i + 1 %>" >
<input type="hidden"  name="flightNumber" value="<%=charmap[j] %><%= i + 1 %>" >
<input type="hidden"  name="userId" value="<%=charmap[j] %><%= i + 1 %>" >
<input type="hidden"  name="priceId" value="<%=charmap[j] %><%= i + 1 %>" >
<button>確認</button>
</form>
	
	
</body>
</html>