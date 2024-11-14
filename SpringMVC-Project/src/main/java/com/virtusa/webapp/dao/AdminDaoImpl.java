package com.virtusa.webapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.virtusa.webapp.model.Admin;
import com.virtusa.webapp.model.User;

@Repository
public class AdminDaoImpl implements AdminDao{
	
	@Autowired(required = true)
	HibernateTemplate hibernateTemplate;

	@Override
	public boolean addAdmin(Admin admin) {
		return false;
	}

	@Override
	public void updateAdmin(Admin admin) {
		hibernateTemplate.saveOrUpdate(admin);
		
	}

	@Override
	public Admin getAdmin(String username) {
		return hibernateTemplate.get(Admin.class, username);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		hibernateTemplate.delete(admin);
		
		
	}

	@Override
	public boolean loginCheck(User u) {
		if(hibernateTemplate.get(Admin.class,u.getUsername())==null) {
			return false;
		}
		else {
			Admin c=hibernateTemplate.get(Admin.class,u.getUsername());
			if(c.getPassword().equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
