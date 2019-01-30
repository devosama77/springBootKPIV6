package org.osama.kpi.services;

import org.osama.kpi.model.SDate;
import org.osama.kpi.repository.SDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SDateService {
    @Autowired
    SDateRepository sDateRepository;

    public List<SDate> getAllSDates(){
        List<SDate> listSDates=new ArrayList<>();
        sDateRepository.findAll().forEach(listSDates::add);
        return listSDates;
    }
    public void addSaleDate(SDate sDate){
        sDateRepository.save(sDate);

    }
    public List<SDate> getLastDate(){
        List<SDate> listSDates=new ArrayList<>();
        sDateRepository.findFirst1ByOrderByMyDateDesc().forEach(listSDates::add);
        return listSDates;
    }
}
