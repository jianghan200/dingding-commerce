package com.ding.action.user;

import java.sql.SQLException;

import com.ding.action.BaseAction;
import com.ding.dao.UserDAO;
import com.ding.dao.impl.JdbcUserDAO;
import com.ding.pojo.User;

public class EmailCodeAction extends BaseAction{
	/**input the  validation typed by customer*/
	private String validat;
	/**output the result*/
	private boolean ok ;
	/**output the error message*/
    public String execute() throws SQLException{
    	System.out.println("傳"+validat);
    	String verifyCode = (String) session.get("emailVerify");
    	System.out.println("verifyCode"+verifyCode);
		if(verifyCode.equals(validat)){		
		    ok=true;		
			return "success";
		}else{
			ok=false;		
			return "success";
		}
		
    }


	public String getValidat() {
		return validat;
	}


	public boolean isOk() {
		return ok;
	}


	public void setValidat(String validat) {
		this.validat = validat;
	}


	public void setOk(boolean ok) {
		this.ok = ok;
	}
    

  

}
