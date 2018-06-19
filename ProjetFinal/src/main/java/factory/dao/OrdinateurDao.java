package factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import factory.model.Ordinateur;



public interface OrdinateurDao extends JpaRepository<Ordinateur, String>{
	
	Ordinateur findByCode(String code);
	
	@Query(name = "Ordinateur.findAllByCode")
	List<Ordinateur> findAllByCode(@Param("recherche") String code);

	@Query("select distinct o from Ordinateur o left join fetch o.stagiaires s")
	List<Ordinateur> findAllWithStagiaires();
}
