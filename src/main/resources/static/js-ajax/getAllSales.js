$( document ).ready(function() {

    // GET REQUEST
    $("#getAllSalesDate").click(function(event){
        event.preventDefault();
       // alert("Iam working")
        ajaxGet();
    });

    // DO GET
    function ajaxGet(){
        $.ajax({
            type : "GET",
            url : window.location + "/Date/all",
            success: function(result){
                if(result.status == "Done"){
                    $('#getResultDiv ul').empty();
                    var custList = "";
                    $.each(result.data, function(i, myDate){
                        var date = "- Date with Id = " + i + ", myDate = " + myDate.myDate + ", Id = " + myDate.id +"<br>";
                        $('#getResultDiv .list-group').append(date);
                        $('.st').append(myDate.status);
                    });
                    console.log("Success: ", result);
                }else{
                    $("#getResultDiv").html("<strong>Error(No Done)</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                $("#getResultDiv").html("<strong>window.location</strong>");
                console.log("ERROR: ", e);
            }
        });
    }
})