<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="row">
    <div class="d-flex flex-column mx-lg-0 mx-auto">
        <div class="card mb-0">
            <div class="card-header pb-0 text-start">
                <h4 class="font-weight-bolder"><s:text name="login.title"/></h4>
                <p class="mb-0"><s:text name="login.instructions"/></p>
            </div>
            <div class="card-body pt-0">
                <s:form action="Autenticazione" method="post">
                	<div class="row">
	                    <div class="col-lg-6 mt-3">
	                        <s:textfield name="email" cssClass="form-control form-control-lg" placeholder="%{getText('login.email')}" required="true" />
	                    </div>
	                    <div class="col-lg-6 mt-3">
	                        <s:password name="password" cssClass="form-control form-control-lg" placeholder="%{getText('login.password')}" required="true" />
	                    </div>
                    </div>
                    <div class="col-lg-12 text-center">
                        <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('login.submit')}" />
                    </div>
                </s:form>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>
