$( document ).ready(function() {

    // GET REQUEST
    $("#getAllSalesByDate").click(function(event){
        event.preventDefault();
        // alert("Iam working")
        ajaxGet();
    });

    // DO GET
    function ajaxGet(){
        var d=$("#searchDate").val();
        $.ajax({
            type : "GET",
            url : window.location + "/sale/"+d,
            success: function(result){
                if(result.status == "Done"){
                    $('#getResultDate ul').empty();
                    var custList = "";
                    $.each(result.data, function(i, myDate){
                        var date = "- Date with Id = " + i + ", Date = " + myDate.customerName + ", Id = " + myDate.id +"<br>";
                        $('#getResultDate .list-group-sales').append(date);
                        $('.sales').append(myDate.status);
                    });
                    console.log("Success: ", result);
                }else{
                    $("#getResultDate").html("<strong>Error</strong>");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#getResultDate").append("Error: "+e);
                console.log("ERROR: ", e);
            }
        });
    }
})