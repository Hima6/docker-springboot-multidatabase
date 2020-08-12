package com.sample.dockermicroservice.multidatasource.user.domain;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "users")
public class User  {
	
	private Long userId;
	
	private String firstName;
	

	
	public User() {
    }

    public User(Long userId, String firstName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
	}

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	 @Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


}
