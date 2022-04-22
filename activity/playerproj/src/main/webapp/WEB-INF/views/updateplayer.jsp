<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update-player" method="post">
<input type="hidden" name="pid" value="${player.playernumber }"><br>
player name:<input type="text" name="pname" value="${player.playernname}"><br><br>
Skill:<select name="skill">
<option value="Batsman">Bats man</option>
<option value="Bowler">Bowler</option>
<option value="All Rounder">All Rounder</option>
<option value="Wicket Keeper">Wicket Keeper</option>
</select><br><br>
Runs: <input type="number" name="runs" value="${player.runs }">
Team Id:<select name="teamid">
<option value="1">RCB</option>
<option value="2">CSK</option>
<option value="3">MI</option>
<option value="4">RR</option>
<option value="5">DC</option>
<option value="6">SRH</option>
</select><br><br>
<input type="submit" value="Register">
</form>
</body>
</html>