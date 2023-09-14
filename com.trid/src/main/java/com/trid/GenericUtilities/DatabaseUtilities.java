package com.trid.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author KARMA
 *
 */
public class DatabaseUtilities {

	Connection con;
	public void connectToDatabase() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.dbName, IPathConstants.dbUN, IPathConstants.dbPWD);
	}
/**
 * This method is used to execute and fetch data
 * @param query
 * @param columnIndex
 * @param expectedData
 * @return
 * @throws Throwable
 */
	public String executeQueryAndFetchData(String query,int columnIndex,String expectedData) throws Throwable {

		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()) {

			String actualData = result.getString(columnIndex);
			if(actualData.equalsIgnoreCase(expectedData)) {

				flag=true;
				break;
			}
		}
		if(flag==true)
		{

			System.out.println("Data verification is done");
			return expectedData;
		}		
		else {

			System.out.println("Data is not present");
			return "";

		}

	}
	
	/**
	 * This method is used for closing the database
	 * @author KARMA
	 * @throws SQLException
	 */
	public void closeDb() throws SQLException {

		con.close();

	}
	

}
