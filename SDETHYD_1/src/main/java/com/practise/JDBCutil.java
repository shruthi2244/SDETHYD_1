package com.practise;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class JDBCutil {
	@Test
public void getExecuteQuery() throws SQLException {
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "root");
	Statement st=con.createStatement();
	ResultSet result = st.executeQuery("select *from customer");
	while(result.next()) {
		System.out.println(result.getString(1));
	}
	}

}
