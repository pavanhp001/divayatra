<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/>
        <link href="css/app.css" rel="stylesheet"/>
        
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    	<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    </head>

  <body>
 
     <!-- Navigation -->
	    <nav class="navbar navbar-light bg-light static-top">
	      <div class="container">
	        <a class="navbar-brand" href="#">Start Bootstrap</a>
	        <a class="navbar-brand" ui-sref="building">Hotel</a>
		    <a class="navbar-brand" ui-sref="room">Room</a>
	        <a class="btn btn-primary" href="#">Sign In</a>
	      </div>
	    </nav>

        <div ui-view></div>
        <script src="${contextPath}/js/lib/angular.min.js"  charset="UTF-8"></script>
        <script src="${contextPath}/js/lib/angular-ui-router.min.js"  charset="UTF-8"></script>
        <script src="${contextPath}/js/lib/localforage.min.js"  charset="UTF-8"></script>
        <script src="${contextPath}/js/lib/ngStorage.min.js"  charset="UTF-8"></script>
        <script src="${contextPath}/js/lib/bootstrap-datetimepicker.js"  charset="UTF-8" ></script>
        <script src="${contextPath}/js/app/customer/CustApp.js"  charset="UTF-8"></script>
        <script src="${contextPath}/js/app/customer/CustController.js"  charset="UTF-8"></script>
        <script src="${contextPath}/js/app/customer/CustService.js"  charset="UTF-8"></script>
        <script  src="${contextPath}/jquery/jquery-1.8.3.min.js" charset="UTF-8"></script>
		<script  src="${contextPath}/js/lib/bootstrap.min.js"  charset="UTF-8"></script>
		<script  src="${contextPath}/js/lib/bootstrap-datetimepicker.js" charset="UTF-8"></script>

    </body>
</html>