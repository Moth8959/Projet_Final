package factory.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Formateur;

public interface FormateurDao extends JpaRepository<Formateur, Long> {

}
