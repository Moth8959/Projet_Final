package factory.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="technician")
@SequenceGenerator(name= "seqTechnicien", sequenceName = "technician_sequence")
public class Technicien extends RessourcesHumaines{
 
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;

	
	/**** CONSTRUCTEURS*/
	
	public Technicien() {
		super();
	}

	public Technicien(String nom, String prenom, String coordonnées, String rue, String ville,
			String codePostal, Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire,
			Boolean accesTechnicien, String username, String password) {
		
		super(nom, prenom, coordonnées, rue, ville, codePostal, accesAdministrateur, accesAdministrateur,
				accesStagiaire, accesTechnicien, username, password);
	}

	public Technicien(String nom, String prenom, String coordonnées, String rue, String ville,
			String codePostal) {
		super(nom, prenom, coordonnées, rue, ville, codePostal);
	}

	/**** METHODES*/	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
