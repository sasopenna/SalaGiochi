<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
	<div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="assignments.title.new"/></h4>
        <p class="mb-0"><s:text name="assignments.instructions.new"/></p>
	</div>
	<div class="card-body">
		<s:form action="Crea" method="post" role="form">
			<div class="mb-3">	
                <s:text name="assignments.reservation"/>
                <s:fielderror fieldName="assegnazione.prenotazione" />
        		<s:select name="assegnazione.prenotazione" list="richieste" listKey="prenotazione" listValue="'['+prenotazione+'] Postazione '+postazione.numero+' - Durata '+durata" cssClass="form-control form-control-lg" required="true" placeholder="%{getText('assignments.reservation')}" onchange="aggiornaCosto()" />
        	</div>
        	
        	<div class="row mb-3">
			    <div class="col-lg-6">
			    	<div class="col-lg-12">
			            <s:text name="assignments.cashier"/>
			            <s:fielderror fieldName="assegnazione.cassiere.idDipendente" />
			            <s:hidden name="assegnazione.cassiere.idDipendente" required="true" readonly="true" />
			            <s:textfield value="%{'('+assegnazione.cassiere.idDipendente+') ' + assegnazione.cassiere.profilo.nome + ' ' + assegnazione.cassiere.profilo.cognome}" cssClass="form-control form-control-lg" required="true" readonly="true" />
			    	</div>
			    	<div class="col-lg-12">
			            <s:text name="assignments.schedule"/>
			            <s:fielderror fieldName="assegnazione.orario" />
			            <s:textfield name="assegnazione.orario" type="time" placeholder="%{getText('assignments.schedule')}" cssClass="form-control form-control-lg" required="true" />
				    </div>
			     </div>
			    <div class="col-lg-6">
			    	<div class="col-lg-12 mb-3">
			            <s:text name="assignments.cost"/>
			            <s:fielderror fieldName="assegnazione.costo" />
			            <s:textfield name="assegnazione.costo" placeholder="%{getText('assignments.cost')}" cssClass="form-control form-control-lg" required="true" />
			    	</div>
			    	<div class="col-lg-12">
					    <table style="width: 100%">
						    <tbody>
							    <tr class="align-middle">
				        			<td class="text-uppercase text-secondary text-sm font-weight-bolder" style="white-space: nowrap"><s:text name="assignments.fixedprice" /></td>
				        			<td>
									    <div class="form-check form-switch">
									        <input class="form-check-input" type="checkbox" id="checkbox" onchange="checkCostoFissato()">
									    </div>
									</td>
									<td width="100%" class="m-0 p-0">
									    <s:textfield id="euroPerMinuti" type="number" step="0.01" onkeyup="aggiornaCosto()" onchange="aggiornaCosto()" placeholder="%{getText('assignments.pricepermin')}" cssClass="form-control form-control-lg" required="true" />
									</td>
				        		</tr>
			        		</tbody>
		        		</table>
			    	</div>
			     </div>
			</div>
        	
			<div class="text-center">
				<s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('assignments.assign')}"/>
			</div>
		</s:form>
	</div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>

<script>
	const costo = document.getElementsByName("assegnazione.costo")[0];
	const checkbox = document.getElementById("checkbox");
	const euroPerMinuti = document.getElementById("euroPerMinuti");
	const select_id = document.getElementsByName("assegnazione.prenotazione")[0];

	function getElementoSelect() {
		const elemento = select_id.options[select_id.selectedIndex];
		return elemento;
	}
	
	function checkCostoFissato() {
		if(checkbox.checked) {
			euroPerMinuti.style.display = "block";
			euroPerMinuti.setAttribute("required", "true");
			costo.setAttribute("readonly", "true");
		} else {
			euroPerMinuti.style.display = "none";
			euroPerMinuti.removeAttribute("required");
			costo.removeAttribute("readonly");
		}
	}
	
	function aggiornaCosto() {
		const elemento = getElementoSelect();
		const durata = elemento.textContent.split(" ")[5];
		const euro = euroPerMinuti.value;
		const minuti = recuperaMinuti(durata);
		
		costo.value = decimali(minuti * euro);
	}
	
	//modificato ma preso da https://stackoverflow.com/questions/62306593/convert-time-string-hoursminute-to-date-object
	function recuperaMinuti(timeString) {
		const hours = parseInt(timeString.substring(0,2));
		const minutes = parseInt(timeString.substring(3,5));
		return (60 * hours) + minutes;
	}
	
	//preso da https://stackoverflow.com/questions/11832914/how-to-round-to-at-most-2-decimal-places-if-necessary
	function decimali(num) {
		return Math.round(num * 100) / 100;
	}
	
	checkCostoFissato();
</script>