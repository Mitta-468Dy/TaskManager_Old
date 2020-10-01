package hoge.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLConnect {

  public static void main(String[] args) {
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {

      con = DriverManager.getConnection(
        "jdbc:mysql://localhost/test?useSSL=false",
        "root",
        "ignitex326"
      );// "password"の部分は，各自の環境に合わせて変更してください。

      pstmt = con.prepareStatement("select * from person where id=3");

      rs = pstmt.executeQuery();

      while (rs.next()) {
        System.out.println(rs.getString("name"));
        System.out.println(rs.getInt("age"));
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
      if (pstmt != null) {
        try {
          pstmt.close();
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