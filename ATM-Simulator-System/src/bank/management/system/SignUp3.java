package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.*;


public class SignUp3 extends JFrame implements ActionListener{
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit , cancel;
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));
	String fromno;
	
	
	public SignUp3(String fromno) {
		this.fromno = fromno;
		setLayout(null);
	
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2= i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(50, 20, 70, 70);
		add(label);
		

		JLabel accountDe = new JLabel("Page 3 : Account Details " );
		accountDe.setBounds(280, 30, 600, 50);
		accountDe.setFont(new Font("Osoward" ,Font.BOLD,30));
		add(accountDe);
		
		JLabel accountType = new JLabel("Account Type :  " );
		accountType.setBounds(100, 140, 200, 30);
		accountType.setFont(new Font("Osoward" ,Font.BOLD,20));
		add(accountType);
		
		r1 = new JRadioButton("Saving Account");
		r1.setBounds(100, 180, 200, 30);
		r1.setFont(new Font("Osoward" ,Font.BOLD,16));
		r1.setBackground(Color.white);
		add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setBounds(350, 180, 200, 30);
		r2.setFont(new Font("Osoward" ,Font.BOLD,16));
		r2.setBackground(Color.white);
		add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setBounds(100, 220, 200, 30);
		r3.setFont(new Font("Osoward" ,Font.BOLD,16));
		r3.setBackground(Color.white);
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setBounds(350, 220, 250, 30);
		r4.setFont(new Font("Osoward" ,Font.BOLD,16));
		r4.setBackground(Color.white);
		add(r4);
		
		ButtonGroup accTypeGroup = new ButtonGroup();
		accTypeGroup.add(r1);
		accTypeGroup.add(r2);
		accTypeGroup.add(r3);
		accTypeGroup.add(r4);
		
		JLabel card = new JLabel("Card Number :  " );
		card.setBounds(100, 300, 200, 30);
		card.setFont(new Font("Osoward" ,Font.BOLD,20));
		add(card);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-1423");
		number.setBounds(330, 300, 400, 30);
		number.setFont(new Font("Osoward" ,Font.BOLD,20));
		add(number);
		
		JLabel cardDetail = new JLabel("Your 16 Digit Card Number");
		cardDetail.setBounds(100, 325, 330, 20);
		cardDetail.setFont(new Font("Osoward" ,Font.BOLD,12));
		add(cardDetail);
		
		
		JLabel pin = new JLabel("Pin :  " );
		pin.setBounds(100, 350, 200, 30);
		pin.setFont(new Font("Osoward" ,Font.BOLD,20));
		add(pin);
		
		JLabel pinDetail = new JLabel("(Your 4 Digit Password)");
		pinDetail.setBounds(100, 375, 370, 20);
		pinDetail.setFont(new Font("Osoward" ,Font.BOLD,12));
		add(pinDetail);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setBounds(330, 350, 400, 30);
		pnumber.setFont(new Font("Osoward" ,Font.BOLD,20));
		add(pnumber);
		
		JLabel services = new JLabel("Services Required :  " );
		services.setBounds(100, 450, 400, 30);
		services.setFont(new Font("Osoward" ,Font.BOLD,20));
		add(services);
		
		c1 = new JCheckBox("ATM CARD");
		c1.setBackground(Color.white);
		c1.setFont(new Font("Osoward" ,Font.BOLD,16));
		c1.setBounds(100,500,200,30);
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBackground(Color.white);
		c2.setFont(new Font("Osoward" ,Font.BOLD,16));
		c2.setBounds(350,500,200,30);
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBackground(Color.white);
		c3.setFont(new Font("Osoward" ,Font.BOLD,16));
		c3.setBounds(100,550,200,30);
		add(c3);
		
		c4 = new JCheckBox("Email Alerts");
		c4.setBackground(Color.white);
		c4.setFont(new Font("Osoward" ,Font.BOLD,16));
		c4.setBounds(350,550,200,30);
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBackground(Color.white);
		c5.setFont(new Font("Osoward" ,Font.BOLD,16));
		c5.setBounds(100,600,200,30);
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBackground(Color.white);
		c6.setFont(new Font("Osoward" ,Font.BOLD,16));
		c6.setBounds(350,600,200,30);
		add(c6);
			
		c7 = new JCheckBox("I here by declares that the above entered detail are correct to the best of my knowledge.");
		c7.setBackground(Color.white);
		c7.setFont(new Font("Osoward" ,Font.BOLD,12));
		c7.setBounds(100,680,600,30);
		add(c7);
		
		
		submit = new JButton("Submit");
		submit.setBounds(450,720,100,30);
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Osoward" ,Font.BOLD,16));
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancle");
		cancel.setBounds(250,720,100,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Osoward" ,Font.BOLD,16));
		cancel.addActionListener(this);
		add(cancel);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		
		setTitle("ACCOUNT DETAILS FROM");
		setSize(850,800);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setIconImage(logo.getImage());
		
		setLocation(350, 0);
	}

	public static void main(String[] args) {
		
		new SignUp3("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submit) {
			
			String accountType = null;
			
			if(r1.isSelected()) {
				accountType = "Saving Account";
			}else if(r2.isSelected()) {
				accountType = "Fixed Deposit Account";
			}else if(r3.isSelected()) {
				accountType = "Current Account";
			}else if(r4.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			
			Random random = new Random();
			String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5357757300000000L);
			
			String pinNumber = "" + Math.abs((random.nextLong() % 9000L + 1000L));
			
			String facility = "";
			
			if(c1.isSelected()) {
				facility = facility + " ATM CARD";
			}
			if(c2.isSelected()){
				facility = facility + " Internat Banking";
			}
			if(c3.isSelected()){
				facility = facility + " Mobile Banking";
			}
			if(c4.isSelected()){
				facility = facility + " Email Alerts";
			}
			if(c5.isSelected()){
				facility = facility + " Cheque Book";
			}
			if(c6.isSelected()){
				facility = facility + " E-Statement";
			}
			
			String declaretion = null;
			if(c7.isSelected()) {
				declaretion = "YES";
			}
			
			try {
				if(accountType == null) {
					JOptionPane.showMessageDialog(null, "Account Type is Required");
				}else if(declaretion == null) {
					JOptionPane.showMessageDialog(null, "Please Cheack The Declaretion From");
				}
//				else if(fromno.isEmpty()) {
//					JOptionPane.showMessageDialog(null, "From Number Not Found!!");
//				}
				else if(true){
					DBCon connection = new DBCon();
					PreparedStatement ps=connection.con.prepareStatement("INSERT INTO signupThreetable (fromno,accountType,cardNumber ,pinNumber,facility) VALUES(?,?,?,?,?)");
					ps.setString(1,fromno);
					ps.setString(2,accountType);
					ps.setString(3,cardNumber);
					ps.setString(4,pinNumber);
					ps.setString(5,facility);
					ps.executeUpdate();
					
					PreparedStatement ps2=connection.con.prepareStatement("INSERT INTO login(fromno,card_number,pin_Number) VALUES (?,?,?)");
					ps2.setString(1,fromno);
					ps2.setString(2,cardNumber);
					ps2.setString(3,pinNumber);
					ps2.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Card Number : " + cardNumber + "\n Pin : " + pinNumber);
					
					setVisible(false);
					new Deposit(pinNumber).setVisible(true);
				}
				
				
			} catch (Exception e1) {
				System.out.println(e1);
			}
			
			
			
		}else if(e.getSource() == cancel) {
			setVisible(false);
			new LogIn().setVisible(true);
		}
	}

}
