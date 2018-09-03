<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="<spring:url value="/resource/style/index.css"/>" rel="stylesheet" type="text/css"/>
        <script type="text/javascript"  src="<spring:url value="/resource/script/jquery-3.3.1.js"/>"></script>

        <title>Blog</title>
    </head>

    <body>


        <%@include file="navbar.jsp" %>

        
        <div class="jumbotron" style="padding: 0px; margin-bottom: 0px;">
            <img src="<spring:url value="/resource/img/BudiNajboljaVerzijaSebe.jpg"/>" style="width: 100%" alt="asds">
        </div>
        
        
        <div class="container" id="content-nav">
            
            <nav class="nav nav-justified">
                <a class="nav-item nav-link active" href="#">BLOG</a>
                <a class="nav-item nav-link" href="#">HOW TO</a>
                <a class="nav-item nav-link" href="#">TEORIJA SVEGA</a>
                <a class="nav-item nav-link disabled" href="#">IT</a>
            </nav>
        </div>

        
        <div class="container" id="content-div" style="padding-top:5%">
            <div class="row" style="text-decoration: none">
                <c:forEach items="${topicList}" var="topic">
                    <a href="topic/${topic.getName()}" >
                        <div class="col-lg-4 col-md-6 col-sm-12 d-flex justify-content-center" style="padding-bottom: 20px">
                            <div class="card text-center" style="width: 16rem;">
                                <img class="card-img-top img-fluid" src="<spring:url value="${topic.getTopicPhoto()}"/>">
                                <div class="card-body">
                                    <h5 class="card-title card-text">${topic.getTitle()} + ${topic.getId()}</h5>
                                    <p class="card-text card-text text-justify">${topic.getDescription()}</p>
                                    <a href="#" style="margin-top:10px" class="btn btn-primary">Vise</a>
                                </div>
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>	
        </div>
        
        <div class="container text-center">
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="index?page=${currentPage-1}">Previous</a></li>
                    <c:forEach begin="${startpage}" end="${endpage}" var="p">
                        <li class="page-item ${p == currentPage?"active":""}" ><a class="page-link" href="index?page=${p}">${p}</a></li>
                    </c:forEach>
                <li class="page-item"><a class="page-link" href="index?page=${currentPage+1}">Next</a></li>
            </ul>
        </div>
        


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<spring:url value="/resource/script/index.js"/>"></script>
    </body>
</html>
