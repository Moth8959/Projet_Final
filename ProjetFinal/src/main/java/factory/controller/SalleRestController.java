package factory.controller;

import java.util.List;

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

import factory.model.Salle;
import factory.dao.SalleDao;
import factory.model.Views;
@RestController
@RequestMapping("/salle")
@CrossOrigin(origins = "*") 
public class SalleRestController {

	@Autowired
	private SalleDao salleDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewSalle.class)
	public List<Salle> list(){
		return salleDao.findAll();
	}
	
	@GetMapping("/{code}")
	@ResponseBody
	@JsonView(Views.ViewSalle.class)
	public Salle find(@PathVariable String code) {
		Salle salle = salleDao.findByCode(code);
		if(salle != null) {
			return salle;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewSalle.class)
	public void create(@RequestBody Salle salle) {
		salleDao.save(salle);
	}
	
	@PutMapping("/{code}")
	@JsonView(Views.ViewSalle.class)
	public void update(@RequestBody Salle salle, @PathVariable String code) {
		salleDao.save(salle);
	}
	
	@DeleteMapping("/{code}")
	@JsonView(Views.ViewSalle.class)
	public void delete(@PathVariable String code) {
		salleDao.delete(salleDao.findByCode(code));
	}

}
