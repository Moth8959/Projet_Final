package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.Module;

public interface ModuleDao extends JpaRepository<Module, Long>{

}
