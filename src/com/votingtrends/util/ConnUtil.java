package com.votingtrends.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnUtil {
	  public static Connection getOracleConnection()
	          throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
	      
	      // Note: Change the connection parameters accordingly.
	      String hostName = "localhost"; 
	      String sid  = "xe";
	      String userName = "system" ;
	      String password  = "Dodger123#";
	      String port = "1521";
	      
	     /* Properties prop = new Properties();
	      prop.load(new FileInputStream("dbproperties.properties"));
	      hostName = prop.getProperty("host");
	      sid = prop.getProperty("sid");
	      userName = prop.getProperty("user");
	      password = prop.getProperty("password");
	      port = prop.getProperty("port");
	      System.out.println(hostName+ " " + userName);*/
	 
	      return getOracleConnection(hostName, sid, userName, password,port);
	  }
	 
	  public static Connection getOracleConnection(String hostName, String sid,
	          String userName, String password,String port) throws ClassNotFoundException,
	          SQLException {
	 
	      
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	 
	 
	      // Example: jdbc:oracle:thin:@localhost:1521:db11g
	      String connectionURL = "jdbc:oracle:thin:@" + hostName +":" +port+ ":"+ sid;
	 
	      Connection conn = DriverManager.getConnection(connectionURL, userName,
	              password);
	      return conn;
	  }
		public static void closeDbConnection(Connection connection) throws SQLException {
			if (null != connection) {
				connection.close();

			}

	  
}
}
