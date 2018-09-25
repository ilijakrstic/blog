$(document).ready(function () {

    var $offset = 0;

    $(".comments").hide();
    $(".show_more_comms").hide();


    //ucitavnje prvih 10 komentara
    $("#show_comments").click(function (event) {
        event.preventDefault();

        //pozivanje funkcije za izvlacenje 10 komentara
        ajaxCall($offset, "#comms",2);
        $(".show_more_comms").show();
        $offset += 2;

    });

    //ucitavanje dodatnih 10 komentara

    $("#show_10_more").click(function (event) {
        event.preventDefault();
        $("#show_10_more").prop("disabled", true);
        
        ajaxCall($offset, "#comms",2);
        $offset += 2;
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


    //like
    $("#like").click(function (event) {
        like(event);
    });

    //disslike
    $("#disslike").click(function (event) {
        disslike(event);
    });


    $(".odgovor").click(function (event) {
        event.preventDefault();
        $(this).next().slideToggle(700);

    });




});


function ajaxCall(offset, div,maxresult) {
    $.ajax({
        url: "../ajaxcall/getcomments",
        data: {offset: offset, maxresult: maxresult, topicId: $("#topicId").val()},
        type: "GET",
        contentType: 'application/json',

        success: function (comments) {

            $("#show_comments").hide();
            $(".comments").show();

            console.log(comments.length);
                
            if(comments.length < maxresult){
                $("#show_10_more").hide();
                
            }
            $.each(comments, function (i, comment) {
                loadComments(comment, div);
            });
        },
        error: function (resp) {
            console.log(resp);
        }
    });
}

function loadComments(comment, div) {
    console.log(comment.userphoto);
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
    $("<i/>", {
        class: "far fa-thumbs-up"

    }).appendTo("#likes_" + comment.commentId);
    $("<i/>", {
        class: "far fa-thumbs-down ml-3"

    }).appendTo("#likes_" + comment.commentId);
}


function like(event) {

    $(event.target).addClass("liked");
    $(event.target).next().next().removeClass("dissliked");


    //ajax
    /*
     $.ajax({
     headers: {
     'Accept': 'application/json',
     'Content-Type': 'application/json'
     },
     url: "../ajaxcall/postlike",
     contentType: 'application/json',
     
     data: {like: like, commId: $("#commentId").val()},
     
     timeout: 100000,
     success: function (data) {
     
     console.log(data);
     },
     error: function (e) {
     
     console.log("ERROR : ", e.responseText);
     
     },
     done: function (data) {
     console.log(data);
     }
     
     
     });
     */

}

function disslike(event) {
    $(event.target).addClass("dissliked");
    $(event.target).prev().prev().removeClass("liked");
}


