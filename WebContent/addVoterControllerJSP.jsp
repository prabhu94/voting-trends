<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@page import="com.votingtrends.util.DbOperationUtil"%>  
<jsp:useBean id="vote" class="com.votingtrends.model.Vote"></jsp:useBean>  
<jsp:setProperty property="*" name="vote"/>  
<%  
int i = DbOperationUtil.insertVote(vote);  
if(i>0){  
response.sendRedirect("addVote.jsp");  
}else{  
response.sendRedirect("error.jsp");  
}  
%>  
</head>
<body>

</body>
</html>