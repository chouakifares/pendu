package com.usthb.dessin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import com.usthb.modeles.*;
public class Login  extends Fenetre implements ActionListener, KeyListener {
	private BackPanel back=new BackPanel();
	private JPanel loginContent=new JPanel();
	private Fond content=new Fond(new FlowLayout(1,0,5));
	private JPanel userPanel=new JPanel();
	private JPanel passwordPanel=new JPanel();
	private JPanel wrongPasswordPanel=new JPanel();
	private JPanel submitPanel=new JPanel();
	private Button submit=new Button("Log in To Euréka");
	private TextField usernameText=new TextField("username");
	private PasswordField passwordText=new PasswordField("password");
	private ErrorMessage wrongPasswordLabel=new ErrorMessage("Incorrect username or password");
	private List<JPanel> panels=new ArrayList();
	Color transparent=new Color(0,0,0,0);
	public Login(){
		super("Log in");
		panels.add(back);
		panels.add(loginContent);
		panels.add(userPanel);
		panels.add(passwordPanel);
		panels.add(wrongPasswordPanel);
		panels.add(submitPanel);
		for(JPanel panel:panels) {
			panel.setBackground(transparent);
		}
		this.addWindowListener( new WindowAdapter() {
			 public void windowOpened( WindowEvent e ){
			        submit.requestFocus();
			    }
		});
		Font f=new Font("arial",Font.PLAIN,20);
		back.setPreferredSize(new Dimension(400,40));
		back.getB().addActionListener(new BackButtonListener());
		Border b=BorderFactory.createEmptyBorder(0,0,20,0);
		loginContent.setPreferredSize(new Dimension(380,320));
		wrongPasswordPanel.add(wrongPasswordLabel);
		submit.setPreferredSize(new Dimension(240,40));
		submit.setFont(f);
		submit.addActionListener(this);
		submitPanel.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
		submitPanel.add(submit);
		userPanel.setPreferredSize(new Dimension(300,40));
		usernameText.setFont(f);
		usernameText.setBorder(BorderFactory.createEmptyBorder(2,5,5,2));
		userPanel.setLayout(new GridLayout(1,1,10,2));
		userPanel.add(usernameText);
		passwordPanel.setPreferredSize(new Dimension(300,80));
		passwordText.setFont(new Font("arial",Font.PLAIN,20));
		passwordText.setForeground(Color.GRAY);
		passwordText.setBorder(BorderFactory.createEmptyBorder(2,5,5,2));
		passwordPanel.setLayout(new GridLayout(2,1,2,2));
		passwordPanel.add(passwordText);
		loginContent.setLayout(new FlowLayout(1,0,20));
		content.setBorder(b);
		loginContent.add(userPanel);
		passwordPanel.add(wrongPasswordPanel);
		loginContent.add(passwordPanel);
		loginContent.add(submitPanel);
		loginContent.setBorder(BorderFactory.createTitledBorder( null,"log in",
				TitledBorder.CENTER,0,new Font("times new roman", Font.BOLD,25), 
				new Color(255,255,255)));
		
		content.add(back);
		content.add(loginContent);
		this.setContentPane(content);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String username=usernameText.getText();
		Player p=null;
		//we read the profiles from a protected hidden directory called "profils"
		//we try to find the file if the file exists we read the profile of the player in it 
		if(Eureka.getPlayer(username)!=null) {
			p=Eureka.getPlayer(username);
			if(passwordText.checkPassword(p.getCorrectPassword()))
			{
				dispose();
				new UserPage(p);
			}
			else
			{
				wrongPasswordLabel.setVisible(true);
					content.repaint();
			}
		}
		
			//if the profile doesn't exist we inform the player that the username he entered is invalid 
		else
		{
			wrongPasswordLabel.setVisible(true);
			content.repaint();
		}
	}
	public void keyPressed(KeyEvent arg0) {
		System.out.print("done");
		if(arg0.getKeyCode()==10) {
			String username=usernameText.getText();
			Player p=null;
			//we read the profiles from a protected hidden directory called "profils"
			//we try to find the file if the file exists we read the profile of the player in it 
			if(Eureka.getPlayer(username)!=null) {
				p=Eureka.getPlayer(username);
				if(passwordText.checkPassword(p.getCorrectPassword()))
				{
					dispose();
					new UserPage(p);
				}
				else
				{
					wrongPasswordLabel.setVisible(true);
						content.repaint();
				}
			}
			
				//if the profile doesn't exist we inform the player that the username he entered is invalid 
			else
			{
				wrongPasswordLabel.setVisible(true);
				content.repaint();
			}
		}
	}
	class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new HomePage();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}

