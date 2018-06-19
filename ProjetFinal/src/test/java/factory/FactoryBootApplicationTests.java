package factory;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import factory.dao.FormateurDao;
import factory.dao.FormationDao;
import factory.dao.GestionnaireDao;
import factory.dao.MatiereDao;
import factory.dao.ModuleDao;
import factory.dao.OrdinateurDao;
import factory.dao.SalleDao;
import factory.dao.StagiaireDao;
import factory.dao.TechnicienDao;
import factory.dao.VideoProjecteurDao;
import factory.model.Formateur;
import factory.model.Matiere;
import factory.model.Module;
import factory.model.NivEnum;
import factory.model.Ordinateur;
import factory.model.Salle;
import factory.model.Technicien;
import factory.model.VideoProjecteur;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryBootApplicationTests {
	
	@Autowired
	private FormateurDao formateurDao;
	@Autowired
	private FormationDao formationDao;
	@Autowired
	private GestionnaireDao gestionnaireDao;
	@Autowired
	private MatiereDao matiereDao;
	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private OrdinateurDao ordinateurDao;
	@Autowired
	private SalleDao salleDao;
	@Autowired
	private StagiaireDao stagiaireDao;
	@Autowired
	private TechnicienDao technicienDao;
	@Autowired
	private VideoProjecteurDao videoProjecteurDao;
	


	@Test
	public void contextLoads() {
		
		Salle salle1 = new Salle("Saphir", 100d, 15);
		Salle salle2 = new Salle("Emeraude", 80d, 20);
		Salle salle3 = new Salle("Ebène", 50d, 10);
		salleDao.save(salle1);
		salleDao.save(salle2);
		salleDao.save(salle3);
		
		VideoProjecteur videoProj1 = new VideoProjecteur("Acer", 20d, "1920x1080", true, true);
		videoProjecteurDao.save(videoProj1);
		
		Ordinateur ordi1 = new Ordinateur("AJC 160", 15d, "i5", 16, 500, 2016);
		Ordinateur ordi2 = new Ordinateur("AJC 168", 15d, "i5", 16, 500, 2016);
		ordinateurDao.save(ordi1);
		ordinateurDao.save(ordi2);
		
		Matiere mat1 = new Matiere("Spring Boot", NivEnum.Débutant, "connaître Spring Boot", "blabla de contenu");
		Matiere mat2 = new Matiere("Boostrap", NivEnum.Avancé, "être autonome sur Boostrap", "blabla de contenu");
		matiereDao.save(mat1);
		matiereDao.save(mat2);
		
		Formateur eric = new Formateur();
		formateurDao.save(eric);
		
		
		
 		
		
		
		Module module = new Module(mat1, salle1, eric, new Date(), new Date(), videoProj1);
		Technicien technicien = new Technicien("Terieur", "Alain", "alain.terieur@ajc.fr", "6 rue Rougemont", "Paris", "75008");
		technicienDao.save(technicien);
		moduleDao.save(module);
		
		
	}
	


}
