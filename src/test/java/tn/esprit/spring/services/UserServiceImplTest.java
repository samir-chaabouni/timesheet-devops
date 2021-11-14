package tn.esprit.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {
	@Autowired
	IUserService us;
	
	@Test
	@Order(1)
	public void testretrieveAllUsers(){
		List<User> listUsers = us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());
	}
	@Test
	@Order(2)
	public void testaddUser() throws ParseException {
		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dataformat.parse("2000-01-01");
		User user = new User("ali","ali",date,Role.INGENIEUR);
		User useradded = us.addUser(user);
		Assertions.assertEquals(user.getLastName(), useradded.getLastName());
	}
	@Test
	@Order(3)
	public void testupdateUser() throws ParseException {
		SimpleDateFormat dataformat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dataformat.parse("2000-01-01");
		User user = new User("med","med",date,Role.INGENIEUR);
		User userupdate = us.updateUser(user);
		Assertions.assertEquals(user.getLastName(), userupdate.getLastName());
	}
	
	@Test
	@Order(4)
	public void testretrieveUser(){
		User retrieveUser= us.retrieveUser("4");
		Assertions.assertEquals(4l, retrieveUser.getId().longValue());
	}
	
	@Test
	@Order(5)
	public void testdeleteUser(){
		us.deleteUser("4");
		Assertions.assertNull(us.retrieveUser("4"));
	}

}
