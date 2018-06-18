package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Ordinateur;

public interface OrdinateurDao extends JpaRepository<Ordinateur, Long>{
	
	Ordinateur findByCode(String code);
}
