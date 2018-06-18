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

import factory.dao.TechnicienDao;
import factory.model.Technicien;
import factory.model.Views;


@RestController
@RequestMapping ("/rest/technicien")
@CrossOrigin(origins="*")
public class TechnicienRestController {
	
	@Autowired
	private TechnicienDao technicienDao; 
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewTechnicien.class)
	public List<Technicien> list() {
		return technicienDao.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewTechnicien.class)
	public Technicien find(@PathVariable Long id) {
		Optional<Technicien> technicien = technicienDao.findById(id);
		if(technicien.isPresent()) {
			return technicienDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
 
	
	@PostMapping("")
	@JsonView(Views.ViewTechnicien.class)
	public void create(@RequestBody Technicien technicien) {
		technicienDao.save(technicien);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewTechnicien.class)
	public void update(@RequestBody Technicien technicien, @PathVariable Long id) {
	     technicienDao.save(technicien);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewTechnicien.class)
	public void delete(@PathVariable Long id) {
		technicienDao.deleteById(id);
	}


}
