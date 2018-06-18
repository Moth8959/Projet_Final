package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Formation;

public interface FormationDao extends JpaRepository<Formation, Long> {

}
