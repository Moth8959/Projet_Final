package factory;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import factory.dao.ModuleDao;
import factory.dao.SalleDao;
import factory.dao.VideoProjecteurDao;
import factory.model.Module;
import factory.model.Salle;
import factory.model.VideoProjecteur;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryBootApplicationTests {
	
	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private SalleDao salleDao;
	


	@Test
	public void contextLoads() {
		
		Salle salle1 = new Salle("Saphir", 100d, 15);
		Salle salle2 = new Salle("Emeraude", 80d, 20);
		Salle salle3 = new Salle("Ebène", 50d, 10);
		salleDao.save(salle1);
		salleDao.save(salle2);
		salleDao.save(salle3);
		
		
		
		Module module = new Module(salle1, new Date(), new Date());
		moduleDao.save(module);
		
		
	}
	


}
