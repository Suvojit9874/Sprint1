package com.ars_vc.dao;

import javax.persistence.PersistenceException;

import com.ars_vc.entity.Admin;

public interface AdminDao {

	void registerAdmin(Admin admin);
	boolean loginAdmin(String userName,String password);
	Admin getAdminById(int id);
	void deleteAdmin(int id) throws PersistenceException;
	Admin updateAdmin(int id, Admin admin);

}
