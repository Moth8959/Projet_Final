package factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "classroom")
@SequenceGenerator(name = "seqSalle", sequenceName = "salle_sequence")
public class Salle {
	@Column(name = "capacity")
	@JsonView(Views.ViewCommon.class)
	private Integer capacite;
	
	
/**** CONSTRUCTEURS*/
	
	public Salle() {
		super();
	}
	public Salle(Integer capacite) {
		super();
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
		return "Salle [capacite=" + capacite + "]";
	}
	

}
