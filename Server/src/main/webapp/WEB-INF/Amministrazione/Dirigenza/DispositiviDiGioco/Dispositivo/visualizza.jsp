<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="row row-cols-2 p-4 justify-content-between">
        <div class="text-start">
            <span class="badge badge-sm bg-gradient-secondary">
                <a class="text-uppercase text-white text-xs font-weight-bolder">
                    <s:property value="dispositivi.size()"/>
                </a>
            </span>
            <b><s:text name="devices.title"/></b>
        </div>
        <div class="text-end">
            <span class="badge badge-sm bg-gradient-info">
                <a class="text-uppercase text-white text-xxs font-weight-bolder" href="<s:url action='Inserisci' namespace='/Dirigenza/DispositivoDiGioco'/>"><s:text name="devices.insert"/></a>
            </span>
        </div>
    </div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="devices.id"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="devices.acquisitionDate"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="devices.platform"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="devices.operations"/></td>
                </tr>
                
                <s:iterator value="dispositivi">
                	<s:set var="tipo" value="tipo" />
                    <tr>
                        <td class="mb-0 text-sm"><s:property value="id"/></td>
                        <td class="mb-0 text-sm text-center"><s:property value="dataAcquisizione"/></td>
                        <td class="mb-0 text-sm">
                        	<s:property value="tipo"/>
                        	<span class="text-xs font-weight-bold">
	          					(<s:if test="tipo.equals(\"PC\")">
	          						Windows <s:property value="windows" />
	          					</s:if>
	          					<s:else>
	          						<s:property value="generazione" />
	          					</s:else>)
          					</span>
                        </td>
                        <td class="align-middle text-end text-sm">
                            <a href="<s:url action='Modifica' namespace='/Dirigenza/DispositivoDiGioco'><s:param name='id' value='id'/></s:url>">
                                <span class="badge badge-sm bg-gradient-success">
                                    <i class="ni ni-ruler-pencil text-white text-sm"></i>
                                </span>
                            </a>
                            <a href="<s:url action='Cancella' namespace='/Dirigenza/DispositivoDiGioco'><s:param name='id' value='id'/></s:url>" onclick="return confirm('<s:text name='devices.confirmdelete'/>')">
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