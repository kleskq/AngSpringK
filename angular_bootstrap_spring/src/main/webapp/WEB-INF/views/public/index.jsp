<!DOCTYPE html>

<html data-ng-app="app">
	<head>
        <script src="resources/js/jquery/jquery.js"></script>
		<script src="resources/js/angular/angular.js"></script>
		<script src="resources/js/angular/angular-route.js"></script>
		<script src="resources/js/bootstrap/bootstrap.js"></script>
        <script src="resources/js/angular-xeditable/xeditable.js"></script>
        <script src="resources/js/angular-local-storage/angular-local-storage.js"></script>
		<script src="resources/js/custom/app.js"></script>
		<script src="resources/js/custom/config.js"></script>
		<script src="resources/js/custom/listener.js"></script>
        <script src="resources/js/custom/directive.js"></script>
		<script src="resources/js/custom/controller.js"></script>
		<script src="resources/js/custom/service.js"></script>
		<script src="resources/js/custom/menu.js"></script>

		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap/bootstrap-theme.css">
        <link rel="stylesheet" type="text/css" href="resources/css/angular-xeditable/xeditable.css">
		<link rel="stylesheet" type="text/css" href="resources/css/custom/styles.css">
		
		<title data-ng-bind="title">Customer Library</title>
	</head>
	<body data-ng-controller="MainController">

        <!-- Header -->
        <div ng-include src="'resources/html/partials/common/header.html'"></div>
		
		<!-- Menu -->
        <div ng-include src="'resources/html/partials/common/menu.html'"></div>

        <!-- Error -->
        <div ng-include src="'resources/html/partials/common/error.html'"></div>

        <!-- PARTIALS -->
			<div data-ng-view></div>
	</body>
</html>
