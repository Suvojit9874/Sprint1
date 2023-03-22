package com.ars_vc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars_vc.config.HibernateUtil;
import com.ars_vc.entity.Admin;
import com.ars_vc.model.AdminDTO;
import com.ars_vc.service.AdminService;
import com.ars_vc.serviceImpl.AdminServiceImpl;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminTest {
	AdminService adminService=new AdminServiceImpl();
	public static SessionFactory sessionFactory;
	private Session session;
	@BeforeAll
	static void setUp()
	{
		sessionFactory=HibernateUtil.getSessionFactory();
	}
@BeforeEach
void openSession()
{
	session= sessionFactory.openSession();
	}
@AfterEach
void closeSession()
{
	if(session!=null)
		session.close();
	System.out.println("session closed");
	}
@AfterAll
static void tearDown()
{
	if(sessionFactory!=null)
		sessionFactory.close();
	System.out.println("Session factory closed");
	}

//testing for admin registration
@Test
@Order(1)
void testRegisterAdmin()
{
	Transaction tx=session.beginTransaction();
	Admin admin=Admin.builder().aName("Nilanjan").email("nilanjan@gmail.com").UserName("nil123").password("nil@123").role("admin").build();
	Integer i=(Integer)session.save(admin);
	tx.commit();
	assertThat(i>0).isTrue();
}

// testing for get Admin
@Test
@Order(2)
void testGetAdminById()
{
	AdminDTO adto=adminService.getAdminById(5);
	assertThat(adto.getAName()).isEqualTo("Nilanjan");
	}

//this method is use for update Admin
@Test
@Order(3)
void testUpdateAdminById()
{
	Transaction tx=session.beginTransaction();
	Admin ad=new Admin();
	ad.setAName("Nilanjan Dasgupta");
	AdminDTO adto=adminService.updateAdmin(5, ad);
	tx.commit();
	assertThat(adto.getAName()).isEqualTo("Nilanjan Dasgupta");
	}

//testing for delete admin
@Test
@Order(4)
@DisplayName(value="Negetive Test Case")
void testDeleteAdmin()
{
	adminService.deleteAdmin(16);
	assertThrows(HibernateException.class,()->adminService.getAdminById(16));
	}

}
