package factory.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import factory.model.Views;

@Entity
@Table(name = "subject")
public class Matiere {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "title", length = 100)
	@JsonView(Views.ViewCommon.class)
	private String titre;
	@Enumerated(EnumType.STRING)
	@Column(name = "level", length = 30)
	@JsonView(Views.ViewCommon.class)
	private NivEnum niveau;
	@Column(name = "aim", length = 40)
	@JsonView(Views.ViewCommon.class)
	private String objectif;
	@Column(name = "contents", length = 40)
	@JsonView(Views.ViewCommon.class)
	private String contenu;
//	@Column(name = "prerequisites")
//	@JsonView(Views.ViewCommon.class)
//	private Matiere prerequis;
	@ManyToMany(mappedBy = "matieres")
	@JsonView(Views.ViewMatiere.class)
	private List<Formateur> formateurs = new ArrayList<>();
	@OneToMany(mappedBy = "matiere")
	@JsonView(Views.ViewMatiereWithModules.class)
	private List<Module> modules = new ArrayList<>();
	
	/**** CONSTRUCTEURS*/
	
	public Matiere() {
		super();
	}
	
	public Matiere(String titre, NivEnum niveau, String objectif, String contenu) {
		super();
		this.titre = titre;
		this.niveau = niveau;
		this.objectif = objectif;
		this.contenu = contenu;
	}
	
//	public Matiere(String titre, NivEnum niveau, String objectif, String contenu, Matiere prerequis) {
//		super();
//		this.titre = titre;
//		this.niveau = niveau;
//		this.objectif = objectif;
//		this.contenu = contenu;
//		this.prerequis = prerequis;
//	}

	/**** METHODES*/	
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public NivEnum getNiveau() {
		return niveau;
	}

	public void setNiveau(NivEnum niveau) {
		this.niveau = niveau;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

//	public Matiere getPrerequis() {
//		return prerequis;
//	}
//
//	public void setPrerequis(Matiere prerequis) {
//		this.prerequis = prerequis;
//	}



}
