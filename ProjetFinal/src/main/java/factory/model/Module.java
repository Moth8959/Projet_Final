package factory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "module")
@SequenceGenerator(name = "seqModule", sequenceName = "module_sequence")
public class Module {
	@Id
	@GeneratedValue(generator = "seqModule")
	@JsonView(Views.ViewCommon.class)
	private Long id;
//	private Matiere matiere;
	@JsonView(Views.ViewCommon.class)
	private Salle salle;
//	private Formateur formateur;
	@Column(name = "startDate")
	@JsonView(Views.ViewCommon.class)
	private Date dateDebut;
	@Column(name = "endDate")
	@JsonView(Views.ViewCommon.class)
	private Date dateFin;
	@Column(name = "startDate")
	@JsonView(Views.ViewCommon.class)
	private VideoProjecteur videoProjecteur;
	
	
/**** CONSTRUCTEURS*/
	
	public Module() {
		super();
	}
	public Module(Salle salle, Date dateDebut, Date dateFin, VideoProjecteur videoProjecteur) {
		super();
		this.salle = salle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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
