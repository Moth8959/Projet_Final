package factory.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "classroom")
public class Salle extends RessourcesMaterielles{
		@Column(name = "capacity")
		@JsonView(Views.ViewCommon.class)
	private Integer capacite;
	
		@OneToMany(mappedBy="salle")
		@JsonView(Views.ViewSalleWithModule.class)
		private List<Module> modules;
	
/**** CONSTRUCTEURS*/
	
	public Salle() {
		super();
	}
	public Salle(String code, Double coutUtilisation, Integer capacite) {
		super(code, coutUtilisation);
		this.capacite = capacite;
	}

/**** METHODES*/	
	
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	
	@Override
	public String toString() {
		return "Salle [capacite=" + capacite + ", modules=" + modules + "]";
	}

}
