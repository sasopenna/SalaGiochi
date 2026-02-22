<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="text.request"/></h4>
    </div>
    <div class="card-body">
        <s:form action="Richiesta" method="post" onkeydown="return event.key != 'Enter';" onsubmit="return checkSubmit()" >
            <s:fielderror fieldName="richiesta.cliente.numeroCliente" />
            <s:hidden name="richiesta.cliente.numeroCliente" value="%{account.account.profilo.socio.cliente.numeroCliente}" cssClass="form-control form-control-lg" required="true" />
        
            <div class="mb-3">
                <h5 class="font-weight-bolder"><s:text name="text.gamingroom"/></h5>
                <s:select name="richiesta.postazione.id.codiceSalaGiochi" cssClass="form-control form-control-lg" listValue="nome" listKey="codice" list="sale" headerValue="%{getText('choose.gamingroom')}" headerKey="-1" onchange="cambiaSala()" />
            </div>
            
            <div class="mb-3">
                <h5 class="font-weight-bolder"><s:text name="text.platform"/></h5>
                <s:select id="piattaforma" cssClass="form-control form-control-lg" list="{'PC','Xbox','PlayStation'}" headerValue="%{getText('choose.platform')}" headerKey="-1" onchange="cambiaPiattaforma()" />
            </div>
            
            <div class="mb-3">
                <h5 class="font-weight-bolder"><s:text name="text.duration"/></h5>
            </div>
            <s:textfield name="richiesta.durata" type="time" value="00:00" cssClass="form-control form-control-lg mb-3" onchange="cambiaTutto()" />
        
            <div>
                <table>
                    <tbody>
                        <tr>
                            <td>
                                <span class="text-dark text-lg font-weight-bolder text-nowrap">
                                    <s:text name="checkbox.specific"/>
                                </span>
                            </td>
                            <td width="99%" style="padding-left: 10px;">
                                <div class="form-check form-switch">
                                    <input type="checkbox" id="checkbox" class="form-check-input" onchange="cambiaTutto()" />
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" id="extra-text" class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="checkbox.random"/></td>
                        </tr>
                    </tbody>
                </table>
            
	            <div id="scegli-postazione">
	                <table class="table mb-0 table-visualizza">
	                    <tbody>
	                        <tr>
	                            <td>
	                                <div class="mb-3">
	                                    <s:text name="checkbox.station"/>
	                                    <s:select name="richiesta.postazione.numero" cssClass="form-control form-control-lg" list="{}" headerValue="%{getText('choose.station')}" headerKey="-1"  onchange="cambiaPostazione()" />
	                                </div>
	                            </td>
	                            <td>
	                                <div class="mb-3">
	                                    <s:text name="checkbox.room"/>
	                                    <s:textfield name="richiesta.postazione.id.stanza" type="number" cssClass="form-control form-control-lg" placeholder="%{getText('checkbox.room')}" readonly="true" />
	                                </div>
	                            </td>
	                            <td>
	                                <div class="mb-3">
	                                    <s:text name="checkbox.seat"/>
	                                    <s:textfield name="richiesta.postazione.id.posto" type="number" cssClass="form-control form-control-lg" placeholder="%{getText('checkbox.seat')}" readonly="true" />
	                                </div>
	                            </td>
	                        </tr>
	                    </tbody>
	                </table>
	            </div>
            </div>
        
            <s:submit id="submit" cssClass="btn btn-lg btn-primary btn-lg w-100 mb-0 mt-3" value="%{getText('submit')}"/>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>

<script>
	const sala = document.getElementsByName("richiesta.postazione.id.codiceSalaGiochi")[0];
	const piattaforma = document.getElementById("piattaforma");
	const orario = document.getElementsByName("richiesta.durata")[0];
	const postazione = document.getElementsByName("richiesta.postazione.numero")[0];
	const checkbox = document.getElementById("checkbox");
	const stanza = document.getElementsByName("richiesta.postazione.id.stanza")[0];
	const posto = document.getElementsByName("richiesta.postazione.id.posto")[0];
	const submit = document.getElementById("submit");
	
	const extraText = document.getElementById("extra-text");
	const scegli_postazione = document.getElementById("scegli-postazione");

	function cambiaSala() {
		piattaforma.selectedIndex = 0;
		orario.value = "00:00";
		checkbox.checked = false;
		cambiaTutto();
	}

	function cambiaPiattaforma() {
		fetchJSON();
		cambiaTutto();
	}

	function cambiaPostazione() {
		if(postazione.selectedIndex != 0) {
			const selezione = postazione.options[postazione.selectedIndex];
			stanza.value = selezione.getAttribute("stanza");
			posto.value = selezione.getAttribute("posto");
		} else {
			stanza.value = "";
			posto.value = "";
		}

		submit.disabled = !checkSubmit();
	}

	function cambiaTutto() {
		const checkBox = checkbox.checked;
		extraText.style.display = (checkBox ? "none" : "block");
		scegli_postazione.style.display = (checkBox ? "block" : "none");
		
		piattaforma.disabled = true;
		orario.disabled = true;
		checkbox.disabled = true;
		postazione.readonly = true;
		submit.disabled = true;
		
		if(sala.selectedIndex == 0) return;
		piattaforma.disabled = false;

		if(piattaforma.selectedIndex == 0) return;
		orario.disabled = false;

		if(orario.value == "00:00") return;
		checkbox.disabled = false;

		//disabilito prima di settarlo
		postazione.readonly = !checkBox;
		if(!checkBox) {
			//random se checkbox è chiusa
			const max = postazione.options.length - 1;
			postazione.selectedIndex = Math.round(Math.random() * (max - 1)) + 1;
		} else if(checkBox) {
			//seleziona "Scegli una postazione"
			postazione.selectedIndex = 0;
		}
		
		cambiaPostazione();
	}

	function checkSubmit() {
		return (sala.selectedIndex != 0 && piattaforma.selectedIndex != 0 && orario.value != "00:00" && postazione.selectedIndex != 0);
	}

	async function fetchJSON() {
		const salaGiochi = sala.options[sala.selectedIndex].value;
		const piatt = piattaforma.options[piattaforma.selectedIndex].value;

		postazione.options.length = 1;
		postazione.selectedIndex = 0;

		cambiaPostazione();
		
		const json = await fetch('CercaPostazione?sala='+salaGiochi+'&piattaforma='+piatt).then(r => r.json());
		json.result.forEach(r => {
			const o = document.createElement("option"); 
			o.value = r.numero; 
			o.setAttribute("posto", r.id.posto);
			o.setAttribute("stanza", r.id.stanza);
			o.text = "#"+r.numero; 
			postazione.appendChild(o);
		});

		cambiaTutto();
	}
	
	cambiaTutto();
</script>