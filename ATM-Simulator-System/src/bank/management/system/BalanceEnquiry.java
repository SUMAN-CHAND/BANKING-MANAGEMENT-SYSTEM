package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	 
	JButton back;
	 String pinNumber;
	 int balance =0;
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));

	public BalanceEnquiry(String pinNumber) {
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);
		
		
		
		try {

			DBCon connection = new DBCon();
			PreparedStatement ps = connection.con.prepareStatement("SELECT * FROM bank where pin = ?");
			ps.setString(1,pinNumber);	
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
		
		JLabel text = new JLabel("Your Current Account Balance is Rs. " + balance);
		text.setBounds(180,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Osoward" ,Font.BOLD,16));
		label.add(text);
		
		
		back = new JButton("Back");
		back.setBounds(355,500,150,30);
		back.addActionListener(this);
		label.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		getContentPane().setBackground(Color.white);
		setIconImage(logo.getImage());
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		new BalanceEnquiry("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		new Transactions(pinNumber).setVisible(true);
		
		
	}

//	public int getAvailableBalByPinNumber(String pin) {
//		if(pinNumber == pin) {
//			return balance;
//		}
//		return 0;
//	}
}
