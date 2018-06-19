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

import factory.dao.FormateurDao;
import factory.model.Formateur;
import factory.model.Views;

@RestController
@RequestMapping("/formateur")
@CrossOrigin(origins="*")
public class FormateurRestController {
	
	@Autowired
	private FormateurDao formateurDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewFormateur.class)
	public List<Formateur> list() {
		return formateurDao.findAll();
	}
	
//	@GetMapping("formation/{id}")
//	@ResponseBody
//	@JsonView(Views.ViewFormateurWithFormations.class)
//	public Formateur findWithFormations(@PathVariable Long id) {
//		return formateurDao.findByIdWithFormations(id);
//	}
//	
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewFormateur.class)
	public Formateur find(@PathVariable Long id) {
		Optional<Formateur> formateur = formateurDao.findById(id);
		if(formateur != null) {
			return formateurDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	
	@PostMapping("")
	@JsonView(Views.ViewFormateur.class)
	public void create(@RequestBody Formateur formateur) {
		formateurDao.save(formateur);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewFormateur.class)
	public void update(@RequestBody Formateur formateur, @PathVariable Long id) {
		formateurDao.save(formateur);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewFormateur.class)
	public void delete(@PathVariable Long id) {
		formateurDao.deleteById(id);
	}

}
