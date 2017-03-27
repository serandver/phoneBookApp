<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="container">

      <form class="form-signin">
        <h2 class="form-signin-heading">Please sign up</h2>
        <div class="form-group">
          <label for="userName" class="sr-only">Login</label>
          <input type="text" class="form-control" id="userName" placeholder="Login" required autofocus>
        </div>
        <div class="form-group">
          <label for="name" class="sr-only">Full name</label>
          <input type="text" class="form-control" id="name" placeholder="Full name" required>
        </div>
        <div class="form-group">
          <label for="inputPassword" class="sr-only">Your password</label>
          <input type="password" id="inputPassword" class="form-control" placeholder="Your password" required>
        </div>
        <div class="form-group">
          <label for="confirmPassword" class="sr-only">Confirm password</label>
          <input type="password" id="inputPassword" class="form-control" placeholder="Confirm password" required>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
