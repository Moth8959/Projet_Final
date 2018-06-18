package factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "salle")
public class Salle {

	@Column(name = "capacity")
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
