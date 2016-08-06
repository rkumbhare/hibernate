/**
 * @auther Rakesh
 * @time Aug 5, 2016
 */

package com.rkumbhare.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Person")
@Table(name = "Person", schema = "demo")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="person_seq")
	@SequenceGenerator(name="person_seq", sequenceName="person_seq", allocationSize=1)
	private Integer id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
