
<%@include file="start.jsp" %>
<link href="<spring:url value="style/comment.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%@include file="navbar.jsp" %>



    <div class="container">
        <form class="mb-3" id="forma">
            <div class="form-group">
                <label for="comment">Postavi komentar:</label>
                <textarea id="text" class="form-control" rows="5" id="comment" required="true"></textarea>
            </div>
            <input type="hidden" id="topicId" value="${topic.getId()}">
            <input type="hidden" id="userId" value="2">
            <button type="submit" id="sendComment" class="btn btn-outline-success">Postavi</button>
        </form>

        <div id="new_comm"></div>
        <c:forEach items="${comments}" var="c">
            <div id="media_comment" class="media comment">

                <img class="align-self-start mr-3 user_pict" src="${c.getUsers().getPicture()}" alt="Generic placeholder image">
                <div class="media-body pt-3">
                    <h5  id="userName" class="mt-3 mb-0 user_name">${c.getUsers().getUserName()}</h5>
                    <span class="comm_time">${c.getCommentTimePassed()}</span>
                    <p class="comment-text">${c.getCommentText()}</p>

                    <div class="like_dislike mr-3" id="like">
                        <i class="fas fa-thumbs-up" id="like-thumb"></i> Svidja mi se
                    </div>
                    <div class="like_dislike mr-3" id="dislike">
                        <i class="fas fa-thumbs-down"></i> Ne svidja mi se
                    </div>
                    
                    <a href="#" class="odgovor mt-2 mb-2">Odgovori na komentar</a>
                    <form id="odgovor-forma" class="mb-2">
                    <textarea rows="5" cols="70"></textarea><br/>
                    <button type="submit" class="btn btn-success">Odgovori</button>
                    </form>
                </div>

            </div>
        </c:forEach>
    </div>



    <script src="<spring:url value="script/comment.js"/>"></script>
    <script src="<spring:url value="script/like-dislike.js"/>"></script>

</script>



</script>



