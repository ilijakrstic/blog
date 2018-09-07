<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html">

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="<spring:url value="/resource/style/newtopic.css"/>" rel="stylesheet" type="text/css"/>
        <script type="text/javascript"  src="<spring:url value="/resource/script/jquery-3.3.1.js"/>"></script>

        <title>Blog</title>
    </head>

    <body>
        <%@include file="navbar.jsp" %>

        <div class="container-fluid ">

            <form action="/blog/topic/newtopic" method="POST" enctype="multipart/form-data">

                <div class="row">

                    <div class="form-group col-lg-4">
                        <label for="title-input">Naslov</label>
                        <input type="text" name="title" maxlength="70" class="form-control" id="title-input" placeholder="Unesi naslov">
                        <small id="title-help" class="form-text text-muted">70</small>
                    </div>

                    <div class="form-group col-lg-4">
                        <label for="kategorija-option">Kategorija</label>
                        <select name="category" class="form-control" id="category-option">
                            <option value="blog">Blog</option>
                            <option value="howto">How to</option>
                            <option value="teorijasvega">Teorija Svega</option>
                            <option value="it">It</option>
                        </select>
                        <small id="category-help" class="form-text text-muted">Odaberite kategoriju</small>
                    </div>

                    <div class="form-group col-lg-4">
                        <label for="subcategory-option">Podkategorija</label>
                        <select name="subcategory" class="form-control" id="subcategory-option">
                            <option value="zivot">Zivot</option>
                            <option value="ljubav">Ljubav</option>
                            <option value="muzika">Muzika</option>
                            <option value="sreca">Sreca</option>
                            <option value="motivacija">Motivacija</option>
                        </select>
                        <small id="subcategory-help" class="form-text text-muted">Izaberi podkategoriju</small>
                    </div>

                    <div class="form-group col-lg-6">
                        <label for="content-input">Sadrzaj teme</label>
                        <textarea name="content" id="content-input" class="form-control" placeholder="Unesi glavni sadrzaj teme" rows="15"></textarea>
                        <small id="content-help" class="form-text text-muted">Unesi sadrzaj teme</small>
                    </div>

                    <div class="container col-lg-6">
                        <div class="form-group col-lg-12">
                            <label for="description-input">Opis</label>
                            <textarea name="description"  maxlength="100" id="description-input" placeholder="Unesite kratak opis teme" class="form-control"></textarea>
                            <small id="description-help" style="display: inline" class="form-text text-muted">100</small>
                        </div>
                           
                        <input type="file" name="fileUpload" size="50" multiple/>                         
                   </div>
            </div>
                
                <input type="hidden" name="author"  value="Ilija Krstic">
                <input type="submit">
            </form>
        </div>





        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="<spring:url value="/resource/script/newtopic.js"/>"></script>
    </body>
</html>