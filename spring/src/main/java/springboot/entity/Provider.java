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
@Table(name = "Provider_TBL")
public class Provider {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String adress;
    private String telephone; 
    private String email;
	public Provider(int id, String name, String adress, String telephone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.telephone = telephone;
		this.email = email;
	}
	public Provider(String name, String adress, String telephone, String email) {
		super();
		this.name = name;
		this.adress = adress;
		this.telephone = telephone;
		this.email = email;
	}
	public Provider() {
		super();
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getadress() {
		return adress;
	}
	public void setadress(String adress) {
		this.adress = adress;
	}
	public String gettelephone() {
		return telephone;
	}
	public void settelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
    
	
}