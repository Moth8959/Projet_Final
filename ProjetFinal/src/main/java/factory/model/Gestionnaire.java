package factory.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity 
@Table(name="manager")
@SequenceGenerator(name= "seqGestionnaire", sequenceName = "manager_sequence")
public class Gestionnaire extends RessourcesHumaines {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id; 

	@OneToMany(mappedBy="gestionnaire")
	@JsonView(Views.ViewGestionnaireWithFormations.class)
	private List <Formation> formations;

	
	/**** CONSTRUCTEURS*/
	
	public Gestionnaire() {
		super();
	}
	
	public Gestionnaire(String nom, String prenom, String coordonnees, String rue, String ville,
			String codePostal, Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire,
			Boolean accesTechnicien, String username, String password) {
		
		super(nom, prenom, coordonnees, rue, ville, codePostal, accesAdministrateur, accesAdministrateur,
				accesStagiaire, accesTechnicien, username, password);
	}
	
	public Gestionnaire(String nom, String prenom, String coordonnees, String rue, String ville,
			String codePostal) {
		super(nom, prenom, coordonnees, rue, ville, codePostal);
	}

	public Gestionnaire(List<Formation> formations) {
		super();
		this.formations = formations;
	}

	/**** METHODES*/	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Formation> getFormations() {
		return formations;
	}


	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}


	
	

}
