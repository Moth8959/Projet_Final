package factory.model;

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
	
	@Id
	@OneToMany(mappedBy="formation")
	private Formation formation;

	public Gestionnaire() {
		super();
	}
	

	public Gestionnaire(Long id, Formation formation) {
		super();
		this.id = id;
		this.formation = formation;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	} 
	
	
	

}
