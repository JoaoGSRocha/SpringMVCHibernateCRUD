package com.jwt.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userID;

	@Column
	private int userFBID;

	@Column
	private String fbName;

	@Column
	private int userPostsID;

	@Column
	private int points;

	@Column
	private int age;
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getUserFBID() {
		return userFBID;
	}

	public void setUserFBID(int userFBID) {
		this.userFBID = userFBID;
	}

	public String getFbName() {
		return fbName;
	}

	public void setFbName(String fbName) {
		this.fbName = fbName;
	}

	public int getUserPostsID() {
		return userPostsID;
	}

	public void setUserPostsID(int userPostsID) {
		this.userPostsID = userPostsID;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}