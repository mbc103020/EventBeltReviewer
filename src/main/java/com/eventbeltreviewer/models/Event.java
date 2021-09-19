package com.eventbeltreviewer.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private Date date; 
	
	@Column 
	private String city; 
	
	@Column
	private String state; 
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")  //annotation from Spring
	private Date createdAt; 
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	//for one to many
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User planner;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "usersevents",
		joinColumns = @JoinColumn(name = "event_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> attendees;
	
//	   @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
//		private List<Message> messages;
		
	
	public Event() {
		
	}
	
	public Event(String name, Date date, String city, String state) {
		this.name = name; 
		this.date = date; 
		this.city = city; 
		this.state = state; 
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	} 

public List<User> getAttendees() {
	return attendees;
}
	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	public User getPlanner() {
		return planner;
	}
	public void setPlanner(User planner) {
		this.planner = planner;
	}
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}
//	public List<Message> getMessages() {
//		return messages;
//	}

}
