package factory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "training")
// @SecondaryTable(name = "training_lazy")
@SequenceGenerator(name = "seqFormtion", sequenceName = "training_sequence")
public class Formation {

	@Id
	@GeneratedValue(generator = "seqFormation")
	private Long id;

	@JsonView(Views.ViewCommon.class)
	private List<Module> modules = new ArrayList<>();;

	@JsonView(Views.ViewFormationWithStagiaires.class)
	private List<Stagiaire> stagiaires = new ArrayList<>();;

	@JsonView(Views.ViewCommon.class)
	private Gestionnaire gestionnaire;

	public Formation() {
		super();
	}

	public Formation(List<Module> modules, List<Stagiaire> stagiaires, Gestionnaire gestionnaire) {
		super();
		this.modules = modules;
		this.stagiaires = stagiaires;
		this.gestionnaire = gestionnaire;
	}

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
