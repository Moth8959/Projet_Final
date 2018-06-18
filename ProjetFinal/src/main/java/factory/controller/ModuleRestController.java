package factory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import factory.dao.ModuleDao;

@RestController
@RequestMapping("/rest/module")
public class ModuleRestController {
	
	@Autowired
	private ModuleDao moduleDao;


}
