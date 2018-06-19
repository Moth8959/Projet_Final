package factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import factory.model.Matiere;


public interface MatiereDao extends JpaRepository<Matiere, Long>{
	
	@Query("select distinct m from Matiere m left join fetch m.modules m where m.id = :id")
	List<Matiere> findwithAllModules(@Param("id") Long id);
	
	@Query("select distinct m from Matiere m left join fetch m.formateurs f here m.id = :id")
	List<Matiere> findwithFormateurs(@Param("id") Long id);
	
}
