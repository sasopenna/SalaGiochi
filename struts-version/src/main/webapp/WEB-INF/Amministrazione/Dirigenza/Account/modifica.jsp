<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="accounts.title.mod"/></h4>
        <p class="mb-0"><s:text name="accounts.instructions.mod"/></p>
    </div>
    <div class="card-body">
        <s:form action="Aggiorna" method="post" role="form">
            <div class="mb-3">
                <h5 class="font-weight-bolder">
                    <s:text name="accounts.email"/>
                    <span class="badge badge-sm bg-gradient-info badge-padding">
                        <span class="text-uppercase text-white text-md font-weight-bolder"><s:property value="accounts.email"/></span>
                    </span>
                </h5>
                <s:fielderror fieldName="accounts.email" />
                <s:hidden name="accounts.email" cssClass="form-control form-control-lg" required="true" />
            </div>

            <table class="table mb-0 table-visualizza">
                <tbody>
                    <tr>
                        <td>
                            <div class="mb-3">
                                <s:text name="accounts.password"/>
                                <s:fielderror fieldName="accounts.password" />
                                <s:textfield name="accounts.password" cssClass="form-control form-control-lg" required="true" />
                            </div>
                        </td>
                        <td>
                            <div class="mb-3">
                                <s:text name="accounts.lastLogin"/> <i class="opacity-3">(gg/mm/aa)</i>
                                <s:fielderror fieldName="accounts.ultimoLogin" />
                                <s:textfield name="accounts.ultimoLogin" cssClass="form-control form-control-lg" required="true" />
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('accounts.update')}"/>
            </div>
        </s:form>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>
