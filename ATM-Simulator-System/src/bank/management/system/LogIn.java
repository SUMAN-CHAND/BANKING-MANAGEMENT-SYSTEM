package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class LogIn extends JFrame implements ActionListener{
	
	JButton login,signup,clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));
	
	public LogIn() {
		
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70, 10, 100, 100);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setBounds(200, 45, 400, 50);
		text.setFont(new Font("Osoward" ,Font.BOLD,40));
		add(text);
		
		JLabel cardNo;
		cardNo = new JLabel("Card No: ");
		cardNo.setBounds(120, 150, 150, 30);
		cardNo.setFont(new Font("Raleway" ,Font.BOLD,28));
		add(cardNo);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,250,30);
		cardTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN: ");
		pin.setBounds(120,220, 250, 30);
		pin.setFont(new Font("Raleway" ,Font.BOLD,28));
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,220,250,30);
		pinTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(pinTextField);
		
		login  = new JButton("SIGN IN"); 
		login.setBounds(300, 300, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		clear  = new JButton("CLEAR"); 
		clear.setBounds(450, 300, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		signup  = new JButton("SIGN UP"); 
		signup.setBounds(300, 350, 250, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		setIconImage(logo.getImage());
	}
	
	public static void main(String[] args) {
		
		 new LogIn();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}else if(e.getSource() == login) {
			
			try {
			
				DBCon connection = new DBCon();
				String cardNumber = cardTextField.getText();
				String pinNumber = pinTextField.getText();
				
				PreparedStatement ps = connection.con.prepareStatement("select * from login where card_number = ? and pin_Number = ?");
			
				ps.setString(1,cardNumber);
				ps.setString(2,pinNumber);	
				
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Card Number or Pin is Incorrect");
				}
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
			
	
		}else if(e.getSource() == signup) {
			setVisible(false);
			new SignUp1().setVisible(true);
		}
		
		
	}

}
