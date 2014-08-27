package com.ding.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Category implements Serializable{
	private Integer cat_id;
	private Integer turn;
	private String enName;
	private String name;
	private String description;
	private Integer parentId;
	//追加，用于存储当前类型的子项
	private List<Category> subCats;
	//追加,用于存储当前类别包含的产品数量
	private Integer pnum;
	private  Set<Product>  products=new HashSet<Product>() ;
	

	public List<Category> getSubCats() {
		return subCats;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setSubCats(List<Category> subCats) {
		this.subCats = subCats;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public Integer getCat_id() {
		return cat_id;
	}
	public Integer getTurn() {
		return turn;
	}
	public String getEnName() {
		return enName;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Integer getParentId() {
		return parentId;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setCat_id(Integer cat_id) {
		this.cat_id = cat_id;
	}
	public void setTurn(Integer turn) {
		this.turn = turn;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	
	public void setProducts(Set<Product>  products) {
		this.products = products;
	}
	
	
	
}
