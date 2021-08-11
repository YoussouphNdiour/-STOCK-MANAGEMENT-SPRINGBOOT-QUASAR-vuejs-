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
@Table(name = "SaleHistory_TBL")
public class SaleHistory {
	@Id
    @GeneratedValue
	private int id;
	private String idinvoices;
	private String quantity;
	private String idProduct;
	private String name;
	public SaleHistory(String quantity, String idProduct, String name, String idinvoices) {
		super();
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.name = name;
		this.idinvoices = idinvoices;
	}
	public SaleHistory(int id, String quantity, String idProduct, String name, String idinvoices) {
		super();
		this.id = id;
		this.idinvoices = idinvoices;
		this.quantity = quantity;
		this.idProduct = idProduct;
		this.name = name;
	}
	public SaleHistory() {
		super();
	}
	public String getIdinvoices() {
		return idinvoices;
	}
	public void setIdinvoices(String idinvoices) {
		this.idinvoices = idinvoices;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}

}
