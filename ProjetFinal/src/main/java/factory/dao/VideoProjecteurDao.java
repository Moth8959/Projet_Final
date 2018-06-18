package factory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import factory.model.VideoProjecteur;

public interface VideoProjecteurDao extends JpaRepository<VideoProjecteur, Long>{
	VideoProjecteur findByCode(String code);
}