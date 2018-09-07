$("#description-input").keydown(function(event) {
    $("#description-help").text(100 - $("#description-input").val().length);
});

$("#title-input").keydown(function(event) {
    $("#title-help").text(70 - $("#title-input").val().length);
});

$("#image-upload-button").click(function(){
   
    console.log($("#image-input").val());
    
});
