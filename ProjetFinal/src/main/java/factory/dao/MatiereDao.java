package factory.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import factory.model.Matiere;


public interface MatiereDao extends JpaRepository<Matiere, Long>{
	
	@Query("select distinct m from Matiere m left join fetch m.modules mo where m.id = :id")
	Matiere findByIdWithModules(@Param("id") Long id);
	
	@Query("select distinct m from Matiere m left join fetch m.formateurs f where m.id = :id")
	Matiere findByWithFormateurs(@Param("id") Long id);
	
}
