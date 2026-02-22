<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<meta http-equiv="refresh" content="3;url=<s:url action='Pannello' namespace='/Amministrazione' />"/>
<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card p-4 align-center">
	<s:text name="please_wait" />
	<a href="<s:url action='Pannello' namespace='/Amministrazione' />"><s:text name="click_here" /></a>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>