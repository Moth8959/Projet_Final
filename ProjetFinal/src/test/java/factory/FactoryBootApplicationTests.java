package factory;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



import factory.dao.ModuleDao;
import factory.model.Salle;
import factory.model.Module;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryBootApplicationTests {
	
	@Autowired
	private ModuleDao moduleDao;


	@Test
	public void contextLoads() {
		
		Module module = new Module(new Salle("gcffy", 10.2d,4), new Date(), new Date());
		moduleDao.save(module);
		
		
	}
	


}
