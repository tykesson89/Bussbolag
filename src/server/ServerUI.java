package server;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class ServerUI extends JPanel{
	private Server server;
	private AL al = new AL();
	
	//Connect
	private JButton btnConnect;
	private JTextField txtPassword;
	private JTextField txtUserName;
	
	//Stad
	private JButton btnCreateTown;
	private JTextField townName;
	private JLabel txtTownName;
	private JTextField townCountry;
	private JLabel txtTownCountry;
	private JTextField townCurrency;
	private JLabel txtTownCurrency;
	private JTextField townLanguage;
	private JLabel txtTownLanguage;
	
	//Resa
	private JButton btnTravel;
	
	private JComboBox comboBoxFrom;
	private JLabel txtTravelFrom;
    private JComboBox comboBoxTo;
    private JLabel txtTravelTo;
	
	private JTextField travelWeek;
	private JLabel txtTravelWeek;
	
	private JTextField travelPrice;
	private JLabel txtTravelPrice;
	
	private JTextField travelSeats;
	private JLabel txtTravelSeats;
	
	private JTextField travelDeparture;
	private JLabel txtTravelDeparture;
	
	private JTextField travelArrival;
	private JLabel txtTravelArrival;
	
	
	
	
	
	public ServerUI(){
		initConnect();
		initTown();
		initComboBoxes();
		initTravel();
		addComponents();
	}
	
	public void initTown(){
		setLayout(null);
		btnCreateTown = new JButton("Skapa ny Stad");
		btnCreateTown.setBounds(25, 150, 200, 25);
		btnCreateTown.addActionListener(al);
		
		townName = new JTextField();
		txtTownName = new JLabel("Stad");
		townName.setBounds(100, 25, 200, 25);
		txtTownName.setBounds(25, 25, 50, 25);
		
		townCountry = new JTextField();
		txtTownCountry = new JLabel("Land");
		townCountry.setBounds(100, 55, 200, 25);
		txtTownCountry.setBounds(25, 55, 50, 25);
		
		
		townCurrency = new JTextField();
		txtTownCurrency = new JLabel("Valuta");
		townCurrency.setBounds(100, 85, 200, 25);
		txtTownCurrency.setBounds(25, 85, 50, 25);
		
		
		townLanguage = new JTextField();
		txtTownLanguage = new JLabel("Språk");
		townLanguage.setBounds(100, 115, 200, 25);
		txtTownLanguage.setBounds(25, 115, 50, 25);
		
		
	}
	
	public void initComboBoxes(){
		comboBoxFrom = new JComboBox();
        comboBoxFrom.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                comboBoxFrom.getSelectedItem();
            }
        });
        comboBoxFrom.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuCanceled(PopupMenuEvent e) {

            }
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

            }
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                comboBoxFrom.removeAllItems();
                Object[] res = server.getAllCities();
                	for(int i = 0; i < res.length; i++){
                		comboBoxFrom.addItem(res[i]);
                }
            }
        });
        txtTravelFrom = new JLabel("Från");
        comboBoxFrom.setBounds(400, 25, 125, 25);
        txtTravelFrom.setBounds(370, 25, 125, 25);
        
        
        comboBoxTo = new JComboBox();
        comboBoxTo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                comboBoxTo.getSelectedItem();
            }
        });
        comboBoxTo.addPopupMenuListener(new PopupMenuListener() {
            public void popupMenuCanceled(PopupMenuEvent e) {

            }
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {

            }
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            	comboBoxTo.removeAllItems();
                Object[] res = server.getAllCities();
                for(int i = 0; i < res.length; i++){
                    comboBoxTo.addItem(res[i]);
                }
            }
        });
        txtTravelTo = new JLabel("Till");
        comboBoxTo.setBounds(600, 25, 125, 25);
        txtTravelTo.setBounds(580, 25, 125, 25);
        
	}
	
	public void initTravel(){
		travelWeek = new JTextField();
		txtTravelWeek = new JLabel("Vecka");
		travelWeek.setBounds(400, 55, 125, 25);
		txtTravelWeek.setBounds(360, 55, 125, 25);
		
		travelPrice = new JTextField();
		txtTravelPrice =  new JLabel("Pris");
		travelPrice.setBounds(600, 55, 125, 25);
		txtTravelPrice.setBounds(575, 55, 125, 25);
		
		travelDeparture = new JTextField("HHMMSS");
		txtTravelDeparture =  new JLabel("Avresa");
		travelDeparture.setBounds(400, 85, 125, 25);
		txtTravelDeparture.setBounds(355, 85, 125, 25);
		
		travelArrival = new JTextField("HHMMSS");
		txtTravelArrival =  new JLabel("Hemresa");
		travelArrival.setBounds(600, 85, 125, 25);
		txtTravelArrival.setBounds(545, 85, 125, 25);
		
		
		travelSeats = new JTextField();
		txtTravelSeats =  new JLabel("Platser");
		travelSeats.setBounds(400, 115, 125, 25);
		txtTravelSeats.setBounds(355, 115, 125, 25);
		
		btnTravel = new JButton("Lägg till resor");
		btnTravel.setBounds(400, 150, 200, 25);
		btnTravel.addActionListener(al);
		
	}
	
	public void initConnect(){
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(al);
		txtPassword = new JTextField("test");
		txtUserName = new JTextField("test");
		
		btnConnect.setBounds(500, 500, 200, 25);
		txtPassword.setBounds(290, 500, 200, 25);
		txtUserName.setBounds(80, 500, 200, 25);
	}
	
	
	
	public void addComponents(){
		add(townName);
		add(townCountry);
		add(townCurrency);
		add(townLanguage);
		add(btnCreateTown);
		add(txtTownName);
		add(txtTownCountry);
		add(txtTownCurrency);
		add(txtTownLanguage);
		
		add(btnConnect);
		add(txtPassword);
		add(txtUserName);
		
		add(comboBoxFrom);
		add(txtTravelFrom);
		add(comboBoxTo);
		add(txtTravelTo);
		
		add(travelWeek);
		add(txtTravelWeek);
		
		add(travelPrice);
		add(txtTravelPrice);
		
		add(travelDeparture);
		add(txtTravelDeparture);
		
		add(travelArrival);
		add(txtTravelArrival);
		
		add(travelSeats);
		add(txtTravelSeats);
		add(btnTravel);
		
		
	}
	
	public long getTimeLong(String time){

		String[] parts;
		parts = time.split(":");
		long ret = ((Long.parseLong(parts[0])-1) * 3600000) + (Long.parseLong(parts[1]) * 60000) + (Long.parseLong(parts[2]) * 1000);
		return ret;
	}
	
	private class AL implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreateTown){
				if(!townName.getText().isEmpty() && !townCountry.getText().isEmpty() && !townCurrency.getText().isEmpty() && !townLanguage.getText().isEmpty()){
					System.out.println("Adding Town " + townName.getText() );
					server.addCity(townName.getText(), townCountry.getText(), townCurrency.getText(), townLanguage.getText());
				}
			} else if (e.getSource() == btnConnect && btnConnect.getText().equals("Connect")){
				server = new Server("localhost", "buss",  txtPassword.getText(), txtUserName.getText(), 40001);
				btnConnect.setText("Disconnect");
			} else if (e.getSource() == btnConnect && btnConnect.getText().equals("Disconnect")){
				server.closeConnection();
				btnConnect.setText("Connect");
			} else if(e.getSource() == btnTravel){
				
				Time departure = new Time(getTimeLong(travelDeparture.getText()));
				Time arrival = new Time(getTimeLong(travelArrival.getText()));
				server.addTravel(Integer.parseInt(travelWeek.getText()), comboBoxFrom.getSelectedItem().toString(), comboBoxTo.getSelectedItem().toString(), departure, arrival, Integer.parseInt(travelPrice.getText()), Integer.parseInt(travelSeats.getText()));
			}
		}
	}
	
	
	
	/**
	 * Main metod för ServerUI
	 */
	public static void main(String [] args){
		
		ServerUI ui = new ServerUI();
		JFrame frame = new JFrame();
		frame.setTitle("Buss");
		frame.setPreferredSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(ui);
		frame.pack();
		frame.setVisible(true);
	}
}
