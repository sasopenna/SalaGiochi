<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="managers.title.new"/></h4>
        <p class="mb-0"><s:text name="managers.instructions.new"/></p>
    </div>
    <div class="card-body">
        <s:form action="Crea" method="post" role="form">
            
            <div class="row">
                <div class="col-lg-5">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="managers.information"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="managers.firstname"/> 
                            <s:fielderror fieldName="dirigente.profilo.nome" />
                            <s:textfield name="dirigente.profilo.nome" placeholder="%{getText('managers.firstname')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-6 mb-3">
                            <s:text name="managers.lastname"/> 
                            <s:fielderror fieldName="dirigente.profilo.cognome" />
                            <s:textfield name="dirigente.profilo.cognome" placeholder="%{getText('managers.lastname')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="managers.gender"/> 
                            <s:fielderror fieldName="dirigente.profilo.sesso" />
                            <s:select name="dirigente.profilo.sesso" list="{'Uomo','Donna'}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="managers.birthdate"/> <i class="opacity-3">(gg/mm/aa)</i>
                            <s:fielderror fieldName="dirigente.profilo.dataDiNascita" />
                            <s:textfield name="dirigente.profilo.dataDiNascita" placeholder="%{getText('managers.birthdate')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <s:text name="managers.cf"/> 
                            <s:fielderror fieldName="dirigente.profilo.codiceFiscale" />
                            <s:textfield name="dirigente.profilo.codiceFiscale" placeholder="%{getText('managers.cf')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="managers.contacts"/></span>
                    <div class="col-lg-12 mt-3 mb-3">
                        <s:text name="managers.phone"/> 
                        <s:fielderror fieldName="dirigente.profilo.telefono" />
                        <s:textfield name="dirigente.profilo.telefono" type="number" placeholder="%{getText('managers.phone')}" cssClass="form-control form-control-lg" required="true" />
                    </div>
                    <div class="col-lg-12 mb-3">
                        <s:text name="managers.email"/> 
                        <s:fielderror fieldName="dirigente.profilo.email" />
                        <s:textfield name="dirigente.profilo.email" placeholder="%{getText('managers.email')}" cssClass="form-control form-control-lg" required="true" />
                    </div>
                </div>
                <div class="col-lg-4 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="managers.residence"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="managers.street"/> 
                            <s:fielderror fieldName="dirigente.profilo.via" />
                            <s:textfield name="dirigente.profilo.via" placeholder="%{getText('managers.street')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-6 mb-3">
                            <s:text name="managers.street_number"/> 
                            <s:fielderror fieldName="dirigente.profilo.numeroCivico" />
                            <s:textfield name="dirigente.profilo.numeroCivico" type="number" placeholder="%{getText('managers.street_number')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="managers.city"/> 
                            <s:fielderror fieldName="dirigente.profilo.citta" />
                            <s:textfield name="dirigente.profilo.citta" placeholder="%{getText('managers.city')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="managers.cap"/> 
                            <s:fielderror fieldName="dirigente.profilo.cap" />
                            <s:textfield name="dirigente.profilo.cap" type="number" placeholder="%{getText('managers.cap')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
			    <div class="col-lg-5">
			        <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="managers.management"/></span>
			        <div class="row mb-3 mt-3">
			            <div class="col-lg-12 mb-3">
			                <s:text name="managers.salary"/> 
			                <s:fielderror fieldName="dirigente.salario" /> <i class="opacity-3">(Ex: 1500,00)</i>
			                <s:textfield name="dirigente.salario" type="text" placeholder="%{getText('managers.salary')}" cssClass="form-control form-control-lg" required="true" />
			            </div>
			            <div class="col-lg-6 mb-3">
			                <s:text name="managers.period"/> 
			                <s:fielderror fieldName="dirigente.periodo" />
			                <s:textfield name="dirigente.periodo" type="number" placeholder="%{getText('managers.period')}" cssClass="form-control form-control-lg" required="true" />
			            </div>
			            <div class="col-lg-6 mb-3">
			                <s:text name="managers.experience"/> 
			                <s:fielderror fieldName="dirigente.esperienza" />
			                <s:textfield name="dirigente.esperienza" type="number" placeholder="%{getText('managers.experience')}" cssClass="form-control form-control-lg" required="true" />
			            </div>
			        </div>
			    </div>
			    <div class="col-lg-3 bl-table">
			        <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="managers.gameroom"/></span>
			        <div class="form-check">
						<s:checkboxlist cssClass="form-check-input" name="salegiochi" list="sale" listKey="codice" listValue="nome" value="dirigente.sale.{codice}" />
			        </div>
			    </div>
			    <div class="col-lg-4 bl-table">
			        <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="managers.shift"/></span>
			        <div class="row mt-3">
			            <div class="col-lg-6 mb-3">
			                <s:text name="managers.start"/> 
			                <s:fielderror fieldName="dirigente.inizioTurno" />
			                <s:textfield name="dirigente.inizioTurno" type="time" placeholder="%{getText('managers.start')}" cssClass="form-control form-control-lg" required="true" />
			            </div>
			            <div class="col-lg-6 mb-3">
			                <s:text name="managers.end"/> 
			                <s:fielderror fieldName="dirigente.fineTurno" />
			                <s:textfield name="dirigente.fineTurno" type="time" placeholder="%{getText('managers.end')}" cssClass="form-control form-control-lg" required="true" />
			            </div>
			        </div>
			    </div>
			</div>
			<div class="text-center">
			    <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('managers.insert')}"/>
			</div>
		</s:form>
	</div>
</div>
<script>
    document.querySelectorAll("label").forEach(label => {
        const br = document.createElement("br");
        label.parentNode.insertBefore(br, label.nextSibling);
    });
</script>
<%@ include file="/WEB-INF/footer.jsp"%>