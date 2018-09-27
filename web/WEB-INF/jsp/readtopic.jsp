<%@include file="start.jsp" %>
<link href="<spring:url value="style/readtopic.css"/>" rel="stylesheet" type="text/css"/>
<link href="<spring:url value="style/comment.css"/>" rel="stylesheet" type="text/css"/>

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


                <div class="container mb-5">
                    <a href="#" id="show_comments">Komentari</a>
                </div>

                <div class="container comments justify-content-center mb-3">


                    <form class="mb-5" id="forma">
                        <div class="form-group">
                            
                            <textarea id="text" class="form-control" rows="1" id="comment" required="true" placeholder='postavi komentar' <c:if test = "${!login}">
                                      readonly="true" 
                                </c:if>></textarea>
                        </div>
                        <input type="hidden" id="topicId" value="${topic.getId()}">

                        <button type="submit" id="sendComment" class="btn btn-success float-right"<c:if test = "${!login}">
                                style='display:none'
                            </c:if>>Postavi</button>
                        <c:if test = "${!login}">
                            <span>Da bi ste postavili komentar morate biti <button onclick="location.href='/blog/login'"  class="btn btn-success btn-sm ml-1 mr-1">Ulogovani</button> 
                               </span>
                            </c:if>
                    </form>

                    <div id="new_comm">

                    </div>
                    <div id="comms">

                    </div>
                    <div class="show_more_comms row justify-content-center mt-2">
                        <div class="col-md-2">
                            <button class="btn btn-outline-success" id="show_10_more">Prikazi jos komentara</button>
                        </div>
                    </div>


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
    <script src="<spring:url value="script/comment.js"/>"></script>
    <%@include file="end.jsp" %>