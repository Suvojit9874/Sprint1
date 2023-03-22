package com.ars_vc.serviceImpl;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;

import com.ars_vc.exception.GlobalException;
import com.ars_vc.model.AdminDTO;
import com.ars_vc.dao.AdminDao;
import com.ars_vc.daoImpl.AdminDaoImpl;
import com.ars_vc.entity.Admin;
import com.ars_vc.service.AdminService;

public class AdminServiceImpl implements AdminService{
	AdminDao aDao=new AdminDaoImpl();
	@Override
	public void registerAdmin(Admin admin) {
		aDao.registerAdmin(admin);
		
	}

	@Override
	public boolean loginAdmin(String userName, String password) {
		
		return aDao.loginAdmin(userName, password);
	}
	//method for get admin  in service layer
			@Override
			public AdminDTO getAdminById(int id) {
				Admin admin	=aDao.getAdminById(id);
				if(admin!=null)
				{
					
					return new ModelMapper().map(admin, AdminDTO.class); //converting entity to DTO
				}
					throw new GlobalException("Admin details does not exist!!");
			}
			//method for delete admin  in service layer
			@Override
			public void deleteAdmin(int id) throws PersistenceException {
				
				aDao.deleteAdmin(id);
				
			}
			//method for update admin  in service layer
			@Override
			public AdminDTO updateAdmin(int id, Admin admin) {
				Admin a=aDao.updateAdmin(id, admin);
				
				return new ModelMapper().map(a, AdminDTO.class); //converting entity to DTO
			}

}
