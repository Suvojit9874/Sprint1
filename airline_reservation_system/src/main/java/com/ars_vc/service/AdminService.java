package com.ars_vc.service;

import javax.persistence.PersistenceException;

import com.ars_vc.model.AdminDTO;
import com.ars_vc.entity.Admin;

public interface AdminService {
	void registerAdmin(Admin admin);
	boolean loginAdmin(String userName,String password);
	AdminDTO getAdminById(int id);
	void deleteAdmin(int id) throws PersistenceException;
	AdminDTO updateAdmin(int id, Admin admin);
	

}
