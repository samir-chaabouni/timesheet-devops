package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {
	@Autowired
	IEmployeService es;

	@Test
	@Order(1)
	public void testgetallEmploye(){
		List<Employe> listEmploye= es.getallEmploye();
		Assertions.assertEquals(0,listEmploye.size());
	}
	@Test
	@Order(2)
	public void testaddEmploye(){
		Employe employe = new Employe("ali","ali","ali@ali.com","1234",true,Role.INGENIEUR);
		Employe employeadd =es.addEmploye(employe);
		Assertions.assertEquals(employe.getEmail(),employeadd.getEmail());
	}
	@Test
	@Order(3)
	public void testupdateEmploye(){
		Employe employe = new Employe(1,"med","med","med@med.com","1234",true,Role.INGENIEUR);
		Employe employeadd =es.updateEmploye(employe);
		Assertions.assertEquals(employe.getEmail(),employeadd.getEmail());
	}
	@Test
	@Order(4)
	public void testretriveEmploye(){
		Employe getemploye =es.retriveEmploye(1);
		Assertions.assertEquals(1,getemploye.getId());
	}
	@Test
	@Order(4)
	public void testdeleteEmploye(){
		es.deleteEmploye(1);
		Assertions.assertNull(es.retriveEmploye(1));
	}
}
