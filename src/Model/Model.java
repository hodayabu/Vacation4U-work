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

    public boolean exist(String userr) {

        String sql = "SELECT user_name FROM users where user_name=\""+userr+"\"" ;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            if(rs.getString("user_name").equals(userr)){
                return true;
            }

                //stmt.close();
                //conn.close();
                //rs.close();
                //conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public String read(String userr) throws InterruptedException {
        String sql = "SELECT * FROM users where user_name=\""+userr+"\"" ;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            if(rs.getString("user_name").equals(userr)){
                String ans="user name:"+" "+rs.getString(1)+"\npassword:"+" "+rs.getString(2)+"\nday of birth:"+" "+rs.getString(3)+
                        "\nfirst name:"+" "+rs.getString(4)+"\nlast name:"+" "+rs.getString(5)+"\ncity:"+" "+rs.getString(6);
                System.out.println(ans);
                return ans;
            }

            //stmt.close();
            //conn.close();
            //rs.close();
            //conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delete(String userr) {
            String sql = "DELETE FROM users where user_name=?";

            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // set the corresponding param
                pstmt.setString(1, userr);
                // execute the delete statement
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    public void update(String currentuser, String newuser ,String pass, String birth, String first, String last, String city) {
        String sql = "UPDATE users SET user_name = ?"
                + "password = ? "
                + "BDay = ?"+ "first_name = ? "+ "last_name = ? "+ "city = ?"+
                " where user_name = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            //pstmt.setString(7, currentuser);


            // set the corresponding param
            if(newuser!="")
                pstmt.setString(1, newuser);
            if(pass!="")
                pstmt.setString(2, pass);
            if(birth!="")
                pstmt.setString(3, birth);
            if(first!="")
                pstmt.setString(4, first);
            if(last!="")
                pstmt.setString(5, last);
            if(city!="")
                pstmt.setString(6, city);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}



