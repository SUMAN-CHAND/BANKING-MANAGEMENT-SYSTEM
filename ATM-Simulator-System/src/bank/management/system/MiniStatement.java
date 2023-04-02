package bank.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;


public class MiniStatement extends JFrame{
	
	
	public MiniStatement(String pinNumber) {
		setLayout(null);
		setTitle("Mini Statement");
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds(150,20,200,20);
		bank.setFont(new Font("Osoward" ,Font.BOLD,16));
		add(bank);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,120,400,300);
		mini.setFont(new Font("Osoward" ,Font.BOLD,16));
		add(mini);
		
		JLabel bal = new JLabel();
		bal.setBounds(20,480,400,20);
		bal.setFont(new Font("Osoward" ,Font.BOLD,16));
		add(bal);
		
		
		
		JLabel card = new JLabel();
		card.setBounds(20,60,300,20);
		card.setFont(new Font("Osoward" ,Font.BOLD,16));
		add(card);
		
		try {
			
			DBCon connection = new DBCon();
			
			PreparedStatement ps = connection.con.prepareStatement("SELECT * FROM login where pin_Number = ?");
			ps.setString(1, pinNumber);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				card.setText("Card Number : " + rs.getString("card_Number").substring(0,4) + "XXXXXXXX" + rs.getString("card_Number").substring(12));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		int balance =0;
		
		try {
			
			DBCon connection = new DBCon();
			
			PreparedStatement ps = connection.con.prepareStatement("SELECT * FROM bank where pin = ?");
			ps.setString(1, pinNumber);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("dates")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>" );
			}
	
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			
			DBCon connection = new DBCon();
			
			PreparedStatement ps = connection.con.prepareStatement("SELECT * FROM bank where pin = ?");
			ps.setString(1, pinNumber);
			ResultSet rs = ps.executeQuery();
					
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance = Integer.parseInt(rs.getString("amount"));
				}else {
					balance -=Integer.parseInt(rs.getString("amount"));
				}		
			}
	
		} catch (Exception e) {
			System.out.println(e);
		}

		bal.setText("Your Current account balance is Rs. " + balance);
		
		setSize(400,600);
		setLocation(20,20);
		setVisible(true);   
//		setUndecorated(true);
		getContentPane().setBackground(Color.white);
	}
	
	public static void main(String[] args) {
		
		new MiniStatement("");

	}

}
