package com.capgemini.moduletest3.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_info")
public class OrderInfo {
	@GeneratedValue
	@Id
	@Column
	 private int id;
	@Column
	private int productId;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	   @JoinColumn(name="user_id")
		private UserInfo e;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public UserInfo getE() {
		return e;
	}
	public void setE(UserInfo e) {
		this.e = e;
	}
	@Override
	public String toString() {
		return "OrderInfo [id=" + id + ", productId=" + productId + ", e=" + e + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + id;
		result = prime * result + productId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderInfo other = (OrderInfo) obj;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (id != other.id)
			return false;
		if (productId != other.productId)
			return false;
		return true;
	}
	

}
