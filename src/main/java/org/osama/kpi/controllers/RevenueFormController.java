package org.osama.kpi.controllers;

import org.osama.kpi.model.RDate;
import org.osama.kpi.model.Revenue;
import org.osama.kpi.model.SDate;
import org.osama.kpi.model.Sale;
import org.osama.kpi.services.RDateService;
import org.osama.kpi.services.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Controller
public class RevenueFormController {
    @Autowired
    RevenueService revenueService;
    @Autowired
    RDateService rDateService;
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("rev-form-all")
    public String getAllSales(Model model, @ModelAttribute("revenue")Revenue revenue){
        List<Revenue> listRevenue =revenueService.getAllRevenues();
        model.addAttribute("revenues",listRevenue);
        return "pages/revenue/form-all";
    }
    @Secured({"ROLE_ADMIN"})
    @PostMapping(value = "rev-forms/addA")
    public String addSaleWithDate(@Valid @ModelAttribute("revenue")Revenue revenue, Model model) {
    RDate rDate=new RDate();
    rDate.setMyDate(revenue.getrDate().getMyDate());
    rDateService.addRevenueDate(rDate);
    revenueService.addRevenue(revenue,rDate.getId());
    return "redirect:/rev-form-all";
   }
    @Secured({"ROLE_ADMIN"})
    @RequestMapping("/rev-update-all")
    public String updateFormAllRevenue(Model model, @ModelAttribute("revenue")Revenue revenue, @RequestParam(name = "id") int id) {
        Revenue revenueByid = revenueService.getRevenueById(id);
        model.addAttribute("revenue",revenueByid);
        List<Revenue> listRevenues = revenueService.getAllRevenues();
        model.addAttribute("revenues", listRevenues);
        return "pages/revenue/form-update-all";
    }

   @Secured({"ROLE_ADMIN"})
    @RequestMapping("rev-delete-all/{id}")
    public String deleteRevenueAll( @PathVariable int id) throws ParseException {
        revenueService.deleteRevenue(id);
        return "redirect:/rev-form-all";
    }
//
//    //   last week from .............................
    @RequestMapping("/rev-form-lastWeek")
    public String getLastWeekRevenue(Model model, @ModelAttribute("revenue")Revenue revenue) throws ParseException {
        LocalDateTime now = LocalDateTime.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = now.format(formatter);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(formatDateTime);
        List<Revenue> listRevenueLWeek =revenueService.getByRDateMyDateAfter(date);
        model.addAttribute("revenuesWeek",listRevenueLWeek);
        return "pages/revenue/form-last-week";
    }

    @PostMapping(value = "rev-form/addLW")
    public String addSaleWithDateLastWeek(@ModelAttribute("revenue")Revenue revenue, Model model) {
        RDate rDate=new RDate();
        Date nowDate=new Date();
        //Get current date time
        rDate.setMyDate(nowDate);
        rDateService.addRevenueDate(rDate);
        revenueService.addRevenue(revenue,rDate.getId());
        return "redirect:/rev-form-lastWeek";
    }

    @RequestMapping("rev-delete/last-week/{id}")
    public String deleteRevenueLastWeek(Model model, @PathVariable int id) throws ParseException {
        revenueService.deleteRevenue(id);
        return "redirect:/rev-form-lastWeek";
    }

    // form last Revenues .......................................
    @RequestMapping("rev-form-last")
    public String getLastRev(Model model, @ModelAttribute("revenue")Revenue revenue){
        try {
            List<Revenue> lastRevenue = revenueService.getLastSale();
            if(lastRevenue!=null){
                RDate rDate = lastRevenue.get(0).getrDate();
                List<Revenue> revenuesByDate = revenueService.getRevenueByDate(rDate.getMyDate());
                model.addAttribute("revenuesByDate",revenuesByDate);
            }
        }
        catch (IndexOutOfBoundsException e){}
        catch (Exception e){}


        return "pages/revenue/form-last";
    }
    @PostMapping(value = "rev-form/addL")
    public String addRev(@ModelAttribute("revenue")Revenue revenue, Model model) {
        RDate rDate=new RDate();
        Date nowDate=new Date();
        //Get current date time
        rDate.setMyDate(nowDate);
        rDateService.addRevenueDate(rDate);
        revenueService.addRevenue(revenue,rDate.getId());
        return "redirect:/rev-form-last";
    }

    @RequestMapping("rev-delete/last/{id}")
    public String deleteRevLast(Model model, @PathVariable int id) throws ParseException {
        revenueService.deleteRevenue(id);
        return "redirect:/rev-form-last";
    }
//
//    @RequestMapping("/forms-update-all")
//    public String updateForm1(Model model, @ModelAttribute("sale")Sale sale, @RequestParam(name = "id") int id) {
//        Sale saleById = saleService.getSaleById(id);
//        model.addAttribute("sale",saleById);
//        List<Sale> listSales = saleService.getAllSales();
//        model.addAttribute("sales", listSales);
//        return "pages/kpi/forms-update-all";
//    }
//
    @RequestMapping("/rev-update-last")
    public String updateLastDate(Model model, @RequestParam(name = "id") int id){
        try {
            Revenue revenueById = revenueService.getRevenueById(id);
            model.addAttribute("revenue",revenueById);
            List<Revenue> lastRevenue = revenueService.getLastSale();
            if(lastRevenue!=null){
                RDate rDate = lastRevenue.get(0).getrDate();
                List<Revenue> revenuesByDate = revenueService.getRevenueByDate(rDate.getMyDate());
                model.addAttribute("revenuesByDate",revenuesByDate);
            }

        }
        catch (IndexOutOfBoundsException e) {}
        catch (Exception e){}

        return "pages/revenue/form-update-last";
    }
//
    @RequestMapping("/rev-update-week")
    public String updateLastWeek(Model model, @RequestParam(name = "id") int id) throws ParseException {
        Revenue revenueById = revenueService.getRevenueById(id);
        model.addAttribute("revenue",revenueById);
        LocalDateTime nowMinusWeek = LocalDateTime.now().minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatDateTime = nowMinusWeek.format(formatter);
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(formatDateTime);
        List<Revenue> listRevenueLWeek =revenueService.getByRDateMyDateAfter(date);
        model.addAttribute("revenueWeek",listRevenueLWeek);
        return "pages/revenue/form-update-week";
    }


}
