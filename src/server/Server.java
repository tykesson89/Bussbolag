package server;

import Objects.Customer;
import Objects.Travel;
import Objects.TravelSuggestions;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Server extends Thread {

    private String host;
    private String databas;
    private String password;
    private String user;
    private ServerSocket serversocket;
    private Thread thread = new Thread(this);
    private Connection conn;

    public Server(String host, String databas, String password, String user, int port) {
        try {
            this.host = host;
            this.databas = databas;
            this.password = password;
            this.user = user;

            serversocket = new ServerSocket(port);
            thread.start();

            System.out.println("Connecting");
            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + databas + "?user=" + user + "&password=" + password);
            System.out.println("Connected: " + conn);

        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Disconnected");
        } catch (SQLException e) {
        }
    }

    public void run() {
        System.out.println("Server startad");
        try {
            while (true) {
                System.out.println("Waiting for client to connect!");
                Socket socket = serversocket.accept();
                System.out.println("Client Connected");
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String str;
                str =  ois.readObject().toString();
                if(str.equals("All Cities")){
                	Object[] res = getAllCities();
                    oos.writeObject(res);
                }else if(str.equals("All Cities As List")) {
                    List<String> list = getAllCitiesAsList();
                    oos.writeObject(list);
                }else if(str.equals("Search")){
                    Travel travel;
                    travel = (Travel)ois.readObject();
                   List<TravelSuggestions> list = getATravelSuggestion(travel);
                    oos.writeObject(list);
                }else if(str.equals("New Customer")){
                    Customer customer;
                    customer = (Customer)ois.readObject();
                  String response =  newCustomer(customer);
                    oos.writeObject(response);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCity(String name, String country, String currency, String language) {
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into Stad(namn, land, valuta, språk) values (?, ?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, country);
            stmt.setString(3, currency);
            stmt.setString(4, language);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Stad   : " + name + "\nLand   : " + country + "\nValuta : " + currency + "\nSpråk  : " + language);

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public String newCustomer(Customer customer){
        long personalNumber = customer.getPersonalNumber();
        int travelId = customer.getTravelId();
        int seats = customer.getSeats();
        String phoneNumber = customer.getPhoneNumber();
        String email = customer.getEmail();
        String address = customer.getAddress();
        String name = customer.getName();
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into Kund(PersonNr, Namn, Email, Adress, Telefon) values (?, ?, ?, ?, ?)");
            stmt.setLong(1, personalNumber);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, address);
            stmt.setString(5, phoneNumber);
            stmt.executeUpdate();

            PreparedStatement stmt1 = conn.prepareStatement("insert into bokning(PersonNr, ResID, platser) values (?, ?, ?)");
            stmt1.setLong(1, personalNumber);
            stmt1.setInt(2, travelId);
            stmt1.setInt(3, seats);
            stmt1.executeUpdate();


            ResultSet rs;

            Statement statement;
            statement = conn.createStatement();
                rs = statement.executeQuery("Select platser from Resa where resID = " + travelId + ";");
                rs.first();
                int seatsLeft = rs.getInt("platser");
                seatsLeft = seatsLeft - seats;

            PreparedStatement stmt2 = conn.prepareStatement("update resa set platser = ? where resID = ?");
            stmt2.setInt(1, seatsLeft);
            stmt2.setInt(2, travelId);
            stmt2.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
            return "Fail";
        }
        return "Success";

    }
    
    public Object[] getAllCities(){
        ResultSet rs;
        ArrayList<String> res = new ArrayList<>();
        Statement statement;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("Select namn from Stad");
            while (rs.next()){
                res.add(rs.getString("namn"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return res.toArray();
    }
    public List<String> getAllCitiesAsList(){
        ResultSet rs;
        List<String> res = new ArrayList<>();
        Statement statement;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("Select namn from Stad");
            while (rs.next()){
                res.add(rs.getString("namn"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return res;
    }
    public List<TravelSuggestions> getATravelSuggestion(Travel travel){
        String from = travel.getFrom();
        String to = travel.getTo();
        String dayOfWeek = travel.getDayOfWeek();
        int week = travel.getWeek();
        int seats = travel.getSeats();
        TravelSuggestions travelSuggestions;
        List<TravelSuggestions> travelSuggestionsList = new ArrayList<>();
        Statement statement;
        ResultSet rs;
        try {
            statement = conn.createStatement();
            rs = statement.executeQuery("Select * from Resa WHERE vecka = " + week + " and veckodag = '" + dayOfWeek + "' and till = '" + to + "' and från = '" + from + "';");
            while (rs.next()){
            travelSuggestions = new TravelSuggestions();

                travelSuggestions.setArrival(rs.getTime("ankomstid"));
                travelSuggestions.setDeparture(rs.getTime("avgångstid"));
                travelSuggestions.setDayOfWeek(rs.getString("veckodag"));
                travelSuggestions.setFrom(rs.getString("från"));
                travelSuggestions.setTo(rs.getString("till"));
                travelSuggestions.setPrice(rs.getInt("pris"));
                travelSuggestions.setSeats(seats);
                travelSuggestions.setWeek(week);
                travelSuggestions.setTravelid(rs.getInt("resid"));
                System.out.println(travelSuggestions.toString());
                travelSuggestionsList.add(travelSuggestions);
            }
        }catch (SQLException e){
            e.printStackTrace();
            e.fillInStackTrace();
            e.getStackTrace();
        }

        return travelSuggestionsList;
    }
    
    
    public void addTravel(int week, String fromCity, String toCity, Time departure, Time arrival, int price, int seats ){
    	String weekDay;
    	
    	for(int i = week ; i < week+26; i++){
    		
    		for(int j = 1 ; j < 8 ; j++){
    			try {
    				if(j == 1){
    					weekDay = "Måndag";
    				} else if(j == 2){
    					weekDay = "Tisdag";
    				} else if (j == 3){
    					weekDay = "Onsdag";
    				} else if (j == 4){
    					weekDay = "Torsdag";
    				} else if (j == 5){
    					weekDay = "Fredag";
    				} else if (j == 6){
    					weekDay = "Lördag";
    				} else {
    					weekDay = "Söndag";
    				}
    	            PreparedStatement stmt = conn.prepareStatement("insert into Resa(vecka, platser, pris, veckodag, avgångstid, ankomstid, till, från) values (?, ?, ?, ?, ?, ?, ?, ?)");
    	            stmt.setInt(1, i);
    	            stmt.setInt(2, seats);
    	            stmt.setInt(3, price);
    	            stmt.setString(4, weekDay);
    	            stmt.setTime(5, departure);
    	            stmt.setTime(6, arrival);
    	            stmt.setString(7, fromCity);
    	            stmt.setString(8, toCity);
    	            stmt.executeUpdate();
    	            
    	        } catch (SQLException e) {
    	            System.out.println(e);
    	        }
    		}
    		
    	}
    	System.out.println("Adding travels");
    }


    /**
     * Test main för Server
     */
    public static void main(String[] args) {
    	long ret = ((((-1) * 3600000)) + ( 30* 60000) + ( 25* 1000));
    	
    	Time time = new Time(ret);
    	System.out.println(time.toString());
    }

}
