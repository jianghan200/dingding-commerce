CREATE TABLE D_PRODUCT (
  PRODUCT_ID  int(12) NOT NULL auto_increment,
  PRODUCT_NAME varchar(100) NOT NULL,
  DESCRIPTION varchar(100) default NULL,
  add_time bigint(20) default NULL,
  fixed_price float(20) NOT NULL,
  dang_price float(20) NOT NULL,
  keywords varchar(200) default NULL,
  has_deleted int(1) NOT NULL default '0',
  product_pic varchar(200) default NULL,
  PRIMARY KEY  (PRODUCT_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE d_book (
  PRODUCT_ID int(12) NOT NULL,
  author varchar(200) NOT NULL,
  publishing varchar(200) NOT NULL,
  publish_time date NOT NULL,
  word_number varchar(255) default NULL,
  which_edtion int(10) default NULL,
  total_page int(10) default NULL,
  print_time date default NULL,
  print_number varchar(255) default NULL,
  isbn varchar(255) default NULL,
  author_summary text NOT NULL,
  catalogue text NOT NULL,
  PRIMARY KEY  (PRODUCT_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE d_category (
  CAT_ID int(10) NOT NULL auto_increment,
  turn int(10) NOT NULL,
  en_name varchar(200) NOT NULL,
  name varchar(200) NOT NULL,
  description varchar(200),
  parent_id int(10),
  PNUM   int(10),
  CATEGORY_VALUE  varchar(200),
  PRIMARY KEY  (CAT_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE d_category_product (
  id int(10) NOT NULL auto_increment,
  product_id int(10) NOT NULL,
  cat_id int(10) NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE d_item (
  ITEM_ID int(10) NOT NULL auto_increment,
  order_id int(10) NOT NULL,
  product_id int(10) NOT NULL,
  product_name varchar(100) NOT NULL,
  dang_price float(20) NOT NULL,
  product_num int(10) NOT NULL,
  amount FLOAT(20) NOT NULL,
  PRIMARY KEY  (ITEM_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE d_order (
  ORDER_ID int(10) NOT NULL auto_increment,
  user_id int(10) NOT NULL,
  status int(10) NOT NULL,
  order_time bigint(20) NOT NULL,
  order_desc varchar(100) default NULL,
  total_price float(26) NOT NULL,
 SEND_FEE  float(26), 
 ORDER_PRICE  float(26),
 SEND_TIME TIMESTAMP(4),
 IS_DELETE int(20),
  receive_name varchar(100) default NULL,
  full_address varchar(200) default NULL,
  postal_code varchar(8) default NULL,
  mobile varchar(20) default NULL,
  phone varchar(20) default NULL,
  
  PRIMARY KEY  (ORDER_ID)
) ENGINE=InnoDB;




CREATE TABLE d_receive_address (
  id int(12) NOT NULL auto_increment,
  user_id int(11) NOT NULL,
  receive_name varchar(20) NOT NULL,
  full_address varchar(200) NOT NULL,
  postal_code varchar(8) NOT NULL,
  mobile varchar(15) default NULL,
  phone varchar(20) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB;



CREATE TABLE d_user (
  USER_ID int(12) NOT NULL auto_increment,
  email varchar(50) NOT NULL,
  nickname varchar(50) default NULL,
  password varchar(50) NOT NULL,
  user_integral int(12) NOT NULL default '0',
  is_email_verify char(3),
  email_verify_code varchar(50) default NULL,
  last_login_time bigint default NULL,
  last_login_ip varchar(15) default NULL,
  ADDRESS varchar(100),
  USER_PIC varchar(100),
  IDENTITY varchar(100),
  INTEREST varchar(100),
  PRIMARY KEY  (USER_ID),
  UNIQUE KEY email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE d_manager (
	id int(10)  NOT NULL auto_increment,
	manager_name varchar(50) NOT NULL,
  	password varchar(50) NOT NULL,
  	PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;