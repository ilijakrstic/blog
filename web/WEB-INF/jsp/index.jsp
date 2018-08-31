<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="<spring:url value="/resource/style/index.css"/>" rel="stylesheet" type="text/css"/>
        <script type="text/javascript"  src="<spring:url value="/resource/script/jquery-3.3.1.js"/>"></script>
        
        <title>Blog</title>
    </head>

    <body>

        
        <nav class="navbar navbar-expand-md navbar-dark bg-dark ">
            <a class="navbar-brand" href="/index">Blog</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapseContent" aria-controls="navbarCollapseContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapseContent" >
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                            <a class="nav-link" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                            <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                            <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
            </div>
	</nav>



        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<spring:url value="/resource/script/index.js"/>"></script>
    </body>
</html>
