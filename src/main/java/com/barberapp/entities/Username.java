package com.barberapp.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table (name = "usernames")
public class Username implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column (name = "id_username")private Long idUsername;
	@Column (name = "type_username", nullable = false) private int typeUsername;
	@Column (name = "email", nullable = false, unique = true) private String email;
	@Column (name = "password") private String password;
	@Column (name = "name") private String name;
	@Column (name = "nickname") private String nickname;
	@Column (name = "cellphone_number") private String cellphoneNumber;
	
	
	public Username() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Username(Long idUsername, int typeUsername, String email, String password, String name, String nickname,
			String cellphoneNumber) {
		super();
		this.idUsername = idUsername;
		this.typeUsername = typeUsername;
		this.email = email;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.cellphoneNumber = cellphoneNumber;
	}


	public Long getIdUsername() {
		return idUsername;
	}


	public void setIdUsername(Long idUsername) {
		this.idUsername = idUsername;
	}


	public int getTypeUsername() {
		return typeUsername;
	}


	public void setTypeUsername(int typeUsername) {
		this.typeUsername = typeUsername;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getCellphoneNumber() {
		return cellphoneNumber;
	}


	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = cellphoneNumber;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Username [idUsername=" + idUsername + ", typeUsername=" + typeUsername + ", email=" + email
				+ ", password=" + password + ", name=" + name + ", nickname=" + nickname + ", cellphoneNumber="
				+ cellphoneNumber + "]";
	}

}
