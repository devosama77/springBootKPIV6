$( document ).ready(function() {
   // alert("Iam working")
    ajaxGetCountNew();
    ajaxGetCountinf();
    ajaxGetCountClo();
    ajaxGetCountFol();
    ajaxGetCountPro();


    // GET REQUEST
    // $("#getAllSalesByDate").click(function(event){
    //     event.preventDefault();
    //     // alert("Iam working")
    //     ajaxGet();
    // });

    // DO GET Count New
    function ajaxGetCountNew(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/New",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineNew').empty();
                    $('#pipelineNew').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelineNew").append("0");
                    console.log("Fail: ", result);
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineNew").append(window.location);
                console.log("ERROR: ", window.location);
            }
        });
    }
    // information
    function ajaxGetCountinf(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/Information Gathering",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineInf').empty();
                    $('#pipelineInf').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelineInf").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineInf").append("0");
            }
        });
    }

// proposal
    function ajaxGetCountPro(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/Proposal",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelinePro').empty();
                    $('#pipelinePro').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelinePro").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelinePro").append("0");
            }
        });
    }

//    follow up
    function ajaxGetCountFol(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/Follow Up",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineFol').empty();
                    $('#pipelineFol').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelineFol").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineFol").append("0");
            }
        });
    }
    // closing
    function ajaxGetCountClo(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/Closing",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineClo').empty();
                    $('#pipelineClo').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelineClo").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineClo").append("0");
            }
        });
    }
})