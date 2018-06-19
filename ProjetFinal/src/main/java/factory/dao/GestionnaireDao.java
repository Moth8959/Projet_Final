package factory.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import factory.model.Gestionnaire;


public interface GestionnaireDao extends JpaRepository <Gestionnaire, Long>{
	
	@Query("select distinct g from Gestionnaire g left join fetch g.formations gf where g.id = :id")
	Gestionnaire findByIdWithFormations(@Param("id") Long id); 
	
	
}
