
<%@include file="start.jsp" %>
<link href="<spring:url value="style/comment.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%@include file="navbar.jsp" %>


    <div class="container">
        <a href="#" id="show_comments">Komentari</a>
    </div>

    <div class="container comments justify-content-center">
        <div class="row">
            <div class="col-md-6">
                <form class="mb-3" id="forma">
                    <div class="form-group">
                        <label for="comment">Postavi komentar:</label>
                        <textarea id="text" class="form-control" rows="3" id="comment" required="true"></textarea>
                    </div>
                    <input type="hidden" id="topicId" value="${topic.getId()}">
                    <input type="hidden" id="userId" value="2">
                    <button type="submit" id="sendComment" class="btn btn-outline-success">Postavi</button>
                </form>

                <div id="new_comm">

                </div>
                <div id="comms">

                </div>
                <div class="show_more_comms row justify-content-center mt-2">
                    <div class="col-md-6">
                        <button class="btn btn-outline-success" id="show_10_more">Prikazi jos komentara</button>
                    </div>
                </div>
            </div>
        </div>
    </div>



    <script src="<spring:url value="script/comment.js"/>"></script>
    <script src="<spring:url value="script/like-dislike.js"/>"></script>

</script>



</script>



