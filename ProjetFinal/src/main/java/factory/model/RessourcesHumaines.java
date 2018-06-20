package factory.model;

import javax.persistence.Column;


import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonView;

@MappedSuperclass
public abstract class RessourcesHumaines {
	
   
   
	@JsonView(Views.ViewCommon.class)
	@Column(name="lastname", length=100)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	@Column(name="firstname", length=100)
	private String prenom; 
	@JsonView(Views.ViewCommon.class)
	@Column(name="phone_number", length=100)
	private String coordonnees;
	@JsonView(Views.ViewCommon.class)
	@Column(name="street", length=100)
	private String rue;
	@JsonView(Views.ViewCommon.class)
	@Column(name="city", length=100)
	private String ville;
	@JsonView(Views.ViewCommon.class)
	@Column(name="zip_code", length=100)
	private String codePostal;
	@JsonView(Views.ViewCommon.class)
	@Column(name="admnistrator_access", length=100)
	private Boolean accesAdministrateur;
	@JsonView(Views.ViewCommon.class)
	@Column(name="trainer_access", length=100)
	private Boolean accesFormateur;
	@JsonView(Views.ViewCommon.class)
	@Column(name="trainee_access", length=100)
	private Boolean accesStagiaire;
	@JsonView(Views.ViewCommon.class)
	@Column(name="tech_access", length=100)
	private Boolean accesTechnicien;
	@JsonView(Views.ViewCommon.class)
	@Column(name="username", length=100)
	private String username;
	@JsonView(Views.ViewCommon.class)
	@Column(name="password", length=100)
	private String password;

	
	/**** CONSTRUCTEURS*/

	public RessourcesHumaines() {
		super();
	}

	public RessourcesHumaines(String nom, String prenom, String coordonnees, String rue, String ville,
			String codePostal, Boolean accesAdministrateur, Boolean accesFormateur, Boolean accesStagiaire,
			Boolean accesTechnicien, String username, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.coordonnees = coordonnees;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.accesAdministrateur = accesAdministrateur;
		this.accesFormateur = accesFormateur;
		this.accesStagiaire = accesStagiaire;
		this.accesTechnicien = accesTechnicien;
		this.username = username;
		this.password = password;
	}

	public RessourcesHumaines(String nom, String prenom, String coordonnees, String rue, String ville,
			String codePostal) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.coordonnees = coordonnees;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
		this.accesAdministrateur = false;
		this.accesFormateur = false;
		this.accesStagiaire = false;
		this.accesTechnicien = false;
	}

	/**** METHODES*/	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Boolean getAccesAdministrateur() {
		return accesAdministrateur;
	}
	public void setAccesAdministrateur(Boolean accesAdministrateur) {
		this.accesAdministrateur = accesAdministrateur;
	}
	public Boolean getAccesFormateur() {
		return accesFormateur;
	}
	public void setAccesFormateur(Boolean accesFormateur) {
		this.accesFormateur = accesFormateur;
	}
	public Boolean getAccesStagiaire() {
		return accesStagiaire;
	}
	public void setAccesStagiaire(Boolean accesStagiaire) {
		this.accesStagiaire = accesStagiaire;
	}
	public Boolean getAccesTechnicien() {
		return accesTechnicien;
	}
	public void setAccesTechnicien(Boolean accesTechnicien) {
		this.accesTechnicien = accesTechnicien;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
		

}
