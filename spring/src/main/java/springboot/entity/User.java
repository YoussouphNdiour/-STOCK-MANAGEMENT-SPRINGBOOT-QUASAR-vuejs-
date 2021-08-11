package springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User_TBL")
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String password;
    private String profile;
    
	public User() {
		super();
	}
	public User(String name,String email, String password, String profile) {
		super();
		this.name = name;
		this.email=email;
		this.password=password;
		this.profile= profile;
	}
	public User(int id, String name, String password, String profile, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email=email;
		this.password=password;
		this.profile= profile;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getprofile() {
		return profile;
	}
	public void setprofile(String profile) {
		this.profile = profile;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}