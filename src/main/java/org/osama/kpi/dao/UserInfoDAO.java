package org.osama.kpi.dao;


import org.osama.kpi.model.UserInfo;

public interface UserInfoDAO {
	public abstract UserInfo getActiveUser(String userName);
}