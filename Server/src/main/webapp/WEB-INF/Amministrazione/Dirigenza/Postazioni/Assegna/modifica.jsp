<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="assignments.title.mod"/></h4>
        <p class="mb-0"><s:text name="assignments.instructions.mod"/></p>
    </div>
    <div class="card-body">
        <s:form action="Aggiorna" method="post" role="form">
            <div class="mb-3">
                <h5 class="font-weight-bolder">
                    <s:text name="assignments.reservation"/>
                    <span class="badge badge-sm bg-gradient-info badge-padding">
                        <span class="text-uppercase text-white text-md font-weight-bolder"><s:property value="assegnazione.prenotazione"/></span>
                    </span>
                </h5>
                <s:fielderror fieldName="assegnazione.prenotazione" />
                <s:hidden name="assegnazione.prenotazione" cssClass="form-control form-control-lg" required="true" />
            </div>

			<div class="row mb-3">
			    <div class="col-lg-4">
		            <s:text name="assignments.cashier"/>
		            <s:fielderror fieldName="assegnazione.cassiere.idDipendente" />
		            <s:select name="assegnazione.cassiere.idDipendente" list="cassieri" listKey="idDipendente" listValue="'('+idDipendente+') ' + profilo.nome + ' ' + profilo.cognome" cssClass="form-control form-control-lg" required="true" />
			    </div>
			    <div class="col-lg-4">
		            <s:text name="assignments.schedule"/>
		            <s:fielderror fieldName="assegnazione.orario" />
		            <s:textfield name="assegnazione.orario" type="time" placeholder="%{getText('assignments.schedule')}" cssClass="form-control form-control-lg" required="true" />
			    </div>
			    <div class="col-lg-4">
		            <s:text name="assignments.cost"/>
		            <s:fielderror fieldName="assegnazione.costo" />
		            <s:textfield name="assegnazione.costo" placeholder="%{getText('assignments.cost')}" cssClass="form-control form-control-lg" required="true" />
			    </div>
			</div>

            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('assignments.update')}"/>
            </div>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>