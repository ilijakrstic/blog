<%@include file="start.jsp" %>
<%@include file="navbar.jsp" %>


<!-- main container-->
<div class="container-fluid mt-5 topic-container">


    <div class="row justify-content-around">
        <!-- topic deo -->
        <div class="col-md-9" >
            <h1 style="text-align: center" class="mb-5">${topic.getName()}</h1>
            <img src="..${topic.getTopicPhoto()}" class="img-fluid"/>
            <div class="container pt-5 topic-content">
                <h2 class="mb-3">${topic.getTitle()}</h2>
                <p >${topic.getContent()}</p>
            </div>
            
        </div>

        <!-- Povezani clanci -->
        <div class="col-md-2 align-items-center" style="padding-top:3em">
            <h3 id="releated-header" class="mb-3" style="text-align: center">Povezani clanci</h3>
            <div class="card">
                <h3 class="card-title pb-2 pt-3" style="text-align: center">${topic.getName()}</h3>
                

                <div class="card-body">
                    <img  src="..${topic.getTopicPhoto()}" alt="povezani clanak slika" class="img-fluid mb-3">
                    <p>Ovde ce da ide samo jedan kratak deo iz texta pa onda 3 tackice..To cu da sredim ;)</p>
                    <button class="btn btn-danger">Saznaj vise</button>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="end.jsp" %>