package factory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "module")
@SequenceGenerator(name = "seqModule", sequenceName = "module_sequence")
public class Module {
		@Id
		@GeneratedValue(generator = "seqModule")
		@JsonView(Views.ViewCommon.class)
	private Long id;
		@ManyToOne
		@JoinColumn(name = "subject_id")
		@JsonView(Views.ViewCommon.class)
	private Matiere matiere;
		@OneToOne
		@JsonView(Views.ViewCommon.class)
	private Salle salle;
		@OneToOne(mappedBy="module")
		@JsonView(Views.ViewCommon.class)
	private Formateur formateur;
		@Temporal(TemporalType.DATE)
		@Column(name = "startDate")
		@JsonView(Views.ViewCommon.class)
	private Date dateDebut;
		@Temporal(TemporalType.DATE)
		@Column(name = "endDate")
		@JsonView(Views.ViewCommon.class)
	private Date dateFin;
		@ManyToOne
		@JoinColumn(name = "projector_id")
		@JsonView(Views.ViewCommon.class)
	private VideoProjecteur videoProjecteur;
		@ManyToOne
		@JoinColumn(name = "training_id")
		@JsonView(Views.ViewCommon.class)
	private Formation formation;
	
	
/**** CONSTRUCTEURS*/
	
	public Module() {
		super();
	}
	public Module(Salle salle, Date dateDebut, Date dateFin) {
		super();
		this.salle = salle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Module(Matiere matiere, Salle salle, Formateur formateur, Date dateDebut, Date dateFin, VideoProjecteur videoProjecteur) {
		this(salle, dateDebut, dateFin);
		this.matiere = matiere;
		this.formateur = formateur;
		this.videoProjecteur = videoProjecteur;
	}

/**** METHODES*/	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public VideoProjecteur getVideoProjecteur() {
		return videoProjecteur;
	}
	public void setVideoProjecteur(VideoProjecteur videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}
	
	@Override
	public String toString() {
		return "Module [id=" + id + ", salle=" + salle + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", videoProjecteur=" + videoProjecteur + "]";
	}

}
