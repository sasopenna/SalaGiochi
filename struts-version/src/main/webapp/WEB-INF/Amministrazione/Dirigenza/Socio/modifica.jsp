<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>

<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="members.title.mod"/></h4>
        <p class="mb-0"><s:text name="members.instructions.mod"/></p>
    </div>
    <div class="card-body">
        <s:form action="Aggiorna" method="post" role="form">
            <div class="mb-3">
                <h5 class="font-weight-bolder">
                    <s:text name="members.member"/>
                    <span class="badge badge-sm bg-gradient-info badge-padding">
                        <span class="text-uppercase text-white text-md font-weight-bolder"><s:property value="socio.numeroCliente"/></span>
                    </span>
                </h5>
                <s:fielderror fieldName="socio.numeroCliente" />
                <s:hidden name="socio.numeroCliente" cssClass="form-control form-control-lg" required="true" />
            </div>
            
            <div class="row">
                <div class="col-lg-5">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="members.personal_info"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="members.first_name"/> 
                            <s:fielderror fieldName="socio.profilo.nome" />
                            <s:textfield name="socio.profilo.nome" placeholder="%{getText('members.first_name')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-6 mb-3">
                            <s:text name="members.last_name"/> 
                            <s:fielderror fieldName="socio.profilo.cognome" />
                            <s:textfield name="socio.profilo.cognome" placeholder="%{getText('members.last_name')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="members.gender"/>
                            <s:fielderror fieldName="socio.profilo.sesso" />
                            <s:select name="socio.profilo.sesso" list="{'Uomo','Donna'}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="members.birthdate"/> 
                            <s:fielderror fieldName="socio.profilo.dataDiNascita" /> <i class="opacity-3">(gg/mm/aa)</i>
                            <s:textfield name="socio.profilo.dataDiNascita" placeholder="%{getText('members.birthdate')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12 mb-3">
                            <s:text name="members.taxcode"/> 
                            <s:fielderror fieldName="socio.profilo.codiceFiscale" />
                            <s:textfield name="socio.profilo.codiceFiscale" placeholder="%{getText('members.taxcode')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-4 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="members.contacts"/></span>
                    <div class="col-lg-12 mt-3 mb-3">
                        <s:text name="members.phone"/>
                        <s:fielderror fieldName="socio.profilo.telefono" />
                        <s:textfield name="socio.profilo.telefono" type="number" placeholder="%{getText('members.phone')}" cssClass="form-control form-control-lg" required="true" />
                    </div>
                    <div class="col-lg-12 mb-3">
                        <s:text name="members.e-mail"/>
                        <s:fielderror fieldName="socio.profilo.email" />
                        <s:textfield name="socio.profilo.email" placeholder="%{getText('members.e-mail')}" cssClass="form-control form-control-lg" required="true" readonly="true" />
                    </div>
                </div>
                
                <div class="col-lg-3 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="members.statistics"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-12 mb-3">
                            <s:text name="members.points"/>
                            <s:fielderror fieldName="socio.punteggio" />
                            <s:textfield name="socio.punteggio" type="number" placeholder="%{getText('members.points')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-12 mb-3">
                            <s:text name="members.joined"/>
                            <s:fielderror fieldName="socio.membroDal" /> <i class="opacity-3">(gg/mm/aa)</i>
                            <s:textfield name="socio.membroDal" placeholder="%{getText('members.joined')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
            </div>

			<div class="row">
                <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="members.residence"/></span>
				<div class="col-lg-3 mb-3">
					<s:text name="members.street" />
					<s:fielderror fieldName="socio.profilo.via" />
					<s:textfield name="socio.profilo.via" placeholder="%{getText('members.street')}" cssClass="form-control form-control-lg" required="true" />
				</div>

				<div class="col-lg-3 mb-3">
					<s:text name="members.street_number" />
					<s:fielderror fieldName="socio.profilo.numeroCivico" />
					<s:textfield name="socio.profilo.numeroCivico" type="number" placeholder="%{getText('members.street_number')}" cssClass="form-control form-control-lg" required="true" />
				</div>
				<div class="col-lg-3 mb-3">
					<s:text name="members.city" />
					<s:fielderror fieldName="socio.profilo.citta" />
					<s:textfield name="socio.profilo.citta" placeholder="%{getText('members.city')}" cssClass="form-control form-control-lg" required="true" />
				</div>
				<div class="col-lg-3 mb-3">
					<s:text name="members.cap" />
					<s:fielderror fieldName="socio.profilo.cap" />
					<s:textfield name="socio.profilo.cap" type="number" placeholder="%{getText('members.cap')}" cssClass="form-control form-control-lg" required="true" />
				</div>
			</div>
            
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('members.update')}"/>
            </div>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>