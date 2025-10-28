<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<%@ include file="/WEB-INF/header-menu.jsp"%>
<div class="card px-4">
    <div class="row mt-4">
        <div class="col-lg-6 mb-4">
            <div class="card">
                <div class="card-header pb-0 p-3">
                    <h6 class="mb-0"><s:text name="genders" /></h6>
                </div>
                <table class="m-3">
                    <tbody>
                        <tr>
                            <td><div class="genere-img uomo"></div></td>
                            <td width="100%">
                                <div class="d-flex flex-column">
                                    <h6 class="mb-1 text-dark text-sm"><s:text name="genders.man" /></h6>
                                    <span class="text-xs font-weight-bold">
                                    	<s:text name="genders.registered">
                                    		<s:param value="uomo"/>
                                    	</s:text>
                                    </span>
                                </div>
                            </td>
                            <td rowspan="2">
                                <div class="statistiche-chart">
                                    <canvas id="sesso-chart" class="chart-canvas"></canvas>
                                </div>
                            </td> 
                        </tr>
                        <tr>
                            <td><div class="genere-img donna"></div></td>
                            <td>
                                <div class="d-flex flex-column">
                                    <h6 class="mb-1 text-dark text-sm"><s:text name="genders.woman" /></h6>
                                    <span class="text-xs font-weight-bold">
                                    	<s:text name="genders.registered">
                                    		<s:param value="donna"/>
                                    	</s:text>
                                    </span>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-lg-6 mb-4">
            <div class="card">
                <div class="card-header pb-0 p-3">
                    <h6 class="mb-0"><s:text name="devices" /></h6>
                </div>
                <table class="m-3">
                    <tbody>
                        <tr>
                            <td><img class="console-img" style="border-radius: 0px" src="<s:url value='/assets/img/console/pc.jpg' />"></td>
                            <td width="100%">
                                <div class="d-flex flex-column">
                                    <h6 class="mb-1 text-dark text-sm">PC</h6>
                                    <span class="text-xs font-weight-bold">
                                    	<s:text name="devices.requested">
                                    		<s:param value="pc"/>
                                    	</s:text>
                                    </span>
                                </div>
                            </td>
                            <td rowspan="3">
                                <div class="statistiche-chart">
                                    <canvas id="console-chart" class="chart-canvas"></canvas>
                                </div>
                            </td> 
                        </tr>
                        <tr>
                            <td><img class="console-img" src="<s:url value='/assets/img/console/xbox.jpg' />"></td>
                            <td>
                                <div class="d-flex flex-column">
                                    <h6 class="mb-1 text-dark text-sm">Xbox</h6>
                                    <span class="text-xs font-weight-bold">
                                    	<s:text name="devices.requested">
                                    		<s:param value="xbox"/>
                                    	</s:text>
                                    </span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td><img class="console-img" src="<s:url value='/assets/img/console/playstation.jpg' />"></td>
                            <td>
                                <div class="d-flex flex-column">
                                    <h6 class="mb-1 text-dark text-sm">PlayStation</h6>
                                    <span class="text-xs font-weight-bold">
                                    	<s:text name="devices.requested">
                                    		<s:param value="play"/>
                                    	</s:text>
                                    </span>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col-lg-6 mb-4">
            <div class="card">
                <div class="card-header pb-0 p-3">
                    <div class="d-flex justify-content-between">
                        <h6 class="mb-2"><s:text name="members.best" /></h6>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table align-items-center">
                        <thead>
                            <tr>
                                <td></td>
                                <td>
                                    <div class="text-center">
                                        <h6 class="text-sm mb-0"><s:text name="members.member" /></h6>
                                    </div>
                                </td>
                                <td>
                                    <div class="text-center">
                                        <h6 class="text-sm mb-0"><s:text name="members.points" /></h6>
                                    </div>
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="top5" status="stat">
                                <tr>
                                    <td>
                                        <div class="text-center">
                                            <h6 class="text-sm mb-0"><s:property value="#stat.index + 1"/>.</h6>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="text-center">
                                            <h6 class="text-sm mb-0"><s:property value="profilo.nome + ' ' + profilo.cognome"/></h6>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="text-center">
                                            <h6 class="text-sm mb-0"><s:property value="punteggio"/></h6>
                                        </div>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-lg-6 mb-4">
            <div class="card">
                <div class="card-header pb-0 p-3">
                    <div class="d-flex justify-content-between">
                        <h6 class="mb-2"><s:text name="members.loyal" /></h6>
                    </div>
                </div>
                <div class="table-responsive">
                    <table class="table align-items-center">
                        <thead>
                            <tr>
                                <td></td>
                                <td>
                                    <div class="text-center">
                                        <h6 class="text-sm mb-0"><s:text name="members.member" /></h6>
                                    </div>
                                </td>
                                <td>
                                    <div class="text-center">
                                        <h6 class="text-sm mb-0"><s:text name="members.since" /></h6>
                                    </div>
                                </td>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="fedeli5" status="stat">
                                <tr>
                                    <td>
                                        <div class="text-center">
                                            <h6 class="text-sm mb-0"><s:property value="#stat.index + 1"/>.</h6>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="text-center">
                                            <h6 class="text-sm mb-0"><s:property value="profilo.nome + ' ' + profilo.cognome"/></h6>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="col text-center">
                                            <h6 class="text-sm mb-0"><s:property value="membroDal"/></h6>
                                        </div>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/footer.jsp"%>
<script>
    // Chart per console
    new Chart(document.getElementById("console-chart").getContext("2d"), {
        type: 'doughnut',
        options: { plugins: { legend: { display: false } } },
        data: {
            labels: ['PC', 'Xbox', 'PlayStation'],
            datasets: [{
                label: '<s:text name="device"/>',
                data: [<s:property value="pc"/>, <s:property value="xbox"/>, <s:property value="play"/>],
                backgroundColor: ['rgb(0, 0, 0)', 'rgb(16, 124, 16)', 'rgb(0, 112, 209)']
            }]
        }
    });

    // Chart per genere
    new Chart(document.getElementById("sesso-chart").getContext("2d"), {
        type: 'pie',
        options: { 
            plugins: { legend: { display: false } }, 
            elements: { arc: { borderWidth: 0 } } 
        },
        data: {
            labels: ['<s:text name="genders.woman"/>', '<s:text name="genders.man"/>'],
            datasets: [{
                label: '<s:text name="genders"/>',
                data: [<s:property value="donna"/>, <s:property value="uomo"/>],
                backgroundColor: ['rgb(243, 175, 204)', 'rgb(166, 217, 245)']
            }]
        }
    });
</script>