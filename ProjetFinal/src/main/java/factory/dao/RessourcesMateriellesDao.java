package factory.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import factory.model.Ordinateur;
import factory.model.VideoProjecteur;
import factory.model.RessourcesMaterielles;
import factory.model.Salle;

public interface RessourcesMateriellesDao extends JpaRepository<RessourcesMaterielles, Long>{

	@Query("select o from Ordinateur o")
	List<Ordinateur> findAllOrdinateur();
	@Query("select vp from VideoProjecteur vp")
	List<VideoProjecteur> findAllVideoProjecteur();
	@Query("select s from Salle s")
	List<VideoProjecteur> findAllSalle();
	
	
}
