package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.text.*;
import java.sql.*;

import com.toedter.calendar.JDateChooser;

public class SignUp2 extends JFrame implements ActionListener{
		
	
	JTextField panTF,addherTF;
	JComboBox<String> religions,categorys,incomes,qualifications,occupations;
	JButton next;
	JDateChooser dateChooser;
	JRadioButton male,female,syes,sno,eyes,eno;
	String fromNo;
	ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("icons/atmlogo.png"));
	
	public SignUp2(String fromNo) {
		this.fromNo = fromNo;
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2= i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(50, 20, 70, 70);
		add(label);
		

		JLabel additonalDe = new JLabel("Page 2 : Additonal Details " );
		additonalDe.setBounds(280, 30, 600, 50);
		additonalDe.setFont(new Font("Osoward" ,Font.BOLD,30));
		add(additonalDe);
		
		
		JLabel religion = new JLabel("Religion :");
		religion.setBounds(100, 160, 100, 30);
		religion.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(religion);
		
		String valReligions[] = {"Other","Hindu","Muslim","Sikh","Christain"};
		religions = new JComboBox<String>(valReligions);
		religions.setBounds(350, 160, 350, 30);
		religions.setFont(new Font("Raleway" ,Font.BOLD,16));
		religions.setBackground(Color.white);
		add(religions);
		
		JLabel category = new JLabel("Category : ");
		category.setBounds(100, 210, 200, 30);
		category.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(category);
		
		String valcategory[] = {"Other","Gen","OBC","SC","ST"};
		categorys = new JComboBox<String>(valcategory);
		categorys.setBounds(350, 210, 350, 30);
		categorys.setFont(new Font("Raleway" ,Font.BOLD,16));
		categorys.setBackground(Color.white);
		add(categorys);
		
		
		JLabel income = new JLabel("Income :");
		income.setBounds(100, 260, 200, 30);
		income.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(income);
		
		String valincome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto  10,00,000"};
		incomes = new JComboBox<String>(valincome);
		incomes.setBounds(350, 260, 350, 30);
		incomes.setFont(new Font("Raleway" ,Font.BOLD,16));
		incomes.setBackground(Color.white);
		add(incomes);
		
		JLabel eduQualification = new JLabel("Educational :");
		eduQualification.setBounds(100, 310, 200, 30);
		eduQualification.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(eduQualification);
		JLabel qualification = new JLabel("Qualification");
		qualification.setBounds(100, 330, 200, 30);
		qualification.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(qualification);
		
		String valqualification[] = {"Other","Non-Graduation","Graduation","Post-Graduation","Doctrate"};
		qualifications = new JComboBox<String>(valqualification);
		qualifications.setBounds(350, 310, 350, 30);
		qualifications.setFont(new Font("Raleway" ,Font.BOLD,16));
		qualifications.setBackground(Color.white);
		add(qualifications);
		
		JLabel occupation = new JLabel("Occupation : ");
		occupation.setBounds(100, 360, 200, 30);
		occupation.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(occupation);
		
		String valOcupation[] = {"Other","Salaried","Self-Employed","Bussiness","Student","Retired"};
		occupations = new JComboBox<String>(valOcupation);
		occupations.setBounds(350, 360, 350, 30);
		occupations.setFont(new Font("Raleway" ,Font.BOLD,16));
		occupations.setBackground(Color.white);
		add(occupations);
		
		
		
		JLabel panNum = new JLabel("Pan Number : ");
		panNum.setBounds(100, 410, 200, 30);
		panNum.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(panNum);
		
		panTF = new JTextField();
		panTF.setBounds(350, 410, 350, 30);
		panTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(panTF);
		
		JLabel aadherNum = new JLabel("Aadhar Number : ");
		aadherNum.setBounds(100, 460, 200, 30);
		aadherNum.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(aadherNum);
		
		addherTF = new JTextField();
		addherTF.setBounds(350, 460, 350, 30);
		addherTF.setFont(new Font("Raleway" ,Font.BOLD,16));
		add(addherTF);
		
		JLabel seniorCit = new JLabel("Senior Citizen : ");
		seniorCit.setBounds(100, 510, 200, 30);
		seniorCit.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(seniorCit);
		
		syes = new JRadioButton("YES");
		syes.setBounds(350, 510, 100, 30);
		syes.setFont(new Font("Raleway" ,Font.BOLD,15));
		syes.setBackground(Color.white);
		add(syes);
		
		sno = new JRadioButton("NO");
		sno.setBounds(550, 510, 150, 30);
		sno.setFont(new Font("Raleway" ,Font.BOLD,15));
		sno.setBackground(Color.white);
		add(sno);
		
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(syes);
		maritalgroup.add(sno);
		
		JLabel exisACC = new JLabel("Existin Account ");
		exisACC.setBounds(100, 560, 200, 30);
		exisACC.setFont(new Font("Raleway" ,Font.BOLD,20));
		add(exisACC);
		
		eyes = new JRadioButton("YES");
		eyes.setBounds(350, 560, 100, 30);
		eyes.setFont(new Font("Raleway" ,Font.BOLD,15));
		eyes.setBackground(Color.white);
		add(eyes);
		
		eno = new JRadioButton("NO");
		eno.setBounds(550, 560, 150, 30);
		eno.setFont(new Font("Raleway" ,Font.BOLD,15));
		eno.setBackground(Color.white);
		add(eno);
		
		ButtonGroup egroup = new ButtonGroup();
		egroup.add(eyes);
		egroup.add(eno);
		
		
		next = new JButton("NEXT");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway",Font.BOLD,15));
		next.setBounds(620, 610,80, 30);
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

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String sreligions = (String)religions.getSelectedItem();
		String scategory = (String)categorys.getSelectedItem();
		String sincome = (String)incomes.getSelectedItem();
		String squalifications = (String)qualifications.getSelectedItem();
		String soccupations = (String)occupations.getSelectedItem();
		
		String sSeniorCit = null;
		if(syes.isSelected()) {
			sSeniorCit = "YES";
		}else if(sno.isSelected()) {
			sSeniorCit = "NO";
		}
		
		String sExisAcc = null;
		if(eyes.isSelected()) {
			sExisAcc = "YES";
		}else if(eno.isSelected()) {
			sExisAcc = "NO";
		}
		
		String sPanTF = panTF.getText();
		String sAadderTF = addherTF.getText();
		
		
		try {
			
//			if(fromNo.isEmpty()) {
//				JOptionPane.showMessageDialog(null, "From Number Not Found!!");
//			}
			//else 
			if(true) {
				
				DBCon connection = new DBCon();
				PreparedStatement ps=connection.con.prepareStatement("INSERT INTO signupTwotable (fromno,religion,category,income,education,occupation,pan,aadhar,seniorcitizen,existingaccount) VALUES(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,fromNo);
				ps.setString(2,sreligions);
				ps.setString(3,scategory);
				ps.setString(4,sincome);
				ps.setString(5,squalifications);
				ps.setString(6,soccupations);
				ps.setString(7,sPanTF);
				ps.setString(8,sAadderTF);
				ps.setString(9,sSeniorCit);
				ps.setString(10,sExisAcc);
				ps.executeUpdate();
			
				// Object 3
				setVisible(false);
				new SignUp3(fromNo).setVisible(true);
			}	
		} catch (Exception e2) {
			System.out.println(e);
		}
		
		
		
	}
	
		
	public static void main(String[] args) {
			
			new SignUp2("");
	}
	

}
 