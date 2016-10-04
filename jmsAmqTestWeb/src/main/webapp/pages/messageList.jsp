<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>messageList.jsp</title>
</head>
<body>
<f:view>
	<h3>liste des messages jms recus dans la file queue.A </h3>
	<h:form id="refreshForm">
	     <h:commandButton value="refresh" 
	                     action="#{msgMbean.refreshReceivedMessageList}"/>
	</h:form>	
	 <h:dataTable var="msg" border="2" value="#{msgMbean.listeJmsReceivedMessages}">
	   <h:column>
	     <f:facet name="header"><f:verbatim>texte du message</f:verbatim></f:facet>
	     <h:outputText  value="#{msg.text}"/>
	   </h:column>
	    <h:column>
	     <f:facet name="header"><f:verbatim>date et heure de la reception</f:verbatim></f:facet>
	     <h:outputText  value="#{msg.date}"/>
	   </h:column>
	  </h:dataTable>
	  <hr/>	  
	  <h:form id="responseForm">
	     message de reponse: <br/>
	     <h:inputTextarea  value="#{msgMbean.responseMessageText}" cols="48" rows="8">
	     </h:inputTextarea><br/>
	     <h:commandButton value="send response" 
	                     action="#{msgMbean.sendResponse}"/> (in queue.B) . <br/>
         statut: <h:outputText value="#{msgMbean.status}" /> <br/>	                     
         modele de message (pour copier/coller):<br/>
          <h:inputTextarea cols="48" rows="8" ></h:inputTextarea>	                     
	  </h:form>
</f:view>
</body>
</html>