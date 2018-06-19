package factory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import factory.dao.StagiaireDao;
import factory.model.Stagiaire;
import factory.model.Views;

@RestController
@RequestMapping("/stagiaire")
//@CrossOrigin(origins="http://localhost:4200") //on peut avoir des soucis au niveau de POSTMAN avec cette URL
@CrossOrigin(origins="*")
public class StagiaireRestController {

	
	@Autowired
	private StagiaireDao stagiaireDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewCommon.class)
	public List<Stagiaire> list() {
		return stagiaireDao.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire find(@PathVariable Long id) {
		Optional<Stagiaire> stagiaire = stagiaireDao.findById(id);
		if(stagiaire.isPresent()) {
			return stagiaireDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewStagiaire.class)
	public void create(@RequestBody Stagiaire stagiaire) {
		stagiaireDao.save(stagiaire);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public void update(@RequestBody Stagiaire stagiaire, @PathVariable Long id) {
		stagiaireDao.save(stagiaire);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public void delete(@PathVariable Long id) {
		stagiaireDao.deleteById(id);
	}

	
	
}
