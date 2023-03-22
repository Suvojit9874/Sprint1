package com.ars_vc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint
		(columnNames = {		
          "email"})})
public class Passenger extends User{
	@Column(length = 50)
	private String name;
	@Column(length = 10)
	private String phno;
	//@Column(length = 50,unique = true,nullable = false)
	private String email;

	@Builder	
	 public Passenger(String name,String phno,String email,int id,String UserName,String password,String role) {
		super(id,UserName,password,role);
		this.name=name;
		this.phno=phno;
		this.email=email;
	}
}
