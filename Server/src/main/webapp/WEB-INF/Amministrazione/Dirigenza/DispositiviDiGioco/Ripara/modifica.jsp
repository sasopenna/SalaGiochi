<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="repairs.title.mod"/></h4>
        <p class="mb-0"><s:text name="repairs.instructions.mod"/></p>
    </div>
    <div class="card-body">
        <s:form action="Aggiorna" method="post" role="form">
            <div class="mb-3">
                <h5 class="font-weight-bolder">
                    <s:text name="repairs.repair"/>
                    <span class="badge badge-sm bg-gradient-info badge-padding">
                        <span class="text-uppercase text-white text-md font-weight-bolder"><s:property value="ripara.progressivo"/></span>
                    </span>
                </h5>
                <s:fielderror fieldName="ripara.progressivo" />
                <s:hidden name="ripara.progressivo" cssClass="form-control form-control-lg" required="true" />
            </div>

            <div class="mb-3">    
                <s:text name="repairs.technician"/>
                <s:fielderror fieldName="ripara.tecnico.idDipendente" />
                <s:select name="ripara.tecnico.idDipendente" list="tecnici" listKey="idDipendente" listValue="'(' + idDipendente + ') ' + profilo.nome + ' ' + profilo.cognome" cssClass="form-control form-control-lg" required="true" />
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
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('repairs.update')}"/>
            </div>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>