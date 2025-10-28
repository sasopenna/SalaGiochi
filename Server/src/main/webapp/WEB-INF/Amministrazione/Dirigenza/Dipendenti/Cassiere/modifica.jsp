<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="cashiers.title.mod" /></h4>
        <p class="mb-0"><s:text name="cashiers.instructions.mod" /></p>
    </div>
    <div class="card-body">
        <s:form action="Aggiorna" method="post" role="form">
            <div class="mb-3">
                <h5 class="font-weight-bolder">
                    <s:text name="cashiers.cashier" />
                    <span class="badge badge-sm bg-gradient-info badge-padding">
                        <span class="text-uppercase text-white text-md font-weight-bolder"><s:property value="cassiere.idDipendente" /></span>
                    </span>
                </h5>
                <s:fielderror fieldName="cassiere.idDipendente" />
                <s:hidden name="cassiere.idDipendente" cssClass="form-control form-control-lg" required="true" />
            </div>

            <div class="row">
                <div class="col-lg-5">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="cashiers.personalData" /></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="cashiers.firstname" /> 
                            <s:fielderror fieldName="cassiere.profilo.nome" />
                            <s:textfield name="cassiere.profilo.nome" placeholder="%{getText('cashiers.firstname')}" cssClass="form-control form-control-lg" required="true" />
                        </div>

                        <div class="col-lg-6 mb-3">
                            <s:text name="cashiers.lastname" /> 
                            <s:fielderror fieldName="cassiere.profilo.cognome" />
                            <s:textfield name="cassiere.profilo.cognome" placeholder="%{getText('cashiers.lastname')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="cashiers.gender" /> 
                            <s:fielderror fieldName="cassiere.profilo.sesso" />
                            <s:select name="cassiere.profilo.sesso" list="{'Uomo','Donna'}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="cashiers.birthdate" /> <i class="opacity-3">(gg/mm/aa)</i>
                            <s:fielderror fieldName="cassiere.profilo.dataDiNascita" />
                            <s:textfield name="cassiere.profilo.dataDiNascita" placeholder="%{getText('cashiers.birthdate')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <s:text name="cashiers.cf" /> 
                            <s:fielderror fieldName="cassiere.profilo.codiceFiscale" />
                            <s:textfield name="cassiere.profilo.codiceFiscale" placeholder="%{getText('cashiers.cf')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="cashiers.contacts" /></span>
                    <div class="col-lg-12 mt-3 mb-3">
                        <s:text name="cashiers.phone" /> 
                        <s:fielderror fieldName="cassiere.profilo.telefono" />
                        <s:textfield name="cassiere.profilo.telefono" type="number" placeholder="%{getText('cashiers.phone')}" cssClass="form-control form-control-lg" required="true" />
                    </div>
                    <div class="col-lg-12 mb-3">
                        <s:text name="cashiers.e-mail" /> 
                        <s:fielderror fieldName="cassiere.profilo.email" />
                        <s:textfield name="cassiere.profilo.email" placeholder="%{getText('cashiers.e-mail')}" cssClass="form-control form-control-lg" required="true" readonly="true" />
                    </div>
                </div>
                <div class="col-lg-4 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="cashiers.address" /></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="cashiers.street" /> 
                            <s:fielderror fieldName="cassiere.profilo.via" />
                            <s:textfield name="cassiere.profilo.via" placeholder="%{getText('cashiers.street')}" cssClass="form-control form-control-lg" required="true" />
                        </div>

                        <div class="col-lg-6 mb-3">
                            <s:text name="cashiers.street_number" /> 
                            <s:fielderror fieldName="cassiere.profilo.numeroCivico" />
                            <s:textfield name="cassiere.profilo.numeroCivico" type="number" placeholder="%{getText('cashiers.street_number')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="cashiers.city" /> 
                            <s:fielderror fieldName="cassiere.profilo.citta" />
                            <s:textfield name="cassiere.profilo.citta" placeholder="%{getText('cashiers.city')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="cashiers.cap" /> 
                            <s:fielderror fieldName="cassiere.profilo.cap" />
                            <s:textfield name="cassiere.profilo.cap" type="number" placeholder="%{getText('cashiers.cap')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row">
	            <div class="col-lg-5">
				    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="cashiers.job"/></span>
				    <div class="row mt-3">
				        <div class="col-lg-12 mb-3">
				            <s:text name="cashiers.gameroom"/> 
							<s:fielderror fieldName="cassiere.salaGiochi.codice" />
				            <s:select name="cassiere.salaGiochi.codice" listKey="codice" listValue="nome" list="sale" class="form-control form-control-lg" required="true" />
						</div>
				        <div class="col-lg-6 mb-3">
				            <s:text name="cashiers.desk"/> 
                            <s:fielderror fieldName="cassiere.sportello" />
				            <s:textfield name="cassiere.sportello" type="number" placeholder="%{getText('cashiers.desk')}" class="form-control form-control-lg" required="true" />
				        </div>
						<div class="col-lg-6 mb-3">
							<s:text name="cashiers.salary"/> <i class="opacity-3">(Ex: 1500,00)</i>
							<s:fielderror fieldName="cassiere.salario" />
							<s:textfield name="cassiere.salario" placeholder="%{getText('cashiers.salary')}" class="form-control form-control-lg" required="true" />
						</div>
				    </div>
				</div>
				
				<div class="col-lg-3 bl-table">
				    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="cashiers.shift"/></span>
				    <div class="row mt-3">
				        <div class="col-lg-12 mb-3">
				            <s:text name="cashiers.shift_start"/> 
                            <s:fielderror fieldName="cassiere.inizioTurno" />
				            <s:textfield name="cassiere.inizioTurno" type="time" placeholder="%{getText('cashiers.shift_start')}" class="form-control form-control-lg" required="true" />
				        </div>
				        <div class="col-lg-12 mb-3">
				            <s:text name="cashiers.shift_end"/> 
                            <s:fielderror fieldName="cassiere.fineTurno" />
				            <s:textfield name="cassiere.fineTurno" type="time" placeholder="%{getText('cashiers.shift_end')}" class="form-control form-control-lg" required="true" />
				        </div>
				    </div>
				</div>
				<div class="col-lg-4 bl-table"></div>
			</div>
            
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('cashiers.update')}" />
            </div>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>
