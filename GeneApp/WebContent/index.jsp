<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Geneious &mdash; Heritability DNA Analysis</title>
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
							<h1>Geneious</h1>
							<h2>Heritability DNA Analysis</h2>
							<p>
							<form:form action="userAgreement.html">
  								<button type="submit" class="btn btn-primary">Get Started</button>
							</form:form>
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
