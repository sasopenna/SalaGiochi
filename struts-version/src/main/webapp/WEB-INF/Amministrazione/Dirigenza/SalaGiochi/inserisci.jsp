<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>

<div class="card">
	<div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="gamerooms.title.new"/></h4>
        <p class="mb-0"><s:text name="gamerooms.instructions.new"/></p>
	</div>
	<div class="card-body">
        <s:form action="Crea" method="post" role="form">
            <div class="row">
                <div class="col-lg-4">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="gamerooms.information"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-12 mb-3">
                            <s:text name="gamerooms.name"/> 
                            <s:fielderror fieldName="salagiochi.nome" />
                            <s:textfield name="salagiochi.nome" placeholder="%{getText('gamerooms.name')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-12 mb-3">
                            <s:text name="gamerooms.capacity"/>
                            <s:fielderror fieldName="salagiochi.capienza" />
                            <s:textfield name="salagiochi.capienza" type="number" placeholder="%{getText('gamerooms.capacity')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
                <div class="col-lg-2 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="gamerooms.hours"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-12 mb-3">
                            <s:text name="gamerooms.opening"/> <i class="opacity-3">(hh:mm)</i>
                            <s:fielderror fieldName="salagiochi.apertura" />
                            <s:textfield name="salagiochi.orarioApertura" type="time" placeholder="%{getText('gamerooms.opening')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-12 mb-3">
                            <s:text name="gamerooms.closing"/> <i class="opacity-3">(hh:mm)</i>
                            <s:fielderror fieldName="salagiochi.chiusura" />
                            <s:textfield name="salagiochi.orarioChiusura" type="time" placeholder="%{getText('gamerooms.closing')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 bl-table">
                    <span class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="gamerooms.location"/></span>
                    <div class="row mt-3">
                        <div class="col-lg-6 mb-3">
                            <s:text name="gamerooms.street"/>
                            <s:fielderror fieldName="salagiochi.indirizzo.via" />
                            <s:textfield name="salagiochi.indirizzo.via" placeholder="%{getText('gamerooms.street')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-6 mb-3">
                            <s:text name="gamerooms.street_number"/>
                            <s:fielderror fieldName="salagiochi.indirizzo.numeroCivico" />
                            <s:textfield name="salagiochi.indirizzo.numeroCivico" type="number" placeholder="%{getText('gamerooms.street_number')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="gamerooms.city"/>
                            <s:fielderror fieldName="salagiochi.indirizzo.citta" />
                            <s:textfield name="salagiochi.indirizzo.citta" placeholder="%{getText('gamerooms.city')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-6 mb-3">
                            <s:text name="gamerooms.postal_code"/>
                            <s:fielderror fieldName="salagiochi.indirizzo.cap" />
                            <s:textfield name="salagiochi.indirizzo.cap" type="number" placeholder="%{getText('gamerooms.postal_code')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-6 mb-3">
                            <s:text name="gamerooms.province"/>
                            <s:fielderror fieldName="salagiochi.indirizzo.provincia" />
                            <s:textfield name="salagiochi.indirizzo.provincia" placeholder="%{getText('gamerooms.province')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                        
                        <div class="col-lg-6 mb-3">
                            <s:text name="gamerooms.region"/>
                            <s:fielderror fieldName="salagiochi.indirizzo.regione" />
                            <s:textfield name="salagiochi.indirizzo.regione" placeholder="%{getText('gamerooms.region')}" cssClass="form-control form-control-lg" required="true" />
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('gamerooms.update')}" />
            </div>
        </s:form>
	</div>
</div>


<%@ include file="/WEB-INF/footer.jsp"%>