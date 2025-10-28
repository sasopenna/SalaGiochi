<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="action.error"/></h4>
        <p class="mb-0 font-weight-bold"><s:property value="exception" /></p>
    </div>
	<div class="card-body">
		<s:property value="exceptionStack" />
	</div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>