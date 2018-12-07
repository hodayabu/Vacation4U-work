package Model;

import java.io.*;

public class Vacation {
    private static int counter =counter();
    private String User_saller;
    private String AirPortCompany;
    private String date;
    private String lagguge;
    private String NumOftickets;
    private String destination;
    private Boolean ReturnFlight;
    private String ticketType;
    private Boolean Availble;
    private int Vacation_id;

    //constructor that does not get vacation_id- mean its create complete new vacation
    public Vacation(String user_saller, String airPortCompany, String date, String lagguge, String numOftickets, String destination, Boolean returnFlight, String ticketType, Boolean availble) {
        User_saller = user_saller;
        AirPortCompany = airPortCompany;
        this.date = date;
        this.lagguge = lagguge;
        NumOftickets = numOftickets;
        this.destination = destination;
        ReturnFlight = returnFlight;
        this.ticketType = ticketType;
        Availble = availble;
        Vacation_id=Vacation.counter;
        Vacation.counter+=1;
        writecounter();
    }

    private void writecounter() {
        try {
            FileWriter f2 = new FileWriter(new File("resources\\counter.txt"),false);
            f2.write(String.valueOf(Vacation.counter));
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //constructor that get vacation_id= mean this vacation has been created in the passed
    public Vacation(String user_saller, String airPortCompany, String date, String lagguge, String numOftickets, String destination, Boolean returnFlight, String ticketType, Boolean availble, int vacation_id) {
        User_saller = user_saller;
        AirPortCompany = airPortCompany;
        this.date = date;
        this.lagguge = lagguge;
        NumOftickets = numOftickets;
        this.destination = destination;
        ReturnFlight = returnFlight;
        this.ticketType = ticketType;
        Availble = availble;
        Vacation_id = vacation_id;
    }

    //<editor-fold desc="getters and setters">
    public static int getCounter() {
        return counter;
    }

    public int getVacation_id(){
        return this.Vacation_id;
    }

    public String getUser_saller() {
        return User_saller;
    }

    public void setUser_saller(String user_saller) {
        User_saller = user_saller;
    }

    public String getAirPortCompany() {
        return AirPortCompany;
    }

    public void setAirPortCompany(String airPortCompany) {
        AirPortCompany = airPortCompany;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLagguge() {
        return lagguge;
    }

    public void setLagguge(String lagguge) {
        this.lagguge = lagguge;
    }

    public String getNumOftickets() {
        return NumOftickets;
    }

    public void setNumOftickets(String numOftickets) {
        NumOftickets = numOftickets;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Boolean getReturnFlight() {
        return ReturnFlight;
    }

    public void setReturnFlight(Boolean returnFlight) {
        ReturnFlight = returnFlight;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Boolean getAvailble() {
        return Availble;
    }

    public void setAvailble(Boolean availble) {
        Availble = availble;
    }
    //</editor-fold>

    private static int counter(){

        File file = new File("resources\\counter.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int ans=  Integer.valueOf(br.readLine());
            br.close();
            return ans;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;

    }
}
