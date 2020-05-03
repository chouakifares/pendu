package com.usthb.dessin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.usthb.modeles.*;
public class FenetreSelection extends Fenetre implements ActionListener{
	private JLabel enTete=new JLabel("Choisissez une catégorie");
	private	BackPanel backArrow=new BackPanel(); 
	private ImageIcon histoire=new ImageIcon("test.jpg");
	private Button choices[]= {new Button("Histoire"),new Button("Géographie"),new Button("Santé"),
			new Button("Islam"),new Button("Culture Générale")};
	private Fond content=new Fond(new BorderLayout());
	private JPanel choicesPanel=new JPanel(new FlowLayout(1,3,3));
	Color transparent=new Color(0,0,0,0);
	Player p=null;
	ThemeJeu themes[]= {new ThemeJeu(Categories.Sante,1,3.5f),new ThemeJeu(Categories.CultureGenrale,1,1.5f),
			new ThemeJeu(Categories.Islam,1,2),new ThemeJeu(Categories.Histoire,1,2.5f),
			new ThemeJeu(Categories.Geographie,1,2.5f)};
	public FenetreSelection(Player p) {
		super("Categorie");
		this.p=p;
		enTete.setFont(new Font("arial",Font.PLAIN,24));
		enTete.setPreferredSize(new Dimension(400,40));
		backArrow.setPreferredSize(new Dimension(400,75));
		enTete.setHorizontalAlignment(JTextField.CENTER);
		for(Button b: choices) {
			if(!b.getText().equals("Culture Générale")) {
				b.setPreferredSize(new Dimension(177,90));
				choicesPanel.add(b);}
			b.addActionListener(this);
			b.setFont(new Font("arial",Font.PLAIN,22));
		}
		enTete.setBackground(transparent);
		backArrow.add(enTete);
		backArrow.getB().addActionListener(new BackButtonListener());
		choicesPanel.setBackground(transparent);
		content.add(backArrow,BorderLayout.NORTH);
		choices[4].setPreferredSize(new Dimension(358,90));
		choicesPanel.add(choices[4]);
		content.add(choicesPanel);
		content.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		this.setContentPane(content);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		if(e.getSource()==choices[0]) {
			new GameLog(Eureka.getTheme(Categories.Histoire),p);
		}
		if(e.getSource()==choices[1]) {
			new GameLog(Eureka.getTheme(Categories.Geographie),p);
		}
		if(e.getSource()==choices[2]) {
			new GameLog(Eureka.getTheme(Categories.Sante),p);
		}
		if(e.getSource()==choices[3]) {
			new GameLog(Eureka.getTheme(Categories.Islam),p);
		}
		if(e.getSource()==choices[4]) {
			new GameLog(Eureka.getTheme(Categories.CultureGenrale),p);
		}
	}
	class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new UserPage(p);
		}	
	}
}
