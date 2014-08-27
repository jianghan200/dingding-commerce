package com.ding.pojo;

import java.io.Serializable;
import java.util.Date;

public class Book extends Product implements Serializable{// 
  private Integer product_id;
  private String author;
  private String publishing;
  private  Date publishTime;
  private String wordNumber;
  //TODO 根据d_book编写属性
  private Integer whichEditon;
  private Integer totalPage;
  private Date printTime;
  private String printNumner;
  private String isbn;
  private String authorSummary;
  private String catalogue;
//追加方法,用于获取时间对象
  public Integer getWhichEditon() {
	return whichEditon ;
}


public Integer getTotalPage() {
	return totalPage;
}


public  Date getPrintTime() {
	return printTime;
}


public String getPrintNumner() {
	return printNumner;
}


public String getIsbn() {
	return isbn;
}


public String getAuthorSummary() {
	return authorSummary;
}


public String getCatalogue() {
	return catalogue;
}


public void setWhichEditon(Integer whichEditon) {
	this.whichEditon = whichEditon;
}


public void setTotalPage(Integer totalPage) {
	this.totalPage = totalPage;
}


public void setPrintTime( Date printTime) {
	this.printTime = printTime;
}


public void setPrintNumner(String printNumner) {
	this.printNumner = printNumner;
}


public void setIsbn(String isbn) {
	this.isbn = isbn;
}


public void setAuthorSummary(String authorSummary) {
	this.authorSummary = authorSummary;
}


public void setCatalogue(String catalogue) {
	this.catalogue = catalogue;
}


//追加方法,用于获取时间对象
  public Date getPublishingDt(){
    return publishTime;
  }
  
  
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public Integer getProduct_id() {
    return product_id;
  }
  public void setProduct_id(Integer product_id) {
    this.product_id = product_id;
  }
  public String getPublishing() {
    return publishing;
  }
  public void setPublishing(String publishing) {
    this.publishing = publishing;
  }
  public  Date getPublishTime() {
    return publishTime;
  }
  public void setPublishTime(Date l) {
    this.publishTime = l;
  }
  public String getWordNumber() {
    return wordNumber;
  }
  public void setWordNumber(String wordNumber) {
    this.wordNumber = wordNumber;
  }
  
}

