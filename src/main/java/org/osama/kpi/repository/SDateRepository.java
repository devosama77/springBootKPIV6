package org.osama.kpi.repository;

import org.osama.kpi.model.SDate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SDateRepository extends CrudRepository<SDate,Integer> {
    List<SDate> findFirst1ByOrderByMyDateDesc();

}
