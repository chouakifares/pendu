package com.usthb.dessin.fenetre;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.usthb.dessin.BackPanel;
import com.usthb.dessin.Button;
import com.usthb.dessin.ErrorMessage;
import com.usthb.dessin.Fond;
import com.usthb.dessin.PasswordField;
import com.usthb.dessin.TextField;
import com.usthb.modeles.Adulte;
import com.usthb.modeles.Date;
import com.usthb.modeles.Enfant;
import com.usthb.modeles.Eureka;

public class SignIn extends Fenetre implements ActionListener,ItemListener{
	private JComboBox day=new JComboBox();
	private JComboBox month=new JComboBox();
	private JComboBox year=new JComboBox();
	String months[]= {"Janvier","Fevrier","Mars","Avril","Mai","Juin","Juillet","Aout",
			"Septembre","Octobre","Novembre","Decembre"};
	private JPanel singinContent=new JPanel(new FlowLayout(1,3,15));
	private Fond content=new Fond(new FlowLayout(1,3,5));
	private JPanel namePanel=new JPanel(new GridLayout(1,2,20,20));
	private	JPanel passwordPanel=new JPanel(new GridLayout(2,1,2,20));
	private JPanel userPanel=new JPanel(new FlowLayout(1,3,3));
	private JPanel datePanel=new JPanel(new FlowLayout(1,10,10));
	private TextField firstNameText=new TextField("First Name");
	private TextField lastNameText=new TextField("Last Name");
	private TextField userText=new TextField("Username");
	private PasswordField passwordText=new PasswordField("Password");
	private PasswordField repeatPasswordText=new PasswordField("Repeat Password");
	private ErrorMessage message=new ErrorMessage("Les mots de passes ne correspondent pas");
	private	BackPanel back=new BackPanel();
	private Button register=new Button("Register");
	private List<JPanel> panels=new ArrayList();
	Color transparent=new Color(0,0,0,0);
	Dimension dateDimension=new Dimension(100,30);
	public static int age(Date d) {
		LocalDate rn=java.time.LocalDate.now();
		if((rn.getMonthValue()>d.getMonth())||(rn.getMonthValue()==d.getMonth() && rn.getDayOfMonth()>=d.getDay())) return (rn.getYear()-d.getYear());
		else return (rn.getYear()-d.getYear()-1);
	}
	public SignIn() {
		super("Sign In");
		this.setSize(400, 500);
		for(int i=1;i<32;i++) {
			day.addItem(i);
		}
		day.setPreferredSize(dateDimension);
		datePanel.add(day);
		for(String i:months) {
			month.addItem(i);
		}
		month.addItemListener(this);
		month.setPreferredSize(dateDimension);
		datePanel.add(month);
		for(int i=1920;i<2014;i++)
		{
			year.addItem(i);
		}
		year.addItemListener(this);
		year.setPreferredSize(dateDimension);
		datePanel.add(year);
		panels.add(back);
		panels.add(userPanel);
		panels.add(passwordPanel);
		panels.add(namePanel);
		panels.add(singinContent);
		panels.add(datePanel);
		for(JPanel panel:panels) {
			panel.setBackground(transparent);
		}
		content.add(back);
		singinContent.setPreferredSize(new Dimension(380,370));
		back.setPreferredSize(new Dimension(400,35));
		back.getB().addActionListener(new BackButtonListener());
		register.addActionListener(new RegisterButtonListener());
		Font f=new Font(Eureka.getFontName(),Font.PLAIN,20);
		Dimension panelDimension=new Dimension(360,40);
		register.setFont(f);
		firstNameText.setFont(f);
		lastNameText.setFont(f);
		namePanel.add(firstNameText);
		namePanel.add(lastNameText);
		namePanel.setPreferredSize(panelDimension);
		userText.setFont(f);
		userText.setPreferredSize(panelDimension);
		userPanel.add(userText);
		userPanel.setPreferredSize(panelDimension);
		repeatPasswordText.setFont(f);
		passwordText.setFont(f);
		passwordPanel.add(passwordText);
		passwordPanel.add(repeatPasswordText);
		passwordPanel.setPreferredSize(new Dimension(360,100));
		singinContent.add(namePanel);
		singinContent.add(userPanel);
		singinContent.add(passwordPanel);
		singinContent.add(datePanel);
		content.setBorder(BorderFactory.createEmptyBorder(0,20,0,20));
		singinContent.add(message);
		content.add(singinContent);
		content.add(register);
		singinContent.setBorder(BorderFactory.createTitledBorder(null, "Sign in",
				TitledBorder.CENTER,0,new Font(Eureka.getFontName(), Font.BOLD,25), 
				new Color(255,255,255)));
		this.setContentPane(content);
	}
	public void signPlayer() {
		String nom=lastNameText.getText();
		String prenom=firstNameText.getText();
		String username=userText.getText();
		String psw="" ;
		if(passwordText.getPassword().length!=0) {
			for(char i:passwordText.getPassword())
				psw+=i;
		}
		String repeat="";
		if(repeatPasswordText.getPassword().length!=0) {
			for(char i:repeatPasswordText.getPassword())
				repeat+=i;
		}
		int year=(int) this.year.getSelectedItem();
		int month=(int) this.year.getSelectedItem();
		int day=(int) this.year.getSelectedItem();
		Date t = new Date(day,month,year);
		//checking if the password is correct
		if(!nom.equals("")&&!prenom.equals("")&&!username.equals("")&&passwordText.getPassword().length!=0 &&repeatPasswordText.getPassword().length!=0
				&& !nom.equals("Last Name")&&!prenom.equals("First Name")&&!username.equals("Username")&&!psw.equals("Password")&&!repeat.equals("Repeat Password")) {
			//control the passwords
			if(!psw.equals(repeat)) {
				message.setText("Les mots de passes ne correspondent pas");
				message.setVisible(true);
				repaint();
			}
			// we use the restriction that usernames are unique for each player
			//cheking if a profile with the same username doesn't already exist
			else {
				if(Eureka.getPlayer(username)==null) {
					if(age(t)>=18)
						Eureka.addPlayer(new Adulte(username,nom,prenom,psw,t));
					else
						Eureka.addPlayer(new Enfant(username,nom,prenom,psw,t));
					dispose();
					new Login();
				}
				else {
					message.setText("Le pseudo que vous avez choisi est indisponible");
					message.setVisible(true);
					repaint();
				}
			}
			// Creation of a new profil if another profil with the same username doesn't exists 
		}
		else {
			message.setText("Veuillez remplir tout les champs du formulaire");
			message.setVisible(true);
			repaint();
		}
	}
	class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new HomePage();
		}
		
	}
	class RegisterButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			signPlayer();
		}
		
	}
	public void actionPerformed(ActionEvent e) {}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(month.getSelectedItem().equals("Janvier")||month.getSelectedItem().equals("Mars")||
			month.getSelectedItem().equals("Mai")||month.getSelectedItem().equals("Juillet")||
			month.getSelectedItem().equals("Aout")||month.getSelectedItem().equals("Octobre")
			||month.getSelectedItem().equals("Decembre")) {
			day.removeAllItems();
			for(int i=1;i<=31;i++)
				day.addItem(i);
		}
		else {
			if(month.getSelectedItem().equals("Fevrier")) {
				if(Date.anneeBissextile((int) year.getSelectedItem())) {
					day.removeAllItems();
					for(int i=1;i<=29;i++)
						day.addItem(i);
				}
				else {
					day.removeAllItems();
					for(int i=1;i<=28;i++)
						day.addItem(i);
				}
			}
			else {
				day.removeAllItems();
				for(int i=1;i<=30;i++)
					day.addItem(i);
			}
		}
	}
}

