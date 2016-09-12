package io.pratik.Movie.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({

	@NamedQuery(name = "Comments.findByName", query = "SELECT c FROM Comments c ORDER BY c.name ASC")
})
public class Comments {
    
    @Id
    @GenericGenerator(name="customUUID", strategy="uuid2")
	@GeneratedValue(generator="customUUID")
    private String id;
    
    private String name;
	private String comment;
	
	//Many Comments can have one User
	//@ManyToOne
	//private User user;
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "Comments [ id " + id + ", name=" + name + ", comment=" + comment + "]";
	}
	
}
