package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            if(rs.getString("user_name").equals(userr) && !(userr.equals("")) ){
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

        private List<String> help (String  currentuser,String newuser  ,String pass, String birth, String first, String last, String city)
        {
           List<String> ans=new ArrayList<>();

            String sql = "SELECT * FROM users where user_name=\""+currentuser+"\"" ;
            try (Connection conn = this.connect();
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)){
                 if(newuser.equals(""))
                     ans.add(0,rs.getString("user_name"));
                 else
                     ans.add(newuser);
                if(pass.equals(""))
                    ans.add(1,rs.getString("password"));
                else
                    ans.add(pass);
                if(birth.equals(""))
                    ans.add(2,rs.getString("BDay"));
                else
                    ans.add(pass);
                if(first.equals(""))
                    ans.add(3,rs.getString("first_name"));
                else
                    ans.add(first);
                if(last.equals(""))
                    ans.add(4,rs.getString("last_name"));
                else
                    ans.add(last);
                if(city.equals(""))
                    ans.add(5,rs.getString("city"));
                else
                    ans.add(city);

                //stmt.close();
                //conn.close();
                //rs.close();
                //conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return ans;
        }

    public void update(String currentuser, String newuser ,String pass, String birth, String first, String last, String city) {


        String sql = "UPDATE users SET user_name = ? , "
                + "password = ? ,"
                + "BDay = ? ,"
                + "first_name = ? ,"
                + "last_name = ? ,"
                + "city = ?"
                + "WHERE user_name=?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(7, currentuser);


            // set the corresponding param
            /*
            if((!newuser.equals("")))
                pstmt.setString(1, newuser);
            if((!pass.equals("")))
                pstmt.setString(2, pass);
            if((!birth.equals("")))
                pstmt.setString(3, birth);
            if((!first.equals("")))
                pstmt.setString(4, first);
            if((!last.equals("")))
                pstmt.setString(5, last);
            if((!city.equals("")))
                pstmt.setString(6, city);
            */
            // update
           List<String> ans= help(currentuser,newuser  ,pass, birth, first, last, city);
            pstmt.setString(1,ans.get(0));
            pstmt.setString(2,ans.get(1));
            pstmt.setString(3,ans.get(2));
            pstmt.setString(4,ans.get(3));
            pstmt.setString(5,ans.get(4));
            pstmt.setString(6,ans.get(5));




            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean logIn (String userName,String password){
        //make sure the password is correct
        String sql = "SELECT password FROM users where user_name=\""+userName+"\"" ;

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            if(!rs.getString("password").equals(password)){
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        //write the user at log in users
            String s = "INSERT INTO logInTable (username) VALUES(?)";
            try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(s)) {
                pstmt.setString(1, userName);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        return true;

    }

    public String checkMySellarInbox(String userName){

        //check if the user have vacation he need to approve-----if he published vacation to sell
        String sql = "SELECT sellarUser FROM waitForSellar where sellarUser=\""+userName+"\"" ;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            if(rs.getString("sellarUser").equals(userName) ){


                //there is vacation wait for the seller approve--we take the details from the table and inform the seller at his inbox
                String vecationFromWaiting = "SELECT vacationId FROM waitForSellar where sellarUser=\""+userName+"\"" ;
                Statement stmt1  = conn.createStatement();
                ResultSet rs1    = stmt1.executeQuery(vecationFromWaiting);
                String vacationWait=rs1.getString("vacationId");

                //details on the buyer
                String buyer = "SELECT buyerUser FROM waitForSellar where sellarUser=\""+userName+"\"" ;
                Statement stm  = conn.createStatement();
                ResultSet ans    = stm.executeQuery(buyer);
                String buyerUser=ans.getString("buyerUser");

                //take the details on the vacation
                String destenation = "SELECT destenation FROM vacationsForSale where vacationId=\""+vacationWait+"\"" ;
                Statement stmt2  = conn.createStatement();
                ResultSet deste    = stmt2.executeQuery(destenation);
                String dest=deste.getString("destenation");


                String airPortCampany = "SELECT airPortCampany FROM vacationsForSale where vacationId=\""+vacationWait+"\"" ;
                Statement stmt3  = conn.createStatement();
                ResultSet airP    = stmt3.executeQuery(airPortCampany);
                String airPort=airP.getString("airPortCampany");


                String dates = "SELECT dateOfVecation FROM vacationsForSale where vacationId=\""+vacationWait+"\"" ;
                Statement stmt4  = conn.createStatement();
                ResultSet datese    = stmt4.executeQuery(dates);
                String date=datese.getString("dateOfVecation");


//                String lugg = "SELECT luggage FROM vacationsForSale where vecation_id=\""+vacationWait+"\"" ;
//                Statement stmt5  = conn.createStatement();
//                ResultSet luggege    = stmt5.executeQuery(lugg);

                String numOfTickets = "SELECT numOfTickets FROM vacationsForSale where vacationId=\""+vacationWait+"\"" ;
                Statement stmt6  = conn.createStatement();
                ResultSet numOftik    = stmt6.executeQuery(numOfTickets);
                String numOftick=numOftik.getString("numOfTickets");



                return "Hello "+userName+"!!\nThe user "+buyerUser+" is interesting in your "+numOftick+" tickets to "+dest+" on the dates: "+date+" from the "+airPort+" air port \nPleas approve or disapprove the request:";
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //if there is nothing on the inbox
        return "";
    }

    public void approveRequest(String sellar){

        String vecationFromWaiting = "SELECT vacationId FROM waitForSellar where sellarUser=\""+sellar+"\"" ;
        try (Connection conn = this.connect();
             Statement stmt1  = conn.createStatement();
             ResultSet rs1    = stmt1.executeQuery(vecationFromWaiting)){

        String vacationIDApproved=rs1.getString("vacationId");

        //details on the buyer
        String buyer = "SELECT buyerUser FROM waitForSellar where sellarUser=\""+sellar+"\"" ;
        Statement stm  = conn.createStatement();
        ResultSet ans    = stm.executeQuery(buyer);
        String buyerUserApproved=ans.getString("buyerUser");


            String sql = "INSERT INTO finalApprove (vacationId,buyerUser,sellarUser) VALUES(?,?,?)";
            //update data on approved requests

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, vacationIDApproved);
                pstmt.setString(2, buyerUserApproved);
                pstmt.setString(3, sellar);
                pstmt.executeUpdate();


            //delete vacation fron waiting requests
            String sql2 = "DELETE FROM waitForSellar where vacationId=?";
            PreparedStatement pstmt1 = conn.prepareStatement(sql2);
            pstmt1.setString(1, vacationIDApproved);
            pstmt1.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


    public String checkMyBuyerInbox(String userName){

        String sql = "SELECT buyerUser FROM finalApprove where buyerUser=\""+userName+"\"" ;
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            if(rs.getString("buyerUser").equals(userName) ) {


                //there is vacation that approved for the user--we take the details from the table and inform the buyer at his inbox
                String vacationApprove = "SELECT vacationId FROM finalApprove where buyerUser=\"" + userName + "\"";
                Statement stmt1 = conn.createStatement();
                ResultSet rs1 = stmt1.executeQuery(vacationApprove);
                String Vapprove = rs1.getString("vacationId");


                //details on the sellar
                String sellar = "SELECT sellarUser FROM finalApprove where buyerUser=\""+userName+"\"" ;
                Statement stm  = conn.createStatement();
                ResultSet ans    = stm.executeQuery(sellar);
                String sellarUser=ans.getString("sellarUser");


                //take the details on the vacation
                String destenation = "SELECT destenation FROM vacationsForSale where vacationId=\""+Vapprove+"\"" ;
                Statement stmt2  = conn.createStatement();
                ResultSet deste    = stmt2.executeQuery(destenation);
                String dest=deste.getString("destenation");


                String airPortCampany = "SELECT airPortCampany FROM vacationsForSale where vacationId=\""+Vapprove+"\"" ;
                Statement stmt3  = conn.createStatement();
                ResultSet airP    = stmt3.executeQuery(airPortCampany);
                String airPort=airP.getString("airPortCampany");


                String dates = "SELECT dateOfVecation FROM vacationsForSale where vacationId=\""+Vapprove+"\"" ;
                Statement stmt4  = conn.createStatement();
                ResultSet datese    = stmt4.executeQuery(dates);
                String date=datese.getString("dateOfVecation");


                String numOfTickets = "SELECT numOfTickets FROM vacationsForSale where vacationId=\""+Vapprove+"\"" ;
                Statement stmt6  = conn.createStatement();
                ResultSet numOftik    = stmt6.executeQuery(numOfTickets);
                String numOftick=numOftik.getString("numOfTickets");

                //delete vacation fron final approved
                String sqll = "DELETE FROM finalApprove where vacationId=?";
                PreparedStatement pstmt1 = conn.prepareStatement(sqll);
                pstmt1.setString(1, Vapprove);
                pstmt1.executeUpdate();


                return "Hello "+userName+"!!\nThe sellar "+sellarUser+" approved your request for "+numOftick+" tickets to "+dest+" on the dates: "+date+" from the "+airPort+" air port \nWe wish you a great vacation";

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



        String sql2 = "SELECT buyerUser FROM notApprove where buyerUser=\""+userName+"\"" ;
        try (Connection conn1 = this.connect();
             Statement stmt1 = conn1.createStatement();
             ResultSet rs1 = stmt1.executeQuery(sql2)){;
             //check non approved vacation

            if(rs1.getString("buyerUser").equals(userName) ) {
                //there is vacation that not approved for the user--we take the details from the table and inform the buyer at his inbox
                String vacationNotApprove = "SELECT vacationId FROM notApprove where buyerUser=\"" + userName + "\"";
                Statement s = conn1.createStatement();
                ResultSet r = s.executeQuery(vacationNotApprove);
                String VNapprove = r.getString("vacationId");


                //details on the sellar
                String sellar = "SELECT sellarUser FROM notApprove where buyerUser=\""+userName+"\"" ;
                Statement stm  = conn1.createStatement();
                ResultSet ans    = stm.executeQuery(sellar);
                String sellarUser=ans.getString("sellarUser");


                //take the details on the vacation
                String destenation = "SELECT destenation FROM vacationsForSale where vacationId=\""+VNapprove+"\"" ;
                Statement stmt2  = conn1.createStatement();
                ResultSet deste    = stmt2.executeQuery(destenation);
                String dest=deste.getString("destenation");


                String airPortCampany = "SELECT airPortCampany FROM vacationsForSale where vacationId=\""+VNapprove+"\"" ;
                Statement stmt3  = conn1.createStatement();
                ResultSet airP    = stmt3.executeQuery(airPortCampany);
                String airPort=airP.getString("airPortCampany");


                String dates = "SELECT dateOfVecation FROM vacationsForSale where vacationId=\""+VNapprove+"\"" ;
                Statement stmt4  = conn1.createStatement();
                ResultSet datese    = stmt4.executeQuery(dates);
                String date=datese.getString("dateOfVecation");


                String numOfTickets = "SELECT numOfTickets FROM vacationsForSale where vacationId=\""+VNapprove+"\"" ;
                Statement stmt6  = conn1.createStatement();
                ResultSet numOftik    = stmt6.executeQuery(numOfTickets);
                String numOftick=numOftik.getString("numOfTickets");

                //delete vacation fron final approved
                String del = "DELETE FROM notApprove where vacationId=?";
                PreparedStatement pstmt1 = conn1.prepareStatement(del);
                pstmt1.setString(1, VNapprove);
                pstmt1.executeUpdate();


                return "Hello "+userName+"!!\nThe sellar "+sellarUser+" did not approved your request for "+numOftick+" tickets to "+dest+" on the dates: "+date+" from the "+airPort+" air port \nKeep looking for the next opportunity";


            }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            //if there is nothing on the inbox
            return "";

    }


    public void notApproveRequest(String sellar){

        String vecationFromWaiting = "SELECT vacationId FROM waitForSellar where sellarUser=\""+sellar+"\"" ;
        try (Connection conn = this.connect();
             Statement stmt1  = conn.createStatement();
             ResultSet rs1    = stmt1.executeQuery(vecationFromWaiting)){

            String vacationIDNotApproved=rs1.getString("vacationId");

            //details on the buyer
            String buyer = "SELECT buyerUser FROM waitForSellar where sellarUser=\""+sellar+"\"" ;
            Statement stm  = conn.createStatement();
            ResultSet ans    = stm.executeQuery(buyer);
            String buyerUserNotApproved=ans.getString("buyerUser");


            String sql = "INSERT INTO notApprove (vacationId,buyerUser,sellarUser) VALUES(?,?,?)";
            //update data on unapproved requests
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vacationIDNotApproved);
            pstmt.setString(2, buyerUserNotApproved);
            pstmt.setString(3, sellar);
            pstmt.executeUpdate();

            //delete vacation fron waiting requests
            String sql2 = "DELETE FROM waitForSellar where vacationId=?";
            PreparedStatement pstmt1 = conn.prepareStatement(sql2);
            pstmt1.setString(1, vacationIDNotApproved);
            pstmt1.executeUpdate();


            //to change available field to true!!




        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}



