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
	private Long id;
	
	@ManyToOne
	@JsonView(Views.ViewCommon.class)
	@JoinColumn(name = "training_id")
	private Formation formation;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "level", length = 30)
	@JsonView(Views.ViewCommon.class)
	private NivEnum nivEnum;
	
	@ManyToOne
	@JoinColumn(name = "computer_id")
	@JsonView(Views.ViewStagiaireWithOrdinateurs.class)
	private Ordinateur ordinateur;

	
	/**** CONSTRUCTEURS*/
	
	public Stagiaire() {
		super();
	}

	public Stagiaire(String nom, String prenom, String coordonnées, String rue, String ville,
			String codePostal, Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire,
			Boolean accesTechnicien, String username, String password, Formation formation, NivEnum nivEnum, Ordinateur ordinateur) {
		super(nom, prenom, coordonnées, rue, ville, codePostal, accesAdministrateur, accesAdministrateur,
				accesStagiaire, accesTechnicien, username, password);
		this.formation = formation;
		this.nivEnum = nivEnum;
		this.ordinateur = ordinateur;
	}
	
	public Stagiaire(String nom, String prenom, String coordonnées, String rue, String ville,
			String codePostal, Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire,
			Boolean accesTechnicien, String username, String password, NivEnum nivEnum) {
		super(nom, prenom, coordonnées, rue, ville, codePostal, accesAdministrateur, accesAdministrateur,
				accesStagiaire, accesTechnicien, username, password);
		this.nivEnum = nivEnum;
	}
	
	public Stagiaire(String nom, String prenom, String coordonnées, String rue, String ville,
			String codePostal, NivEnum nivEnum) {
		super(nom, prenom, coordonnées, rue, ville, codePostal);
		this.nivEnum = nivEnum;
	}

	/**** METHODES*/	
	
	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public NivEnum getNivEnum() {
		return nivEnum;
	}

	public void setNivEnum(NivEnum nivEnum) {
		this.nivEnum = nivEnum;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}
	
	
	
}
