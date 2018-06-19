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

import factory.dao.GestionnaireDao;
import factory.model.Gestionnaire;
import factory.model.Views;

@RestController
@RequestMapping("/gestion")
//@CrossOrigin(origins="http://localhost:4200") //on peut avoir des soucis au niveau de POSTMAN avec cette URL
@CrossOrigin(origins="*")
public class GestionnaireRestController {
	
	@Autowired
	private GestionnaireDao gestionnaireDao; 
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewGestionnaire.class)
	public List<Gestionnaire> list() {
		return gestionnaireDao.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewGestionnaire.class)
	public Gestionnaire find(@PathVariable Long id) {
		Optional<Gestionnaire> gestionnaire = gestionnaireDao.findById(id);
		if(gestionnaire.isPresent()) {
			return gestionnaireDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
 
	
	@PostMapping("")
	@JsonView(Views.ViewGestionnaire.class)
	public void create(@RequestBody Gestionnaire gestionnaire) {
		gestionnaireDao.save(gestionnaire);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewTechnicien.class)
	public void update(@RequestBody Gestionnaire gestionnaire, @PathVariable Long id) {
	     gestionnaireDao.save(gestionnaire);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewTechnicien.class)
	public void delete(@PathVariable Long id) {
		gestionnaireDao.deleteById(id);
	}


}
