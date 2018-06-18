package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Ordinateur;

public interface OrdinateurDao extends JpaRepository<Ordinateur, String>{
	
	Ordinateur findByCode(String code);
}
