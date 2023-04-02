package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{
	
	JButton deposit,back;
	JTextField amount;
	String pinNumber;
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));
	
	public Deposit(String pinNumber) {
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);
		
		JLabel text = new JLabel("Enter The Amount You want to deposit");
		text.setBounds(190,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Osoward" ,Font.BOLD,16));
		label.add(text);
		
		
		amount = new JTextField();
		amount.setFont(new Font("Osoward" ,Font.BOLD,16));
		amount.setBounds(190,350,300,25);
		label.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(355,450,100,30);
		deposit.addActionListener(this);
		label.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(355,500,100,30);
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
		
		new Deposit("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == deposit) {
			String number = amount.getText();
			Date date = Calendar.getInstance().getTime();  
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
			String strDate = dateFormat.format(date);  
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit!!");
			}else{
				try {
					
					DBCon connection = new DBCon();
					
					PreparedStatement ps = connection.con.prepareStatement("SELECT * FROM bank where pin = ?");
					
					ps.setString(1,pinNumber);	
					
					ResultSet rs = ps.executeQuery();
					
					int balance =0;
					while(rs.next()) {
						if(rs.getString("type").equals("Deposit")) {
							balance = Integer.parseInt(rs.getString("amount"));
						}else {
							balance -=Integer.parseInt(rs.getString("amount"));
						}
					}
					
//					if(e.getSource() != back && balance <Integer.parseInt(amount)) {
//						JOptionPane.showMessageDialog(null, "Insuficient Balance!!");
//						return;
//					}
					
					int finalBalance = balance + Integer.parseInt(number);
					
					String numbers = Integer.toString(finalBalance);
					
					
					PreparedStatement ps1 = connection.con.prepareStatement("INSERT INTO bank (pin ,dates , type ,amount ) VALUES (?,?,?,?)");
					ps1.setString(1,pinNumber);
					ps1.setString(2, strDate);
					ps1.setString(3, "Deposit");
					ps1.setString(4, numbers);
					ps1.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"Rs. " +number+ " Deposit Successfully");
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
					
					
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		}else if(e.getSource() == back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
	}

}
