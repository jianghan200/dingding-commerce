package com.ding.util;

import java.util.UUID;

public class VerifyUtil {
	public static String createVerifyCode(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
		
	}
	  public static void main(String[] args){
		    System.out.println(createVerifyCode());
		    System.out.println(createVerifyCode());
		    System.out.println(createVerifyCode());
		  }
}
