package org.osama.kpi.dao.impl;


import org.osama.kpi.dao.UserInfoDAO;
import org.osama.kpi.model.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UserInfoDAOImpl implements UserInfoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public UserInfo getActiveUser(String userName) {
		UserInfo userInfo = new UserInfo();
		short ENABLED = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=? and enabled=?")
				.setParameter(1, userName).setParameter(2, ENABLED).getResultList();
		if (!list.isEmpty()) {
			userInfo = (UserInfo) list.get(0);
		}
		return userInfo;
	}
}