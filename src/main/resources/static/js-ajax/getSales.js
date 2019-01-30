$( document ).ready(function() {

    // GET REQUEST
    $("#getAllSalesNew").click(function(event){
        event.preventDefault();
        // alert("Iam working")
        ajaxGetSalesNew()
    });
    $("#getAllSalesInf").click(function(event){
        event.preventDefault();
        //alert("Iam working")
        ajaxGetSalesInf();
    });
    $("#getAllSalesPro").click(function(event){
        event.preventDefault();
        //alert("Iam working")
        ajaxGetSalesPro();
    });
    $("#getAllSalesFol").click(function(event){
        event.preventDefault();
        //alert("Iam working")
        ajaxGetSalesFol();
    });
    $("#getAllSalesClo").click(function(event){
        event.preventDefault();
        //alert("Iam working")
        ajaxGetSalesClo();
    });
    //.................
    // DO GET
    function ajaxGetSalesNew(){
        $.ajax({
            type : "GET",
            url : window.location + "/mydashboard/sales/New",
            success: function(result){
                if(result.status == "Done"){

                    $( "#salesTable" ).show();
                    $('#saleRow').empty();
                    $.each(result.data, function(i, myData){
                          var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                                    "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                                    "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                                    "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRow').append(data);

                    });
                    $('#inf').empty();
                    $('#inf').html("New");
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
            url : window.location + "/mydashboard/sales/Information Gathering",
            success: function(result){
                if(result.status == "Done"){

                    $( "#salesTable" ).show();
                    $('#saleRow').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRow').append(data);
                    });
                    $('#inf').empty();
                    $('#inf').html("Information Gathering");
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
            url : window.location + "/mydashboard/sales/Proposal",
            success: function(result){
                if(result.status == "Done"){

                    $( "#salesTable" ).show();
                    $('#saleRow').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRow').append(data);
                    });
                    $('#inf').empty();
                    $('#inf').html("Proposal");
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
            url : window.location + "/mydashboard/sales/Follow Up",
            success: function(result){
                if(result.status == "Done"){

                    // var data="<table width=\"100%\" class=\"table table-striped table-bordered table-hover\" id=\"dataTables-allSales\">"+
                    //     "<thead><tr><th>#</th><th>Customer Name</th><th>Contact</th><th>Industry</th><th>CustomerMet</th>\n" +
                    //     "<th>Revenue</th><th>Date</th></tr></thead>";
                    //     $('#salesData').append(data);
                    $( "#salesTable" ).show();
                    $('#saleRow').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRow').append(data);
                    });
                    $('#inf').empty();
                    $('#inf').html("Follow Up");
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
            url : window.location + "/mydashboard/sales/Closing",
            success: function(result){
                if(result.status == "Done"){
                    $( "#salesTable" ).show();
                    $('#saleRow').empty();
                    $.each(result.data, function(i, myData){
                        var data =  "<tr><td>" + i + "</td>" +"<td>"+ myData.customerName +"</td>" +
                            "<td>"+ myData.contact +"</td>" + "<td>" + myData.industry +"</td>"+
                            "<td>"+ myData.customerMet +"</td>" + "<td>" + myData.revenue +"</td>"+
                            "<td>"+ myData.sDate.myDate+"</td></tr> ";


                        $('#saleRow').append(data);
                    });
                    $('#inf').empty();
                    $('#inf').html("Closing");
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