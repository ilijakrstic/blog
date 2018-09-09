$(document).ready(function () {

    var files;

    $("#description-input").keydown(function (event) {
        $("#description-help").text(100 - $("#description-input").val().length);
    });

    $("#title-input").keydown(function (event) {
        $("#title-help").text(70 - $("#title-input").val().length);
    });

    
    $("#file-input").on("change", function (e) {

        files = e.target.files;
        console.log(files);
    });

    $("#file-upload-button").click(function(e){
        
        e.preventDefault();
        fileUpload = new FormData();
        
        
        for (var i = 0; i < files.length; i++) {
            fileUpload.append("fileUpload", files[i]);
        }
      
     
      $.ajax({
          url:'/blog/topic/upload',
          type: 'POST',
          data: fileUpload,
           cache: false,
           dataType:"multipart/form-data",
           processData: false,
           contentType: false,
           success:function(data){
               console.log(data + "succes");
               
           }
          
            
        });

    });

});

