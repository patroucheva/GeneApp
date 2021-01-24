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
	
	<style>
		
		a.risk {
			color: #ff0000;
		}
		
		a.risk:hover {
  			color: #ff0000;
		}
		
		a.common {
			color: #009933;
		}
		
		a.common:hover {
			color: #009933;
		}
		
		a.unchecked {
			color: black;
		}
		
		a.unchecked:hover {
			color: black;
		}
		
	</style>
	
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

	<header id="gtco-header" class="gtco-cover" role="banner" style="background-image:url(resources/images/dna.jpg);" data-spy="affix">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>We've Analyzed Your DNA.</h1>
							<div class="panel-group" id="accordion">
							  <div class="panel panel-danger">
							    <div align="left" class="panel-heading">
							      <h4 class="panel-title">
							        <a class="risk" data-toggle="collapse" data-parent="#accordion" href="#collapse1">
							        Genetic Risks <span id="riskBadge" class="badge"></span></a>
							      </h4>
							    </div>
							    <div id="collapse1" class="panel-collapse collapse">
							      <div class="panel-body">
							      <ul class="list-group">
							      	<c:forEach var="result" items="${results}">
								  		<c:if test = "${result.result.atRisk && result.result.ableToCheck}">
											<li class="list-group-item">
		    									<div align="left">
		    										<h4 style="color: #ff0000;">${result.disorderName}: ${result.geneName}</h4>
		    										<h4>Location: ${result.location} | Risk Allele: ${result.riskAllele}</h4>
		    										<h4>Possible Outcomes:<c:forEach var="outcome" items="${result.result.alleleCombinations}"> ${outcome}</c:forEach></h4>
		    										<button data-toggle="collapse" data-target="#explanation1">What Does This Mean?</button>
													<div id="explanation1" class="collapse">
														<hr>
														<h4>Your child has a 25% chance of inheriting of a type of ${result.disorderName} found at gene ${result.geneName}, a 25% of not inheriting, and a 50% chance of being a carrier for the disorder like yourselves.</h4>
														<h4>Learn more about Hemochromatosis<a href="#"> here</a>. Or find out about your <a href="#">next steps</a>.</h4>
													</div>
		    									</div>
	    									</li>
	    									<br>
										</c:if>
									</c:forEach>
							      </ul>
							      </div>
							    </div>
							  </div>
							  <div class="panel panel-success">
							    <div align="left" class="panel-heading">
							      <h4 class="panel-title">
							        <a class="common" data-toggle="collapse" data-parent="#accordion" href="#collapse2">
							        No Identified Risks <span id="commonBadge" class="badge"></span></a>
							      </h4>
							    </div>
							    <div id="collapse2" class="panel-collapse collapse in">
							      <div class="panel-body">
								      <ul class="list-group">
								      	<c:forEach var="result" items="${results}">
									  		<c:if test = "${!result.result.atRisk && result.result.ableToCheck}">
												<li class="list-group-item">
			    									<div align="left">
			    										<h4 style="color: #009933;">${result.disorderName}: ${result.geneName}</h4>
			    										<h4>Location: ${result.location} | Risk Allele: ${result.riskAllele}</h4>
			    										<h4>Possible Outcomes:<c:forEach var="outcome" items="${result.result.alleleCombinations}"> ${outcome}</c:forEach></h4>
			    										<button data-toggle="collapse" data-target="#${result.geneName}">What Does This Mean?</button>
														<div id="${result.geneName}" class="collapse">
															<hr>
															<h4>Your child does not appear to be at risk for a type of ${result.disorderName} at gene ${result.geneName}, one of several possible forms of the disorder, based on the text files you submitted. Review our Terms and Conditions <a href="#">here</a>
															, or learn more about <a href="#">${result.disorderName}</a></h4>
														</div>
			    									</div>
		    									</li>
		    									<br>
											</c:if>
										</c:forEach>
								      </ul>
							      </div>
							    </div>
							  </div>
							  <div class="panel panel-default">
							    <div align="left" class="panel-heading">
							      <h4 class="panel-title">
							        <a class="unchecked" data-toggle="collapse" data-parent="#accordion" href="#collapse3">
							        Unable to Check For (Not Included in DNA Text Files)</a>
							      </h4>
							    </div>
							    <div id="collapse3" class="panel-collapse collapse">
							      <div class="panel-body">
							      	<ul class="list-group">
								      	<c:forEach var="result" items="${results}">
									  		<c:if test = "${!result.result.atRisk && result.result.ableToCheck}">
												<li class="list-group-item">
			    									<div align="left">
			    										<h4 style="color: black;">${result.disorderName}: ${result.geneName}</h4>
			    										<h4>Location: ${result.location} | Risk Allele: ${result.riskAllele}</h4>
			    										<h4>Possible Outcomes:<c:forEach var="outcome" items="${result.result.alleleCombinations}"> ${outcome}</c:forEach></h4>
			    									</div>
		    									</li>
		    									<br>
											</c:if>
										</c:forEach>
								      </ul>
							      </div>
							    </div>
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	
	
	<script type="text/javascript">
		
		document.getElementById('riskBadge').innerHTML = ${riskCount};
		document.getElementById('commonBadge').innerHTML = ${commonCount};
		
	</script>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/main.js"></script>

	</body>
</html>
