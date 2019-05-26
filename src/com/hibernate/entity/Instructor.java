package com.hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	//Annotate the class as an entity and map to db table
	
	//define the fields
	
	//annotate the fields with db column names
	
	//create constructor
	
	//generate getter/setter methods
	
	//generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lasttName;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	@OneToMany(mappedBy="instructor", cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Course> courese;
	
	public Instructor()
	{
		
	}

	public Instructor(String firstName, String lasttName, String email) {
		
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLasttName() {
		return lasttName;
	}

	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	

	public List<Course> getCourese() {
		return courese;
	}

	public void setCourese(List<Course> courese) {
		this.courese = courese;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lasttName=" + lasttName + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
		
	
	public void add(Course tempCourse)
	{
		if(courese == null)
		{
			courese = new ArrayList<>();
		}
		courese.add(tempCourse);
		tempCourse.setInstructor(this); 
	}
}
