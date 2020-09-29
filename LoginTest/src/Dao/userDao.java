package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class userDao {
	private static final String driverClass="com.mysql.jdbc.Driver";
	private static final String jdbcURL="jdbc:mysql://localhost/mytest?useUnicode=true&characterEncoding=UTF-8";
	private static final String user="root";
	private static final String pwd="123456";
	
	public static Connection getConnection() throws Exception
	{
		Class.forName(driverClass);
		Connection conn=DriverManager.getConnection(jdbcURL, user, pwd);
		return conn;
	}
	
	public String testLogin(String name,String password) throws Exception {
		Connection connection=getConnection();
		PreparedStatement myps=connection.prepareStatement("select * from user where ID=?");
		myps.setString(1, name);
		myps.execute();
		String psw="";
		ResultSet rs=myps.getResultSet();
		if(rs.next())
		{
			psw=rs.getString("password");
		}
		if (psw.equals(password))
			return "ok";
		else {
			return "error";
		}
		
		
		
	}

}
