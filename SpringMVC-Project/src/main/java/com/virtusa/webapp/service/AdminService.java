package com.virtusa.webapp.service;

import com.virtusa.webapp.model.Admin;
import com.virtusa.webapp.model.User;

public interface AdminService {
	
	void updateAdmin(Admin admin);
	boolean addAdmin(Admin admin);
	void deleteAdmin(Admin admin);
	boolean loginCheck(User user);

}
