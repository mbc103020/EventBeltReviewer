package com.eventbeltreviewer.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column
	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 20)
	private String name; 
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private String date; 
	
	@Column 
	private String location; 
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")  //annotation from Spring
	private Date createdAt; 
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	public Event() {
		
	}
	
	public Event(String name, String date, String location) {
		this.name = name; 
		this.date = date; 
		this.location = location; 
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date(); 
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date(); 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	} 

}
