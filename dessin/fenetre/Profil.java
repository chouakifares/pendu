package com.usthb.dessin.fenetre;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.usthb.dessin.BackPanel;
import com.usthb.dessin.Fond;
import com.usthb.modeles.Eureka;
import com.usthb.modeles.Player;

public class Profil extends Fenetre {
	private BackPanel back=new BackPanel();
	private Player p=null;
	private JPanel innerContent=new JPanel(new GridLayout(3,1,10,10));
	private JLabel nameLabel=new JLabel(); 
	private JLabel usernameLabel=new JLabel(); 
	private JLabel ageLabel=new JLabel(); 
	private Fond content=new Fond(new FlowLayout(0,20,20));
	Color transparent=new Color(0,0,0,0);
	public Profil(Player p) {
		super();
		this.p=p;
		back.setBorder(BorderFactory.createEmptyBorder(0,0,0,350));
		nameLabel.setFont(new Font(Eureka.getFontName(),Font.PLAIN,28));
		nameLabel.setText("Nom :"+p.getFirstName()+" "+p.getLastName());
		nameLabel.setBackground(transparent);
		nameLabel.setPreferredSize(new Dimension(400,50));
		usernameLabel.setText("Username :"+p.getUsername());
		usernameLabel.setFont(new Font(Eureka.getFontName(),Font.PLAIN,28));	
		usernameLabel.setBackground(transparent);
		innerContent.setSize(400, 300);	
		innerContent.add(new JPanel().add(nameLabel));
		innerContent.add(new JPanel().add(usernameLabel));
		content.add(back);
		innerContent.setBackground(transparent);
		content.add(innerContent);
		back.getB().addActionListener(new BackButtonListener());
		this.setContentPane(content);
	}
	class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new UserPage(p);
		}	
	}
}
