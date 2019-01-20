<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Une page generant une citation aleatoire</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-2.2.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Citation</h1>
			<p class="lead" style="height: 150px">
				<span>${quote.content}</span> <br /> <span
					style="font-style: italic;">${quote.author}</span>
			</p>
			<div class="btn-group" role="group">
				<c:choose>
					<c:when test="${quote.first}">
						<a role="button" class="btn btn-lg btn-success disabled">Premiere
							citation</a>
					</c:when>
					<c:otherwise>
						<a role="button"
							href="${pageContext.request.contextPath}/displayQuote/${quote.firstIndex}"
							class="btn btn-lg btn-success">Premiere citation</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${quote.hasPrevious}">
						<a role="button"
							href="${pageContext.request.contextPath}/displayQuote/${quote.previousIndex}"
							class="btn btn-lg btn-success">Citation precedente</a>
					</c:when>
					<c:otherwise>
						<a role="button" class="btn btn-lg btn-success disabled">Citation
							precedente</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${quote.hasNext}">
						<a role="button"
							href="${pageContext.request.contextPath}/displayQuote/${quote.nextIndex}"
							class="btn btn-lg btn-success">Citation suivante</a>
					</c:when>
					<c:otherwise>
						<a role="button" class="btn btn-lg btn-success disabled">Citation
							suivante</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${quote.hasNotLastQuote}">
						<a role="button" class="btn btn-lg btn-success disabled">Derniere
							citation</a>
					</c:when>
					<c:otherwise>
						<a role="button"
							href="${pageContext.request.contextPath}/displayQuote/${quote.lastIndex}"
							class="btn btn-lg btn-success">Derniere citation</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</body>
</html>