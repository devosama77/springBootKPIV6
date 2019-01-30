package org.osama.kpi.repository;



import org.osama.kpi.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<UserInfo, Integer> {
    List<UserInfo>  findByUserName(String name);


}
