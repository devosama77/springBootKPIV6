package org.osama.kpi.controllers;

import org.osama.kpi.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    SaleService saleService;
    @RequestMapping(value = "/")
    public String getIndex(){
        return "pages/index";
    }

    @RequestMapping("index")
    public String getPagesIndex(){
        return "pages/index";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("custom-login");
        return modelAndView;
    }
//    @GetMapping("pages/app-logout")
//    public String appLogout() {
//        return "custom-login";
//    }
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("pages/test")
    public String test() {
        return "test";
    }

//    Dashboard .....................................................
//    @RequestMapping("dashboard/{pipeline}")
//    public String getCountPipeline(@PathVariable String pipeline,Model model){
//        long countByPipeline=0;
//        if(pipeline!=null){
//            countByPipeline = saleService.getCountByPipeline(pipeline);
//        }
//        model.addAttribute("",countByPipeline);
//        return "pages/index";
//    }

}
