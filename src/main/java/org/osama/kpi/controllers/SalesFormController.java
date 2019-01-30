package org.osama.kpi.controllers;

import org.osama.kpi.model.SDate;
import org.osama.kpi.model.Sale;
import org.osama.kpi.services.SDateService;
import org.osama.kpi.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SalesFormController {
    @Autowired
    SaleService saleService;
    @Autowired
    SDateService sDateService;

    @Secured({"ROLE_ADMIN"})
    @RequestMapping("forms-all")
    public String getAllSales(Model model, @ModelAttribute("sale")Sale sale){
        List<Sale> listSales =saleService.getAllSales();
        model.addAttribute("sales",listSales);
        return "pages/kpi/forms-all-sales";
    }
    @Secured({"ROLE_ADMIN"})
    @PostMapping(value = "forms/addA")
    public String addSaleWithDateAllSales(@Valid @ModelAttribute("sale")Sale sale, Model model) {
        SDate sDate=new SDate();
        sDate.setMyDate(sale.getsDate().getMyDate());
        sDateService.addSaleDate(sDate);
        saleService.addSale(sale,sDate.getId());
        return "redirect:/forms-all";
    }

//    @Secured({"ROLE_ADMIN"})
//    @PostMapping(value = "update-all")
//    public String updateSaleWithDate(@RequestParam("sale")Sale sale, Model model ) {
//        SDate sDate=new SDate();
//        sDate.setMyDate(sale.getsDate().getMyDate());
//        sDateService.addSaleDate(sDate);
//        saleService.addSale(sale,sDate.getId());
//        return "redirect:/forms-all";
//    }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("delete/all/{id}")
    public String deleteSaleAll(Model model, @PathVariable int id) throws ParseException {
        saleService.deleteSale(id);
        return "redirect:/forms-all";
    }

//   last week from .............................
    @RequestMapping("forms-lastWeek")
    public String getLastWeek(Model model, @ModelAttribute("sale")Sale sale) throws ParseException {
        LocalDateTime now = LocalDateTime.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = now.format(formatter);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(formatDateTime);
        List<Sale> listSalesLWeek =saleService.getLastDateSales(date);
        model.addAttribute("salesWeek",listSalesLWeek);
        return "pages/kpi/forms-last-week";
    }
    @PostMapping(value = "forms/addL")
    public String addSaleWithDateLastWeek(@Valid @ModelAttribute("sale")Sale sale, Model model) {
        SDate sDate=new SDate();
        Date nowDate=new Date();
        //Get current date time
        sDate.setMyDate(nowDate);
        sDateService.addSaleDate(sDate);
        saleService.addSale(sale,sDate.getId());
        return "redirect:/forms-lastWeek";
    }

    @RequestMapping("delete/week/{id}")
    public String deleteSaleLastWeek(Model model, @PathVariable int id) throws ParseException {
        saleService.deleteSale(id);
        return "redirect:/form-update";
    }
    // form last sales .......................................
    @RequestMapping("forms-lastSales")
    public String getLastSales(Model model, @ModelAttribute("sale")Sale sale){
        try {
            List<Sale> lastSale = saleService.getLastSale();
            List<Sale> list=new ArrayList<>();
            SDate sDate;
            if (lastSale!=null){
                lastSale.forEach(list::add);
                sDate = list.get(0).getsDate();
                //sDate=new SDate(new Date());
            }else {
                sDate=new SDate(new Date());
            }
            List<Sale> saleByDate = saleService.getSaleByDate(sDate.getMyDate());
            model.addAttribute("saleByDate",saleByDate);
        }catch (IndexOutOfBoundsException e){}
        catch (Exception e){}




        return "pages/kpi/forms-last-sales";
    }
    @PostMapping(value = "forms/add")
    public String addSale(@Valid @ModelAttribute("sale")Sale sale, Model model) {
        SDate sDate=new SDate();
        Date nowDate=new Date();
        //Get current date time
        sDate.setMyDate(nowDate);
        sDateService.addSaleDate(sDate);
        saleService.addSale(sale,sDate.getId());
        return "redirect:/forms-lastSales";
    }

    @RequestMapping("delete/last/{id}")
    public String deleteSaleLast(Model model, @PathVariable int id) throws ParseException {
        saleService.deleteSale(id);
        return "redirect:/forms-lastSales";
    }

    @RequestMapping("/forms-update-all")
    public String updateForm1(Model model, @ModelAttribute("sale")Sale sale, @RequestParam(name = "id") int id) {
        Sale saleById = saleService.getSaleById(id);
        model.addAttribute("sale",saleById);
        List<Sale> listSales = saleService.getAllSales();
        model.addAttribute("sales", listSales);
        return "pages/kpi/forms-update-all";
    }

    @RequestMapping("/forms-update-last")
 public String updateLastDate(Model model, @RequestParam(name = "id") int id){
        try {
            Sale saleById = saleService.getSaleById(id);
            model.addAttribute("sale",saleById);

            List<Sale> lastSale = saleService.getLastSale();
            if(lastSale!=null){
                SDate sDate = lastSale.get(0).getsDate();
                List<Sale> saleByDate = saleService.getSaleByDate(sDate.getMyDate());
                model.addAttribute("saleByDate",saleByDate);
            }

        }catch (IndexOutOfBoundsException e){}
        catch (Exception e){}

        return "pages/kpi/forms-update-last";
 }

    @RequestMapping("/forms-update-last-week")
    public String updateLastWeek(Model model, @RequestParam(name = "id") int id) throws ParseException {
        Sale saleById = saleService.getSaleById(id);
        model.addAttribute("sale",saleById);
        LocalDateTime nowMinusWeek = LocalDateTime.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = nowMinusWeek.format(formatter);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(formatDateTime);
        List<Sale> listSalesLWeek =saleService.getLastDateSales(date);
        model.addAttribute("salesWeek",listSalesLWeek);
        return "pages/kpi/forms-update-last-week";
    }
}
