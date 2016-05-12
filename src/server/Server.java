package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

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

    public void addTravel(Date date, int week, int seats, int price, Time departure, Time arrival, String from, String to) {
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into Resa(datum, vecka, platser, pris, avgångstid, ankomsttid, till, från) values (?, ?, ?, ?, ?, ?, ?, ?)");
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
    public static void main(String[] args) {

    }

}
