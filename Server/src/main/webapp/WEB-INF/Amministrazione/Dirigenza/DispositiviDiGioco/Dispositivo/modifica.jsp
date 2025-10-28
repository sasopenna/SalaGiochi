<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="devices.title.mod"/></h4>
        <p class="mb-0"><s:text name="devices.instructions.mod"/></p>
    </div>
    <div class="card-body">
        <s:form action="Aggiorna" method="post" role="form">
            <div class="mb-3">
                <h5 class="font-weight-bolder">
                    <s:text name="devices.device"/>
                    <span class="badge badge-sm bg-gradient-info badge-padding">
                        <span class="text-uppercase text-white text-md font-weight-bolder"><s:property value="dispositivoDiGioco.id"/></span>
                    </span>
                </h5>
                <s:fielderror fieldName="dispositivoDiGioco.id" />
                <s:hidden name="dispositivoDiGioco.id" cssClass="form-control form-control-lg" required="true" />
            </div>

			<div class="row">
				<div class="col-lg-4 mb-3">
                    <div class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="devices.platform"/></div>
                    <s:text name="devices.device"/>
                    <s:fielderror fieldName="dispositivo" />
                    <s:textfield name="tipo" value="%{dispositivoDiGioco.getTipo()}" cssClass="form-control form-control-lg" required="true" readonly="true" />
				</div>
				<div class="col-lg-4">
                    <div class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="devices.version"/></div>
                    <div class="col-lg-12 mb-3" id="sezionePC">
                        <s:text name="devices.version"/>
                        <s:fielderror fieldName="discriminator" />
                        <s:select name="discriminator" id="pc" list="discriminatorWindows" value="dispositivoDiGioco.windows" cssClass="form-control form-control-lg" required="true" />
                    </div>
                    <div class="col-lg-12 mb-3" id="sezioneXbox">
                        <s:text name="devices.gen"/>
                        <s:fielderror fieldName="discriminator" />
                        <s:select name="discriminator" id="xbox" list="discriminatorXbox" value="dispositivoDiGioco.generazione" cssClass="form-control form-control-lg" required="true" />
                    </div>
                    <div class="col-lg-12 mb-3" id="sezionePlay">
                        <s:text name="devices.gen"/>
                        <s:fielderror fieldName="discriminator" />
                        <s:select name="discriminator" id="play" list="discriminatorPlayStation" value="dispositivoDiGioco.generazione" cssClass="form-control form-control-lg" required="true" />
                    </div>
				</div>
				<div class="col-lg-4">
                    <div class="text-uppercase text-secondary text-sm font-weight-bolder"><s:text name="devices.acquisition_date"/></div>
                    <s:text name="devices.date"/> <i class="opacity-3">(gg/mm/aa)</i>
                    <s:fielderror fieldName="dispositivoDiGioco.dataAcquisizione" />
                    <s:textfield name="dispositivoDiGioco.dataAcquisizione" cssClass="form-control form-control-lg" required="true" />
                </div>
			</div>
            
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('devices.update')}"/>
            </div>
        </s:form>
    </div>
</div>
<script>
	const dispositivo = document.getElementsByName("tipo")[0];

    const sezionePC = document.getElementById("sezionePC");
    const sezioneXbox = document.getElementById("sezioneXbox");
    const sezionePlay = document.getElementById("sezionePlay");
    const PC = document.getElementById("pc");
    const Xbox = document.getElementById("xbox");
    const Play = document.getElementById("play");

    function aggiorna() {
        // nascondo tutto a prescindere e metto disabled=true perchè così non li invia alla action
        sezionePC.style.display = "none";
		sezioneXbox.style.display = "none";
        sezionePlay.style.display = "none";
        PC.disabled = true;
        Xbox.disabled = true;
        Play.disabled = true;
        
        // mostro e abilito solo quelli "scelti"
        if (dispositivo.value === "PC") {
        	sezionePC.style.display = "block";
        	PC.disabled = false;
        } else if (dispositivo.value === "Xbox") {
        	sezioneXbox.style.display = "block";
            Xbox.disabled = false;
        } else if (dispositivo.value === "PlayStation") {
        	sezionePlay.style.display = "block";
            Play.disabled = false;
        }
    }

    dispositivo.onchange = aggiorna;
    aggiorna();
</script>
<%@ include file="/WEB-INF/footer.jsp"%>
