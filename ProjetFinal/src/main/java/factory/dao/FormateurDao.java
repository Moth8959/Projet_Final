package factory.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import factory.model.Formateur;

public interface FormateurDao extends JpaRepository<Formateur, Long> {
	
	
	@Query("select distinct f from Formateur f left join fetch f.formations ff where f.id = :id")
	Formateur findByIdWithFormations(@Param("id") Long id);
	
	@Query("select distinct f from Formateur f left join fetch f.modules fm where f.id = :id")
	Formateur findByIdWithModules(@Param("id") Long id);

}
