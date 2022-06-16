package com.barberapp.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "barbershops")
public class Barbershop implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id  @Column (name = "id_barbershop") private Long idBarbershop;
	@Column (name = "location") private String location;
	@Column (name = "qualification") private Double qualification;
	@Column (name = "linked_barbers") private int linkedBarbers;
	
	
	public Barbershop() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Barbershop(Long idBarbershop, String location, Double qualification, int linkedBarbers) {
		super();
		this.idBarbershop = idBarbershop;
		this.location = location;
		this.qualification = qualification;
		this.linkedBarbers = linkedBarbers;

	}
	

	public Long getIdBarbershop() {
		return idBarbershop;
	}


	public void setIdBarbershop(Long idBarbershop) {
		this.idBarbershop = idBarbershop;
	}

	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public Double getQualification() {
		return qualification;
	}


	public void setQualification(Double qualification) {
		this.qualification = qualification;
	}


	public int getLinkedBarbers() {
		return linkedBarbers;
	}


	public void setLinkedBarbers(int linkedBarbers) {
		this.linkedBarbers = linkedBarbers;
	}
	
	

	@Override
	public String toString() {
		return "Barbershop [idBarbershop=" + idBarbershop + ", location=" + location + ", qualification="
				+ qualification + ", linkedBarbers=" + linkedBarbers + ", catalogue=" +  "]";
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
