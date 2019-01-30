$( document ).ready(function() {

    // GET REQUEST
    $("#getAllSalesNewL").click(function(event){
        event.preventDefault();
        // alert("Iam working")
        ajaxGetSalesNew()
    });
    $("#getAllSalesInfL").click(function(event){
        event.preventDefault();
        //alert("Iam working")
        ajaxGetSalesInf();
    });
    $("#getAllSalesProL").click(function(event){
        event.preventDefault();
        //alert("Iam working")
        ajaxGetSalesPro();
    });
    $("#getAllSalesFolL").click(function(event){
        event.preventDefault();
        //alert("Iam working")
        ajaxGetSalesFol();
    });
    $("#getAllSalesCloL").click(function(event){
        event.preventDefault();
        //alert("Iam working")
        ajaxGetSalesClo();
    });
    //.................
    // DO GET
    function ajaxGetSalesNew(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/sales/New/lastweek",
            success: function(result){
                if(result.status == "Done"){

                    $( "#salesTableL" ).show();
                    $('#saleRowL').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRowL').append(data);
                    });
                    $('#inf-last-week').empty();
                    $('#inf-last-week').html("New (Last Weeek)");
                    // $('#salesData').append("<tbody></tbody></table>");
                }else{
                    $("#mess").html("<strong>Error(No Done)</strong>");
                }
            },
            error : function(e) {
                $("#mess").html("<strong>Erro Ajax</strong>");
            }
        });
    }
    function ajaxGetSalesInf(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/sales/Information Gathering/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $( "#salesTableL" ).show();
                    $('#saleRowL').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRowL').append(data);
                    });
                    $('#inf-last-week').empty();
                    $('#inf-last-week').html("Information Gathering (Last Weeek)");
                    // $('#salesData').append("<tbody></tbody></table>");
                }else{
                    $("#mess").html("<strong>Error(No Done)</strong>");
                }
            },
            error : function(e) {
                $("#mess").html("<strong>Erro Ajax</strong>");
            }
        });
    }

    function ajaxGetSalesPro(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/sales/Proposal/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $( "#salesTableL" ).show();
                    $('#saleRowL').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRowL').append(data);
                    });
                    $('#inf-last-week').empty();
                    $('#inf-last-week').html("Proposal (Last Weeek)");
                    // $('#salesData').append("<tbody></tbody></table>");
                }else{
                    $("#mess").html("<strong>Error(No Done)</strong>");
                }
            },
            error : function(e) {
                $("#mess").html("<strong>Erro Ajax</strong>");
            }
        });
    }
    function ajaxGetSalesFol(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/sales/Follow Up/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $( "#salesTableL" ).show();
                    $('#saleRowL').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRowL').append(data);
                    });
                    $('#inf-last-week').empty();
                    $('#inf-last-week').html("Follow Up (Last Weeek)");
                    // $('#salesData').append("<tbody></tbody></table>");
                }else{
                    $("#mess").html("<strong>Error(No Done)</strong>");
                }
            },
            error : function(e) {
                $("#mess").html("<strong>Erro Ajax</strong>");
            }
        });
    }
    function ajaxGetSalesClo(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/sales/Closing/lastweek",
            success: function(result){
                if(result.status == "Done"){
                    $( "#salesTableL" ).show();
                    $('#saleRowL').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";
                        $('#saleRowL').append(data);
                    });
                    $('#inf-last-week').empty();
                    $('#inf-last-week').html("Closing (Last Weeek)");
                    // $('#salesData').append("<tbody></tbody></table>");
                }else{
                    $("#mess").html("<strong>Error(No Done)</strong>");
                }
            },
            error : function(e) {
                $("#mess").html("<strong>Erro Ajax</strong>");
            }
        });
    }
})