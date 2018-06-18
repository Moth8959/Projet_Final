package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Salle;

public interface SalleDao extends JpaRepository<Salle, String>{
	Salle findByCode(String code);
}