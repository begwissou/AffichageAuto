package com.ingeniousafrica.listview;

import java.io.Serializable;

public class Voiture implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fabriquant;
	private String marque;
	
	private String model;
	private String moteur;
	
	private String img;
	
	
	
	
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Voiture(String fabriquant, String marque, String model, String moteur, String img) {
		super();
		this.fabriquant = fabriquant;
		this.marque = marque;
		this.model = model;
		this.moteur = moteur;
		this.img = img;
	}
	
	public Voiture(String fabriquant, String marque, String model, String moteur) {
		super();
		this.fabriquant = fabriquant;
		this.marque = marque;
		this.model = model;
		this.moteur = moteur;
	}
	public String getFabriquant() {
		return fabriquant;
	}
	public void setFabriquant(String fabriquant) {
		this.fabriquant = fabriquant;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMoteur() {
		return moteur;
	}
	public void setMoteur(String moteur) {
		this.moteur = moteur;
	}
	
	

}
