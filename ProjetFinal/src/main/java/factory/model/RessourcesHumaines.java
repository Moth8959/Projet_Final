package factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class RessourcesHumaines {
    
	@JsonView(Views.ViewCommon.class)
	@Column(name="lastname", length=100)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	@Column(name="firstname", length=100)
	private String prenom; 
	@JsonView(Views.ViewCommon.class)
	@Column(name="phone_number", length=100)
	private String coordonnées;
	@JsonView(Views.ViewCommon.class)
	@Column(name="street", length=100)
	private String rue;
	@JsonView(Views.ViewCommon.class)
	@Column(name="city", length=100)
	private String ville;
	@JsonView(Views.ViewCommon.class)
	@Column(name="zip_code", length=100)
	private Integer codePostal;
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
	public String getCoordonnées() {
		return coordonnées;
	}
	public void setCoordonnées(String coordonnées) {
		this.coordonnées = coordonnées;
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
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Integer codePostal) {
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
