$( document ).ready(function(event) {
   // alert("Iam working")
   // event.preventDefault();
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

    // function formatDate(date) {
    //     var d = new Date(date),
    //         month = '' + (d.getMonth() + 1),
    //         day = '' + d.getDate(),
    //         year = d.getFullYear();
    //
    //     if (month.length < 2) month = '0' + month;
    //     if (day.length < 2) day = '0' + day;
    //
    //     return [year, month, day].join('-');
    // }
    function ajaxGetCountNew(){
        // var s= formatDate(new Date());
        // console.log(s);
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/New/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineNewL').empty();
                    $('#pipelineNewL').append(result.data);
                }else{
                    $("#pipelineNewL").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineNewL").append("0");
                console.log("ERROR: ", e);
            }
        });
    }
    // information
    function ajaxGetCountinf(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/Information Gathering/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineInfL').empty();
                    $('#pipelineInfL').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelineInfL").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineInfL").append("0");
            }
        });
    }

// proposal
    function ajaxGetCountPro(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/Proposal/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineProL').empty();
                    $('#pipelineProL').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelineProL").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineProL").append("0");
            }
        });
    }

//    follow up
    function ajaxGetCountFol(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/Follow Up/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineFolL').empty();
                    $('#pipelineFolL').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelineFolL").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineFolL").append("0");
            }
        });
    }
    // closing
    function ajaxGetCountClo(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/Closing/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $('#pipelineCloL').empty();
                    $('#pipelineCloL').append(result.data);
                    console.log("Success: ", result);
                }else{
                    $("#pipelineCloL").append("0");
                }
            },
            error : function(e) {
                //$("#getResultDate").html("<strong>Error</strong>");
                $("#pipelineCloL").append("0");
            }
        });
    }
})