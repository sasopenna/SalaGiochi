<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="repairs.title.new"/></h4>
        <p class="mb-0"><s:text name="repairs.instructions.new"/></p>
    </div>
    <div class="card-body">
        <s:form action="Crea" method="post" role="form">
            <div class="mb-3">    
                <s:text name="repairs.technician"/>
                <s:fielderror fieldName="ripara.tecnico.idDipendente" />
                <s:hidden name="ripara.tecnico.idDipendente" required="true" readonly="true" />
                <s:textfield value="%{'('+ripara.tecnico.idDipendente+') ' + ripara.tecnico.profilo.nome + ' ' + ripara.tecnico.profilo.cognome}" cssClass="form-control form-control-lg" required="true" readonly="true" />
            </div>
            <div class="mb-3">
                <s:text name="repairs.device"/>
                <s:fielderror fieldName="ripara.dispositivoDiGioco.id" />
                <s:select name="ripara.dispositivoDiGioco.id" list="dispositivi" listKey="id" listValue="'(' + id + ') ' + tipo" cssClass="form-control form-control-lg" required="true" />
            </div>
            <div class="mb-3">
                <s:text name="repairs.repairCost"/> <i class="opacity-3">(Ex: 50,00)</i>
                <s:fielderror fieldName="ripara.costoRiparazione" />
                <s:textfield name="ripara.costoRiparazione" placeholder="%{getText('repairs.repairCost')}" cssClass="form-control form-control-lg" required="true" />
            </div>
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('repairs.insert')}"/>
            </div>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>