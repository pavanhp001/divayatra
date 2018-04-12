<!DOCTYPE html>

<html lang="en" ng-app="crudApp">
    <head>
        <title>${title}</title>
        <link href="css/bootstrap.css" rel="stylesheet"/> 
        <link href="css/app.css" rel="stylesheet"/>
        <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->

	    <!-- Custom fonts for this template -->
	    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
	    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
	
	    <!-- Custom styles for this template -->
	    <link href="css/landing-page.min.css" rel="stylesheet">  
    </head>
    <body>
    
		<nav class="navbar navbar-inverse">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>                        
		      </button>
		      <a class="navbar-brand" href="#">Logo</a>
		    </div>
		    <div class="collapse navbar-collapse" id="myNavbar" ng-controller="UserController">
		      <ul class="nav navbar-nav">
		        <li class="active"><a ui-sref="home1">Home</a></li>
		        <li><a href="#">About</a></li>
		        <li><a href="#">Projects</a></li>
		        <li><a href="#">Contact</a></li>
		        <li><a ui-sref="building">Hotel</a></li>
		        <li><a ui-sref="room">Room</a></li>
		        <li><a href="#!/view1">Owner</a></li>
		        <li><a href="#!/view2">Customer</a></li>
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>

        <div ui-view></div>
        <script src="js/lib/angular.min.js" ></script>
        <script src="js/lib/angular-ui-router.min.js" ></script>
        <script src="js/lib/localforage.min.js" ></script>
        <script src="js/lib/ngStorage.min.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/UserService.js"></script>
        <script src="js/app/UserController.js"></script>
        <script src="js/app/building/BuildingService.js"></script>
        <script src="js/app/building/BuildingController.js"></script>
        <script src="js/app/room/RoomService.js"></script>
        <script src="js/app/room/RoomController.js"></script>
        <script src="js/app/HomeService.js"></script>
        <script src="js/app/HomeController.js"></script>
    </body>
</html>