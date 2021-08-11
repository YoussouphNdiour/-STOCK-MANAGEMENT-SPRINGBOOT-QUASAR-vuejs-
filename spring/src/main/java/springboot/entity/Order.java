package springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Order_TBL")
public class Order {
	@Id
    @GeneratedValue
	private int id;
	private String name;
	private String idProduct;
	private String idProvider;
	private String price;
	private String quantity;
	private String iduser;
	private String date;
	public Order(int id,String name, String idProduct, String idProvider, String price, String quantity,String iduser, String date) {
		super();
		this.id=id;
		this.name = name;
		this.idProduct = idProduct;
		this.idProvider = idProvider;
		this.price = price;
		this.quantity = quantity;
		this.iduser=iduser;
		this.date=date;
	}
	
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public Order(String idProduct,String name,  String idProvider, String price, String quantity, String iduser, String date) {
		super();
		this.name = name;
		this.idProduct = idProduct;
		this.idProvider = idProvider;
		this.price = price;
		this.quantity = quantity;
		this.iduser=iduser;
		this.date=date;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public Order() {}
	public String getname() {
		return name;
	}
	
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getIdProvider() {
		return idProvider;
	}
	public void setIdProvider(String idProvider) {
		this.idProvider = idProvider ;
	}
	public String getprice() {
		return price;
	}
	public void setprice(String price) {
		this.price = price;
	}
	public String getquantity() {
		return quantity;
	}
	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
}
