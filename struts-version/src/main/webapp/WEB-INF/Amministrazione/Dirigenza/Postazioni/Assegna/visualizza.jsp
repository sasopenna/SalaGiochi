<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="row row-cols-2 p-4 justify-content-between">
        <div class="text-start">
            <span class="badge badge-sm bg-gradient-secondary">
                <a class="text-uppercase text-white text-xs font-weight-bolder">
                    <s:property value="assegnazioni.size()"/>
                </a>
            </span>
            <b><s:text name="assignments.title"/></b>
        </div>
        <div class="text-end">
            <span class="badge badge-sm bg-gradient-info">
                <a class="text-uppercase text-white text-xxs font-weight-bolder" href="<s:url action='Inserisci' namespace='/Dirigenza/Postazione/Assegna'/>"><s:text name="assignments.insert"/></a>
            </span>
        </div>
    </div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0 edit-table">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="assignments.id"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="assignments.cashier"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="assignments.cost"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="assignments.time"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="assignments.operations"/></td>
                </tr>
                
                <s:iterator value="assegnazioni">
                    <tr>
                        <td class="mb-0 text-sm"><s:property value="prenotazione"/></td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0 font-weight-bold"><s:property value="cassiere.profilo.nome + ' ' + cassiere.profilo.cognome"/></p>
                            <p class="text-xxs mb-0">
                            	<s:text name="assignments.identity">
                            		<s:param value="cassiere.idDipendente"/>
                            	</s:text>
                            </p>
                        </td>
                        <td class="mb-0 text-sm"><s:property value="costo"/></td>
                        <td class="mb-0 text-sm"><s:property value="orario"/></td>
                        <td class="align-middle text-end text-sm">
                            <a href="<s:url action='Modifica' namespace='/Dirigenza/Postazione/Assegna'><s:param name='id' value='prenotazione'/></s:url>">
                                <span class="badge badge-sm bg-gradient-success">
                                    <i class="ni ni-ruler-pencil text-white text-sm"></i>
                                </span>
                            </a>
                            <a href="<s:url action='Cancella' namespace='/Dirigenza/Postazione/Assegna'><s:param name='id' value='prenotazione'/></s:url>" onclick="return confirm('<s:text name='assignments.confirmdelete'/>')">
                                <span class="badge badge-sm bg-gradient-danger">
                                    <i class="ni ni-fat-remove text-white text-sm"></i>
                                </span>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
                
            </tbody>
        </table>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>