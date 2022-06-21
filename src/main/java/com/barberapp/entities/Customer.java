package com.barberapp.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id @Column (name = "id_user") private Long idUser;
	@Column (name = "age") private Date age;
	@Column (name = "gender") private char geder;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(Long idUser, Date age, char geder) {
		super();
		this.idUser = idUser;
		this.age = age;
		this.geder = geder;
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public Date getAge() {
		return age;
	}


	public void setAge(Date age) {
		this.age = age;
	}


	public char getGeder() {
		return geder;
	}


	public void setGeder(char geder) {
		this.geder = geder;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Customer [idUser=" + idUser + ", age=" + age + ", geder=" + geder + "]";
	}
}
