<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="<spring:url value="/resource/style/login.css"/>" rel="stylesheet" type="text/css"/>
        <script type="text/javascript"  src="<spring:url value="/resource/script/jquery-3.3.1.js"/>"></script>

        <title>Login</title>
    </head>

    <body>
        
        
        
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <div id="login-div" class="col-lg-3 col-md-8 col-sm-8">
                    
                    <div id="login-message" class="text-center display-4">
                        <p>Dobrodosli</p>
                    </div>

                    <form id="login-form" class="text-center" action="/blog/login" method="POST">

                        <!-- Error class is for show error after failed login-->
                        <input type="email" name="userEmail" class="form-control" placeholder="E-mail">                 
                        <p id="email-error" class="error">${emailError}</p>
                        
                        <input type="password" name="userPassword" class="form-control" placeholder="Password">          
                        <p id="password-error" class="error">${passwordError}</p>
                        
                        <input type="submit" class="btn btn-success" value="Uloguj se" style="background-color: #2ecc71;">
                        <p></p>
                        
                        <!--TODO add link for forgot password page-->
                        <a href="#">Zaobravio/la si lozinku</a>

                    </form>

                </div>
            </div>
        </div>




        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<spring:url value="/resource/script/login.js"/>"></script>
    </body>
</html>
