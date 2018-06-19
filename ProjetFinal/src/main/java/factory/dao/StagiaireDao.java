package factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import factory.model.Stagiaire;

public interface StagiaireDao extends JpaRepository<Stagiaire, Long> {
	
	@Query("select distinct s from Stagiaire s left join fetch s.ordinateur so where s.id = :id")
	Stagiaire findByIdWithOrdinateurs(@Param("id") Long id);
	
	@Query("select distinct s from Stagiaire s left join fetch s.ordinateur o")
    List<Stagiaire> findAllWithOrdinateurs();
	
	

}
