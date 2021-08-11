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
@Table(name = "Sale_TBL")
public class Sale {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String iduser;
    private String date;
    private String price_total;
	public Sale(int id, String name,  String price_total, String iduser,String date) {
		super();
		this.id = id;
		this.name = name;
		this.price_total = price_total;
		this.iduser = iduser;
		this.date=date;
	}
	public Sale(String name,  String price_total,String iduser,String date) {
		super();
		this.name = name;
		this.price_total = price_total;
		this.iduser = iduser;
		this.date=date;
	}
	public String getPrice_total() {
		return price_total;
	}
	public void setPrice_total(String price_total) {
		this.price_total = price_total;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Sale() {}
	public String getname() {
		return this.name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public int getId() {
		return id;
	}

}
