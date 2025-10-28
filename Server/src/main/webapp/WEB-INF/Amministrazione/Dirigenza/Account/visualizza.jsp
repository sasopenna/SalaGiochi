<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card">
    <div class="row row-cols-2 p-4 justify-content-between">
        <div class="text-start">
            <span class="badge badge-sm bg-gradient-secondary">
                <a class="text-uppercase text-white text-xs font-weight-bolder">
                    <s:property value="accounts.size()"/>
                </a>
            </span>
            <b><s:text name="accounts.title"/></b>
        </div>
    </div>
    <div class="card-body pt-0">
        <table class="table align-items-center mb-0">
            <tbody>
                <tr>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="accounts.email"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder"><s:text name="accounts.password"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-center"><s:text name="accounts.lastLogin"/></td>
                    <td class="text-uppercase text-secondary text-xxs font-weight-bolder text-end"><s:text name="accounts.operations"/></td>
                </tr>
                
                <s:iterator value="accounts">
                    <tr>
                        <td class="mb-0 text-sm"><s:property value="email"/></td>
                        <td class="mb-0 text-sm"><s:property value="password"/></td>
                        <td class="mb-0 text-sm text-center"><s:property value="ultimoLogin"/></td>
                        <td class="align-middle text-end text-sm">
                            <a href="<s:url action='Modifica' namespace='/Dirigenza/Account'><s:param name='email' value='email'/></s:url>">
                                <span class="badge badge-sm bg-gradient-success">
                                    <i class="ni ni-ruler-pencil text-white text-sm"></i>
                                </span>
                            </a>
                            <a href="<s:url action='Cancella' namespace='/Dirigenza/Account'><s:param name='email' value='email'/></s:url>" onclick="return confirm('<s:text name='accounts.confirmdelete'/>')">
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