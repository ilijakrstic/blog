$(document).ready(function () {


    //postavljanje novog komentara
    $("#forma").submit(function (event) {

        event.preventDefault();

        var poruka = {};
        poruka["userId"] = $("#userId").val();
        poruka["topicId"] = $("#topicId").val();
        poruka["text"] = $("#text").val();



        $("#sendComment").prop("disabled", true);

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "../ajaxcall/postcomment",
            contentType: 'application/json',
            method: "POST",
            data: JSON.stringify(poruka),

            timeout: 100000,
            success: function (data) {

                addNewComment(data);
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



function addNewComment(data) {

    $("#sendComment").removeAttr("disabled");
    $("#text").val("");


    $("<div/>", {
        id: "comment_" + data.commentId,
        class: "media comment"
    }).appendTo("#new_comments");

    $("<img/>", {
        src: data.userphoto,
        class: "align-self-center mr-3 user_pict"
    }).appendTo("#comment_" + data.commentId);

    $("<div/>", {
        id: "comment_body" + data.commentId,
        class: "media-body pt-3"

    }).appendTo("#comment_" + data.commentId);
    $("<h5/>", {
        class: "mt-3 mb-0 user_name mr-1",
        text: data.username
    }).appendTo("#comment_body" + data.commentId);
    $("<span/>", {
        class: "comm_time",
        text: data.time
    }).appendTo("#comment_body" + data.commentId);
  
    $("<p/>", {
        class: "comment-text",
        text: data.text
    }).appendTo("#comment_body" + data.commentId);

    


}//kraj new commenta



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