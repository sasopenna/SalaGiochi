<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="row row-cols-2 p-4 justify-content-between">
        <div class="text-start">
            <span class="badge badge-sm bg-gradient-secondary">
                <a class="text-uppercase text-white text-xs font-weight-bolder">
                    <s:property value="richieste.size()"/>
                </a>
            </span>
            <b><s:text name="requests.title"/></b>
        </div>
        <div class="text-end">
            <span class="badge badge-sm bg-gradient-info">
                <a class="text-uppercase text-white text-xxs font-weight-bolder" href="<s:url action='Inserisci' namespace='/Dirigenza/Postazione/Richiede'/>"><s:text name="requests.insert"/></a>
            </span>
        </div>
    </div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0 edit-table">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="requests.id"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="requests.assigned"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="requests.station"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="requests.client"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="requests.duration"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="requests.operations"/></td>
                </tr>
                
                <s:iterator value="richieste">
                    <tr>
                        <td class="mb-0 text-sm"><s:property value="prenotazione"/></td>
                        <td class="mb-0 text-sm">
                            <div style="text-align: -webkit-center">
	                            <s:if test="%{assegnazione}">
								    <div class="genere-img ok"></div>
								</s:if>
								<s:else>
								    <div class="genere-img no"></div>
								</s:else>
                            </div>
                        </td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0 font-weight-bold"><s:property value="postazione.dispositivoDiGioco.tipo"/></p>
                            <p class="text-xxs mb-0">
                            	<s:text name="requests.identity">
                            		<s:param value="postazione.numero"/>
                            	</s:text>
                            </p>
                        </td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0 font-weight-bold"><s:property value="cliente.socio.profilo.nome + ' ' + cliente.socio.profilo.cognome"/></p>
                            <p class="text-xxs mb-0">
                            	<s:text name="requests.identity">
                            		<s:param value="cliente.numeroCliente"/>
                            	</s:text>
                            </p>
                        </td>
                        <td class="mb-0 text-sm text-center"><s:property value="durata"/></td>
                        <td class="align-middle text-end text-sm">
                            <a href="<s:url action='Modifica' namespace='/Dirigenza/Postazione/Richiede'><s:param name='id' value='prenotazione'/></s:url>">
                                <span class="badge badge-sm bg-gradient-success">
                                    <i class="ni ni-ruler-pencil text-white text-sm"></i>
                                </span>
                            </a>
                            <a href="<s:url action='Cancella' namespace='/Dirigenza/Postazione/Richiede'><s:param name='id' value='prenotazione'/></s:url>" onclick="return confirm('<s:text name='requests.confirmdelete'/>')">
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