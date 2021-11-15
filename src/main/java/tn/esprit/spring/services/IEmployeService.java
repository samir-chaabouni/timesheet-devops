package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService {
	List<Employe> getallEmploye();
	Employe addEmploye(Employe e);
	void deleteEmploye(int id);
	Employe updateEmploye(Employe e);
	Employe retriveEmploye(int i);

}
