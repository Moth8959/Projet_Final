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

import factory.model.Ordinateur;
import factory.dao.OrdinateurDao;
import factory.model.Views;
@RestController
@RequestMapping("/ordinateur")
@CrossOrigin(origins = "*") 
public class OrdinateurRestController {

	@Autowired
	private OrdinateurDao ordinateurDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewOrdinateur.class)
	public List<Ordinateur> list(){
		return ordinateurDao.findAll();
	}
	
	@GetMapping("/{code}")
	@ResponseBody
	@JsonView(Views.ViewOrdinateur.class)
	public Ordinateur find(@PathVariable String code) {
		Ordinateur ordinateur = ordinateurDao.findByCode(code);
		if(ordinateur != null) {
			return ordinateur;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewOrdinateur.class)
	public void create(@RequestBody Ordinateur ordinateur) {
		ordinateurDao.save(ordinateur);
	}
	
	@PutMapping("/{code}")
	@JsonView(Views.ViewOrdinateur.class)
	public void update(@RequestBody Ordinateur ordinateur, @PathVariable String code) {
		ordinateurDao.save(ordinateur);
	}
	
	@DeleteMapping("/{code}")
	@JsonView(Views.ViewOrdinateur.class)
	public void delete(@PathVariable String code) {
		ordinateurDao.delete(ordinateurDao.findByCode(code));
	}

}
