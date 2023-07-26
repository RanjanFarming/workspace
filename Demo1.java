package online;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import ineuron.JdbcUtil;

import java.io.IOException;
import java.sql.*;

public class Demo1 {
	
	public static void main(String[] arg) {
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try {
		
			
			
			connection=JdbcUtil.getConnection();
			//step--->3 create the statement object and execute the query
			if(connection!=null)
			statement=connection.createStatement();
			if(statement !=null) {
				String s="select * from lombok";
				resultset=statement.executeQuery(s);
				System.out.println(  statement.getClass().getName());
				System.out.println(  resultset.getClass().getName());
			}
			if(resultset !=null) {
				
				System.out.println("id\tname");
				// step--->4 process the resultSet
				while(resultset.next()) {
					
					System.out.println(resultset.getInt("id")+"\t" +resultset.getString("name"));
				}
			
			
			}
		}
		
		
		
		 catch ( SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		try {
			JdbcUtil.cleanUp(connection, statement, resultset);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}