$(document).ready(function () {



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
    $(".like_dislike").click(function (event) {
        var like_dislike = event.target.id;

        if (like_dislike == 'like') {
           $(this).first().addClass("liked");
           $(this).next().first().removeClass("disliked");
           

        } else {
            $(this).first().addClass("disliked");
            $(this).prev().first().removeClass("liked");
        }


    });

    
    $(".odgovor").click(function(event){
        event.preventDefault();
        $(this).next().slideToggle(700);
    });


});



function addNewComment(data) {

    $("#sendComment").removeAttr("disabled");
    $("#text").val("");

    $("#new_comm").addClass("media comment");

    $("<img/>", {
        class: 'align-self-start mr-3 user_pict',
        src: data.userphoto,
        alt: 'new_user_picture'
    }).appendTo("#new_comm");

    $("<div/>", {
        id: "media_body",
        class: "media-body pt-3"
    }).appendTo("#new_comm");

    $("<h5/>", {
        class: "mt-3 mb-0 user_name mr-1",
        text: data.username
    }).appendTo("#media_body");

    $("<span/>", {
        class: "comm_time",
        style: "margin-bottom: 1em",
        text: data.time
    }).appendTo("#media_body");

    $("<p/>", {
        class: "comment-text",
        text: data.text
    }).appendTo("#media_body");

    $("<img/>", {
        id: 'like_btn',
        class: 'like-btn',
        src: 'img/lik.png',
        alt: "like-button"
    }).appendTo("#media_body");
    $("<img/>", {
        id: 'dislike_btn',
        class: 'dislike-btn',
        src: 'img/dislike.png',
        alt: "dislike-button"
    }).appendTo("#media_body");
    $("<a/>", {
        href: "#",
        html: "odgovori"
    }).appendTo("#media_body");
}