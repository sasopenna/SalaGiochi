<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
	<div class="row row-cols-2 p-4 justify-content-between">
		<div class="text-start">
			<span class="badge badge-sm bg-gradient-secondary">
			    <a class="text-uppercase text-white text-xs font-weight-bolder">
			        <s:property value="salagiochi.size()"/>
			    </a>
			</span>
			<b><s:text name="gamerooms.title"/></b>
		</div>
		<div class="text-end">
			<span class="badge badge-sm bg-gradient-info">
				<a class="text-uppercase text-white text-xxs font-weight-bolder" href="<s:url action='Inserisci' namespace='/Dirigenza/SalaGiochi'/>"><s:text name="gamerooms.insert"/></a>
			</span>
		</div>
	</div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0 edit-table">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="gamerooms.id"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="gamerooms.name"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="gamerooms.capacity"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="gamerooms.hours"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="gamerooms.location"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="gamerooms.operations"/></td>
                </tr>
                
                <s:iterator value="salagiochi">
	                <tr>
	                    <td class="mb-0 text-sm"><s:property value="codice"/></td>
	                    <td class="mb-0 text-sm"><s:property value="nome"/></td>
	                    <td class="mb-0 text-sm text-center">
	                    	<s:text name="gamerooms.capacity_row">
	                    		<s:param value="capienza"/>
	                    	</s:text>
	                    </td>
	                    <td class="mb-0 text-sm text-center">
	                        <p class="text-xs mb-0"><s:text name="gamerooms.opening"/>: <b><s:property value="orarioApertura"/></b></p>
	                        <p class="text-xs mb-0"><s:text name="gamerooms.closing"/>: <b><s:property value="orarioChiusura"/></b></p>
	                    </td>
	                    <td class="mb-0 text-sm">
	                    	<s:text name="gamerooms.location_row">
	                    		<s:param value="indirizzo.via"/>
	                    		<s:param value="indirizzo.numeroCivico"/>
	                    	</s:text>
	                        <br>
	                    	<s:text name="gamerooms.location_row2">
	                    		<s:param value="%{indirizzo.cap.toString()}"/>
	                    		<s:param value="indirizzo.citta"/>
	                    		<s:param value="indirizzo.provincia"/>
	                    	</s:text>
	                    </td>
	                    <td class="align-middle text-end text-sm">
	                    	<a href="<s:url action='Modifica' namespace='/Dirigenza/SalaGiochi'><s:param name='id' value='codice'/></s:url>">
	                        	<span class="badge badge-sm bg-gradient-success">
	                                <i class="ni ni-ruler-pencil text-white text-sm"></i>
	                        	</span>
                            </a>
	                        <a href="<s:url action='Cancella' namespace='/Dirigenza/SalaGiochi'><s:param name='id' value='codice'/></s:url>" onclick="return confirm('<s:text name='gamerooms.confirmdelete'/>')">
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