package com.ding.interceptor;

import com.ding.util.DbUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TransactionInterceptor 
  extends AbstractInterceptor{

  @Override
  public String intercept(ActionInvocation invocation) throws Exception {
    //开启事务控制
    System.out.println("开启事务控制");
    DbUtil.getConnection().setAutoCommit(false);
    try{
      String result = invocation.invoke();//执行后续的拦截器或Action
      //结束事务控制
      if(!DbUtil.getConnection().getAutoCommit()){
        DbUtil.getConnection().commit();
        System.out.println("提交事务");
      }
      return result;
    }catch(Exception ex){
      ex.printStackTrace();
      DbUtil.getConnection().rollback();
      System.out.println("回滚事务");
      throw ex;//将异常继续抛出，交给Struts框架处理
    }finally{
      DbUtil.closeConnection();
      System.out.println("关闭Connection链接");
    }
  }

}
