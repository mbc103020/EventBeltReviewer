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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String city;
	
	private String state;
	
	@NotEmpty
	@Size(min=8)
	private String password;
	
	@Transient
	private String confirmPassword;
	
	
	@Column(updatable=false)
    private Date createdAt;
	
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    
    //for user to event one to many
    @OneToMany(mappedBy="planner", fetch = FetchType.LAZY)
    private List<Event> eventsPlanned; 
   
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "usersevents",
    	joinColumns = @JoinColumn(name = "user_id"),
    	inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> joinedevents;
    
//    @OneToMany(mappedBy="author", fetch = FetchType.LAZY)
//	private List<Message> messages;
    
    
	public User() {

	}
	
	public User(String firstName, String lastName, String email, String city, String state, String password) {
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.email = email; 
		this.city = city; 
		this.state = state; 
		this.password = password; 
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
    
	public List<Event> getJoinedevents() {
		return joinedevents;
	}

	public void setJoinedevents(List<Event> joinedevents) {
		this.joinedevents = joinedevents;
	}
	
	
	public List<Event> getEvents() {
		return eventsPlanned;
	}
	public void setEvents(List<Event> eventsPlanned) {
		this.eventsPlanned = eventsPlanned;
	}
	
	
//	public List<Message> getMessages() {
//		return messages;
//	} 
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}
}
