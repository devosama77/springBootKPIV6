package org.osama.kpi.controllers;


import org.osama.kpi.model.AllCost;
import org.osama.kpi.model.Cost;
import org.osama.kpi.view.ExcelReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class CostController implements   ServletContextAware {

    private ServletContext servletContext;
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    @RequestMapping("cost")
    public String getCost(@ModelAttribute Cost cost  ){
//        if(bindingResult.hasErrors()){
//            new ModelAndView("pages/cost-input-form","cost",cost);
//        }
        return "pages/cost-input-form";
    }


    @RequestMapping("/download")
    public ModelAndView redirect(HttpServletRequest request){
        //  List<AllCost> list=new ArrayList();
        String type = request.getParameter("type");
        AllCost allCost = (AllCost) servletContext.getAttribute("allCost");

        if(type!=null&&type.equals("xlsx")){

            return new ModelAndView(new ExcelReport(),"allCost",allCost);
        }

        return new ModelAndView("download","allCost",allCost);
    }

    @RequestMapping("result-cost")
    public ModelAndView getCalc(Model model, @ModelAttribute("cost") Cost cost ){

        AllCost allCost=new AllCost();
        allCost.setSizeOfTanker(cost.getSizeOfTanker());
        double currentRate= Double.parseDouble(cost.getCurrentRate());
        double dieselBaseRate= Double.parseDouble(cost.getDieselBaseRate());
        double usage=.45;
        double fuelSurchargeRate=(currentRate-dieselBaseRate)*usage;
        cost.setFuelSurchargeRate(fuelSurchargeRate);
        allCost.setFuelSurchargeRate(fuelSurchargeRate);
        double distanceToMill = Double.parseDouble(cost.getDistanceToMill());
          double distanceToBase= Double.parseDouble(cost.getDistanceToBase());
          double distanceToBuyer=Double.parseDouble(cost.getDistanceToBuyer());
          allCost.setDistancetoMill(distanceToMill);
        allCost.setDistancetoBase(distanceToBase);
        allCost.setDistancetoBuyer(distanceToBuyer);
        allCost.setCapacity(Double.parseDouble(cost.getCapacity()));
        allCost.setStandByTime(Double.parseDouble(cost.getStandByTime()));
        allCost.setDeliveryTime(Double.parseDouble(cost.getDeliveryTime()));
        // variable cost ...............................................................................................

        allCost.setSalaryCalc(Double.parseDouble(cost.getSalaryList()));

        allCost.setWaterCalc(Double.parseDouble(cost.getWaterList()));

        allCost.setSalariesString(cost.getSalariesString());
        allCost.setWaterString(cost.getWaterString());

        double salaryPerHour = Double.parseDouble(cost.getSalaryPerHour());
        double salaryPerHourCalc=salaryPerHour *100;
        allCost.setSalaryPerHour(Double.parseDouble(cost.getSalaryPerHour()));
        allCost.setSalaryPerHourCalc(salaryPerHourCalc);

        allCost.setSalaryRevenue(Double.parseDouble(cost.getSalaryRevenue()));

        allCost.setRentalTanker(Double.parseDouble(cost.getRentalTanker()));
        allCost.setDisposalPlace(Double.parseDouble(cost.getDisposalPlace()));
        allCost.setWashTanker(Double.parseDouble(cost.getWashTanker()));

        double diesel=(distanceToBuyer+distanceToBase+distanceToMill)*.45*2;
        double deliveryTime=Double.parseDouble(cost.getDeliveryTime());
        double standByTime = Double.parseDouble(cost.getStandByTime());
        double toll= deliveryTime*9;
        double standByTimeCal=standByTime*200;

        double rentalTanker= Double.parseDouble(cost.getRentalTanker());
        double disposalPlace= Double.parseDouble(cost.getDisposalPlace());
        double washTanker= Double.parseDouble(cost.getWashTanker());
        double totalVar=allCost.getSalaryCalc()+allCost.getWaterCalc()+salaryPerHourCalc+allCost.getSalaryRevenue()+rentalTanker
                +disposalPlace+washTanker +standByTimeCal+diesel+toll;

        allCost.setDieselPetrol(diesel);
        allCost.setToolFee(toll);
        allCost.setStandByTimeCalc(standByTimeCal);
        allCost.setTotalVariableCost(totalVar);

//        // fixed cost .......................................................
        String sizeOfTanker=cost.getSizeOfTanker();

        double gitInsurancePrice=20150d/11;
        double gitInsurance;
        if(sizeOfTanker.equals("33m3")||sizeOfTanker.equals("40m3")||sizeOfTanker.equals("50m3")||sizeOfTanker.equals("Iso")){
            gitInsurance=gitInsurancePrice/22d;}
        else {
            gitInsurance=0;
        }
        allCost.setGitInsurance(gitInsurance);

        double vehicleInsurance;
        if(sizeOfTanker.equals("33m3")){
            vehicleInsurance=9419.03d/12/22;
        } else if (sizeOfTanker.equals("40m3")) {
            vehicleInsurance=7097.29d/12/22;
        }else if (sizeOfTanker.equals("50m3")){
            vehicleInsurance=19515.01d/12/22;
        }
        else if(sizeOfTanker.equals("Iso")){
            vehicleInsurance=8118.22d/12/22;
        }
        else {
            vehicleInsurance=0d;
        }
        allCost.setVehicleInsurance(vehicleInsurance);

        double vehicleRoadTax;
        if(sizeOfTanker.equals("33m3")){
            vehicleRoadTax=530d/12/22;
        } else if (sizeOfTanker.equals("40m3")) {
            vehicleRoadTax=567d/12/22;
        }else if (sizeOfTanker.equals("50m3")){
            vehicleRoadTax=370d/12/22;
        }
        else if(sizeOfTanker.equals("Iso")){
            vehicleRoadTax=132d/12/22;
        }
        else {
            vehicleRoadTax=0d;
        }
        allCost.setVehicleRoadTax(vehicleRoadTax);

        double jpjInspection;
        if(sizeOfTanker.equals("33m3")||sizeOfTanker.equals("40m3")||sizeOfTanker.equals("50m3")||sizeOfTanker.equals("Iso")){
            jpjInspection=800d/22;
        }
        else {
            jpjInspection=0d;
        }
        allCost.setJpjInspection(jpjInspection);

        double pushpakomInspection;
        if(sizeOfTanker.equals("33m3")||sizeOfTanker.equals("40m3")||sizeOfTanker.equals("50m3")||sizeOfTanker.equals("Iso")){
            pushpakomInspection=200/22d;
        }
        else {
            pushpakomInspection=0d;
        }
        allCost.setPushpakomInspection(pushpakomInspection);

        double gpsMaintenance=50/22d;
        allCost.setGpsMaintenance(gpsMaintenance);


        double installmentOfTanker;
        if(sizeOfTanker.equals("33m3")){
            installmentOfTanker=155;
        }
        else if(sizeOfTanker.equals("50m3")){
            installmentOfTanker=212;
        }
        else if(sizeOfTanker.equals("Iso")){
            installmentOfTanker=3636/30;
        }
        else if(sizeOfTanker.equals("Storage")){
            installmentOfTanker=60;
        }
        else {
            installmentOfTanker=0d;
        }
        allCost.setInstallMentOfTanker(installmentOfTanker);


        double vehicleMaintanence;
        if(sizeOfTanker.equals("Storage")){
            vehicleMaintanence=0d;
        }
        else {
            vehicleMaintanence=(550923d+8678.02+23261.01)/25/12/22d;
        }
        allCost.setVehicleMaintanence(vehicleMaintanence);


        double adminCost;
        if(sizeOfTanker.equals("Storage")){
            adminCost=0d;
        }
        else {
            adminCost=50000d/34/22d;
        }
        allCost.setAdminCost(adminCost);

        double hardware;
        if(sizeOfTanker.equals("Storage")){
            hardware=0d;
        }
        else {
            hardware=94915.98d/34/9/22;
        }
        allCost.setHardware(hardware);

        double totalFixedCost;
        if(allCost.getRentalTanker()==0) {
            totalFixedCost = gitInsurance + vehicleInsurance + vehicleRoadTax + jpjInspection + pushpakomInspection
                    + gpsMaintenance + installmentOfTanker + vehicleMaintanence + adminCost + hardware;
        }else {
            totalFixedCost=0;
        }
        allCost.setTotalFixedCost(totalFixedCost);
        double totalCost=totalFixedCost+totalVar;
//        // total cost ......................................................................
        allCost.setTotalCost(totalCost);
        double additionalExpenses=(totalCost*10)/100;
        allCost.setAdditionalExpenses(additionalExpenses);
        double markUpPrecentage= Double.parseDouble(cost.getMarkUpPrecentage());
        double markup =(totalCost+additionalExpenses)*markUpPrecentage/100;
        allCost.setMarkup(markup);
        allCost.setMarkUpPrecentage(markUpPrecentage);

        double pricing =(totalCost+additionalExpenses+markup);
        allCost.setPricing(pricing);
        if(allCost.getSalariesString().equals("20% of revenue")){
            double salaryRev=(allCost.getPricing()*20)/100;
            allCost.setSalaryRevenue(salaryRev);
            allCost.setRealPricing(pricing+salaryRev);
        }
        else {
            allCost.setSalaryRevenue(0.0);
            allCost.setRealPricing(pricing);
        }

        double fuelSurcharge=(distanceToBuyer+distanceToBase+distanceToMill)*cost.getFuelSurchargeRate();
        allCost.setFuelSurCharge(fuelSurcharge);

         servletContext.setAttribute("allCost",allCost);
        model.addAttribute("allCost",allCost);

        return new ModelAndView("pages/cost-result","cost",cost);

    }
}
