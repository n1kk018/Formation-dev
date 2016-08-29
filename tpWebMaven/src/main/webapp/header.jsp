<%@page import="java.text.DateFormat"%>
<%@ page import="java.util.Date"%> 
<% 
	DateFormat dt = DateFormat.getDateInstance(DateFormat.FULL);
%>
<p><%=dt.format(new Date())%></p>
