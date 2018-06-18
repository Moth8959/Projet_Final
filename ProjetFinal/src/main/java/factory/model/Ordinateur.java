package factory.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import factory.model.Views;

@Entity
@Table(name = "computer")
public class Ordinateur extends RessourcesMaterielles{
	
	@Column(name = "processor", length = 25)
	@JsonView(Views.ViewCommon.class)
	private String processeur;
	@JsonView(Views.ViewCommon.class)
	private int ram;
	@Column(name = "hard_drive_capacity")
	@JsonView(Views.ViewCommon.class)
	private int capaciteDD;
	@Column(name = "year_of_purchase")
	@JsonView(Views.ViewCommon.class)
	private int anneeAchat;
	@OneToMany(mappedBy="ordinateur")
	@JsonView(Views.ViewOrdinateurWithStagiaires.class)
	private List<Stagiaire> stagiaires = new ArrayList<>();
	
	
	public Ordinateur() {
		super();
	}
	
	
	public Ordinateur(String code, Double coutUtilisation, String processeur, int ram, int capaciteDD, int anneeAchat) {
		super(code, coutUtilisation);
		this.processeur = processeur;
		this.ram = ram;
		this.capaciteDD = capaciteDD;
		this.anneeAchat = anneeAchat;
	}
	
	public String getProcesseur() {
		return processeur;
	}
	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getCapaciteDD() {
		return capaciteDD;
	}
	public void setCapaciteDD(int capaciteDD) {
		this.capaciteDD = capaciteDD;
	}
	public int getAnneeAchat() {
		return anneeAchat;
	}
	public void setAnneeAchat(int anneeAchat) {
		this.anneeAchat = anneeAchat;
	}


	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}


	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	
	public void addStagiaires(Stagiaire stagiaire) {
		this.stagiaires.add(stagiaire);
	}
	
	
}
