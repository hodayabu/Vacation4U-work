package Model;

import View.Controller;

import java.sql.*;
import java.util.Observable;

public class Model {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:resources\\db.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;




//////////////////////////////////////////////////////////////////



    }


    public void Insert(String user, String pass, String birth, String first, String last, String city) {

            String sql = "INSERT INTO users (user_name,password,BDay,first_name,last_name, city) VALUES(?,?,?,?,?,?)";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, user);
                pstmt.setString(2, pass);
                pstmt.setString(3, birth);
                pstmt.setString(4, first);
                pstmt.setString(5, last);
                pstmt.setString(6, city);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    public boolean exist(String user) {
        String sql = "SELECT user_name FROM users where user_name='user'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
                System.out.println(rs.getString("user_name") );

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    }


