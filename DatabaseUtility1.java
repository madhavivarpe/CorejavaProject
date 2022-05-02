package com.myownproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtility1 {
	static  Connection conn=null;
    static final String URL="jdbc:mysql://localhost:3306/studentmanagement";
    static final String UN="root";
    static final String PASS="roor";
    static String DB="com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection() {
    	try {
    		//load the driver
    		Class.forName(DB);
    		conn = DriverManager.getConnection(URL, UN, PASS);
    		
    		if(conn!=null) {
    			System.out.println("Connected");
    		}else {
    			System.out.println("Not connected");
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
  
    	return conn;
    	
    	 }
    
}





