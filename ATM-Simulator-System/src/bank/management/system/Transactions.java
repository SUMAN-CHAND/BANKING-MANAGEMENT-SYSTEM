package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oracle.net.aso.f;

public class Transactions extends JFrame implements ActionListener{
	
	 JButton exit,pinchange,balacequeary,ministatement,fastcash,withdrawl,deposit;
	 String pinNumber;
		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));

	
	public Transactions(String pinNumber) {
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(0, 0, 900, 900);
		add(label);
		
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(220,300,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("Osoward" ,Font.BOLD,16));
		label.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(200,370,100,30);
		deposit.addActionListener(this);
		label.add(deposit);
		
		withdrawl = new JButton("Cash Withdrawl");
		withdrawl.setBounds(350,370,130,30);
		withdrawl.addActionListener(this);
		label.add(withdrawl);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(200,420,100,30);
		fastcash.addActionListener(this);
		label.add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(350,410,130,30);		
		ministatement.addActionListener(this);
		label.add(ministatement);
		
		balacequeary = new JButton("Balance Enquiry");
		balacequeary.setBounds(350,450,130,30);
		balacequeary.addActionListener(this);
		label.add(balacequeary);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(200,470,100,30);
		pinchange.addActionListener(this);
		label.add(pinchange);
		
		exit = new JButton("Exit");
		exit.setBounds(350,490,130,30);
		exit.addActionListener(this);
		label.add(exit);
		

		setSize(900,900);
		setLocation(300,0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		getContentPane().setBackground(Color.white);
		setIconImage(logo.getImage());
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		
		new Transactions("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == exit) {
			System.exit(0);
		}else if(e.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}else if(e.getSource() == withdrawl) {
			setVisible(false);
			new Withdrawl(pinNumber).setVisible(true);
		}else if(e.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}else if(e.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}else if(e.getSource() == balacequeary) {
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}else if(e.getSource() == ministatement) {
			new MiniStatement(pinNumber).setVisible(true);
		}
		
		
	}

}
