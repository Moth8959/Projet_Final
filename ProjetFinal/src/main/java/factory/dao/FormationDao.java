package factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import factory.model.Formation;


public interface FormationDao extends JpaRepository<Formation, Long> {
//	
//	@Query("select distinct f from Formation f left join fetch f.modules m")
//	List<Formation> findAllWithModules();
//	
//	@Query("select distinct f from Formation f left join fetch f.stagiaires s")
//	List<Formation> findAllWithStagiaires();
//	
	

}
