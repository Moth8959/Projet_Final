package factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import factory.dao.*;
import factory.model.*;

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
		
		
		
		Matiere java = new Matiere("Java débutant", NivEnum.Débutant, "Apprentissage des bases de java", "Notions d'objets et de classes");
		VideoProjecteur videoProjecteur = new VideoProjecteur("Acer", 20d, "1920x1080", true, true);
		videoProjecteurDao.save(videoProjecteur);
 		
		
		
		Module moduleJava = new Module(salle2, new Date(), new Date());
		moduleJava.setMatiere(java);

		
		Module module = new Module(salle1, new Date(), new Date());
		Module module1 = new Module(mat1, salle1, eric, new Date(), new Date(), videoProj1);
		Technicien technicien = new Technicien("Terieur", "Alain", "alain.terieur@ajc.fr", "6 rue Rougemont", "Paris", "75008");
		
		matiereDao.save(java);
		technicienDao.save(technicien);

		Gestionnaire gestionnaire1 = new Gestionnaire("Gestionnaire", "Jacques", "0606006066", "3 rue du cul de sac", "Villeneuve", "65236");
		
		List<Module> listeModules = new ArrayList<>();
		listeModules.add(module);
		listeModules.add(module1);
		listeModules.add(moduleJava);
		
		moduleDao.save(moduleJava);
		technicienDao.save(technicien);
		moduleDao.save(module);
		moduleDao.save(module1);
		
		Stagiaire massi = new Stagiaire("Dziri", "Massinissa","0315653456", "4 rue de la paix", "Paris", "75001", NivEnum.Expert);
		Stagiaire eleve1 = new Stagiaire("Bonblanc", "Jean","0715653789", "4 rue de l'impasse", "Villeneuve", "65874", NivEnum.Débutant);

		List<Stagiaire> listeStagiaires = new ArrayList<>();
		listeStagiaires.add(massi);
		listeStagiaires.add(eleve1);

		
		Formation formation = new Formation(listeModules, listeStagiaires, gestionnaire1);
		List<Formation> listeFormations = new ArrayList<>();
		listeFormations.add(formation);
		gestionnaire1.setFormations(listeFormations);
		massi.setFormation(formation);

		gestionnaireDao.save(gestionnaire1);
		formationDao.save(formation);
		stagiaireDao.save(massi);
		stagiaireDao.save(eleve1);

		
	}
	


}
