<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- UTF-8 -->
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- AutoRefresh -->
		<meta http-equiv="refresh" content="10">
		<!-- Import for JQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!-- Import for AngularJS -->
		<script src="/WS-MASTERE-IS/assets/libs/angular.min.js"></script>
		<!-- Import Monitor.js -->
		<script src="/WS-MASTERE-IS/assets/scripts/monitor.js"></script>
		<script>
		
			$(document).ready(function(){
				
// 				$("#monitorTable").
				
			});
		
		</script>
		<!-- Title -->
		<title>Ing�Sup - Monitor</title>
	</head>

	<header>
		JEE Mast�re Ing�Sup Header
	</header>

<ul>
	<c:forEach items="${model}" var="park">
		<li><a href = "/WS-MASTERE-IS/park?idPark=${park.id}">Park : ${park.roomIds}</a></li>
	</c:forEach>
</ul>