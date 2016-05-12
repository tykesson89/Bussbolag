package Controller;

import GUI.MainGUI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Henrik on 2016-04-28.
 */
public class MainGuiController {
    private boolean turIsChecked;
    private boolean returIsChecked;
    private Object[] res;
    private MainGUI mainGUI;
    private String avresa;
    private String hemresa;
    private Date dateAvresa;
    private Date dateHemresa;
    private Boolean tur;
    private int tickets;

    public MainGuiController(){
        mainGUI = new MainGUI(this);
        new GetAllCities();
    }
    public Object[] getAllCities(){
        return res;
    }
    public void setDateAvresa(String dateAvresa){
        Date date;
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = formatter.parse(dateAvresa);
            this.dateAvresa = date;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setDateHemresa(String dateHemresa){
        Date date;
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = formatter.parse(dateHemresa);
            this.dateHemresa = date;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setTickets(int tickets){
        this.tickets = tickets;

    }
    public void setTur(boolean tur){
        this.tur = tur;
    }

    public void turIsChecked(){
        this.turIsChecked = true;
        this.returIsChecked = false;

    }
    public void returIsChecked(){
        this.turIsChecked = false;
        this.returIsChecked = true;
    }


    public void setAvresa(String avresa){
        this.avresa = avresa;
    }
    public void setHemresa(String hemresa){
        this.hemresa = hemresa;
    }



    class GetAllCities extends Thread {
        private Socket socket;
        private Thread thread = new Thread(this);
        private static final String ip = "127.0.0.1";
        private static final int port = 40001;


        public GetAllCities(){
        thread.start();
        }

        @Override
        public void run() {
            try {
                socket = new Socket(ip, port);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                objectOutputStream.writeObject("All Cities");
                res = (Object[])objectInputStream.readObject();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        MainGuiController mainGuiController = new MainGuiController();
    }
}
