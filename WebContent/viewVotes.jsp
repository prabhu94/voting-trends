<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@page import="com.votingtrends.*,com.votingtrends.model.*,java.util.*,com.votingtrends.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<h1>Vote Count Table</h1>  
  
<%  
List<Vote> list=DbOperationUtil.displayVotes();  
request.setAttribute("list",list);  
%>  
  
<table border="2" width="90%">  
<tr><th>Phone</th><th>Vote Count</th></tr>  
<c:forEach items="${list}" var="v">  
<tr><td>${v.getPhone()}</td>
<td>${v.getCount()}</td></tr>  
</c:forEach>  
</table>  
<br/><a href="index.jsp">Go Back</a>  

</body>  
</html>