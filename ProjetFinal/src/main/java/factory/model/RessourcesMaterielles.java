package factory.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@MappedSuperclass
public abstract class RessourcesMaterielles {

	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Id
	@Column(length = 10)
	@JsonView(Views.ViewCommon.class)
	private String code;
	@Column(name = "usingCost")
	@JsonView(Views.ViewCommon.class)
	private Double coutUtilisation;
	
	public RessourcesMaterielles() {
		super();
	}
	
	public RessourcesMaterielles(String code, Double coutUtilisation) {
		super();
		this.code = code;
		this.coutUtilisation = coutUtilisation;
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
