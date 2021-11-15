package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {
	@Autowired
	EmployeRepository employeRepository;
	
//  Logger 
	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	@Override
	public List<Employe> getallEmploye() {
		List<Employe> employes = null;
		try{
			l.info("In getallEmploye() :");
			employes = (List<Employe>) employeRepository.findAll();
			l.info("out of getallEmploye() :");
		}catch(Exception e){
			l.error("Error in getallEmploye() :"+e);
		}
		return employes;
	}

	@Override
	public void deleteEmploye(int id) {
		// Log en début de la méthode 
		l.info("In deleteEmploye()");
		employeRepository.deleteById((long) id);
		l.info("Out deleteEmploye()");
	}

	@Override
	public Employe updateEmploye(Employe e) {
		// Log  en début de la méthode 
		l.info("In updateEmploye()");
		Employe employe=employeRepository.save(e);
		//  Log à la fin de la méthode 
		l.info("Out updateUser()");
			return employe;
	}

	@Override
	public Employe retriveEmploye(int id) {
	//  Log en début de la méthode 
			l.info("In retrieveUser()");
			Employe employe = null;
			try{
				l.info("In retriveEmploye() :");
				employe = employeRepository.findById((long) id).get();
				l.info("out of retriveEmploye() :");
			}catch(Exception e){
				l.error("Error in retriveEmploye() :"+e);
			}
			return employe;
	}

	@Override
	public Employe addEmploye(Employe e) {
		// Log  en début de la méthode 
				l.info("In addEmploye()");
				Employe employe=employeRepository.save(e);
				//  Log à la fin de la méthode 
				l.info("Out addEmploye()");
					return employe;
	}

}
