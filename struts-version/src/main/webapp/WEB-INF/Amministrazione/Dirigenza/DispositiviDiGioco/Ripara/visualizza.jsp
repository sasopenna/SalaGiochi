<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="row row-cols-2 p-4 justify-content-between">
        <div class="text-start">
            <span class="badge badge-sm bg-gradient-secondary">
                <a class="text-uppercase text-white text-xs font-weight-bolder">
                    <s:property value="riparazioni.size()"/>
                </a>
            </span>
            <b><s:text name="repairs.title"/></b>
        </div>
        <div class="text-end">
            <span class="badge badge-sm bg-gradient-info">
                <a class="text-uppercase text-white text-xxs font-weight-bolder" href="<s:url action='Inserisci' namespace='/Dirigenza/DispositivoDiGioco/Ripara'/>"><s:text name="repairs.insert"/></a>
            </span>
        </div>
    </div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0 edit-table">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="repairs.id"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="repairs.device"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="repairs.technician"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="repairs.repairCost"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="repairs.operations"/></td>
                </tr>
                
                <s:iterator value="riparazioni">
                    <tr>
                        <td class="mb-0 text-sm"><s:property value="progressivo"/></td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0 font-weight-bold"><s:property value="dispositivoDiGioco.tipo"/></p>
                            <p class="text-xxs mb-0">
                            	<s:text name="repairs.identity">
                            		<s:param value="dispositivoDiGioco.id"/>
                            	</s:text>
                            </p>
                        </td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0 font-weight-bold"><s:property value="tecnico.profilo.nome"/> <s:property value="tecnico.profilo.cognome"/></p>
                            <p class="text-xxs mb-0">
                            	<s:text name="repairs.identity">
                            		<s:param value="tecnico.idDipendente"/>
                            	</s:text>
                            </p>
                        </td>
                        <td class="mb-0 text-xs"><s:property value="costoRiparazione"/></td>
                        <td class="align-middle text-end text-sm">
                            <a href="<s:url action='Modifica' namespace='/Dirigenza/DispositivoDiGioco/Ripara'><s:param name='id' value='progressivo'/></s:url>">
                                <span class="badge badge-sm bg-gradient-success">
                                    <i class="ni ni-ruler-pencil text-white text-sm"></i>
                                </span>
                            </a>
                            <a href="<s:url action='Cancella' namespace='/Dirigenza/DispositivoDiGioco/Ripara'><s:param name='id' value='progressivo'/></s:url>" onclick="return confirm('<s:text name='repairs.confirmdelete'/>')">
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