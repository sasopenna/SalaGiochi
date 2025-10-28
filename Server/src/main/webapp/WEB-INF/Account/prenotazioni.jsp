<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>

<s:if test="richieste.size() == 0">
	<div class="row">
		<div class="col">
			<div class="card p-4">
				<h4 class="font-weight-bolder text-center"><s:text name="no_prenotations" /></h4>
			</div>
		</div>
	</div>
</s:if>
<s:else>
	<div class="row">
		<div class="col-lg-3 mb-4">
			<div class="card">
				<div class="card-body">
					<div class="row justify-content-center mb-4 font-weight-bold"><s:text name="qr_code" /></div>
					<div class="d-flex justify-content-center mb-4" id="qrcode"></div>
					<div id="assegnazione" class="row justify-content-center mb-4 font-weight-bold"></div>
					<div class="row text-center mt-4">
						<span class="mb-2 text-sm">
							<s:text name="code" /> #<span id="codice" class="font-weight-bold"></span>
						</span>
						<span class="mb-2 text-sm">
							<s:text name="price" /> <span id="costo" class="font-weight-bold"></span>€
						</span>
						<span class="mb-2 text-sm">
							<s:text name="time" /> <span id="orario" class="font-weight-bold"></span>
						</span>
					</div>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="card">
				<div class="card-body">
					<div class="row">
						<s:iterator value="richieste">
						
						    <div class="col-sm-6 mb-4 col-lg-4">
						        <div class="card prenotazione nav-link selezione" 
						             data-prenotazione="<s:property value="prenotazione" />" 
						             <s:if test="assegnazione != null">
						                 data-assegnata="true"
						                 data-orario="<s:property value="assegnazione.orario" />"
						                 data-costo="<s:property value="assegnazione.costo" />"
						             </s:if>>
						            
						            <div class="card-body p-3 d-flex flex-column">
						                <h6 class="mb-3 text-md">
						                	<s:text name="prenotation">
						                		<s:param value="prenotazione" />
						                	</s:text>
						                </h6>
						                <span class="mb-2 text-sm">
						                    <s:text name="platform" />
						                    <img class="piattaforma" src="<s:url value='/assets/img/console/%{postazione.dispositivoDiGioco.tipo.toLowerCase()}.jpg' />">
						                    <span class="text-dark font-weight-bold"><s:property value="postazione.dispositivoDiGioco.tipo" /></span>
						                </span>
						                <span class="mb-2 text-sm">
						                	<s:text name="station" /> #<span class="text-dark font-weight-bold"><s:property value="postazione.numero" /></span>
						                </span>
						                <span class="mb-2 text-sm">
						                	<s:text name="duration" />
						                	<span class="text-dark font-weight-bold"><s:property value="durata" /></span>
						                </span>
						                <span class="mb-2 text-sm">
						                    <s:text name="status" />
						                    <s:if test="assegnazione != null">
						                        <img class="genere-img ok" style="margin-right: 0px;">
						                        <span class="text-dark font-weight-bold"><s:text name="assigned" /></span>
						                    </s:if>
						                    <s:else>
						                        <img class="genere-img no" style="margin-right: 0px;">
						                        <span class="text-dark font-weight-bold"><s:text name="not_assigned" /></span>
						                    </s:else>
						                </span>
						            </div>
						        </div>
						    </div>
						</s:iterator>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- codice QR preso da https://davidshimjs.github.io/qrcodejs/ -->
	<script src="<s:url value='/assets/js/qrcode.min.js' />"></script>
	<script>
		const mostraRiquadro = document.getElementById("mostraRiquadro");
		const prenotazioni = document.getElementsByClassName("prenotazione");
		const qr = document.getElementById("qrcode");
		
		const assegnazione = document.getElementById("assegnazione");
		const codice = document.getElementById("codice");
		const orario = document.getElementById("orario");
		const costo = document.getElementById("costo");
		
		var lastElemento = null;
		
		for(var i = 0; i < prenotazioni.length; i++) {
			const elemento = prenotazioni[i];
			//registro l'evento in cui si clicca su una prenotazione
			elemento.addEventListener('click', function () {
				if(lastElemento != null) {
					lastElemento.classList.remove("active");
					qr.innerHTML = "";
				}
		
				elemento.classList.add("active");
				
				const getPrenotazione = elemento.getAttribute("data-prenotazione");
				const getOrario = elemento.getAttribute("data-orario");
				const getCosto = elemento.getAttribute("data-costo");
				const assegnata = elemento.getAttribute("data-assegnata")  == "true";
				
				new QRCode(qr, { text: getPrenotazione, width: 190,  height: 190 });
				
				assegnazione.innerHTML = (assegnata ? "<s:text name='assigned.long' />" : "<s:text name='not_assigned.long' />");
				assegnazione.classList.remove("text-success"); 
				assegnazione.classList.remove("text-danger"); 
				assegnazione.classList.add(assegnata ? "text-success" : "text-danger");
				
				codice.innerHTML = getPrenotazione;
				
				costo.parentElement.style.display = (assegnata ? "block" : "none");
				orario.parentElement.style.display = (assegnata ? "block" : "none");
				
				if(assegnata) {
					costo.innerHTML = (Math.round(getCosto * 100) / 100);
					orario.innerHTML = getOrario;
				}
				
				lastElemento = elemento;
				
				window.scrollTo({ top: 0, behavior: 'smooth' });
			});
			
			if(i == 0) {
				elemento.click();
			}
		}
	</script>
</s:else>

<%@ include file="/WEB-INF/footer.jsp"%>