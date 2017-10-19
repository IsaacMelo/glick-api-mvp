package com.glick.api.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Medication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "medication_id")
	private long id;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "glucose_id")
	private Glucose glucose;
	
	@Column(name = "medication_status")
	private String medicationStatus;

	@Column(name = "insulin_unities")
	private double insulinUnities;
	
	@Column(name = "reading_date")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date readingDate;

	@CreationTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	private Date createDate;

	@UpdateTimestamp
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_date")
	private Date modifyDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMedicationStatus() {
		return medicationStatus;
	}

	public void setMedicationStatus(String medicationStatus) {
		this.medicationStatus = medicationStatus;
	}

	public double getInsulinUnities() {
		return insulinUnities;
	}

	public void setInsulinUnities(double insulinUnities) {
		this.insulinUnities = insulinUnities;
	}

	public Glucose getGlucose() {
		return glucose;
	}

	public void setGlucose(Glucose glucose) {
		this.glucose = glucose;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}
}
