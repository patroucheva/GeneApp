<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Geneious &mdash; Heritability DNA Analysis </title>
	<meta name="viewport" content="width=device-width, initial-scale=1">


	<link href='https://fonts.googleapis.com/css?family=Raleway:400,300,600,400italic,700' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="resources/css/bootstrap.css">
	<link rel="stylesheet" href="resources/css/style.css">
	</head>
	<body>
		
	<div class="gtco-loader"></div>
	
	<div id="page">
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			<div class="row">
				<div class="col-xs-2">
					<div id="gtco-logo"><a href="resources/WEB-INF/index.jsp">Geneious</a></div>
				</div>
				<div class="col-xs-10 text-right menu-1">
					<ul>
						<li class="active"><a href="resources/WEB-INF/index.jsp">Home</a></li>
						<li><a href="resources/WEB-INF/index.jsp">About</a></li>
						<li><a href="resources/WEB-INF/jsp/contact.html">Contact</a></li>
					</ul>
				</div>
			</div>
			
		</div>
	</nav>

	<header id="gtco-header" class="gtco-cover" role="banner" style="background-image:url(resources/images/dna.jpg);">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>Terms and Conditions</h1>
							<div class="well">
								<form:form action="formUpload.html" modelAttribute="termsForm">
									<div align="left" style="margin-bottom: 20px">
										<c:forEach var="error" items="${termsForm.errors}">
											<div class="alert alert-danger">
		  										<strong>&#9888;</strong> ${error}
											</div>
										</c:forEach>
										<ul>
											<li>I understand the report is for research and educational purposes only.</li>
											<li>I understand the report only checks for a limited number of conditions. And that we are not responsible for any birth outcomes outside of and including these conditions.</li>
											<li>I understand that prior to making any reproductive/health decisions I must first confirm the test results by an independent clinically validated test through my doctor.</li>
											<li>I accept the risk of learning that I could be a carrier for a serious disease.</li>
											<li>I acknowledge that this is not a form of medical diagnosis, but merely a method of interpretation of DNA test kits which determine its accuracy.</li>
										</ul>
										<form:checkbox path="allTerms" value="I have read and acknowledge the above terms."/> I have read and acknowledge the above terms.<br>
										<form:checkbox path="termsAndConditions" value="I have read and acknowledge the full "/> I have read and agree to the full <a href="url">Terms and Conditions</a>.<br>
									</div>
									<div align="center">
										<form:button type="submit" class="btn btn-primary" id="agree">I agree</form:button>
										<form:button type="button" class="btn btn-danger" id="disagree">I do not agree</form:button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/main.js"></script>
	</body>
</html>
