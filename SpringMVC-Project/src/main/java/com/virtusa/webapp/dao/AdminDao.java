package com.virtusa.webapp.dao;

import com.virtusa.webapp.model.Admin;
import com.virtusa.webapp.model.User;

public interface AdminDao {
	
	boolean addAdmin(Admin admin);
	void updateAdmin(Admin admin);
	Admin getAdmin(String username);
	void deleteAdmin(Admin admin);
	boolean loginCheck(User u);

}
