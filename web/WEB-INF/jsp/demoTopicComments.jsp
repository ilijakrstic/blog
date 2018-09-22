
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

            <div id="new_comments">
                
            </div>
        <c:forEach items="${comments}" var="c">
            <div id="media_comment" class="media comment">
                
                
                <img class="align-self-center mr-3 user_pict" src="${c.getUsers().getPicture()}" alt="Generic placeholder image">
                <div class="media-body pt-3">
                    <h5  id="userName" class="mt-3 mb-0 user_name">${c.getUsers().getUserName()}</h5>
                    <span class="comm_time">${c.getCommentTimePassed()}</span>
                    <p class="comment-text">${c.getCommentText()}</p>

                  
                    <i class="fas fa-thumbs-up" id="like"></i><span class="mr-3 ml-1 like-dislike-text">12</span> 
                
                   
                    <i class="fas fa-thumbs-down" id="disslike"></i> <span class="mr-3 ml-1 like-dislike-text">3</span> 
                 
                    <input type="hidden" value="${c.getComment_id()}" id="commentId"/>
                    <a href="#" class="odgovor mt-2 mb-2">Odgovori na komentar</a>
                    <form  class="mb-2 odgovor-forma" >
                    <textarea class="mt-1"rows="5" cols="70"></textarea><br/>
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



