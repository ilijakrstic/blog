$(document).ready(function () {

    var files;
    

    $("#description-input").keydown(function (event) {
        $("#description-help").text(100 - $("#description-input").val().length);
    });

    $("#title-input").keydown(function (event) {
        $("#title-help").text(70 - $("#title-input").val().length);
    });

    
    
    //Aktivira se na svakoj promeni na input="file" i fajlove stavlja u var files
    $("#file-input").on("change", function (e) {

        files = e.target.files;
        console.log(files);
    });
    
    //kada se klikne na "Sacuvaj Slike" dugme se aktivira
    $("#file-upload-button").click(function(e){
        
        e.preventDefault();
        fileUpload = new FormData();     //kreira se objekat za listu fajlova
        
        
        for (var i = 0; i < files.length; i++) {
            fileUpload.append("fileUpload", files[i]);   //svaki fajl se dodaje u FormData iznad
        }

        
        
        //ajax salje fajlove, ne navoditi dataType jer u ovom slucaju controller treba vratiti STRING, a ajax salje multipart... tako
        //da ce se uvek aktivirati "error"
        $.ajax({
            url:'/blog/topic/upload',
            type: 'POST',
            data: fileUpload,
            cache: false,
            processData: false,
            contentType: false,
            success : function(response) {
                setImagesInDiv(response);   //salje string u kome su imena fajlova u funkciju koja ce obraditi i kreirati slike
            },
            error : function(xhr, status, error) {
               console.log("tyest");
            }
          
            
        });

    });
    
    function setImagesInDiv(response){
 
        
        images = response.split("\\\\");   //deli string na "\\"
        images.pop();  //izbacuje zadnji index u array-u "images" jer je on prazan
        image = "";
        for (var i = 0; i < images.length; i++) {
            image+="<img src=\"img/topic_resources/test/"+images[i]+"\"><br>";
        }
        
        
       $("#imageListDiv").html(image);
        
    }
    
    

});

