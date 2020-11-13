package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HWTask {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:mysql://hostmane:port/db name
	String dbUrl = "jdbc:mysql://18.232.148.34:3306/syntaxhrm_mysql";

	@Test
	public void resultSetMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select emp_firstname, emp_lastname, loc.name\r\n" + 
				"from hs_hr_employees emp \r\n" + 
				"join hs_hr_emp_locations empLoc \r\n" + 
				"on emp.emp_number = empLoc.emp_number\r\n" + 
				"join ohrm_location loc \r\n" + 
				"on empLoc.location_id = loc.id\r\n" + 
				"where loc.name = 'Smart Office';");
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int colCount = rsMetaData.getColumnCount();
		System.out.println(colCount);

		List<String> colNames = new ArrayList<>();
		for (int i = 1; i <= colCount; i++) {
			String colName = rsMetaData.getColumnName(i);
			colNames.add(colName);
		}

		for (String cN : colNames) {
			System.out.println(cN);
		}
		System.out.println("------------------------------------");
		List<String> colTypes = new ArrayList<>();
		for (int i = 1; i <= colCount; i++) {
			String colType = rsMetaData.getColumnTypeName(i);			
			colTypes.add(colType);
		}

		List<String> colTableNames = new ArrayList<>();
		for (int i = 1; i <= colCount; i++) {
			String colTableName = rsMetaData.getTableName(i);
			colTableNames.add(colTableName);
		}
		
		for(int i = 0; i < colCount; i++) {
			String format = "%-20s%-20s%s%n";
			System.out.printf(format, colNames.get(i), colTypes.get(i),colTableNames.get(i));
		}
		
		rs.close();
		st.close();
		conn.close();
	}
}
