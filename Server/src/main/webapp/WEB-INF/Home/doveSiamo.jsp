<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/header-menu.jsp"%>

<div class="card">
    <div class="card-body">
        <div class="row">
            <s:iterator value="sale">
                <s:set var="maps" value="indirizzo.via + ', ' + indirizzo.numeroCivico + ' ' + indirizzo.cap + ' ' + indirizzo.citta" />
                <div class="col-lg-3 col-sm-6 mb-4">
                    <div class="card dovesiamo nav-link selezione" data-via="<s:property value='#maps' />">
                        <div class="card-body p-3">
                            <div class="d-flex flex-column">
                                <h6 class="mb-3 text-sm"><s:property value="nome" /></h6>
                                <span class="mb-2 text-xs"><s:property value="indirizzo.via + ', ' + indirizzo.numeroCivico" /></span>
                                <span class="mb-2 text-xs"><span class="text-dark font-weight-bold"><s:property value="indirizzo.cap + ' - ' + indirizzo.citta" /></span></span>
                                <span class="mb-2 text-xs">
                                	<s:text name="free_spots">
                                		<s:param value="capienza" />
                                	</s:text>
                                </span>
                                <span class="mb-2 text-xs">
	                                <s:text name="time_open">
	                                	<s:param value="orarioApertura" />
	                                	<s:param value="orarioChiusura" />
	                                </s:text>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
            </s:iterator>
        </div>
        <div class="row">
            <div>
                <iframe id="maps-iframe" scrolling="no" style="background: rgb(229 227 223)"></iframe>
            </div>
        </div>
    </div>
</div>

<script>
const googleMaps = document.getElementById("maps-iframe");
const dovesiamo = document.getElementsByClassName("dovesiamo");
var lastDovesiamo = null;

for(var i = 0; i < dovesiamo.length; i++) {
	const elemento = dovesiamo[i];
	
	//registro l'evento in cui si clicca su una sala giochi
	elemento.addEventListener('click', function () {
		if(lastDovesiamo != null) { //rimuovo l'ultimo elemento settato come active
			lastDovesiamo.classList.remove("active");
		}
		//metto active l'elemento che si seleziona
		elemento.classList.add("active");
		//setto l'elemento attuale come ultimo per tenerne tarccia
		lastDovesiamo = elemento;
		
		//prendo la stringa che ho messo come attributo in ogni elemento
		const stringaMaps = elemento.getAttribute("data-via");
		//la assegno alla mappa
		googleMaps.setAttribute("src", "https://maps.google.com/maps?q="+encodeURIComponent(stringaMaps)+"&t=&z=17&ie=UTF8&iwloc=&output=embed");
		
		//va in fondo alla pagina automaticamente https://stackoverflow.com/a/66771399 
		//window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' })
		//creava confusione
	});
	
	if(i == 0) { 
		elemento.click();
	}
}
</script>
<%@ include file="/WEB-INF/footer.jsp"%>