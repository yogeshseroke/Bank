<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BankSer" method="post">
<table>
<tr>
<th>branch id</th>
<th>customer name</th>
<th>customer id</th>
<th>customer account number</th>
</tr>
<tr>
<td><input type="number" name="txtbid" placeholder="Enter branch id" /></td>
<td><input type="text" name="txtcn" placeholder="Enter customer name" /></td>
<td><input type="number" name="txtcid" placeholder="Enter customerid" /></td>
<td><input type="number" name="txtca" placeholder="Enter customer account number" /></td>
</tr>
</table>
<br><br>
<input type="submit" name="btnsubmit" value="submit" />
</form>
<% 
if(request.getParameter("q")!=null)
{
    response.sendRedirect("Bank.jsp?q=");	
}
%>
</body>
</html>