<%@ taglib uri="/struts-tags" prefix="s" %>

<s:set var="loggato" value="#session.account != null" />
<s:if test="#loggato">
	<s:set var="profilo" value="#session.account.account.profilo" />
	
    <s:set var="isSocio" value="#profilo.socio != null" />
    <s:set var="isDipendente" value="#profilo.dipendente != null" />
    
    <s:set var="isTecnico" value="false" />
    <s:set var="isCassiere" value="false" />
    <s:set var="isDirigente" value="false" />
    
    <s:if test="#isDipendente">
   		<s:set var="isTecnico" value="#profilo.dipendente.isTecnico()" />
   		<s:set var="isCassiere" value="#profilo.dipendente.isCassiere()" />
   		<s:set var="isDirigente" value="#profilo.dipendente.isDirigente()" />
    </s:if>
</s:if>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="apple-touch-icon" sizes="76x76" href="<s:url value='/assets/img/apple-icon.png' />">
        <link rel="icon" type="image/png" href="<s:url value='/assets/img/favicon.png' />">
        <title><s:text name="title" /></title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet" />
        <link href="<s:url value='/assets/css/nucleo-icons.css' />" rel="stylesheet" />
        <link href="<s:url value='/assets/css/nucleo-svg.css' />" rel="stylesheet" />
        <link href="<s:url value='/assets/css/nucleo-svg.css' />" rel="stylesheet" />
        <link id="pagestyle" href="<s:url value='/assets/css/argon-dashboard.css?v=2.0.4' />" rel="stylesheet" />
        <link href="<s:url value='/assets/css/modifiche-penna.css' />" rel="stylesheet" />
    </head>
    <body class="g-sidenav-show dark-version bg-gray-100">
        <div class="min-height-300 bg-primary position-absolute w-100"></div>
        <aside class=" sidenav bg-default navbar navbar-vertical navbar-expand-xs border-0 border-radius-xl my-3 fixed-start ms-4 " id="sidenav-main">
            <div class="sidenav-header">
                <i class="fas fa-times p-3 cursor-pointer text-secondary opacity-5 position-absolute end-0 top-0 d-none d-xl-none" aria-hidden="true" id="iconSidenav"></i>
                <a class="navbar-brand m-0">
                    <img src="<s:url value='/assets/img/logo.jpg' />" class="navbar-brand-img h-100" alt="main_logo">
                    <span class="ms-1 font-weight-bold">
                        <s:text name="title" />
                    </span>
                </a>
            </div>
            <hr class="horizontal dark mt-0">
            <div class="collapse navbar-collapse w-auto" id="sidenav-collapse-main">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link selezione selezione-sub" href="<s:url action='Home' namespace='/' />">
                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="ni ni-shop text-info text-sm opacity-10"></i>
                            </div>
                            <span class="nav-link-text ms-1">
                                <s:text name="button.home" />
                            </span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link selezione selezione-sub" href="<s:url action='Statistiche' namespace='/' />">
                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="ni ni-chart-pie-35 text-primary text-sm opacity-10"></i>
                            </div>
                            <span class="nav-link-text ms-1">
                                <s:text name="button.statistics" />
                            </span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link selezione selezione-sub" href="<s:url action='DoveSiamo' namespace='/' />">
                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                                <i class="ni ni-square-pin text-danger text-sm opacity-10"></i>
                            </div>
                            <span class="nav-link-text ms-1">
                                <s:text name="button.how_to_find_us" />
                            </span>
                        </a>
                    </li>
                    
                    <s:if test="(#isSocio && #loggato) || !#loggato">
                        <li class="nav-item mt-3">
                            <s:if test="#isSocio && #loggato">
                                <a href="<s:url action='Pannello' namespace='/Account' />" class="d-flex flex-row">
                                    <h6 class="ps-4 ms-2 text-uppercase text-xs font-weight-bolder opacity-6 hover-color">
                                        <s:text name="button.account" />
                                    </h6>
                                    <i class="ni ni-bold-right text-xs opacity-6 freccia"></i>
                                </a>
                            </s:if>
                            <s:else>
                                <h6 class="ps-4 ms-2 text-uppercase text-xs font-weight-bolder opacity-6">
                                    <s:text name="button.account" />
                                </h6>
                            </s:else>
                        </li>
                    </s:if>
                    
                    <s:if test="!#loggato">
	                    <li class="nav-item">
	                        <a class="nav-link selezione selezione-sub" href="<s:url action='Login' namespace='/' />">
	                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
	                                <i class="ni ni-lock-circle-open text-warning text-sm opacity-10"></i>
	                            </div>
	                            <span class="nav-link-text ms-1">
	                                <s:text name="button.login" />
	                            </span>
	                        </a>
	                        <a class="nav-link selezione selezione-sub" href="<s:url action='Registrazione' namespace='/' />">
	                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
	                                <i class="ni ni-book-bookmark text-primary text-sm opacity-10"></i>
	                            </div>
	                            <span class="nav-link-text ms-1">
	                                <s:text name="button.register" />
	                            </span>
	                        </a>
	                    </li>
                    </s:if>
                    
                    
                    <s:if test="#isSocio && #loggato">
	                    <li class="nav-item">
	                        <a class="nav-link selezione selezione-sub" href="<s:url action='Profilo' namespace='/Account' />">
	                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
	                                <i class="ni ni-circle-08 text-dark text-sm opacity-10"></i>
	                            </div>
	                            <span class="nav-link-text ms-1">
	                                <s:text name="button.profile" />
	                            </span>
	                        </a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link selezione selezione-sub" href="<s:url action='Prenotazioni' namespace='/Account' />">
	                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
	                                <i class="ni ni-bullet-list-67 text-success text-sm opacity-10"></i>
	                            </div>
	                            <span class="nav-link-text ms-1">
	                                <s:text name="button.booking" />
	                            </span>
	                        </a>
	                    </li>
	                    <li class="nav-item">
	                        <a class="nav-link selezione selezione-sub" href="<s:url action='Richiedi' namespace='/Account' />">
	                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
	                                <i class="ni ni-single-copy-04 text-warning text-sm opacity-10"></i>
	                            </div>
	                            <span class="nav-link-text ms-1">
	                                <s:text name="button.request_station" />
	                            </span>
	                        </a>
	                    </li>
                    </s:if>
                    
                    <s:if test="#isDipendente && #loggato">
	                    <li class="nav-item mt-3">
	                        <a href="<s:url action='Pannello' namespace='/Amministrazione' />" class="d-flex flex-row">
	                            <h6 class="ps-4 ms-2 text-uppercase text-xs font-weight-bolder opacity-6 hover-color">
	                                <s:text name="button.administration" />
	                            </h6>
	                            <i class="ni ni-bold-right text-xs opacity-6 freccia"></i>
	                        </a>
	                    </li>
	                    
                    	<s:if test="#isCassiere">
                    		<li class="nav-item">
                                <a class="nav-link selezione selezione-sub" href="<s:url action='Assegna' namespace='/Cassiere' />">
                                	<div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                                    	<i class="ni ni-bullet-list-67 text-dark text-sm opacity-10"></i>
		                            </div>
                                    <span class="nav-link-text ms-1">
                                        <s:text name="options.assignments" />
                                    </span>
                                </a>
                            </li>
                    	</s:if>
	                    
                    	<s:if test="#isTecnico">
                    		<li class="nav-item">
                                <a class="nav-link selezione selezione-sub" href="<s:url action='Ripara' namespace='/Tecnico' />">
                                	<div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
                                    	<i class="ni ni-settings text-dark text-sm opacity-10"></i>
		                            </div>
                                    <span class="nav-link-text ms-1">
                                        <s:text name="options.fixes" />
                                    </span>
                                </a>
                            </li>
                    	</s:if>
		                    
                    	<s:if test="#isDirigente">
		                    <!-- INIZIO SALE GIOCHI -->
		                    <li class="nav-item">
		                        <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/SalaGiochi' />">
		                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
		                                <i class="ni ni-building text-info text-sm opacity-10"></i>
		                            </div>
		                            <span class="nav-link-text ms-1">
		                                <s:text name="button.gamerooms" />
		                            </span>
		                        </a>
		                    </li>
		                    <!-- FINE SALE GIOCHI -->
		                    <!-- INIZIO ACCOUNT -->
		                    <li class="nav-item">
		                        <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/Account' />">
		                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
		                                <i class="ni ni-badge text-success text-sm opacity-10"></i>
		                            </div>
		                            <span class="nav-link-text ms-1">
		                                <s:text name="button.account" />
		                            </span>
		                        </a>
		                    </li>
		                    <!-- FINE ACCOUNT -->
		                    <!-- INIZIO SOCI -->
		                    <li class="nav-item">
		                        <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/Socio' />">
		                            <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
		                                <i class="ni ni-satisfied text-danger text-sm opacity-10"></i>
		                            </div>
		                            <span class="nav-link-text ms-1">
		                                <s:text name="button.members" />
		                            </span>
		                        </a>
		                    </li>
		                    <!-- FINE SOCI -->
		                    <!-- INIZIO DIPENDENTI -->
		                    <li class="nav-item">
		                        <div id="accordion">
		                            <div id="headingOne">
		                                <a class="nav-link selezione selezione-sub" data-bs-toggle="collapse" data-bs-target="#collapse-dipendenti" aria-controls="collapse-dipendenti">
		                                    <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
		                                        <i class="ni ni-single-02 text-black-50 text-sm opacity-10"></i>
		                                    </div>
		                                    <span class="nav-link-text ms-1">
		                                        <s:text name="button.employees" />
		                                    </span>
		                                </a>
		                                <div id="collapse-dipendenti" class="collapse" aria-labelledby="headingOne" data-bs-parent="#accordion">
		                                    <ul class="navbar-nav padding-left">
		                                        <li class="nav-item">
		                                            <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/Dipendenti/Dirigente' />">
		                                                <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
		                                                <span class="nav-link-text ms-1">
		                                                    <s:text name="button.managers" />
		                                                </span>
		                                            </a>
		                                        </li>
		                                        <li class="nav-item">
		                                            <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/Dipendenti/Cassiere' />">
		                                                <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
		                                                <span class="nav-link-text ms-1">
		                                                    <s:text name="button.cashiers" />
		                                                </span>
		                                            </a>
		                                        </li>
		                                        <li class="nav-item">
		                                            <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/Dipendenti/Tecnico' />">
		                                                <i class="ni ni-single-02 text-dark text-sm opacity-10"></i>
		                                                <span class="nav-link-text ms-1">
		                                                    <s:text name="button.technicians" />
		                                                </span>
		                                            </a>
		                                        </li>
		                                    </ul>
		                                </div>
		                            </div>
		                        </div>
		                    </li>
		                    <!-- FINE DIPENDENTI -->
		                    <!-- INIZIO DISPOSITVI -->
		                    <li class="nav-item">
		                        <div id="accordion">
		                            <div id="headingOne">
		                                <a class="nav-link selezione selezione-sub" data-bs-toggle="collapse" data-bs-target="#collapse-ddg" aria-controls="collapse-ddg">
		                                    <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
		                                        <i class="ni ni-controller text-primary text-sm opacity-10"></i>
		                                    </div>
		                                    <span class="nav-link-text ms-1">
		                                        <s:text name="button.gaming_devices" />
		                                    </span>
		                                </a>
		                                <div id="collapse-ddg" class="collapse" aria-labelledby="headingOne" data-bs-parent="#accordion">
		                                    <ul class="navbar-nav padding-left">
		                                        <li class="nav-item">
		                                            <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/DispositivoDiGioco' />">
		                                                <i class="ni ni-calendar-grid-58 text-dark text-sm opacity-10"></i>
		                                                <span class="nav-link-text ms-1">
		                                                    <s:text name="options.list" />
		                                                </span>
		                                            </a>
		                                        </li>
		                                        <li class="nav-item">
		                                            <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/DispositivoDiGioco/Ripara' />">
		                                                <i class="ni ni-settings text-dark text-sm opacity-10"></i>
		                                                <span class="nav-link-text ms-1">
		                                                    <s:text name="options.fixes" />
		                                                </span>
		                                            </a>
		                                        </li>
		                                    </ul>
		                                </div>
		                            </div>
		                        </div>
		                    </li>
		                    <!-- FINE DISPOSITVI -->
		                    <!-- INIZIO POSTAZIONI -->
		                    <li class="nav-item">
		                        <div id="accordion">
		                            <div id="headingOne">
		                                <a class="nav-link selezione selezione-sub" data-bs-toggle="collapse" data-bs-target="#collapse-postazioni" aria-controls="collapse-postazioni">
		                                    <div class="icon icon-shape icon-sm border-radius-md text-center me-2 d-flex align-items-center justify-content-center">
		                                        <i class="ni ni-collection text-warning text-sm opacity-10"></i>
		                                    </div>
		                                    <span class="nav-link-text ms-1">
		                                        <s:text name="button.stations" />
		                                    </span>
		                                </a>
		                                <div id="collapse-postazioni" class="collapse" aria-labelledby="headingOne" data-bs-parent="#accordion">
		                                    <ul class="navbar-nav padding-left">
		                                        <li class="nav-item">
		                                            <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/Postazione' />">
		                                                <i class="ni ni-calendar-grid-58 text-dark text-sm opacity-10"></i>
		                                                <span class="nav-link-text ms-1">
		                                                    <s:text name="options.list" />
		                                                </span>
		                                            </a>
		                                        </li>
		                                        <li class="nav-item">
		                                            <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/Postazione/Richiede' />">
		                                                <i class="ni ni-send text-dark text-sm opacity-10"></i>
		                                                <span class="nav-link-text ms-1">
		                                                    <s:text name="options.requests" />
		                                                </span>
		                                            </a>
		                                        </li>
		                                        <li class="nav-item">
		                                            <a class="nav-link selezione selezione-sub" href="<s:url action='Lista' namespace='/Dirigenza/Postazione/Assegna' />">
		                                                <i class="ni ni-bullet-list-67 text-dark text-sm opacity-10"></i>
		                                                <span class="nav-link-text ms-1">
		                                                    <s:text name="options.assignments" />
		                                                </span>
		                                            </a>
		                                        </li>
		                                    </ul>
		                                </div>
		                            </div>
		                        </div>
		                    </li>
		                    <!-- FINE POSTAZIONI -->
	                    </s:if>
					</s:if>
					
					<s:if test="#loggato">
						<li class="nav-item mt-3">
	                        <a href="<s:url action='Logout' namespace='/' />" class="d-flex flex-row">
	                            <h6 class="ps-4 ms-2 text-uppercase text-xs font-weight-bolder opacity-6 hover-color">
	                                <s:text name="button.logout" />
	                            </h6>
	                            <i class="ni ni-bold-right text-xs opacity-6 freccia"></i>
	                        </a>
	                    </li>
					</s:if>
                </ul>
            </div>
        </aside>
        <main class="main-content position-relative border-radius-lg" style="overflow: unset !important">
        <!-- Navbar -->
        <div class="container position-sticky z-index-sticky top-0" style="max-width: 100% !important">
            <nav class="navbar navbar-expand-lg blur blur-dark border-radius-lg top-0 z-index-3 shadow position-absolute mt-3 p-0 py-2 start-0 end-0 mx-4 " id="navbarBlur" data-scroll="false" style="box-shadow: 0 23px 45px -11px rgba(20, 20, 20, 0.25) !important;">
                <div class="container-fluid p-0 px-4">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
                            <li class="breadcrumb-item text-sm">
                                <a class="opacity-5 text-dark">
                                    <s:text name="breadcrumb.parent"/>
                                </a>
                            </li>
                            <li class="breadcrumb-item text-sm text-dark active" aria-current="page">
                                <s:text name="breadcrumb.children"/>
                            </li>
                        </ol>
                    </nav>
                    <div class="mt-sm-0 mt-2 me-md-0 z-index-3" id="navbar">
                        <ul class="navbar-nav justify-content-end">
                            <li class="nav-item d-flex align-items-center nav-link text-white font-weight-bold px-0">
                            	
                    			<s:if test="#loggato">
	                            	<s:if test="#isSocio">
	                            		<a href="<s:url action='Profilo' namespace='/Account' />">
	                            			<img src="<s:url value='%{#session.account.getFotoPath()}'/>" class="profile-pic mini-pic shadow-sm" />
	                            		</a>
	                            	</s:if>
	                            	<s:else>
	                            		<a href="<s:url action='Pannello' namespace='/Amministrazione' />">
	                            			<img src="<s:url value='%{#session.account.getFotoPath()}'/>" class="profile-pic mini-pic shadow-sm" />
	                            		</a>
	                            	</s:else>
                            	</s:if>
                            	<s:else>
                                	<i class="ni ni-single-02 text-dark text-sm"></i>
                            	</s:else>
                                
                    			<s:if test="!#loggato">
	                                <a href="<s:url action='Login' namespace='/' />" class="nav-link text-dark font-weight-bold hover-color">
	                                    <span class="d-sm-inline d-none">
	                                        <s:text name="button.login" />
	                                    </span>
	                                </a>
	                                <a href="<s:url action='Registrazione' namespace='/' />" class="nav-link text-dark font-weight-bold hover-color">
	                                    <span class="d-sm-inline d-none">
	                                        <s:text name="button.register" />
	                                    </span>
	                                </a>
                                </s:if>
                                <s:else>
	                                <span class="d-sm-inline d-none">
	                                	<s:if test="#isSocio">
	                                		<a class="nav-link text-dark font-weight-bold hover-color" href="<s:url action='Pannello' namespace='/Account' />"><s:property value="#profilo.nome" /></a>
	                                	</s:if>
	                                	<s:else>
	                                		<a class="nav-link text-dark font-weight-bold hover-color" href="<s:url action='Pannello' namespace='/Amministrazione' />"><s:property value="#profilo.nome" /></a>
	                                	</s:else>
	                                </span>
	                                <span class="d-sm-inline d-none opacity-7">
	                                    <a href="<s:url action='Logout' namespace='/' />" class="nav-link text-black hover-color">
	                                        (<s:text name="button.logout" />)
	                                    </a>
	                                </span>
                                </s:else>
                                
                                <a class="nav-link text-dark p-0 px-2 d-xl-none" id="iconNavbarSidenav">
                                    <div class="sidenav-toggler-inner">
                                        <i class="sidenav-toggler-line bg-black"></i>
                                        <i class="sidenav-toggler-line bg-black"></i>
                                        <i class="sidenav-toggler-line bg-black"></i>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <!-- End Navbar -->
        <div class="container-fluid pt-7" style="padding-top: 6.5rem !important;">
	        <s:if test="hasActionErrors()">
	            <div class="alert alert-danger alert-dismissible fade show" role="alert">
	                <span class="opacity-7">
	                    <s:actionerror />
	                </span>
	                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	            </div>
	        </s:if>
	        <s:if test="hasActionMessages()">
	            <div class="alert alert-success alert-dismissible fade show" role="alert">
	                <span class="opacity-7">
	                    <s:actionmessage />
	                </span>
	                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	            </div>
	        </s:if>