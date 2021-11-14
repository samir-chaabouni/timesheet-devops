package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	//  Logger 
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);
	
	// git test
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
			// Log en début de la méthode 
			l.info("In retriveneAllUsers() :");
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				// Log pour affiher chaque user dans les logs  
				l.debug("user +++ : "+user);
			} 
			//  Log à la fin de la méthode 
			l.info("out of retrieveAllUser() :");
		}catch (Exception e) {
			//  Log pour gérer les erreurs 
			l.error("Error in retrieveAllUser() :"+e);
		}

		return users;
	}


	@Override
	public User addUser(User u) {
		// Log en début de la méthode 
		l.info("IN adduser()");
		User u_saved = userRepository.save(u); 
		//  Log à la fin de la méthode 
		l.info("Out addUser()");
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// Log  en début de la méthode 
		l.info("In updateUser()");
		User u_saved = userRepository.save(u); 
		//  Log à la fin de la méthode 
		l.info("Out updateUser()");
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// Log en début de la méthode 
		l.info("In deleteUser()");
		userRepository.deleteById(Long.parseLong(id)); 
		//  Log à la fin de la méthode 
		l.info("Out deleteUser()");
	}

	@Override
	public User retrieveUser(String id) {
		//  Log en début de la méthode 
		l.info("In retrieveUser()");
		User u=null;
		try{
			//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
			 u =  userRepository.findById(Long.parseLong(id)).get(); 
		}catch(Exception e){
			l.error("Error in retrieveUser() :"+e);
		}
		
		
		// Log  à la fin de la méthode 
		l.info("Out retrieveUser()");
		return u; 
	}


}
