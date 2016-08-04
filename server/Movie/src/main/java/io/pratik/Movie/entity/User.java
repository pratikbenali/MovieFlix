package io.pratik.Movie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u ORDER BY u.email ASC"),
@NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email=:pEmail")
})
public class User {
	
	@Id
	@GenericGenerator(name="customUUID", strategy="uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;
	
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
	private String email;
	
	private int age;
	private String city;
	private String state;
	
	//One User can have many Comments
//	@OneToMany
//	private List<Comments> comment;
//	
//	public List<Comments> getComment() {
//		return comment;
//	}
//
//	public void setComment(List<Comments> comment) {
//		this.comment = comment;
//	}

	
	
	
	public String getId() {
		return id;
	}
//	public List<Comments> getComment() {
//		return comment;
//	}
//	public void setComment(List<Comments> comment) {
//		this.comment = comment;
//	}
	
	public void setId(String id) {
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
		+", age="+ age	+ ", city=" + city + ", state=" + state + "]";
	}

}
