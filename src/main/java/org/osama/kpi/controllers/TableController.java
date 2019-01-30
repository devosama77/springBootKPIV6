package org.osama.kpi.controllers;

import org.osama.kpi.model.SDate;
import org.osama.kpi.model.Sale;
import org.osama.kpi.services.SDateService;
import org.osama.kpi.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    SaleService saleService;
    @Autowired
    SDateService sDateService;
//    @RequestMapping("pages/tables")
//    public String getIndex(Model model) throws ParseException {
//        List<Sale> listSales =saleService.getAllSales();
//        model.addAttribute("sales",listSales);
//
//        LocalDateTime nowMinusWeek = LocalDateTime.now().minusDays(7);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String formatDateTime = nowMinusWeek.format(formatter);
//        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(formatDateTime);
//
//        List<Sale> listSalesLWeek =saleService.getLastDateSales(date);
//        model.addAttribute("salesWeek",listSalesLWeek);
//
//        List<Sale> lastSale = saleService.getLastSale();
//        if(lastSale!=null){
//            SDate sDate = listSales.get(0).getsDate();
//            List<Sale> saleByDate = saleService.getSaleByDate(sDate.getMyDate());
//            model.addAttribute("saleByDate",saleByDate);
//        }
//        return "pages/tables";
//    }

    @RequestMapping("table-all-sales")
    public String getAllSales(Model model) throws ParseException {
        List<Sale> listSales =saleService.getAllSales();
        model.addAttribute("sales",listSales);
     return "pages/kpi/table-all-sales";
    }
    @RequestMapping("table-lastSales")
    public String getLast(Model model) throws ParseException {
        List<Sale> listSales =saleService.getAllSales();
        List<Sale> lastSale = saleService.getLastSale();
        if(lastSale!=null){
            SDate sDate = listSales.get(0).getsDate();
            List<Sale> saleByDate = saleService.getSaleByDate(sDate.getMyDate());
            model.addAttribute("saleByDate",saleByDate);
        }
        return "pages/kpi/table-lastSales";
    }
    @RequestMapping("table-last-week")
    public String getAllLastWeek(Model model) throws ParseException {
        LocalDateTime nowMinusWeek = LocalDateTime.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = nowMinusWeek.format(formatter);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(formatDateTime);

        List<Sale> listSalesLWeek =saleService.getLastDateSales(date);
        model.addAttribute("salesWeek",listSalesLWeek);
        return "pages/kpi/table-last-week";
    }
//    @RequestMapping("/dates")
//    public String getAllSales()  {
//       // Date date=new SimpleDateFormat("yyyy-MM-dd").parse(myDate);
////        if(myDate!=null){
////            Date date=new SimpleDateFormat("yyyy-MM-dd").parse(myDate);
////            List<Sale> listSales =saleService.getAllSales(date);
////            model.addAttribute("sales",listSales);
////        }
//        return "redirect:/";
//    }
}
