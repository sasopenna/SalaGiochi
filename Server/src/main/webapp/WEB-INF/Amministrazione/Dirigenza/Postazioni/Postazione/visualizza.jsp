<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="row row-cols-2 p-4 justify-content-between">
        <div class="text-start">
            <span class="badge badge-sm bg-gradient-secondary">
                <a class="text-uppercase text-white text-xs font-weight-bolder">
                    <s:property value="postazioni.size()"/>
                </a>
            </span>
            <b><s:text name="stations.title" /></b>
        </div>
        <div class="text-end">
            <span class="badge badge-sm bg-gradient-info">
                <a class="text-uppercase text-white text-xxs font-weight-bolder" href="<s:url action='Inserisci' namespace='/Dirigenza/Postazione'/>"><s:text name="stations.insert"/></a>
            </span>
        </div>
    </div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0 edit-table">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="stations.id"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="stations.position"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="stations.device"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="stations.operations"/></td>
                </tr>
                
                <s:iterator value="postazioni">
                    <tr>
                        <td class="mb-0 text-sm"><s:property value="numero"/></td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0"><s:text name="stations.gameroom_name"><s:param value="id.codiceSalaGiochi"/></s:text></p>
                            <p class="text-xs mb-0"><s:text name="stations.room_name"><s:param value="id.stanza"/></s:text></p>
                            <p class="text-xs mb-0"><s:text name="stations.position_name"><s:param value="id.posto"/></s:text></p>
                        </td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0"><s:property value="dispositivoDiGioco.tipo"/></p>
                            <p class="text-xxs mb-0">
                            	<s:text name="stations.identity">
                            		<s:param value="dispositivoDiGioco.id"/>
                            	</s:text>
                            </p>
                        </td>
                        <td class="align-middle text-end text-sm">
                            <a href="<s:url action='Modifica' namespace='/Dirigenza/Postazione'><s:param name='id' value='numero'/></s:url>">
                                <span class="badge badge-sm bg-gradient-success">
                                    <i class="ni ni-ruler-pencil text-white text-sm"></i>
                                </span>
                            </a>
                            <a href="<s:url action='Cancella' namespace='/Dirigenza/Postazione'><s:param name='id' value='numero'/></s:url>" onclick="return confirm('<s:text name='stations.confirmdelete'/>')">
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