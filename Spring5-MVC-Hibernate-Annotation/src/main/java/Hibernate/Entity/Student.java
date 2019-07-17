package Hibernate.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String firstName;
	private String secondName;
	private String email;
	private String gender;
	private String college;
	private String department;
	
	public Student() {
		
	}
	
	public Student(String fn, String sn, String e, String g, String c, String d) {
		
		this.firstName = fn;
		this.secondName = sn;
		this.email = e;
		this.gender = g;
		this.college = c;
		this.department = d;
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
	
	public String getSecondName() {
		
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		
		this.secondName = secondName;
	}
	
	public String getEmail() {
		
		return email;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	public String getGender() {
		
		return gender;
	}
	
	public void setGender(String gender) {
		
		this.gender = gender;
	}
	
	public String getCollege() {
		
		return college;
	}

	public void setCollege(String college) {
		
		this.college = college;
	}
	
	public String getDepartment() {
		
		return department;
	}
	
	public void setDepartment(String department) {
		
		this.department = department;
	}
}
