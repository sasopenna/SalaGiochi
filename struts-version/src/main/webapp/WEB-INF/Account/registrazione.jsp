<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="row">
    <div class="d-flex flex-column mx-lg-0 mx-auto">
        <div class="card">
            <div class="card-header pb-0 text-start">
                <h4 class="font-weight-bolder"><s:text name="register.title"/></h4>
                <p class="mb-0"><s:text name="register.instructions"/></p>
            </div>
            <div class="card-body">
                <s:form action="Registra" method="post">
					<span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="register.data" /></span>
                	<div class="row">
	                	<div class="col-lg-6 mb-3">
                            <s:fielderror fieldName="profilo.nome" />
	                        <s:textfield name="profilo.nome" cssClass="form-control form-control-lg" placeholder="%{getText('register.name')}" required="true" />
	                    </div>
	                    <div class="col-lg-6 mb-3">
                            <s:fielderror fieldName="profilo.cognome" />
	                        <s:textfield name="profilo.cognome" cssClass="form-control form-control-lg" placeholder="%{getText('register.surname')}" required="true" />
	                    </div>
                	</div>
                    
                	<div class="row">
	                    <div class="col-lg-6 mb-3">
                            <s:fielderror fieldName="profilo.sesso" />
	                        <s:select name="profilo.sesso" cssClass="form-control form-control-lg" list="{'Uomo','Donna'}" required="true" />
	                    </div>
	                    <div class="col-lg-6 mb-3">
                            <s:fielderror fieldName="profilo.dataDiNascita" />
	                        <s:textfield name="profilo.dataDiNascita" cssClass="form-control form-control-lg" placeholder="%{getText('register.birthdate')}" required="true" />
	                    </div>
	                	<div class="col-lg-12 mb-3">
                            <s:fielderror fieldName="profilo.codiceFiscale" />
	                        <s:textfield name="profilo.codiceFiscale" cssClass="form-control form-control-lg" placeholder="%{getText('register.cf')}" required="true" />
	                    </div>
                    </div>
                    
					<span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="register.contacts" /></span>
                	<div class="row">
	                    <div class="col-lg-6 mb-3">
	                    	<div class="row">
		                    	<div class="col-lg-6 mb-3">
		                            <s:fielderror fieldName="profilo.via" />
			                        <s:textfield name="profilo.via" cssClass="form-control form-control-lg" placeholder="%{getText('register.via')}" required="true" />
			                    </div>
			                    <div class="col-lg-6 mb-3">
		                            <s:fielderror fieldName="profilo.numeroCivico" />
			                        <s:textfield name="profilo.numeroCivico" cssClass="form-control form-control-lg" placeholder="%{getText('register.nr')}" required="true" />
			                    </div>
			                    <div class="col-lg-6 mb-3">
		                            <s:fielderror fieldName="profilo.citta" />
			                        <s:textfield name="profilo.citta" cssClass="form-control form-control-lg" placeholder="%{getText('register.citta')}" required="true" />
			                    </div>
			                    <div class="col-lg-6 mb-3">
		                            <s:fielderror fieldName="profilo.cap" />
			                        <s:textfield name="profilo.cap" type="number" cssClass="form-control form-control-lg" placeholder="%{getText('register.cap')}" required="true" />
			                    </div>
	                    	</div>
		                </div>
	                    <div class="col-lg-6 mb-3">
	                    	<div class="row">
		                    	 <div class="col-lg-12 mb-3">
	                            	<s:fielderror fieldName="profilo.telefono" />
		                        	<s:textfield name="profilo.telefono" cssClass="form-control form-control-lg" placeholder="%{getText('register.cellphone')}" required="true" />
		                    	 </div>
			                     <div class="col-lg-12 mb-3">
		                            <s:fielderror fieldName="profilo.email" />
			                        <s:textfield name="profilo.email" cssClass="form-control form-control-lg" placeholder="%{getText('register.email')}" required="true" />
		                    	</div>
	                    	</div>
	                    </div>
                    </div>
                    
					<span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="register.password" /></span>
                	<div class="row">
	                    <div class="col-lg-6 mb-3">
                            <s:fielderror fieldName="password" />
	                        <s:password name="password" cssClass="form-control form-control-lg" placeholder="%{getText('register.password')}" required="true" />
	                    </div>
	                    <div class="col-lg-6 mb-3">
                            <s:fielderror fieldName="confirm_password" />
	                        <s:password name="confirm_password" cssClass="form-control form-control-lg" placeholder="%{getText('register.confirm_password')}" required="true" />
	                    </div>
                    </div>
                    
                    <div class="text-center">
                        <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('register.submit')}" />
                    </div>
                </s:form>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>
