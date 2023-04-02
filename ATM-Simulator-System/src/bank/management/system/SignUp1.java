package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.*;
import java.sql.*;

import com.toedter.calendar.JDateChooser;

public class SignUp1 extends JFrame implements ActionListener{
		
	String first;
	JTextField nameTF,fatherNameTF,stateTF,pinTF,cityTF,addTF,emailTF;
	JButton next;
	JDateChooser dateChooser;
	JRadioButton male,female,other,married,unmarried,others;
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));

	
	public SignUp1() {
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2= i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(50, 20, 70, 70);
		add(label);
		
		Random random = new Random();
		long first4 = (random.nextLong() % 9000L) + 1000L;
	    first = "" + Math.abs(first4);

		JLabel fromNo = new JLabel("APPLICATION FROM NO : " + first);
		fromNo.setBounds(150, 30, 600, 50);
		fromNo.setFont(new Font("Osoward" ,Font.BOLD,35));
		add(fromNo);
		
		JLabel parsonalDetail = new JLabel("Page 1 : Personal Details");
		parsonalDetail.setBounds(280, 85, 400, 30);
		parsonalDetail.setFont(new Font("Osoward" ,Font.BOLD,20));
		add(parsonalDetail);
		
		JLabel name = new JLabel("Name :");
		name.setBounds(100, 160, 100, 30);
		name.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(name);
		
		nameTF = new JTextField();
		nameTF.setBounds(350, 160, 350, 30);
		nameTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(nameTF);
		
		JLabel fatherName = new JLabel("Father's Name : ");
		fatherName.setBounds(100, 210, 200, 30);
		fatherName.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(fatherName);
		
		fatherNameTF = new JTextField();
		fatherNameTF.setBounds(350, 210, 350, 30);
		fatherNameTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(fatherNameTF);
		
		JLabel dob = new JLabel("Date Of Birth :");
		dob.setBounds(100, 260, 200, 30);
		dob.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(350, 260, 350, 30);
		dateChooser.setForeground(Color.black);
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender :");
		gender.setBounds(100, 310, 200, 30);
		gender.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(350, 310, 60, 30);
		male.setFont(new Font("Raleway" ,Font.BOLD,15));
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 310, 100, 30);
		female.setFont(new Font("Raleway" ,Font.BOLD,15));
		female.setBackground(Color.white);
		add(female);
		
		other = new JRadioButton("Other");
		other.setBounds(590, 310, 100, 30);
		other.setFont(new Font("Raleway" ,Font.BOLD,15));
		other.setBackground(Color.white);
		add(other);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(other);
		
		JLabel email = new JLabel("Email Address : ");
		email.setBounds(100, 360, 200, 30);
		email.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(email);
		
		emailTF = new JTextField();
		emailTF.setBounds(350, 360, 350, 30);
		emailTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(emailTF);
		
		JLabel marital = new JLabel("Marital Status : ");
		marital.setBounds(100, 410, 200, 30);
		marital.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(350, 410, 100, 30);
		married.setFont(new Font("Raleway" ,Font.BOLD,15));
		married.setBackground(Color.white);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450, 410, 130, 30);
		unmarried.setFont(new Font("Raleway" ,Font.BOLD,15));
		unmarried.setBackground(Color.white);
		add(unmarried);
		
		others = new JRadioButton("Other");
		others.setBounds(590, 410, 100, 30);
		others.setFont(new Font("Raleway" ,Font.BOLD,15));
		others.setBackground(Color.white);
		add(others);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(others);
		
		
		JLabel address = new JLabel("Address : ");
		address.setBounds(100, 460, 200, 30);
		address.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(address);
		
		addTF = new JTextField();
		addTF.setBounds(350, 460, 350, 30);
		addTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(addTF);
		
		JLabel city = new JLabel("City : ");
		city.setBounds(100, 510, 200, 30);
		city.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(city);
		
		 cityTF = new JTextField();
		cityTF.setBounds(350, 510, 350, 30);
		cityTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(cityTF);
		
		JLabel pin = new JLabel("Pin Code : ");
		pin.setBounds(100, 560, 200, 30);
		pin.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(pin);
		
		pinTF = new JTextField();
		pinTF.setBounds(350, 560, 350, 30);
		pinTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(pinTF);
		
		JLabel state = new JLabel("State :");
		state.setBounds(100, 610, 200, 30);
		state.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(state);
		
		stateTF = new JTextField();
		stateTF.setBounds(350, 610, 350, 30);
		stateTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(stateTF);
		
		next = new JButton("NEXT");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,15));
		next.setBounds(620, 680,80, 30);
		next.addActionListener(this);
		add(next);
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	
		setTitle("NEW ACCOUNT APPLICATION FROM");
		setSize(850,800);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setIconImage(logo.getImage());
		
		setLocation(350, 0);
	}

	public static void main(String[] args) {
		
		new SignUp1();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String fromNo = first;
		String name = nameTF.getText();
		String fathersName = fatherNameTF.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); 
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}else if(female.isSelected()) {
			gender = "Female";
		}else if(other.isSelected()) {
			gender = "Other";
		}
		String email = emailTF.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}else if(unmarried.isSelected()) {
			marital = "Unmarried";
		}else if(others.isSelected()) {
			marital = "Other";
		}
		String add = addTF.getText();
		String city = cityTF.getText();
		String pin = pinTF.getText();
		String state = stateTF.getText();
		
		try {
		
			if(name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}else if(fathersName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Father's Name is Required");
			}else if(dob.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Date Of Birth is Required");
			}else if(gender.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Gender is Required");
			}else if(email.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Email is Required");
			}else if(marital.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Marital Status is Required");
			}else if(add.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Address is Required");
			}else if(city.isEmpty()) {
				JOptionPane.showMessageDialog(null, "City is Required");
			}else if(pin.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Pin Code is Required");
			}else if(state.isEmpty()) {
				JOptionPane.showMessageDialog(null, "State is Required");
			}else if(true){
				DBCon connection = new DBCon();
				PreparedStatement ps=connection.con.prepareStatement("INSERT INTO signupOnetable (fromno,name,father_name,dob,gender,email,marital_status,address,city,pin,state) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,fromNo);
				ps.setString(2,name);
				ps.setString(3,fathersName);
				ps.setString(4,dob);
				ps.setString(5,gender);
				ps.setString(6,email);
				ps.setString(7,marital);
				ps.setString(8,add);
				ps.setString(9,city);
				ps.setString(10,pin);
				ps.setString(11, state);
				ps.executeUpdate();
				
				setVisible(false);
				new SignUp2(fromNo).setVisible(true);
				
			}
			
			
		} catch (Exception e2) {
			System.out.println(e);
		}
		
		
		
	}

}
