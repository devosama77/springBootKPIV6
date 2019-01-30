package org.osama.kpi.services;

import org.osama.kpi.model.RDate;
import org.osama.kpi.model.SDate;
import org.osama.kpi.repository.RDateRepository;
import org.osama.kpi.repository.SDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RDateService {
    @Autowired
    RDateRepository rDateRepository;

//    public List<SDate> getAllSDates(){
//        List<SDate> listSDates=new ArrayList<>();
//        rDateRepository.findAll().forEach(listSDates::add);
//        return listSDates;
//    }
    public void addRevenueDate(RDate rDate){
        rDateRepository.save(rDate);

    }
//    public List<SDate> getLastDate(){
//        List<SDate> listSDates=new ArrayList<>();
//        sDateRepository.findFirst1ByOrderByMyDateDesc().forEach(listSDates::add);
//        return listSDates;
//    }
}
