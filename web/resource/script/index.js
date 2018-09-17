$(".like").click(function(event){
    
    event.preventDefault();
    
    $(this).css({
        "background-color":"red"
    });
    console.log($(this).attr("data-topic"));
    console.log($.cookie('userid'));
    console.log("kokieeeee");
    
});
