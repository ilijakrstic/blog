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
        <nav class="navbar navbar-expand-md navbar-dark bg-dark ">
            <a class="navbar-brand" href="/index">BLOG</a>
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
                        <a class="nav-link" href="#">Contact us`</a>
                    </li>
                </ul>
                ${profileOption}
            </div>
        </nav>

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
        
        <div class="container text-center" style="margin-top:2%">
            <a href="/blog/index?subcategory=zivot" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Zivot</a>
            <a href="/blog/index?subcategory=ljubav" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Ljubav</a>
            <a href="/blog/index?subcategory=muzika" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Muzika</a>
            <a href="/blog/index?subcategory=umetnost" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Umetnost</a>
            <a href="/blog/index?subcategory=filmovi" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Filmovi</a>
            <a href="/blog/index?subcategory=poznati" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Poznati</a>
            <a href="/blog/index?subcategory=zanimljivosti" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Zanimljivosti</a>
            <a href="/blog/index?subcategory=mladi" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Mladi</a>
             <a href="/blog/index?subcategory=gejming" class="btn btn btn-outline-success subcategory btn-sm" role="button" >Gejming</a>
        </div>

                            


        <div class="container-fluid">
            <div class="row" style="margin-top:2%">
                <div class="container d-flex justify-content-center text-center col " id="content-div" style="margin:0px">
                    <div class="row" style="text-decoration: none">
                        <c:forEach items="${topicList}" var="topic">
                            <a href="/blog/topic/${topic.getCategory()}/${topic.getSubCategory()}/${topic.getId()}" >
                                <div class="col-lg-12 col-md-6 col-sm-12 d-flex  justify-content-center" style="padding-bottom: 20px">
                                    <div class="card text-center text-justify" style="width: 19rem; height: 25rem">
                                        <img class="card-img-top img-fluid" src="<spring:url value="${topic.getTopicPhoto()}"/>">
                                        <div class="card-body">
                                            <h5 class="card-title card-text">${topic.getTitle()} + ${topic.getId()}</h5>
                                            <p class="card-text card-text text-justify">${topic.getDescription()}</p>
                                            <span><button type="button" class="like" data-topic="${topic.getId()}">LIKE</button></span>
                                        </div>
                                    </div>
                                </div>
                            </a>                                     
                        </c:forEach>
                    </div>	
                </div>
                <div class="container col col-lg-3"
                     <div  class="card">
                        <div id="social-card" class="card-body">
                            <div class="container text-center">
                                <h6>Zapratite nas na drustvenim mrezama</h6>
                                <img class="social-icon" src="<spring:url value="/resource/img/facebook.png"/>"/>
                                <img class="social-icon" src="<spring:url value="/resource/img/instagram.png"/>"/>
                                <img class="social-icon" src="<spring:url value="/resource/img/youtube.png"/>"/> 
                                <br>
                                <hr>
                                <h6>SPONSORED ADS</h6>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container text-center d-flex justify-content-center">
                    <ul class="pagination">
                        <li class="page-item"><a class="page-link" href="blog/index?page=${currentPage-1}">Previous</a></li>
                            <c:forEach begin="${startpage}" end="${endpage}" var="p">
                            <li class="page-item ${p == currentPage?"active":""}" ><a class="page-link" href="blog/index?page=${p}">${p}</a></li>
                            </c:forEach>
                        <li class="page-item"><a class="page-link" href="blog/index?page=${currentPage+1}">Next</a></li>
                    </ul>
                </div>

            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<spring:url value="/resource/script/index.js"/>"></script>
    </body>
</html>
