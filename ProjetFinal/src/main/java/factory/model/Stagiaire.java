package factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "trainee")
// @SecondaryTable(name = "trainee_lazy")
@SequenceGenerator(name = "seqStagiaire", sequenceName = "trainee_sequence")
public class Stagiaire extends RessourcesHumaines{

	
	@Id
	@GeneratedValue(generator = "seqStagiaire")
	@JsonView(Views.ViewCommon.class)
	private Long id;
	
	@ManyToOne
	@JsonView(Views.ViewCommon.class)
	@JoinColumn(name = "training_id")
	private Formation formation;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "level", length = 30)
	@JsonView(Views.ViewCommon.class)
	private NivEnum niveau;
	
	@ManyToOne
	@JoinColumn(name = "computer_id")
	@JsonView(Views.ViewCommon.class)
	private Ordinateur ordinateur;

	
	/**** CONSTRUCTEURS*/
	
	public Stagiaire() {
		super();
	}

	public Stagiaire(String nom, String prenom, String coordonnees, String rue, String ville,
			String codePostal, Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire,
			Boolean accesTechnicien, String username, String password, Formation formation, NivEnum niveau, Ordinateur ordinateur) {
		super(nom, prenom, coordonnees, rue, ville, codePostal, accesAdministrateur, accesAdministrateur,
				accesStagiaire, accesTechnicien, username, password);
		this.formation = formation;
		this.niveau = niveau;
		this.ordinateur = ordinateur;
	}
	
	public Stagiaire(String nom, String prenom, String coordonnees, String rue, String ville,
			String codePostal, Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire,
			Boolean accesTechnicien, String username, String password, NivEnum niveau) {
		super(nom, prenom, coordonnees, rue, ville, codePostal, accesAdministrateur, accesAdministrateur,
				accesStagiaire, accesTechnicien, username, password);
		this.niveau = niveau;
	}
	
	public Stagiaire(String nom, String prenom, String coordonnees, String rue, String ville,
			String codePostal, NivEnum niveau) {
		super(nom, prenom, coordonnees, rue, ville, codePostal);
		this.niveau = niveau;
	}

	/**** METHODES*/	
	
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public NivEnum getNivEnum() {
		return niveau;
	}

	public void setNivEnum(NivEnum niveau) {
		this.niveau = niveau;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
	
	
	
}
