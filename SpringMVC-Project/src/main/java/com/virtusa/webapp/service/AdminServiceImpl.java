package com.virtusa.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.webapp.dao.AdminDao;
import com.virtusa.webapp.model.Admin;
import com.virtusa.webapp.model.User;

@Service
public class AdminServiceImpl implements AdminService{
	
	
	@Autowired(required = true)
	AdminDao adminDao;

	@Override
	@Transactional
	public void updateAdmin(Admin admin) {
		adminDao.updateAdmin(admin);
		
	}

	@Override
	@Transactional
	public boolean addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	@Transactional
	public void deleteAdmin(Admin admin) {
		adminDao.deleteAdmin(admin);
		
	}

	@Override
	@Transactional
	public boolean loginCheck(User user) {
		return adminDao.loginCheck(user);
	}

}
