<%@include file="start.jsp" %>
<link href="<spring:url value="style/readtopic.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="navbar.jsp" %>


<!-- main container-->
<div class="container-fluid mt-5 topic-container">


    <div class="row justify-content-around">
        <!-- topic deo -->
        <div class="col-md-9 topic">
          
                <h1 style="text-align: center" class="mb-5">${topic.getName()}</h1>

                <img src="..${topic.getTopicPhoto()}" class="img-fluid mx-auto d-block" />
                <div class="container pt-5 topic-content">
                    <h2 class="mb-3">${topic.getTitle()}</h2>
                    <p >${topic.getContent()}</p>
                </div>
     
        </div>
            
                <!-- Povezani clanci -->
            <div class="col-md-2  align-items-center" style="padding-top:3em">
                 <h3 id="releated-header" class="mb-3" style="text-align: center">Povezani clanci</h3>
                <c:forEach items="${releatedTopics}" var="rel">
                <div class="card mb-5">
                    <h3 class="card-title pt-3 " style="text-align: center">${rel.getName()}</h3>
                    <div class="card-body">
                        <img  src="..${rel.getTopicPhoto()}" alt="povezani clanak slika" class="img-fluid mb-3">
                        <p>${rel.getDescription()}</p>
                        <button class="btn btn-outline-success">Saznaj vise</button>
                    </div>
                </div>
       
        </c:forEach>
     </div>
    </div>
</div>

<%@include file="end.jsp" %>