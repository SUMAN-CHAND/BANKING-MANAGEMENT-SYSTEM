package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.*;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import oracle.net.aso.b;

public class FastCash extends JFrame implements ActionListener{
	
	 JButton back,jb100,jb500,jb1000,jb2000,jb5000,jb10000;
	 String pinNumber;
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));
	public FastCash(String pinNumber) {
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);
		
		JLabel text = new JLabel("Please Select Withdrawl Amount");
		text.setBounds(220,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Osoward" ,Font.BOLD,16));
		label.add(text);
		
		jb100 = new JButton("Rs. 100");
		jb100.setBounds(200,370,100,30);
		jb100.addActionListener(this);
		label.add(jb100);
		
		jb500 = new JButton("Rs. 500");
		jb500.setBounds(350,370,130,30);
		jb500.addActionListener(this);
		label.add(jb500);
		
		jb1000 = new JButton("Rs. 1000");
		jb1000.setBounds(200,420,100,30);
		jb1000.addActionListener(this);
		label.add(jb1000);
		
		jb2000 = new JButton("Rs. 2000");
		jb2000.setBounds(350,410,130,30);		
		jb2000.addActionListener(this);
		label.add(jb2000);
		
		jb2000 = new JButton("Rs. 5000");
		jb2000.setBounds(350,450,130,30);
		jb2000.addActionListener(this);
		label.add(jb2000);
		
		jb10000 = new JButton("Rs. 10000");
		jb10000.setBounds(200,470,100,30);
		jb10000.addActionListener(this);
		label.add(jb10000);
		
		back = new JButton("Back");
		back.setBounds(350,490,130,30);
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
		
		new FastCash("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}else {
			String amount = ((JButton)e.getSource()).getText().substring(4); //Rs. 500
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
				
				if(e.getSource() != back && balance <Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insuficient Balance!!");
					return;
				}
				
				Date date = Calendar.getInstance().getTime();  
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
				String strDate = dateFormat.format(date);  
			  
			  PreparedStatement ps1 = connection.con.prepareStatement("INSERT INTO bank (pin ,dates , type ,amount ) VALUES (?,?,?,?)");
				ps1.setString(1,pinNumber);
				ps1.setString(2, strDate);
				ps1.setString(3, "Withdrawl");
				ps1.setString(4, amount);
				ps1.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Rs. " +amount+" Debited Successfully");
				
				setVisible(false);
				new Transactions(pinNumber).setVisible(true); 
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
	}

}
