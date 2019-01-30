package org.osama.kpi.repository;

import org.osama.kpi.model.Sale;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface SaleRepository extends CrudRepository<Sale,Integer> {

       List<Sale> findBySDateMyDate(Date date);
       List<Sale> findFirst7ByOrderBySDateMyDateDesc();
       List<Sale> findBySDateMyDateAfter(Date date);
       List<Sale> findFirst1ByOrderBySDateMyDateDesc();
       List<Sale> findByPipeline(String pipeline);
       List<Sale> findByPipelineAndSDateMyDateAfter(String pipeline, Date date);
       long countByPipeline(String pipeline);
       long countByPipelineAndSDateMyDateAfter(String pipeline, Date date);

}
