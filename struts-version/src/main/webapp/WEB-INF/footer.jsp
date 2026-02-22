<%@ taglib uri="/struts-tags" prefix="s" %>

<footer class="footer pt-3">
	<div class="container-fluid">
		<div class="row align-items-center justify-content-lg-between">
			<div class="col-lg-6 mb-lg-0 mb-4">
				<div class="copyright text-center text-sm text-muted text-lg-start">
					<s:text name="project_by" /> © <script>document.write(new Date().getFullYear())</script>
				</div>
			</div>
			<div class="col-lg-6">
				<ul class="nav nav-footer justify-content-center justify-content-lg-end">
					<li class="nav-item"><a
						href="https://www.creative-tim.com/product/argon-dashboard"
						class="nav-link text-muted" target="_blank">Argon Dashboard</a></li>
					<li class="nav-item"><a href="https://www.creative-tim.com"
						class="nav-link text-muted" target="_blank">Creative Tim</a></li>
				</ul>
			</div>
		</div>
	</div>
</footer>
</div>
</main>
<!--   Core JS Files   -->
<script src="<s:url value='/assets/js/core/popper.min.js' />"></script>
<script src="<s:url value='/assets/js/core/bootstrap.min.js' />"></script>
<script src="<s:url value='/assets/js/plugins/perfect-scrollbar.min.js' />"></script>
<script src="<s:url value='/assets/js/plugins/smooth-scrollbar.min.js' />"></script>
<script src="<s:url value='/assets/js/plugins/chartjs.min.js' />"></script>
<script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>
<!-- Github buttons -->
<!--<script async defer src="https://buttons.github.io/buttons.js"></script>-->
<!-- Control Center for Soft Dashboard: parallax effects, scripts for the example pages etc -->
<script src="<s:url value='/assets/js/argon-dashboard.min.js?v=2.0.4' />"></script>


<script> /*modifiche penna */
	//trovato su https://getbootstrap.com/docs/5.0/components/alerts/
	//modificato perchè va a null
	const alertNodes = [...document.querySelectorAll('.alert')]; 
	for (const alertNode of alertNodes) {
		const alert = new bootstrap.Alert(alertNode);
		//ho messo chiusura automatica dopo 7.5 secondi
		setTimeout(function () { alert.close(); }, 7500);
	}
</script>
</body>
</html>