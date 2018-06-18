package factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;



@Entity
@Table(name = "resource")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class RessourcesMaterielles {

	@Id
	@GeneratedValue
	@JsonView(View.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(View.ViewCommon.class)
	private int version;
	@Column(length = 10)
	@JsonView(View.ViewCommon.class)
	private String code;
	@JsonView(View.ViewCommon.class)
	private Double coutUtilisation;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Double getCoutUtilisation() {
		return coutUtilisation;
	}
	public void setCoutUtilisation(Double coutUtilisation) {
		this.coutUtilisation = coutUtilisation;
	}
	
	
	
}
