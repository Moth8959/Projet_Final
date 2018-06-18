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

import factory.model.VideoProjecteur;
import factory.dao.VideoProjecteurDao;
import factory.model.Views;
@RestController
@RequestMapping("/videoProjecteur")
@CrossOrigin(origins = "*") 
public class VideoProjecteurRestController {

	@Autowired
	private VideoProjecteurDao videoProjecteurDao;
	
	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewVideoProjecteur.class)
	public List<VideoProjecteur> list(){
		return videoProjecteurDao.findAll();
	}
	
	@GetMapping("/{code}")
	@ResponseBody
	@JsonView(Views.ViewVideoProjecteur.class)
	public VideoProjecteur find(@PathVariable String code) {
		VideoProjecteur videoProjecteur = videoProjecteurDao.findByCode(code);
		if(videoProjecteur != null) {
			return videoProjecteur;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewVideoProjecteur.class)
	public void create(@RequestBody VideoProjecteur videoProjecteur) {
		videoProjecteurDao.save(videoProjecteur);
	}
	
	@PutMapping("/{code}")
	@JsonView(Views.ViewVideoProjecteur.class)
	public void update(@RequestBody VideoProjecteur videoProjecteur, @PathVariable String code) {
		videoProjecteurDao.save(videoProjecteur);
	}
	
	@DeleteMapping("/{code}")
	@JsonView(Views.ViewVideoProjecteur.class)
	public void delete(@PathVariable String code) {
		videoProjecteurDao.delete(videoProjecteurDao.findByCode(code));
	}

}
