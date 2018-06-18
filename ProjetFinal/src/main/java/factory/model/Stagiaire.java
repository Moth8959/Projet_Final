package factory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	private Formation formation;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "level", length = 30)
	@JsonView(Views.ViewCommon.class)
	private NivEnum nivEnum;
	
	@OneToMany(mappedBy="stagiaire")
	@JsonView(Views.ViewStagiaireWithOrdinateurs.class)
	private List<Ordinateur> ordinateurs;

	public Stagiaire() {
		super();
	}

	public Stagiaire(Formation formation, NivEnum nivEnum, List<Ordinateur> ordinateurs) {
		super();
		this.formation = formation;
		this.nivEnum = nivEnum;
		this.ordinateurs = ordinateurs;
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

	public List<Ordinateur> getOrdinateurs() {
		return ordinateurs;
	}

	public void setOrdinateurs(List<Ordinateur> ordinateurs) {
		this.ordinateurs = ordinateurs;
	}
	
	
	
}
