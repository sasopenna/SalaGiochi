<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="row row-cols-2 p-4 justify-content-between">
        <div class="text-start">
            <span class="badge badge-sm bg-gradient-secondary">
                <a class="text-uppercase text-white text-xs font-weight-bolder">
                    <s:property value="tecnici.size()"/>
                </a>
            </span>
            <b><s:text name="technicians.title"/></b>
        </div>
        <div class="text-end">
            <span class="badge badge-sm bg-gradient-info">
                <a class="text-uppercase text-white text-xxs font-weight-bolder" href="<s:url action='Inserisci' namespace='/Dirigenza/Dipendenti/Tecnico'/>"><s:text name="technicians.insert"/></a>
            </span>
        </div>
    </div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0 edit-table">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="technicians.id"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="technicians.personalData"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="technicians.birthdate"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="technicians.contacts"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="technicians.address"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="technicians.work"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="technicians.shift"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="technicians.operations"/></td>
                </tr>
                
                <s:iterator value="tecnici">
                    <tr>
                        <td class="mb-0 text-sm"><s:property value="idDipendente"/></td>
                        <td class="mb-0 text-sm">
                            <s:property value="profilo.nome"/> <s:property value="profilo.cognome"/>
                            <p class="text-xxs mb-0"><b><s:property value="profilo.codiceFiscale"/></b></p>
                            <p class="text-xxs mb-0"><s:property value="profilo.sesso"/></p>
                        </td>
                        <td class="mb-0 text-sm text-center"><s:property value="profilo.dataDiNascita"/></td>
                        <td class="mb-0 text-sm">
                            <p class="text-xs mb-0">
                                <s:text name="technicians.cellphone">
                                    <s:param value="%{profilo.telefono.toString()}" />
                                </s:text>
                            </p>
                            <p class="text-xs mb-0">
                                <s:text name="technicians.email">
                                    <s:param value="profilo.email" />
                                </s:text>
                            </p>
                        </td>
                        <td class="mb-0 text-xs">
                            <s:text name="technicians.location_row">
                                <s:param value="profilo.via"/>
                                <s:param value="profilo.numeroCivico"/>
                            </s:text>
                            <br>
                            <s:text name="technicians.location_row2">
                                <s:param value="%{profilo.cap.toString()}"/>
                                <s:param value="profilo.citta"/>
                            </s:text>
                        </td>
                        <td class="mb-0 text-xs text-center">
                            <s:text name="technicians.work_spec">
                            	<s:param value="salario"/>
                            	<s:param value="specializzazione"/>
                            </s:text>
                        </td>
                        <td class="mb-0 text-xs">
                            <p class="text-xs mb-0">
                                <s:text name="technicians.turn_start">
                                    <s:param value="inizioTurno"/>
                                </s:text>
                            </p>
                            <p class="text-xs mb-0">
                                <s:text name="technicians.turn_end">
                                    <s:param value="fineTurno"/>
                                </s:text>
                            </p>
                        </td>
                        <td class="align-middle text-end text-sm">
                            <a href="<s:url action='Modifica' namespace='/Dirigenza/Dipendenti/Tecnico'><s:param name='id' value='idDipendente'/></s:url>">
                                <span class="badge badge-sm bg-gradient-success">
                                    <i class="ni ni-ruler-pencil text-white text-sm"></i>
                                </span>
                            </a>
                            <a href="<s:url action='Cancella' namespace='/Dirigenza/Dipendenti/Tecnico'><s:param name='id' value='idDipendente'/></s:url>" onclick="return confirm('<s:text name='technicians.confirmdelete'/>')">
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