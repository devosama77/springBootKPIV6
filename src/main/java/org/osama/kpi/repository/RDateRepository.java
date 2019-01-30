package org.osama.kpi.repository;

import org.osama.kpi.model.RDate;
import org.osama.kpi.model.SDate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RDateRepository extends CrudRepository<RDate,Integer> {
    List<RDate> findFirst1ByOrderByMyDateDesc();
}
