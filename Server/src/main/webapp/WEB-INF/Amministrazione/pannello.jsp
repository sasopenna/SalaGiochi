<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="row">
    
	<div class="col-lg-2">
		<div class="card mb-4">
			<div class="card-body p-3 d-flex flex-column align-items-center">
				<div class="row">
					<div class="col-6 col-lg-12 text-center">
						<h6 class="mb-3 text-md">
							<s:text name="panel.employee">
								<s:param value="#profilo.dipendente.idDipendente" />
							</s:text>
						</h6>
						<img id="avatar" src="<s:url value='%{#session.account.getFotoPath()}'/>" class="profile-pic shadow-sm selezione" />
						<s:form action="CambiaFoto" role="form" method="post" enctype="multipart/form-data" style="display: none">
							<s:token />
							<s:file name="file" id="inputFile" accept="image/jpeg" required="true" />
							<s:submit />
						</s:form>
					</div>
					
					<div class="mt-2 col-6 col-lg-12 text-xs text-secondary text-left justify-content-center d-flex flex-column">
					    <span><s:text name="label.nome"><s:param value="#profilo.nome"/></s:text></span>
					    <span><s:text name="label.cognome"><s:param value="#profilo.cognome"/></s:text></span>
					    <span><s:text name="label.salario"><s:param value="#profilo.dipendente.salario"/></s:text></span>
					    <h6 class="text-uppercase text-xs text-primary font-weight-bolder opacity-6 pb-1 pt-2 m-0"><s:text name="label.turno" /></h6>
					    <span><s:text name="label.inizioTurno"><s:param value="%{#profilo.dipendente.inizioTurno.toString()}"/></s:text></span>
					    <span><s:text name="label.fineTurno"><s:param value="%{#profilo.dipendente.fineTurno.toString()}"/></s:text></span>
					</div>

				</div>
			</div>
		</div>
	</div>
	
	<div class="col-lg-10">
        <div class="card">
            <div class="card-header mb-0 pb-0">
                <h5 class="mb-0 text-md"><s:text name="admin.panel"/></h5>
            </div>
            <div class="card-body">
                <div class="row">
                
                	<s:if test="#isCassiere">
	                    <div class="col-lg-4 mb-4">
	                        <a href="<s:url namespace='/Cassiere' action='Assegna'/>">
								<div class="card nav-link selezione">
									<div class="card-body p-3 d-flex flex-column align-items-center">
										<h6 class="mb-3 text-md"><s:text name="stations.assignments"/></h6>
										<i class="ni ni-bullet-list-67 text-dark text-xxl opacity-10 mb-3"></i>
										<span class="text-sm text-secondary text-center"><s:text name="assignments.description" /></span>
									</div>
								</div>
							</a>
	                    </div>
                	</s:if>
                
                	<s:if test="#isTecnico">
	                    <div class="col-lg-4 mb-4">
	                        <a href="<s:url namespace='/Tecnico' action='Ripara'/>">
								<div class="card nav-link selezione">
									<div class="card-body p-3 d-flex flex-column align-items-center">
										<h6 class="mb-3 text-md"><s:text name="game.devices.repairs"/></h6>
										<i class="ni ni-settings text-dark text-xxl opacity-10 mb-3"></i>
										<span class="text-sm text-secondary text-center"><s:text name="repair.description" /></span>
									</div>
								</div>
							</a>
	                    </div>
                	</s:if>
                	
                	<s:if test="#isDirigente">
	                    <div class="col-lg-4 mb-4">
	                        <a href="<s:url namespace='/Dirigenza/SalaGiochi' action='Lista'/>">
								<div class="card nav-link selezione">
									<div class="card-body p-3 d-flex flex-column align-items-center">
										<h6 class="mb-3 text-md"><s:text name="game.rooms.title" /></h6>
										<i class="ni ni-building text-info text-xxl opacity-10 mb-3"></i>
										<span class="text-sm text-secondary text-center"><s:text name="game.rooms.description" /></span>
									</div>
								</div>
							</a>
	                    </div>
	                    
	                    <div class="col-lg-4 mb-4">
	                        <a href="<s:url namespace='/Dirigenza/Account' action='Lista'/>">
	                            <div class="card nav-link selezione">
	                                <div class="card-body p-3 d-flex flex-column align-items-center">
	                                    <h6 class="mb-3 text-md"><s:text name="account.title"/></h6>
	                                    <i class="ni ni-badge text-success text-xxl opacity-10 mb-3"></i>
	                                    <span class="text-sm text-secondary text-center"><s:text name="account.description"/></span>
	                                </div>
	                            </div>
	                        </a>
	                    </div>
	                    
	                    <div class="col-lg-4 mb-4">
	                        <a href="<s:url namespace='/Dirigenza/Socio' action='Lista'/>">
	                            <div class="card nav-link selezione">
	                                <div class="card-body p-3 d-flex flex-column align-items-center">
	                                    <h6 class="mb-3 text-md"><s:text name="members.title"/></h6>
	                                    <i class="ni ni-satisfied text-danger text-xxl opacity-10 mb-3"></i>
	                                    <span class="text-sm text-secondary text-center"><s:text name="members.description"/></span>
	                                </div>
	                            </div>
	                        </a>
	                    </div>
	                    
	                    <div class="col-lg-4 mb-4">
	                        <div class="card">
	                            <div class="card-body p-3 d-flex flex-column align-items-center">
	                                <h6 class="mb-3 text-md"><s:text name="employees.title"/></h6>
	                                <table width="100%">
	                                    <tbody>
	                                        <tr>
	                                            <td class="text-end w-50 pe-4">
	                                                <i class="ni ni-single-02 text-black-50 text-xxl opacity-10 mb-3"></i>
	                                            </td>
	                                            <td class="w-50">
	                                                <ul class="navbar-nav">
	                                                    <li class="nav-item">
	                                                        <a class="nav-link selezione selezione-sub" href="<s:url namespace='/Dirigenza/Dipendenti/Dirigente' action='Lista'/>">
	                                                            <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
	                                                            <span class="nav-link-text ms-1"><s:text name="employees.managers"/></span>
	                                                        </a>
	                                                    </li>
	                                                    <li class="nav-item">
	                                                        <a class="nav-link selezione selezione-sub" href="<s:url namespace='/Dirigenza/Dipendenti/Cassiere' action='Lista'/>">
	                                                            <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
	                                                            <span class="nav-link-text ms-1"><s:text name="employees.cashiers"/></span>
	                                                        </a>
	                                                    </li>
	                                                    <li class="nav-item">
	                                                        <a class="nav-link selezione selezione-sub" href="<s:url namespace='/Dirigenza/Dipendenti/Tecnico' action='Lista'/>">
	                                                            <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
	                                                            <span class="nav-link-text ms-1"><s:text name="employees.technicians"/></span>
	                                                        </a>
	                                                    </li>
	                                                </ul>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="2" class="text-center text-sm text-secondary"><s:text name="employees.description"/></td>
	                                        </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    
	                    <div class="col-lg-4 mb-4">
	                        <div class="card">
	                            <div class="card-body p-3 d-flex flex-column align-items-center">
	                                <h6 class="mb-3 text-md"><s:text name="game.devices.title"/></h6>
	                                <table width="100%">
	                                    <tbody>
	                                        <tr>
	                                            <td class="text-end w-50 pe-4">
	                                                <i class="ni ni-controller text-primary text-xxl opacity-10 mb-3"></i>
	                                            </td>
	                                            <td class="w-50">
	                                                <ul class="navbar-nav">
	                                                    <li class="nav-item">
	                                                        <a class="nav-link selezione selezione-sub" href="<s:url namespace='/Dirigenza/DispositivoDiGioco' action='Lista'/>">
	                                                            <i class="ni ni-calendar-grid-58 text-dark text-sm opacity-10"></i>
	                                                            <span class="nav-link-text ms-1"><s:text name="game.devices.list"/></span>
	                                                        </a>
	                                                    </li>
	                                                    <li class="nav-item">
	                                                        <a class="nav-link selezione selezione-sub" href="<s:url namespace='/Dirigenza/DispositivoDiGioco/Ripara' action='Lista'/>">
	                                                            <i class="ni ni-settings text-dark text-sm opacity-10"></i>
	                                                            <span class="nav-link-text ms-1"><s:text name="game.devices.repairs"/></span>
	                                                        </a>
	                                                    </li>
	                                                </ul>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="2" class="text-center text-sm text-secondary"><s:text name="game.devices.description"/></td>
	                                        </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	                    
	                    <div class="col-lg-4 mb-4">
	                        <div class="card">
	                            <div class="card-body p-3 d-flex flex-column align-items-center">
	                                <h6 class="mb-3 text-md"><s:text name="stations.title"/></h6>
	                                <table width="100%">
	                                    <tbody>
	                                        <tr>
	                                            <td class="text-end w-50 pe-4">
	                                                <i class="ni ni-collection text-warning text-xxl opacity-10 mb-3"></i>
	                                            </td>
	                                            <td class="w-50">
	                                                <ul class="navbar-nav">
	                                                    <li class="nav-item">
	                                                        <a class="nav-link selezione selezione-sub" href="<s:url namespace='/Dirigenza/Postazione' action='Lista'/>">
	                                                            <i class="ni ni-calendar-grid-58 text-dark text-sm opacity-10"></i>
	                                                            <span class="nav-link-text ms-1"><s:text name="stations.list"/></span>
	                                                        </a>
	                                                    </li>
	                                                    <li class="nav-item">
	                                                        <a class="nav-link selezione selezione-sub" href="<s:url namespace='/Dirigenza/Postazione/Richiede' action='Lista'/>">
	                                                            <i class="ni ni-send text-dark text-sm opacity-10"></i>
	                                                            <span class="nav-link-text ms-1"><s:text name="stations.requests"/></span>
	                                                        </a>
	                                                    </li>
	                                                    <li class="nav-item">
	                                                        <a class="nav-link selezione selezione-sub" href="<s:url namespace='/Dirigenza/Postazione/Assegna' action='Lista'/>">
	                                                            <i class="ni ni-bullet-list-67 text-dark text-sm opacity-10"></i>
	                                                            <span class="nav-link-text ms-1"><s:text name="stations.assignments"/></span>
	                                                        </a>
	                                                    </li>
	                                                </ul>
	                                            </td>
	                                        </tr>
	                                        <tr>
	                                            <td colspan="2" class="text-center text-sm text-secondary"><s:text name="stations.description"/></td>
	                                        </tr>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
                    </s:if>
                    
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
		inputFile.onchange = function() {
			inputFile.parentElement.submit();
		}
	});
</script>
<%@ include file="/WEB-INF/footer.jsp"%>