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

import factory.dao.MatiereDao;
import factory.model.Matiere;
import factory.model.Views;

@RestController
@RequestMapping("/matiere")
@CrossOrigin(origins="*")
public class MatiereRestController {
	
	@Autowired
	private MatiereDao matiereDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewMatiere.class)
	public List<Matiere> list() {
		return matiereDao.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	@JsonView(Views.ViewMatiere.class)
	public Matiere find(@PathVariable Long id) {
		Optional<Matiere> matiere = matiereDao.findById(id);
		if(matiere.isPresent()) {
			return matiereDao.findById(id).get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewMatiere.class)
	public void create(@RequestBody Matiere matiere) {
		matiereDao.save(matiere);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewMatiere.class)
	public void update(@RequestBody Matiere matiere, @PathVariable Long id) {
		matiereDao.save(matiere);
	}
	
	@DeleteMapping("/{id}")
	@JsonView(Views.ViewMatiere.class)
	public void delete(@PathVariable Long id) {
		matiereDao.deleteById(id);
	}

}
