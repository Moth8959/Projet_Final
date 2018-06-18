package factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

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
	@Column(name = "hardDriveCapacity")
	@JsonView(Views.ViewCommon.class)
	private int capaciteDD;
	@Column(name = "yearOfPurchase")
	@JsonView(Views.ViewCommon.class)
	private int anneeAchat;
	
	
	public Ordinateur() {
		super();
	}
	
	
	public Ordinateur(String processeur, int ram, int capaciteDD, int anneeAchat) {
		super();
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
	
	
	
}
