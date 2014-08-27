package com.ding.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public final class DbUtil {
  private static DataSource ds;
  //可以将Connection对象与当前线程绑定
  private static ThreadLocal<Connection> 
      connLocal = new ThreadLocal<Connection>();
  
  static{
    try{
      Properties props = new Properties();
      props.load(DbUtil.class
          .getClassLoader()
          .getResourceAsStream("db.properties"));
      ds = BasicDataSourceFactory
            .createDataSource(props);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  
  
   public static Connection getConnection() 
                         throws SQLException{
     //先尝试从local中获取
     Connection conn = connLocal.get();
     //获取不到,说明当前线程前面没使用过
     if(conn == null){
       //从连接池获取一个,放入local
       conn = ds.getConnection();
       connLocal.set(conn);
     }
     return conn;
   }
   
   public static void closeConnection() throws SQLException{
     //先尝试从local中获取
     Connection conn = connLocal.get();
     //清空local
     connLocal.set(null);
     if(conn != null && !conn.isClosed()){
       conn.close();
     }
   }
   
   public static void main(String[] args) throws SQLException{
     Connection conn = getConnection();
     System.out.println(conn.hashCode());
     Connection conn1 = getConnection();
     System.out.println(conn1.hashCode());
     //conn使用
     closeConnection();
   }
   
   
   
   
   
}
