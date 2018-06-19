package factory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "training")
// @SecondaryTable(name = "training_lazy")

@SequenceGenerator(name = "seqFormation", sequenceName = "training_sequence")

public class Formation {

	@Id
	@GeneratedValue(generator = "seqFormation")
	private Long id;

	@OneToMany(mappedBy="formation")
	@JsonView(Views.ViewFormationWithModules.class)
	private List<Module> modules = new ArrayList<>();;

	@OneToMany(mappedBy="formation")
	@JsonView(Views.ViewFormationWithStagiaires.class)
	private List<Stagiaire> stagiaires = new ArrayList<>();;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	@JsonView(Views.ViewCommon.class)
	private Gestionnaire gestionnaire;

	/**** CONSTRUCTEURS*/
	
	public Formation() {
		super();
	}

	public Formation(List<Module> modules, List<Stagiaire> stagiaires, Gestionnaire gestionnaire) {
		super();
		this.modules = modules;
		this.stagiaires = stagiaires;
		this.gestionnaire = gestionnaire;
	}
	
	/**** METHODES*/	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}



}
