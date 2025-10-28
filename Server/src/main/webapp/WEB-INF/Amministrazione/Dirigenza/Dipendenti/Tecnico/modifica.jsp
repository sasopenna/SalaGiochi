<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="technicians.title.mod"/></h4>
        <p class="mb-0"><s:text name="technicians.instructions.mod"/></p>
    </div>
    <div class="card-body">
        <s:form action="Aggiorna" method="post" role="form">
            <div class="mb-3">
                <h5 class="font-weight-bolder">
                    <s:text name="technicians.technician"/>
                    <span class="badge badge-sm bg-gradient-info badge-padding">
                        <span class="text-uppercase text-white text-md font-weight-bolder"><s:property value="tecnico.idDipendente"/></span>
                    </span>
                </h5>
                <s:fielderror fieldName="tecnico.idDipendente" />
                <s:hidden name="tecnico.idDipendente" cssClass="form-control form-control-lg" required="true" />
            </div>
            
            <div class="row">
                <div class="col-lg-5">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="technicians.personalData"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.firstname"/> 
                            <s:fielderror fieldName="tecnico.profilo.nome" />
                            <s:textfield name="tecnico.profilo.nome" placeholder="%{getText('technicians.firstname')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.lastname"/> 
                            <s:fielderror fieldName="tecnico.profilo.cognome" />
                            <s:textfield name="tecnico.profilo.cognome" placeholder="%{getText('technicians.lastname')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.gender"/> 
                            <s:fielderror fieldName="tecnico.profilo.sesso" />
                            <s:select name="tecnico.profilo.sesso" list="{'Uomo','Donna'}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.birthdate"/> <i class="opacity-3">(gg/mm/aa)</i>
                            <s:fielderror fieldName="tecnico.profilo.dataDiNascita" />
                            <s:textfield name="tecnico.profilo.dataDiNascita" placeholder="%{getText('technicians.birthdate')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <s:text name="technicians.cf"/> 
                            <s:fielderror fieldName="tecnico.profilo.codiceFiscale" />
                            <s:textfield name="tecnico.profilo.codiceFiscale" placeholder="%{getText('technicians.cf')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="technicians.contacts"/></span>
                    <div class="col-lg-12 mt-3 mb-3">
                        <s:text name="technicians.phone"/> 
                        <s:fielderror fieldName="tecnico.profilo.telefono" />
                        <s:textfield name="tecnico.profilo.telefono" type="number" placeholder="%{getText('technicians.phone')}" cssClass="form-control form-control-lg" required="true" />
                    </div>
                    <div class="col-lg-12 mb-3">
                        <s:text name="technicians.e-mail"/> 
                        <s:fielderror fieldName="tecnico.profilo.email" />
                        <s:textfield name="tecnico.profilo.email" placeholder="%{getText('technicians.e-mail')}" cssClass="form-control form-control-lg" required="true" readonly="true" />
                    </div>
                </div>
                <div class="col-lg-4 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="technicians.residence"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.street"/> 
                            <s:fielderror fieldName="tecnico.profilo.via" />
                            <s:textfield name="tecnico.profilo.via" placeholder="%{getText('technicians.street')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.street_number"/> 
                            <s:fielderror fieldName="tecnico.profilo.numeroCivico" />
                            <s:textfield name="tecnico.profilo.numeroCivico" type="number" placeholder="%{getText('technicians.street_number')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.city"/> 
                            <s:fielderror fieldName="tecnico.profilo.citta" />
                            <s:textfield name="tecnico.profilo.citta" placeholder="%{getText('technicians.city')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.cap"/> 
                            <s:fielderror fieldName="tecnico.profilo.cap" />
                            <s:textfield name="tecnico.profilo.cap" type="number" placeholder="%{getText('technicians.cap')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-lg-5">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="technicians.work"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.salary"/> 
                            <s:fielderror fieldName="tecnico.salario" /> <i class="opacity-3">(Ex: 1500,00)</i>
                            <s:textfield name="tecnico.salario" type="text" placeholder="%{getText('technicians.salary')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.specialization"/> 
                            <s:fielderror fieldName="tecnico.specializzazione" />
                            <s:select name="tecnico.specializzazione" list="{'PC','Xbox','PlayStation'}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 bl-table"></div>
                <div class="col-lg-4 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="technicians.shift"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.start"/> 
                            <s:fielderror fieldName="tecnico.inizioTurno" />
                            <s:textfield name="tecnico.inizioTurno" type="time" placeholder="%{getText('technicians.start')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        <div class="col-lg-6 mb-3">
                            <s:text name="technicians.end"/> 
                            <s:fielderror fieldName="tecnico.fineTurno" />
                            <s:textfield name="tecnico.fineTurno" type="time" placeholder="%{getText('technicians.end')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('technicians.update')}"/>
            </div>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>
