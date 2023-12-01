package configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// configs chứa file cấu hình dự án
public class DataSource {
	
	private String lapName = "LAPTOP-GLPU496D";
	private String databaseName = "testwebcafe3";
	
											// ten lap top                 // database name
	//private String jdbcURL = "jdbc:sqlserver://LAPTOP-GLPU496D;databaseName=TESTDATA;integratedSecurity=true";
	private String jdbcURL = "jdbc:sqlserver://" + lapName + ";databaseName=" + databaseName +";integratedSecurity=true;characterEncoding=UTF-8";
	private String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public DataSource() {
		
	}
	
	protected  Connection getConnection() {
		Connection connection =null;
		try {
			Class.forName(jdbcDriver);
			connection = DriverManager.getConnection(jdbcURL);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}
	
	// print exception 
	public void printSQLException(SQLException exception) {
		for (Throwable throwable : exception) {
			if (throwable instanceof SQLException) {
				throwable.printStackTrace(System.err);
				System.err.println("SQL State: "+ ((SQLException) throwable).getSQLState());
				System.err.println("Error Code: "+ ((SQLException) throwable).getErrorCode());
				System.err.println("Message: "+ ((SQLException) throwable).getMessage());
				Throwable throwable2 = exception.getCause();
				while (throwable2 != null) {
					System.out.println("Cause: " + throwable2);
					throwable2 = throwable2.getCause();
				}
				
			}
		}
	}

}
