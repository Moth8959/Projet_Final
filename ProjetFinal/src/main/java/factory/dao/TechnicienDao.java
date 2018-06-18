package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Technicien;

public interface TechnicienDao extends JpaRepository <Technicien,Long> {

}
