package factory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "trainer")
public class Formateur extends RessourcesHumaines {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@ManyToMany
	@JoinTable(name = "trainer_subject", joinColumns = {@JoinColumn(name = "trainer_id")}, inverseJoinColumns = { @JoinColumn(name = "subject_id")})
	@JsonView(Views.ViewFormateur.class)
	private List<Matiere> matieres = new ArrayList<>();
	@OneToOne
	@JsonView(Views.ViewCommon.class)
	@JoinColumn(name = "training_id")
	private Formation formation;
	@OneToOne(mappedBy = "formateur")
	@JsonView(Views.ViewCommon.class)
	private Module module;

	public Formateur() {
		super();
	}

	
	
	public Formateur(String nom, String prenom, String coordonnées, String rue, String ville, Integer codePostal,
			Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire, Boolean accesTechnicien,
			String username, String password) {
		super(nom, prenom, coordonnées, rue, ville, codePostal, accesAdministrateur, accesFormateur, accesStagiaire,
				accesTechnicien, username, password);
	}

	

	public Formateur(String nom, String prenom, String coordonnées, String rue, String ville, Integer codePostal,
			Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire, Boolean accesTechnicien,
			String username, String password, Long id, List<Matiere> matieres, Formation formation, Module module) {
		this(nom, prenom, coordonnées, rue, ville, codePostal, accesAdministrateur, accesFormateur, accesStagiaire,
				accesTechnicien, username, password);
		this.id = id;
		this.matieres = matieres;
		this.formation = formation;
		this.module = module;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	

}
