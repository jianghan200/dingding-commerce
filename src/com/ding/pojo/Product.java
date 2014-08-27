package com.ding.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Product implements Serializable{
	private Integer product_id;
	private String productName;
	private String description;
	private  Long addTime;
	private double fixedPrice;
	private double dangPrice;
	private String keywords;
	private Integer hasDeleted;
	private String productPic;
	//private   Book  book ;
	private Set<Item> items
	= new HashSet<Item>();
	
	private Set<Category>  categorys
	= new HashSet<Category>();


	public Integer getProduct_id() {
		return product_id;
	}
	public String getProductName() {
		return productName;
	}
	public String getDescription() {
		return description;
	}
	public  Long getAddTime() {
		return addTime;
	}
	public double getFixedPrice() {
		return fixedPrice;
	}
	public double getDangPrice() {
		return dangPrice;
	}
	public String getKeywords() {
		return keywords;
	}
	public Integer getHasDeleted() {
		return hasDeleted;
	}
	public String getProductPic() {
		return productPic;
	}
  public  Set<Item> getItems() {
	return items;
  }
	public Set<Category> getCategorys() {
		return categorys;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id= product_id;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setAddTime( Long addTime) {
		this.addTime = addTime;
	}
	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public void setDangPrice(double dangPrice) {
		this.dangPrice = dangPrice;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public void setHasDeleted(Integer hasDeleted) {
		this.hasDeleted = hasDeleted;
	}
	public void setProductPic(String productPic) {
		this.productPic = productPic;
	}
	
	  public  void setItems(Set <Item>  items)
	  {
			this.items=items;
		 }
	  
	  public  void setCategorys(Set <Category>  categorys)
	  {
			this.categorys=categorys;
		 }
	
}
