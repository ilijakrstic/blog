<%@include file="start.jsp" %>
<link href="<spring:url value="style/readtopic.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%@include file="navbar.jsp" %>


    <!-- main container-->
    <div class="container-fluid mt-5 topic-container">






        <div class="row justify-content-center">
            <!-- topic deo -->
            <div class="col-lg-6 topic">
                <h1  class="mb-2">${topic.getName()}</h1>
                <i class="fas fa-clock mb-3"></i> <span style="font-size: 14px;">${topic.getPublish_date()}</span> 
                <i class="fas fa-user ml-3"></i> <span style="font-size: 14px"> ${topic.getAuthor()}</span>

                <img src="..${topic.getTopicPhoto()}" class="img-fluid mx-auto d-block" />
                <div class="container pt-5 topic-content">
                    <h2 class="mb-3">${topic.getTitle()}</h2>
                    <p >${topic.getContent()}</p>
                </div>

            </div>

            <!-- Povezani clanci -->
            <div class="col-lg-3 mt-5 align-items-center " >


                <div class="card mb-5 ml-5">
                    <h3 class="card-title pt-2 pb-2" style="text-align: center">Povezani clanci</h3>
                    <c:forEach items="${releatedTopics}" var="rel">
                        <div class="card-body ml-4 mr-4" >
                            <img  src="..${rel.getTopicPhoto()}" alt="povezani clanak slika" class="img-fluid mb-3">
                            <p>${rel.getDescription()}</p>
                            <button class="btn btn-outline-success">Saznaj vise</button>
                        </div>
                    </c:forEach>
                </div>


            </div>
        </div>
    </div>

    <%@include file="end.jsp" %>