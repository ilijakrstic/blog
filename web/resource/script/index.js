$(".like").click(function(event){
    
    event.preventDefault();
    
    $(this).css({
        "background-color":"red"
    });
    var topic_id = $(this).attr("data-topic");
    var user_id = getCookie("userid");
    
    $.post( "/blog/topic/like", { user_id: user_id, topic_id: topic_id }, function(data){
        
        console.log('success');
        
    });
    
    
});

function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}