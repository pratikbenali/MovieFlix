package io.pratik.Movie.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
@NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r ORDER BY r.name ASC"),
@NamedQuery(name = "Rating.findByName", query = "SELECT r FROM Rating r WHERE r.name=:pName")
})
public class Rating {

	@Id
	@GenericGenerator(name="customUUID", strategy="uuid2")
	@GeneratedValue(generator="customUUID")
	private String id;
	
	@Column(unique=true)
	private String name;
	private int rate;
	
	//One Rating can have one User
		@OneToOne(cascade=CascadeType.ALL)
		private User user;
		
	public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "Rating [id=" + id + ", Name=" + name +  ", rating=" + rate + ", User=" + user +"]";
	}

	
}
