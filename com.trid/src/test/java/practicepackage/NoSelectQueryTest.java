package practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NoSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		int result=0;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mobiles", "root", "ROOT");
		
		Statement statement = conn.createStatement();
		
		String query="insert into android values('nothing','phone1',27999),('vivo','v17',17999);";
		
		result = statement.executeUpdate(query);
		}
		catch (Exception e) {
			
		}
		finally {
		if(result>0) {
			System.out.println("Data updated");
		}
		else {
		
		System.err.println("Data updation failed");
		}
		}

	}

}
