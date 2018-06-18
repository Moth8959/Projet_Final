package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Gestionnaire;

public interface GestionnaireDao extends JpaRepository <Gestionnaire, Long>{

}
