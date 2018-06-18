package factory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "module")
@SequenceGenerator(name = "seqModule", sequenceName = "module_sequence")
public class Module {
	@Id
	@GeneratedValue(generator = "seqModule")
	private Long id;
//	private Matiere matiere;
//	private Salle salle;
//	private Formateur formateur;
	@Column(name = "startDate")
	private Date dateDebut;
	@Column(name = "endDate")
	private Date dateFin;
//	private VideoProjecteur videoProjecteur;
	
	
/**** CONSTRUCTEURS*/
	
	public Module() {
		super();
	}
	public Module(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
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
	@Override
	public String toString() {
		return "Module [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + "]";
	}
	
	

}
