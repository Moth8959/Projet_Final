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

import factory.dao.FormationDao;
import factory.model.Formation;
import factory.model.Views;

@RestController
@RequestMapping("/rest/formation")
//@CrossOrigin(origins="http://localhost:4200") //on peut avoir des soucis au niveau de POSTMAN avec cette URL
@CrossOrigin(origins="*")
public class FormationRestController {
	
	@Autowired
	private FormationDao formationDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewCommon.class)
	public List<Formation> list() {
		return formationDao.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewFormation.class)
	public Formation find(@PathVariable Long id) {
		Optional<Formation> formation = formationDao.findById(id);
		if(formation.isPresent()) {
			return formationDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewFormation.class)
	public void create(@RequestBody Formation formation) {
		formationDao.save(formation);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewFormation.class)
	public void update(@RequestBody Formation formation, @PathVariable Long id) {
		formationDao.save(formation);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewFormation.class)
	public void delete(@PathVariable Long id) {
		formationDao.deleteById(id);
	}

}


