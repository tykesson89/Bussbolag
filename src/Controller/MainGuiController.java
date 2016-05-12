package Controller;

import GUI.MainGUI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Henrik on 2016-04-28.
 */
public class MainGuiController {
    private boolean turIsChecked;
    private boolean returIsChecked;
    private Object[] res;
    private MainGUI mainGUI;

    public MainGuiController(){
        mainGUI = new MainGUI(this);
        new GetAllCities();
    }
    public Object[] getAllCities(){
        return res;
    }


    public void turIsChecked(){
        this.turIsChecked = true;
        this.returIsChecked = false;

    }
    public void returIsChecked(){
        this.turIsChecked = false;
        this.returIsChecked = true;
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
