package practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class SelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		
		//Step:1(Register the database)
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//Step:2(Get connection for database)
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiles", "root", "ROOT");
		
		//Step:3(Create statement)
		Statement state=conn.createStatement();
		String query="select * from ios;";
		
		//Step:4(Execute the query)
		ResultSet result=state.executeQuery(query);
		
		while(result.next()) {
			
			
			System.out.println(result.getString(1)+"----"+result.getString(2)+"----"+result.getString(3));
		}
	    //Step:5(Close the connection)
		conn.close();
	}

}
