package server;

import java.sql.*;

import javax.swing.JOptionPane;

public class Server {
	
	private String host;
	private String databas;
	private String password;
	private String user;
	
	private Connection conn;
	
	public Server(String host, String databas, String password, String user){
		try {
			this.host = host;
			this.databas = databas;
			this.password = password;
			this.user = user;

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
		} catch (SQLException e) {}
    }
	
	public void addCity(String name, String country, String currency, String language){
		try {
			PreparedStatement stmt = conn.prepareStatement( "insert into Stad(namn, land, valuta, språk) values (?, ?, ?, ?)");
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
	
	public void addTravel(Date date, int week, int seats, int price, Time departure, Time arrival, String from, String to ){
		try {
			PreparedStatement stmt = conn.prepareStatement( "insert into Resa(datum, vecka, platser, pris, avgångstid, ankomsttid, till, från) values (?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setDate(1, date);
			stmt.setInt(2, week);
			stmt.setInt(3, seats);
			stmt.setInt(4, price);
			stmt.setTime(5, departure);
			stmt.setTime(6, arrival);
			stmt.setString(7, from);
			stmt.setString(8, to);	
			stmt.executeUpdate();
			
			} catch (SQLException e) {
				System.out.println(e);
			}
	}
	
	
	/**
	 * Test main för Server
	 */
	public static void main(String [] args){
		
	}

}
