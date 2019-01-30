package org.osama.kpi.controllers;


import org.osama.kpi.message.Response;
import org.osama.kpi.model.SDate;
import org.osama.kpi.model.Sale;
import org.osama.kpi.services.SDateService;
import org.osama.kpi.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class RestSaleController {
    @Autowired
    SaleService saleService;
    @Autowired
    SDateService sDateService;


    @RequestMapping("/Date/all")
    public Response getAllDates(){
        List<SDate> allSaleDates = sDateService.getAllSDates();
        Response response = new Response("Done", allSaleDates);
        return response;
    }

    @RequestMapping(value = "Date/{NewDate}",method = RequestMethod.POST)
    public Response addSale(@PathVariable String NewDate) throws ParseException {
        Date date=new SimpleDateFormat("dd-MM-yyyy").parse(NewDate);
        SDate sDate=new SDate();
        sDate.setMyDate(date);
        sDateService.addSaleDate(sDate);
        Response response=new Response("Done",sDate);
        return response;
    }

//    Sales .........


    @RequestMapping("/sale/{myDate}")
    public Response getAllSales(@PathVariable String myDate) throws ParseException {
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(myDate);
        List<Sale> listSales =saleService.getLastSalesByDate(date);
        Response response = new Response("Done", listSales);
        return response;
    }


    //    Sale ..................................
    @RequestMapping("sale/all")
    public Response findAllSales()  {
        List<Sale> listSales =saleService.getAllSales();
        Response response = new Response("Done", listSales);
        return response;
    }

    @RequestMapping(value = "sale/{myDate}/add",method = RequestMethod.POST)
    public Response addSale(@RequestBody Sale sale, @PathVariable String myDate) throws ParseException {
        Date date=new SimpleDateFormat("dd-MM-yyyy").parse(myDate);
        SDate sDate=new SDate();
        sDate.setMyDate(date);
        sDateService.addSaleDate(sDate);
        saleService.addSale(sale,sDate.getId());
        Response response=new Response("Done",sale);
        return response;
    }

    @RequestMapping("mydashboard/{pipeline}")
    public Response getCountPipeline(@PathVariable String pipeline, Model model){
        long countByPipeline=0;
        if(pipeline!=null){
            countByPipeline = saleService.getCountByPipeline(pipeline);
        }
        String countString= String.valueOf(countByPipeline);
        Response response=new Response("Done",countString);
        return response;
    }
    @RequestMapping("mydashboard/sales/{pipeline}")
    public Response getPipeline(@PathVariable String pipeline, Model model){
        List<Sale> salesByPipeline =new ArrayList<>();
        if(pipeline!=null){
           salesByPipeline = saleService.getSalesByPipeline(pipeline);
        }
        Response response=new Response("Done",salesByPipeline);
        return response;
    }
    // get count by pipeline in the last week
    @RequestMapping("mydashboard/{pipeline}/lastweek")
    public Response getCountPipelineLastWeek(@PathVariable String pipeline , Model model) throws ParseException {
        long countByPipeline=0;
        LocalDateTime nowMinusWeek = LocalDateTime.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = nowMinusWeek.format(formatter);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(formatDateTime);
        if(pipeline!=null){
            countByPipeline = saleService.getCountLastWeekByPipeline(pipeline,date);
        }
        String countString= String.valueOf(countByPipeline);
        Response response=new Response("Done",countString);
        return response;
    }
    // get all sales by pipeline in the last week
    @RequestMapping("mydashboard/sales/{pipeline}/lastweek")
    public Response getPipelineLastweek(@PathVariable String pipeline, Model model) throws ParseException {
        LocalDateTime nowMinusWeek = LocalDateTime.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = nowMinusWeek.format(formatter);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(formatDateTime);
        List<Sale> salesByPipeline =new ArrayList<>();
        if(pipeline!=null){
            salesByPipeline = saleService.getSalesLastWeekByPipeline(pipeline,date);
        }
        Response response=new Response("Done",salesByPipeline);
        return response;
    }

}
