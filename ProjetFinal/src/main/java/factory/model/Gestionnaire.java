package factory.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity 
@Table(name="manager")
@SequenceGenerator(name= "seqGestionnaire", sequenceName = "manager_sequence")
public class Gestionnaire extends RessourcesHumaines {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id; 

	@OneToMany(mappedBy="gestionnaire")
	@JsonView(Views.ViewGestionnaireWithFormations.class)
	private List <Formation> formations;

	public Gestionnaire() {
		super();
	}
	

	public Gestionnaire(Long id, List<Formation> formations) {
		super();
		this.id = id;
		this.formations = formations;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public List<Formation> getFormations() {
		return formations;
	}


	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}


	
	

}
