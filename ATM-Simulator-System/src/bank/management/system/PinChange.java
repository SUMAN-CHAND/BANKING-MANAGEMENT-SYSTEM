package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {
	
	String pinNumber;
	JButton change,back;
	JPasswordField pin , repin;
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));
	
	public PinChange(String pinNumber ) {
		this.pinNumber = pinNumber;
		
			setLayout(null);
			
			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
			Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel label = new JLabel(i3);
			label.setBounds(0, 0, 900, 900);
			add(label);
			
			JLabel text = new JLabel("Change Your PIN");
			text.setBounds(250,300,700,35);
			text.setForeground(Color.white);
			text.setFont(new Font("Osoward" ,Font.BOLD,20));
			label.add(text);
			
			JLabel pinText = new JLabel("New PIN : ");
			pinText.setBounds(200,350,100,35);
			pinText.setForeground(Color.white);
			pinText.setFont(new Font("Osoward" ,Font.BOLD,16));
			label.add(pinText);
			
			JLabel repinText = new JLabel("ReEnter PIN : ");
			repinText.setBounds(200,400,200,35);
			repinText.setForeground(Color.white);
			repinText.setFont(new Font("Osoward" ,Font.BOLD,16));
			label.add(repinText);
			
			pin = new JPasswordField();
			pin.setBounds(310,358,150,25);
			pin.setFont(new Font("Osoward" ,Font.BOLD,20));
			label.add(pin);
			
			repin = new JPasswordField();
			repin.setBounds(310,408,150,25);
			repin.setFont(new Font("Osoward" ,Font.BOLD,20));
			label.add(repin);
			
			change = new JButton("Change");
			change.setBounds(355,485,150,25);
			change.setFont(new Font("Osoward" ,Font.BOLD,20));
			change.addActionListener(this);
			label.add(change);
			
			back = new JButton("Back");
			back.setBounds(355,520,150,25);
			back.setFont(new Font("Osoward" ,Font.BOLD,20));
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
		
		new PinChange("").setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == change) {
		
			try {
				
				String nPin = pin.getText();
				String rPin = repin.getText();
				
				if(!nPin.equals(rPin)) {
					JOptionPane.showMessageDialog(null, "Entered Pin dose not Match!!");
					return;
				}
				if(nPin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter New Pin!!");
					return;
				}
				if(rPin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please re-Enter New Pin!!");
					return;
				}
				
				DBCon connection  = new DBCon();
				PreparedStatement ps = connection.con.prepareStatement("Update bank set pin = ? where pin = ?");
				ps.setString(1, rPin);
				ps.setString(2, pinNumber);
				ps.executeUpdate();
				
				PreparedStatement ps1 = connection.con.prepareStatement("Update login set pin_Number = ? where pin_Number = ?");
				ps1.setString(1, rPin);
				ps1.setString(2, pinNumber);
				ps1.executeUpdate();
				
				PreparedStatement ps2 = connection.con.prepareStatement("Update signupThreetable set pinNumber = ? where pinNumber = ?");
				ps2.setString(1, rPin);
				ps2.setString(2, pinNumber);
				ps2.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Pin Change Successfully");
				JOptionPane.showMessageDialog(null, "Your New Pin : " + rPin);
				
				setVisible(false);
				new LogIn().setVisible(true);
				
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}else {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
	}

}
