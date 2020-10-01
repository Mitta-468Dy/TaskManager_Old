package hoge.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Trying {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			con = DriverManager.getConnection(
			        "jdbc:mysql://localhost/tasktestdata?useSSL=false",
			        "root",
			        "ignitex326"
			);
			
			ps = con.prepareStatement("select * from tasks");
			
		    rs = ps.executeQuery();

		    while (rs.next()) {
		    	System.out.printf(String.valueOf(rs.getInt(1)) + " ");
		        System.out.printf(String.valueOf(rs.getInt(2)) + " ");
		        System.out.printf(rs.getString(3) + " ");
		        System.out.printf(rs.getString(4) + " ");
		        System.out.printf(String.valueOf(rs.getDate(5)) + " ");
		        System.out.printf(String.valueOf(rs.getDate(6)) + " ");
		        System.out.printf(String.valueOf(rs.getInt(7)) + " ");
		        System.out.printf(String.valueOf(rs.getInt(8)) + " ");
		        System.out.printf("\n");
		    }
			
		} catch (SQLException e) {
		      e.printStackTrace();
	    } finally {
	        if (rs != null) {
	            try {
	              rs.close();
	            } catch (SQLException e) {
	              e.printStackTrace();
	            }
	          }
	          if (ps != null) {
	            try {
	              ps.close();
	            } catch (SQLException e) {
	              e.printStackTrace();
	            }
	          }
	          if (con != null) {
	            try {
	              con.close();
	            } catch (SQLException e) {
	              e.printStackTrace();
	            }
	          }
	        }
		
	}
	

	
}
