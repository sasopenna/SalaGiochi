<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="row">
    <div class="col">
        <div class="card">
            <div class="card-header mb-0 pb-0">
                <h5 class="mb-0 text-md"><s:text name="account.panel"/></h5>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-sm-6 mb-4 col-lg-4">
                        <a href="<s:url namespace='/Account' action='Profilo'/>">
                            <div class="card nav-link selezione">
                                <div class="card-body p-3 d-flex flex-column align-items-center">
                                    <h6 class="mb-3 text-md"><s:text name="profile"/></h6>
                                    <img src="<s:url value='%{account.getFotoPath()}'/>" class="profile-pic shadow-sm" />
                                    <!-- <i class="ni ni-circle-08 text-dark text-xxl opacity-10 mb-3"></i> -->
                                    <span class="text-sm text-secondary text-center"><s:text name="profile.info"/></span>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-6 mb-4 col-lg-4">
                        <a href="<s:url namespace='/Account' action='Prenotazioni'/>">
                            <div class="card nav-link selezione">
                                <div class="card-body p-3 d-flex flex-column align-items-center">
                                    <h6 class="mb-3 text-md"><s:text name="reservations"/></h6>
                                    <i class="ni ni-bullet-list-67 text-success text-xxl opacity-10 mb-3"></i>
                                    <span class="text-sm text-secondary text-center"><s:text name="reservations.info"/></span>
                                </div>
                            </div>
                        </a>
                    </div>
                    <div class="col-sm-6 mb-4 col-lg-4">
                        <a href="<s:url namespace='/Account' action='Richiedi'/>">
                            <div class="card nav-link selezione">
                                <div class="card-body p-3 d-flex flex-column align-items-center">
                                    <h6 class="mb-3 text-md"><s:text name="request"/></h6>
                                    <i class="ni ni-single-copy-04 text-warning text-xxl opacity-10 mb-3"></i>
                                    <span class="text-sm text-secondary text-center"><s:text name="request.info"/></span>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/footer.jsp"%>