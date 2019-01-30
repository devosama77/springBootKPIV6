package org.osama.kpi.view;


import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.osama.kpi.model.AllCost;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ExcelReport extends AbstractXlsxView {
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        @SuppressWarnings("unchecked")
        AllCost allCost= (AllCost) model.get("allCost");
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"cost.xlsx\"");

        Sheet sheet = workbook.createSheet("sheet1");
      //  workbook.getSheet("sheet1").autoSizeColumn(0);
        sheet.autoSizeColumn(1000);
        sheet.setDefaultColumnWidth(30);

        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        font.setBold(true);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
//        CellStyle style = workbook.createCellStyle();
//        style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
//        style.setFillForegroundColor(IndexedColors.RED.getIndex());
//        style.setBottomBorderColor(IndexedColors.BLUE.getIndex());
//
//        Font font = workbook.createFont();
//        font.setBold(true);
//        style.setFont(font);



        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("");
        header.getCell(0).setCellStyle(style);
        header.createCell(1).setCellValue("Items");
        header.getCell(1).setCellStyle(style);
        header.createCell(2).setCellValue("Price");
        header.getCell(2).setCellStyle(style);
        header.createCell(3).setCellValue("Size Of Tanker : "+allCost.getSizeOfTanker());
        header.getCell(3).setCellStyle(style);



        Row row1 = sheet.createRow(1);

            row1.createCell(0).setCellValue("Details");
            row1.createCell(1).setCellValue("Fuel Surcharge Rate");
            row1.createCell(2).setCellValue("");
            row1.createCell(3).setCellValue(allCost.getFuelSurchargeRate());
        Row row2 = sheet.createRow(2);
           row2.createCell(0).setCellValue("");
           row2.createCell(1).setCellValue("Distance to Buyer (KM)");
           row2.createCell(2).setCellValue(allCost.getDistancetoBuyer());
           row2.createCell(3).setCellValue(allCost.getDistancetoBuyer());
        Row row3 = sheet.createRow(3);
          row3.createCell(0).setCellValue("");
          row3.createCell(1).setCellValue("Distance to Mill (KM)");
          row3.createCell(2).setCellValue(allCost.getDistancetoMill());
          row3.createCell(3).setCellValue(allCost.getDistancetoMill());
        Row row4 = sheet.createRow(4);
           row4.createCell(0).setCellValue("");
           row4.createCell(1).setCellValue("Distance to Base");
           row4.createCell(2).setCellValue(allCost.getDistancetoBase());
           row4.createCell(3).setCellValue(allCost.getDistancetoBase());
        Row row5 = sheet.createRow(5);
           row5.createCell(0).setCellValue("");
           row5.createCell(1).setCellValue("Capacity");
           row5.createCell(2).setCellValue(allCost.getCapacity());
           row5.createCell(3).setCellValue(allCost.getCapacity());
        Row row6 = sheet.createRow(6);
           row6.createCell(0).setCellValue("");
           row6.createCell(1).setCellValue("Hours: stand by time ");
           row6.createCell(2).setCellValue(allCost.getStandByTime());
           row6.createCell(3).setCellValue(allCost.getStandByTime());
        Row row7 = sheet.createRow(7);
           row7.createCell(0).setCellValue("");
           row7.createCell(1).setCellValue(" : delivery time ");
           row7.createCell(2).setCellValue(allCost.getDeliveryTime());
           row7.createCell(3).setCellValue(allCost.getDeliveryTime());
        Row row8 = sheet.createRow(8);
           row8.createCell(0).setCellValue("Variable Cost");
           row8.createCell(1).setCellValue(allCost.getSalariesString());
           row8.createCell(2).setCellValue(allCost.getSalaryCalc());
           row8.createCell(3).setCellValue(allCost.getSalaryCalc());
        Row row9 = sheet.createRow(9);
           row9.createCell(0).setCellValue("");
           row9.createCell(1).setCellValue("SALARIES - DRIVERS (HOUR OT / 1 HOUR)");
           row9.createCell(2).setCellValue("100");
           row9.createCell(3).setCellValue(allCost.getSalaryPerHour());
        Row row10 = sheet.createRow(10);
           row10.createCell(0).setCellValue("");
           row10.createCell(1).setCellValue("SALARIES - DRIVERS (20% of revenue)");
           row10.createCell(2).setCellValue("Based on Pricing");
           row10.createCell(3).setCellValue(allCost.getSalaryRevenue());
        Row row11 = sheet.createRow(11);
           row11.createCell(0).setCellValue("");
           row11.createCell(1).setCellValue(allCost.getWaterString());
           row11.createCell(2).setCellValue(allCost.getWaterCalc());
           row11.createCell(3).setCellValue(allCost.getWaterCalc());
        Row row12 = sheet.createRow(12);
           row12.createCell(0).setCellValue("");
           row12.createCell(1).setCellValue("Rental Tanker");
           row12.createCell(2).setCellValue(allCost.getRentalTanker());
           row12.createCell(3).setCellValue(allCost.getRentalTanker());
        Row row13 = sheet.createRow(13);
           row13.createCell(0).setCellValue("");
           row13.createCell(1).setCellValue("DISPOSAL PLACE");
           row13.createCell(2).setCellValue(allCost.getDisposalPlace());
           row13.createCell(3).setCellValue(allCost.getDisposalPlace());
        Row row14 = sheet.createRow(14);
           row14.createCell(0).setCellValue("");
           row14.createCell(1).setCellValue("Wash Tanker");
           row14.createCell(2).setCellValue(allCost.getWashTanker());
           row14.createCell(3).setCellValue(allCost.getWashTanker());
        Row row15 = sheet.createRow(15);
          row15.createCell(0).setCellValue("");
          row15.createCell(1).setCellValue("DIESEL & PETROL  (0.45L/Km)");
          row15.createCell(2).setCellValue("(distanceToBuyer+distanceToBase+distanceToMill)*.45*2");
          row15.createCell(3).setCellValue(allCost.getDieselPetrol());
        Row row16 = sheet.createRow(16);
          row16.createCell(0).setCellValue("");
          row16.createCell(1).setCellValue("TOLL FEE (1%-3%) or (RM9/hrs)");
          row16.createCell(2).setCellValue("delivery Time*9");
          row16.createCell(3).setCellValue(allCost.getToolFee());
        Row row17 = sheet.createRow(17);
          row17.createCell(0).setCellValue("");
          row17.createCell(1).setCellValue("Stand by time");
          row17.createCell(2).setCellValue("200");
          row17.createCell(3).setCellValue(allCost.getStandByTimeCalc());
        Row row18 = sheet.createRow(18);
          row18.createCell(0).setCellValue("");
          row18.createCell(1).setCellValue("Total Variable Cost");
          row18.createCell(2).setCellValue("");
          row18.createCell(3).setCellValue(allCost.getTotalVariableCost());
          /// Fixed cost .............................................
        Row row19 = sheet.createRow(19);
          row19.createCell(0).setCellValue("");
          row19.createCell(1).setCellValue("GIT INSURANCE");
          row19.createCell(2).setCellValue("");
          row19.createCell(3).setCellValue(allCost.getGitInsurance());
        Row row20 = sheet.createRow(20);
          row20.createCell(0).setCellValue("");
          row20.createCell(1).setCellValue("VEHICLE INSURANCE");
          row20.createCell(2).setCellValue("");
          row20.createCell(3).setCellValue(allCost.getVehicleInsurance());
        Row row21 = sheet.createRow(21);
          row21.createCell(0).setCellValue("");
          row21.createCell(1).setCellValue("VEHICLE ROAD TAX ");
          row21.createCell(2).setCellValue("");
          row21.createCell(3).setCellValue(allCost.getVehicleRoadTax());
        Row row22 = sheet.createRow(22);
          row22.createCell(0).setCellValue("");
          row22.createCell(1).setCellValue("JPJ INSPECTION");
          row22.createCell(2).setCellValue("");
          row22.createCell(3).setCellValue(allCost.getJpjInspection());
        Row row23 = sheet.createRow(23);
          row23.createCell(0).setCellValue("");
          row23.createCell(1).setCellValue("PUSHPAKOM INSPECTION");
          row23.createCell(2).setCellValue("");
          row23.createCell(3).setCellValue(allCost.getPushpakomInspection());
        Row row24 = sheet.createRow(24);
          row24.createCell(0).setCellValue("");
          row24.createCell(1).setCellValue("GPS MAINTENANCE ");
          row24.createCell(2).setCellValue("");
          row24.createCell(3).setCellValue(allCost.getGpsMaintenance());
        Row row25 = sheet.createRow(25);
          row25.createCell(0).setCellValue("");
          row25.createCell(1).setCellValue("INSTALLMENT OF TANKER");
          row25.createCell(2).setCellValue("");
          row25.createCell(3).setCellValue(allCost.getInstallMentOfTanker());
        Row row26 = sheet.createRow(26);
          row26.createCell(0).setCellValue("");
          row26.createCell(1).setCellValue("VEHICLE MAINTANENCE");
          row26.createCell(2).setCellValue("");
          row26.createCell(3).setCellValue(allCost.getVehicleMaintanence());
        Row row27 = sheet.createRow(27);
          row27.createCell(0).setCellValue("");
          row27.createCell(1).setCellValue("Admin Cost (5% on 1m sales )");
          row27.createCell(2).setCellValue("");
          row27.createCell(3).setCellValue(allCost.getAdminCost());
        Row row28 = sheet.createRow(28);
          row28.createCell(0).setCellValue("");
          row28.createCell(1).setCellValue("HARDWARE");
          row28.createCell(2).setCellValue("");
          row28.createCell(3).setCellValue(allCost.getHardware());
        Row row29 = sheet.createRow(29);
          row29.createCell(0).setCellValue("");
          row29.createCell(1).setCellValue("Total Fixed Cost");
          row29.createCell(2).setCellValue("");
          row29.createCell(3).setCellValue(allCost.getTotalFixedCost());
        row29.getCell(0).setCellStyle(style);
        row29.getCell(1).setCellStyle(style);
        row29.getCell(2).setCellStyle(style);
        row29.getCell(3).setCellStyle(style);
        Row row30 = sheet.createRow(30);
          row30.createCell(0).setCellValue("TOTAL COST OF SALES ");
          row30.createCell(1).setCellValue("Total Cost");
          row30.createCell(2).setCellValue("");
          row30.createCell(3).setCellValue(allCost.getTotalCost());
        row30.getCell(0).setCellStyle(style);
        row30.getCell(1).setCellStyle(style);
        row30.getCell(2).setCellStyle(style);
        row30.getCell(3).setCellStyle(style);
        Row row31 = sheet.createRow(31);
          row31.createCell(0).setCellValue("");
          row31.createCell(1).setCellValue("Additional Expenses ");
          row31.createCell(2).setCellValue("(totalCost*10)/100");
          row31.createCell(3).setCellValue(allCost.getAdditionalExpenses());
        Row row32 = sheet.createRow(32);
          row32.createCell(0).setCellValue("");
          row32.createCell(1).setCellValue("Mark up ");
          row32.createCell(2).setCellValue("totalCost+additionalExpenses)*markUp Percentage/100");
          row32.createCell(3).setCellValue(allCost.getMarkup());
        Row row33 = sheet.createRow(33);
          row33.createCell(0).setCellValue("");
          row33.createCell(1).setCellValue("Pricing");
          row33.createCell(2).setCellValue("totalCost+additionalExpenses+markup+Salary Revenue");
          row33.createCell(3).setCellValue(allCost.getRealPricing());
        Row row34 = sheet.createRow(34);
          row34.createCell(0).setCellValue("");
          row34.createCell(1).setCellValue("FUEL SURCHARGE  (RM0.1035/KM)");
          row34.createCell(2).setCellValue("distanceToBuyer+distanceToBase+distanceToMill)*fuelSurchargeRate()");
          row34.createCell(3).setCellValue(allCost.getFuelSurCharge());



    }
}
