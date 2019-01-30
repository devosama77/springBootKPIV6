package org.osama.kpi.services;


import org.osama.kpi.model.RDate;
import org.osama.kpi.model.Revenue;
import org.osama.kpi.model.SDate;
import org.osama.kpi.model.Sale;
import org.osama.kpi.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RevenueService {
    @Autowired
    RevenueRepository revenueRepository;

//    public List<Sale> getLastSalesByDate(Date date){
//        List<Sale> listSales=new ArrayList<>();
//        saleRepository.findBySDateMyDate(date).forEach(listSales::add);
//        return listSales;
//    }
//
    public void addRevenue(Revenue revenue, int revenueDateId){
        revenue.setrDate(new RDate(revenueDateId));
        revenueRepository.save(revenue);
    }
    public List<Revenue> getAllRevenues(){
        List<Revenue> listRevenues=new ArrayList<>();
        revenueRepository.findAll().forEach(listRevenues::add);
        return listRevenues;
    }
//    public List<Sale> getLast7Sales(){
//        List<Sale> listSales=new ArrayList<>();
//        saleRepository.findFirst7ByOrderBySDateMyDateDesc().forEach(listSales::add);
//        return listSales;
//    }
//    // get last transactional after specific date .....
    public List<Revenue> getByRDateMyDateAfter(Date date){
        List<Revenue> listRevenue=new ArrayList<>();
        revenueRepository.findByRDateMyDateAfter(date).forEach(listRevenue::add);
        return listRevenue;
    }
//    // get all revenue by  date
    public List<Revenue> getRevenueByDate(Date date){
        List<Revenue> listRevenues=new ArrayList<>();
        revenueRepository.findByRDateMyDate(date).forEach(listRevenues::add);
        return listRevenues;
    }
//    // get last  Revenue transaction
    public List<Revenue> getLastSale(){
        List<Revenue> listRevenues=new ArrayList<>();
        revenueRepository.findFirst1ByOrderByRDateMyDateDesc().forEach(listRevenues::add);
        return listRevenues;
    }
//    // get all sales by pipeline
//    public List<Sale> getSalesByPipeline(String pipeline){
//        List<Sale> list=new ArrayList<>();
//        saleRepository.findByPipeline(pipeline).forEach(list::add);
//        return list;
//    }
//    // get the number of pipelines    getSalesLastWeekByPipeline
//    public long getCountByPipeline(String pipeline){
//        return saleRepository.countByPipeline(pipeline);
//    }
//
//    // get all sales by pipeline in the last week
//    public List<Sale> getSalesLastWeekByPipeline(String pipeline, Date date){
//        List<Sale> list=new ArrayList<>();
//        saleRepository.findByPipelineAndSDateMyDateAfter(pipeline,date).forEach(list::add);
//        return list;
//    }
//    // get the number of pipelines in the last week
//    public long getCountLastWeekByPipeline(String pipeline,Date date){
//        return saleRepository.countByPipelineAndSDateMyDateAfter(pipeline,date);
//    }
//    public void updateSale(int id,Sale sale){
//        saleRepository.save(sale);
//
//    }
    public Revenue getRevenueById(int id){
        Revenue one = revenueRepository.findOne(id);
        return one;
    }


    public void deleteRevenue(int id){
        revenueRepository.delete(id);
    }



}
