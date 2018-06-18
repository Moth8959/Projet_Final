package factory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import factory.model.Views;

@Entity
@Table(name = "video_projector")
public class VideoProjecteur extends RessourcesMaterielles{

	@JsonView(Views.ViewCommon.class)
	private Integer resolution;
	@JsonView(Views.ViewCommon.class)
	private Boolean hdmi;
	@JsonView(Views.ViewCommon.class)
	private Boolean vga;
	@OneToMany(mappedBy="videoProjecteur")
	private List<Module> modules = new ArrayList<>();
	
	
	public VideoProjecteur() {
		super();
	}
	
	public VideoProjecteur(int version, String code, Double coutUtilisation, Integer resolution, Boolean hdmi, Boolean vga, List<Module> modules) {
		super(version, code, coutUtilisation);
		this.resolution = resolution;
		this.hdmi = hdmi;
		this.vga = vga;
		this.modules = modules;
	}
	
	public Integer getResolution() {
		return resolution;
	}
	public void setResolution(Integer resolution) {
		this.resolution = resolution;
	}
	public Boolean getHdmi() {
		return hdmi;
	}
	public void setHdmi(Boolean hdmi) {
		this.hdmi = hdmi;
	}
	public Boolean getVga() {
		return vga;
	}
	public void setVga(Boolean vga) {
		this.vga = vga;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public void addModule(Module module) {
		this.modules.add(module);
	}
	
	
}
