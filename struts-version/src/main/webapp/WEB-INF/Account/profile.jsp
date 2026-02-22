<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
	<div class="card m-4 p-3 pb-1">
		<div class="row gx-4">
			<div class="col-auto">
				<div id="avatar" class="avatar avatar-xl position-relative" style="right: 0; left: unset;">
					<img src="<s:url value='%{account.getFotoPath()}'/>" class="w-100 h-100 border-radius-lg shadow-sm" />
				</div>
			</div>
			<div class="col-auto my-auto">
				<div class="h-100">
					<h5 class="mb-1">
						<s:text name="your_profile">
							<s:param value="account.account.profilo.socio.numeroCliente" />
						</s:text>
					</h5>
					<s:form action="CambiaFoto" role="form" method="post" enctype="multipart/form-data">
						<s:token />
						<div class="input-group">
							<label class="input-group-text" for="inputFile"><s:text name="change_photo" /></label>
							<s:file name="file" class="form-control" id="inputFile" accept="image/jpeg" required="true" />
							<s:submit cssClass="btn btn-primary" value="%{getText('upload')}" />
						</div>
					</s:form>
				</div>
			</div>
			<div
				class="col-lg-4 col-md-6 my-sm-auto ms-sm-auto me-sm-0 mx-auto mt-3">
				<div class="nav-wrapper position-relative end-0">
					<p class="mb-2 text-sm">
						<s:text name="score" />
						<span class="badge badge-sm bg-gradient-info"> <a
							class="text-uppercase text-white text-xs font-weight-bolder"><s:property value="account.account.profilo.socio.punteggio" /></a>
						</span>
					</p>
					<p class="mb-2 text-sm">
						<s:text name="member_since" />
						<span class="font-weight-bold"><s:property value="account.account.profilo.socio.membroDal" /></span>
					</p>
				</div>
			</div>
		</div>
	</div>
	<div class="card-body pt-0">
		<p class="text-uppercase text-secondary text-sm font-weight-bolder"> <s:text name="personal_data" /></p>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="form-control-label"><s:text name="name" /></label>
					<s:textfield name="account.account.profilo.nome" cssClass="form-control" readonly="true" />
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="form-control-label"><s:text name="surname" /></label>
					<s:textfield name="account.account.profilo.cognome" cssClass="form-control"  readonly="true" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="form-control-label"><s:text name="birth_date" /></label>
					<s:textfield name="account.account.profilo.dataDiNascita" cssClass="form-control" readonly="true" />
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="form-control-label"><s:text name="gender" /></label>
					<s:textfield name="account.account.profilo.sesso" cssClass="form-control" readonly="true" />
				</div>
			</div>
		</div>
		<p class="text-uppercase text-secondary text-sm font-weight-bolder">
			<s:text name="contacts" />
		</p>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="form-control-label"><s:text name="phone" /></label>
					<s:textfield name="account.account.profilo.telefono" cssClass="form-control" readonly="true" />
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="form-control-label"><s:text name="email" /></label>
					<s:textfield name="account.account.profilo.email" cssClass="form-control" type="email" readonly="true" />
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	const avatar = document.getElementById("avatar");
	avatar.addEventListener("click", function() {
		const inputFile = document.getElementById("inputFile");
		inputFile.click();
	});
</script>
<%@ include file="/WEB-INF/footer.jsp"%>