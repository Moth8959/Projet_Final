package factory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "trainee")
// @SecondaryTable(name = "trainee_lazy")
@SequenceGenerator(name = "seqStagiaire", sequenceName = "trainee_sequence")
public class Stagiaire {

	
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

	public Stagiaire() {
		super();
	}

	public Stagiaire(Formation formation, NivEnum nivEnum, Ordinateur ordinateur) {
		super();
		this.formation = formation;
		this.nivEnum = nivEnum;
		this.ordinateur = ordinateur;
	}

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
