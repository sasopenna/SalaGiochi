<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="card-header pb-0 text-start">
        <h4 class="font-weight-bolder"><s:text name="stations.title.new"/></h4>
        <p class="mb-0"><s:text name="stations.instructions.new"/></p>
    </div>
    <div class="card-body">
        <s:form action="Crea" method="post" role="form">
            <table class="table mb-0 table-visualizza">
                <tbody>
                    <tr>
                        <td>
                            <div class="mb-3">    
                                <s:text name="stations.gameroom"/>
                                <s:fielderror fieldName="postazione.id.codiceSalaGiochi"/>
                                <s:select name="postazione.id.codiceSalaGiochi" list="sale" listKey="codice" listValue="nome" cssClass="form-control form-control-lg" required="true"/>
                            </div>
                        </td>
                        <td>
                            <div class="mb-3">
                                <s:text name="stations.room"/>
                                <s:fielderror fieldName="postazione.id.stanza"/>
                                <s:textfield name="postazione.id.stanza" type="number" step="1" placeholder="%{getText('stations.room')}" cssClass="form-control form-control-lg" required="true"/>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="mb-3">
                                <s:text name="stations.device"/>
                                <s:fielderror fieldName="postazione.dispositivoDiGioco.id"/>
                                <s:select name="postazione.dispositivoDiGioco.id" list="dispositivi" listKey="id" listValue="'(' + id + ') ' + tipo" cssClass="form-control form-control-lg" required="true"/>
                            </div>
                        </td>
                        <td>
                            <div class="mb-3">
                                <s:text name="stations.position"/>
                                <s:fielderror fieldName="postazione.id.posto"/>
                                <s:textfield name="postazione.id.posto" type="number" step="1" placeholder="%{getText('stations.position')}" cssClass="form-control form-control-lg" required="true"/>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            
            <div class="text-center">
                <s:submit cssClass="btn btn-lg btn-primary btn-lg w-100 mt-4 mb-0" value="%{getText('stations.insert')}"/>
            </div>
        </s:form>
        
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>