<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>

<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="requests.title.new"/></h4>
        <p class="mb-0"><s:text name="requests.instructions.new"/></p>
    </div>
    <div class="card-body">
        <s:form action="Crea" method="post" role="form">
            <div class="mb-3">    
                <s:text name="requests.client"/>
                <s:fielderror fieldName="richiesta.cliente.numeroCliente"/>
                <s:select name="richiesta.cliente.numeroCliente" list="clienti" listKey="numeroCliente" listValue="'['+numeroCliente+'] '+(socio?(socio.profilo.nome+' '+socio.profilo.cognome):'')" cssClass="form-control form-control-lg" required="true"/>
            </div>
            <div class="mb-3">
                <s:text name="requests.station"/>
                <s:fielderror fieldName="richiesta.postazione.numero"/>
                <s:select name="richiesta.postazione.numero" list="postazioni" listKey="numero" listValue="'['+numero+'] '+salaGiochi.nome+' (Stanza '+id.stanza+' | Posto '+id.posto+')'" cssClass="form-control form-control-lg" required="true"/>
            </div>
            <div class="mb-3">
                <s:text name="requests.duration"/>
                <s:fielderror fieldName="richiesta.durata"/>
                <s:textfield name="richiesta.durata" placeholder="%{getText('requests.duration')}" type="time" cssClass="form-control form-control-lg" required="true"/>
            </div>
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('requests.insert')}"/>
            </div>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>
