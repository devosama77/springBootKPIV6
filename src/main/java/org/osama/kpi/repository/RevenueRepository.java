package org.osama.kpi.repository;



import org.osama.kpi.model.Revenue;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RevenueRepository  extends CrudRepository<Revenue,Integer> {
    List<Revenue> findByRDateMyDate(Date date);
    List<Revenue> findFirst7ByOrderByRDateMyDateDesc();
    List<Revenue> findByRDateMyDateAfter(Date date);
    List<Revenue> findFirst1ByOrderByRDateMyDateDesc();
//    List<Revenue> findByPipeline(String pipeline);
//    List<Revenue> findByPipelineAndSDateMyDateAfter(String pipeline, Date date);
//    long countByPipeline(String pipeline);
//    long countByPipelineAndSDateMyDateAfter(String pipeline, Date date);
}
