<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="row row-cols-2 p-4 justify-content-between">
        <div class="text-start">
            <span class="badge badge-sm bg-gradient-secondary">
                <a class="text-uppercase text-white text-xs font-weight-bolder">
                    <s:property value="soci.size()"/>
                </a>
            </span>
            <b><s:text name="members.title"/></b>
        </div>
        <div class="text-end">
            <span class="badge badge-sm bg-gradient-info">
                <a class="text-uppercase text-white text-xxs font-weight-bolder" href="<s:url action='Inserisci' namespace='/Dirigenza/Socio'/>"><s:text name="members.insert"/></a>
            </span>
        </div>
    </div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0 edit-table">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="members.id"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="members.fullName"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="members.gender"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="members.birthdate"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="members.contacts"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="members.points"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="members.joined"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="members.operations"/></td>
                </tr>
                
                <s:iterator value="soci">
                    <tr>
                        <td class="mb-0 text-sm"><s:property value="cliente.numeroCliente"/></td>
                        <td class="mb-0 text-sm"><s:property value="profilo.nome"/> <s:property value="profilo.cognome"/></td>
                        <td class="mb-0 text-sm text-center"><s:property value="profilo.sesso"/></td>
                        <td class="mb-0 text-sm text-center"><s:property value="profilo.dataDiNascita"/></td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0">
                            	<s:text name="members.cellphone">
                            		<s:param value="%{profilo.telefono.toString()}" />
                            	</s:text>
                            </p>
                            <p class="text-xs mb-0">
                            	<s:text name="members.email">
                            		<s:param value="profilo.email" />
                            	</s:text>
                            </p>
                        </td>
                        <td class="mb-0 text-sm text-center"><s:property value="punteggio"/></td>
                        <td class="mb-0 text-sm text-center"><s:property value="membroDal"/></td>
                        <td class="align-middle text-end text-sm">
                            <a href="<s:url action='Modifica' namespace='/Dirigenza/Socio'><s:param name='id' value='numeroCliente'/></s:url>">
                                <span class="badge badge-sm bg-gradient-success">
                                    <i class="ni ni-ruler-pencil text-white text-sm"></i>
                                </span>
                            </a>
                            <a href="<s:url action='Cancella' namespace='/Dirigenza/Socio'><s:param name='id' value='numeroCliente'/></s:url>" onclick="return confirm('<s:text name='members.confirmdelete'/>')">
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