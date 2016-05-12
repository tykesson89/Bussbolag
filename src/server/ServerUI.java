package server;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	
	public ServerUI(){
		initConnect();
		initTown();
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
	
	public void initTravel(){
		
	}
	
	public void initConnect(){
		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(al);
		txtPassword = new JTextField("pw");
		txtUserName = new JTextField("root");
		
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
		
	}
	
	private class AL implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnCreateTown){
				if(!townName.getText().isEmpty() && !townCountry.getText().isEmpty() && !townCurrency.getText().isEmpty() && !townLanguage.getText().isEmpty()){
					System.out.println("Adding Town " + townName.getText() );
					server.addCity(townName.getText(), townCountry.getText(), townCurrency.getText(), townLanguage.getText());
				}
			} else if (e.getSource() == btnConnect && btnConnect.getText().equals("Connect")){
				server = new Server("localhost", "buss",  txtPassword.getText(), txtUserName.getText());
				btnConnect.setText("Disconnect");
			} else if (e.getSource() == btnConnect && btnConnect.getText().equals("Disconnect")){
				server.closeConnection();
				btnConnect.setText("Connect");
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
