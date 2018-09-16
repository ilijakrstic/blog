
<%@include file="start.jsp" %>
<%@include file="navbar.jsp" %>



<div class="container">
    <form class="mb-3">
        <div class="form-group">
            <label for="comment">Postavi komentar:</label>
            <textarea id="text" class="form-control" rows="5" id="comment"></textarea>
        </div>
        <button type="submit" id="sendComment" class="btn btn-outline-success">Postavi</button>
    </form>

    <c:forEach items="${comments}" var="c">
        <div class="media">

            <img class="align-self-start mr-3" src="${c.getUsers().getPicture()}" alt="Generic placeholder image" style="width: 100px;height: 100px">
            <div class="media-body">
                <h5 class="mt-3 mb-0">${c.getUsers().getUserName()}</h5>
                <span style="margin-bottom: 1em">${c.getCommentTimePassed()}</span>
                <p>${c.getCommentText()}</p>

            </div>
        </div>
    </c:forEach>

    <div id="ja"></div>
</div>

<script>
    


</script>



