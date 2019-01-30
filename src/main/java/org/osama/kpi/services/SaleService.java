package org.osama.kpi.services;

import org.osama.kpi.model.SDate;
import org.osama.kpi.model.Sale;
import org.osama.kpi.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public List<Sale> getLastSalesByDate(Date date){
        List<Sale> listSales=new ArrayList<>();
        saleRepository.findBySDateMyDate(date).forEach(listSales::add);
        return listSales;
    }

    public void addSale(Sale sale, int saleDateId){
        sale.setsDate(new SDate(saleDateId));
        saleRepository.save(sale);
    }
    public List<Sale> getAllSales(){
        List<Sale> listSales=new ArrayList<>();
        saleRepository.findAll().forEach(listSales::add);
        return listSales;
    }
    public List<Sale> getLast7Sales(){
        List<Sale> listSales=new ArrayList<>();
        saleRepository.findFirst7ByOrderBySDateMyDateDesc().forEach(listSales::add);
        return listSales;
    }
    // get last transactional after specific date .....
    public List<Sale> getLastDateSales(Date date){
        List<Sale> listSales=new ArrayList<>();
        saleRepository.findBySDateMyDateAfter(date).forEach(listSales::add);
        return listSales;
    }
    // get all sale by  date
    public List<Sale> getSaleByDate(Date date){
        List<Sale> listSales=new ArrayList<>();
       saleRepository.findBySDateMyDate(date).forEach(listSales::add);
        return listSales;
    }
    // get last transaction
    public List<Sale> getLastSale(){
        List<Sale> listSales=new ArrayList<>();
        saleRepository.findFirst1ByOrderBySDateMyDateDesc().forEach(listSales::add);
        return listSales;
    }
    // get all sales by pipeline
    public List<Sale> getSalesByPipeline(String pipeline){
        List<Sale> list=new ArrayList<>();
                saleRepository.findByPipeline(pipeline).forEach(list::add);
        return list;
    }
    // get the number of pipelines    getSalesLastWeekByPipeline
    public long getCountByPipeline(String pipeline){
        return saleRepository.countByPipeline(pipeline);
    }

    // get all sales by pipeline in the last week
    public List<Sale> getSalesLastWeekByPipeline(String pipeline, Date date){
        List<Sale> list=new ArrayList<>();
        saleRepository.findByPipelineAndSDateMyDateAfter(pipeline,date).forEach(list::add);
        return list;
    }
    // get the number of pipelines in the last week
    public long getCountLastWeekByPipeline(String pipeline,Date date){
        return saleRepository.countByPipelineAndSDateMyDateAfter(pipeline,date);
    }
    public void updateSale(int id,Sale sale){
        saleRepository.save(sale);

    }
    public Sale getSaleById(int id){
        Sale one = saleRepository.findOne(id);
        return one;
    }

    public void deleteSale(int id){
        saleRepository.delete(id);
    }

}
