$(document).ready(function () {

    var $offset = 0;
    var $maxresult = 5;

    $(".comments").hide();
    $(".show_more_comms").hide();


    //ucitavnje prvih 10 komentara
    $("#show_comments").click(function (event) {
        event.preventDefault();

        //pozivanje funkcije za izvlacenje 10 komentara
        ajaxCall($offset, "#comms", $maxresult);
        $(".show_more_comms").show();
        $offset += 5;

    });

    //ucitavanje dodatnih 10 komentara

    $("#show_10_more").click(function (event) {
        event.preventDefault();
        $("#show_10_more").prop("disabled", true);

        ajaxCall($offset, "#comms", $maxresult);
        $offset += 5;
        $("#show_10_more").prop("disabled", false);
    });

    //postavljanje novog komentara
    $("#forma").submit(function (event) {

        event.preventDefault();



        $("#sendComment").prop("disabled", true);

        $.ajax({

            url: "../ajaxcall/postcomment",
            data: {topicId: $("#topicId").val(), text: $("#text").val()},
            contentType: 'application/json',

            success: function (comment) {

                loadComments(comment, "#new_comm");
                $("#text").val("");
                $("#sendComment").prop("disabled", false);

            },
            error: function (e) {

                console.log("ERROR : ", e.responseText);
                $("#btn-search").prop("disabled", false);
            },
            done: function (data) {
                $("#btn-search").prop("disabled", false);
            }


        });

    });





});


function ajaxCall(offset, div, maxresult) {
    $.ajax({
        url: "../ajaxcall/getcomments",
        data: {offset: offset, maxresult: maxresult, topicId: $("#topicId").val()},
        type: "GET",
        contentType: 'application/json',

        success: function (comments) {

            $("#show_comments").hide();
            $(".comments").show();

            console.log(comments.length);

            if (comments.length < maxresult) {
                $("#show_10_more").hide();

            }
            $.each(comments, function (i, comment) {
                console.log("comm id: " + comment.commentId + " likes: " +comment.likes+ " disslikes : " +comment.disslikes);
                loadComments(comment, div);
            });
        },
        error: function (resp) {
            console.log(resp);
        }
    });
}

function loadComments(comment, div) {
    
    $("<div/>", {
        id: "comment_" + comment.commentId,
        class: "container comment"

    }).appendTo(div);
    $("<div/>", {
        id: "comment-row_" + comment.commentId,
        class: "row justify-content-start comment-row"

    }).appendTo("#comment_" + comment.commentId);
    $("<img/>", {
        src: comment.userphoto,
        class: "user-pict mr-2 rounded"
    }).appendTo("#comment-row_" + comment.commentId);
    $("<div/>", {
        id: "comm-col_" + comment.commentId,
        class: "col-10"
    }).appendTo("#comment-row_" + comment.commentId);
    $("<div/>", {
        id: "row_user_" + comment.commentId,
        class: "row user"
    }).appendTo("#comm-col_" + comment.commentId);
    $("<a/>", {
        href: "/blog/user/" + comment.username,
        class: "mr-1",
        text: comment.username
    }).appendTo("#row_user_" + comment.commentId);
    $("<span/>", {
        class: "comm_time",
        text: comment.time
    }).appendTo("#row_user_" + comment.commentId);
    $("<div/>", {
        id: "row-comment-text" + comment.commentId,
        class: "row comment-text"
    }).appendTo("#comm-col_" + comment.commentId);
    $("<p/>", {
        class: "comment-text",
        text: comment.text
    }).appendTo("#row-comment-text" + comment.commentId);
    $("<div/>", {
        id: "likes_" + comment.commentId,
        class: "row"
    }).appendTo("#comm-col_" + comment.commentId);
    $("<span/>", {
        id:"numb_of_likes_"+comment.commentId,
        class:"comment_likes mr-1",
        text:comment.likes
    }).appendTo("#likes_" + comment.commentId);
    $("<i/>", {
        id: "like",
        class: "far fa-thumbs-up mr-2"
        , onclick: "like(event)"
    }).appendTo("#likes_" + comment.commentId);

    $("<span/>", {
        id:"numb_of_disslikes_"+comment.commentId,
        class:"comment_likes mr-1",
        text:comment.disslikes
    }).appendTo("#likes_" + comment.commentId);
    $("<i/>", {
        id: "disslike",
        class: "far fa-thumbs-down"
        , onclick: "like(event)"
    }).appendTo("#likes_" + comment.commentId);
    $("<input/>", {
        type: "hidden",
        value: comment.commentId
    }).appendTo("#likes_" + comment.commentId);
}


function like(event) {
    var $commId = $(event.target).parent().children().last().val();
    switch (event.target.id) {
        case "like":
            
            likeAjaxCall(1, $commId, event);

            break;
        case "disslike":

            likeAjaxCall(-1, $commId, event);

            break;
    }

}

function likeAjaxCall(value, commentId, event) {
    $.ajax({
        url: "../ajaxcall/postlike",
        data: {like: value, commId: commentId},
        type: "GET",
        contentType: 'application/json',

        success: function (likes) {
            switch (event.target.id) {
                case "like":
                    $(event.target).addClass("liked");
                    $(event.target).next().next().removeClass("dissliked");
                    $("#numb_of_likes_"+likes.commentId).html(likes.likes);
                    console.log(likes.commentId);
                    console.log(likes.likes);
                    break;
                case "disslike":
                    $(event.target).addClass("dissliked");
                    $(event.target).prev().prev().removeClass("liked");
                    $("#numb_of_disslikes_"+likes.commentId).html(likes.disslikes);
                    console.log(likes.commentId);

                    break;
            }
        },

        error: function (resp) {
            console.log(resp);
        }
    });
}





