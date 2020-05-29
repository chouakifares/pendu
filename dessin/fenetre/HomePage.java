package com.usthb.dessin.fenetre;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.usthb.dessin.Button;
import com.usthb.dessin.Fond;
import com.usthb.modeles.Eureka;

public class HomePage extends Fenetre implements ActionListener{
	private Button login=new Button("Log in");
	private Button signin=new Button("Sign in");
	private JButton stats=new JButton("Statistiques");
	private JPanel choice=new JPanel(new FlowLayout(1,50,30));
	private Fond content=new Fond(new BorderLayout(),true);
	private JPanel info=new JPanel(new FlowLayout(1,40,10));
	private static Color transparent=new Color(0,0,0,0);
	private JButton rules=new JButton(""),about=new JButton("");
	public HomePage() {
		super("Home Page");
		try {
			
			rules.addActionListener(this);
			rules.setIcon(new ImageIcon(ImageIO.read(new File("images/icons/rules.png"))));
			about.addActionListener(this);
			about.setIcon(new ImageIcon(ImageIO.read(new File("images/icons/about.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		info.setPreferredSize(new Dimension(500,50));
		stats.setFont(new Font(Eureka.getFontName(),Font.PLAIN,22));
		stats.addActionListener(this);
		stats.setPreferredSize(new Dimension(130,40));
		info.add(rules);
		info.add(stats);
		info.add(about);
		info.setBackground(transparent);
		this.getContentPane().setBackground(transparent);
		login.setPreferredSize(new Dimension(140,40));
		login.setFont(new Font(Eureka.getFontName(),Font.PLAIN,30));
		signin.setFont(new Font(Eureka.getFontName(),Font.PLAIN,30));
		signin.setPreferredSize(new Dimension(140,40));
		login.addActionListener(this);
		signin.addActionListener(this);
		choice.setBackground(transparent);
		choice.add(login);
		choice.add(signin);
		content.add(info,BorderLayout.NORTH);
		content.add(choice,BorderLayout.SOUTH);
		this.setContentPane(content);	
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent elt) {
		if(elt.getSource()==login)
		{
			dispose();
			Login connexion =new Login();
			/*Categories c=connexion.selectCategorie();
			GameLog g=new GameLog(c,0,0);*/
		}
		else if(elt.getSource()==signin)
		{
			dispose();
			SignIn creationCompte= new SignIn();
		}
		else if(elt.getSource()==about)
		{
			try {
				new JOptionPane().showMessageDialog(this,"Game designed and develloped by \n          CHOUAKI Fares \n          DEHRI Faycal","About us",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageIO.read(new File("images/icons/about.png"))));
			} catch (HeadlessException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(elt.getSource()==rules)
		{
			try {
				JLabel text=new JLabel("<HTML>&#9;&#9;Rules of the game<br/>The player is asked a question with a picture related to that question<br>He tries to "
			+"find the answer ans that before the falsly accused prisoner gets hangued and that by entering either :<br>&#9;The whole answer : if the answer is correct the player moves on to the next level.<br>"+
			"If the answer is not correct the prisonner gets one step closer to his death<br>&#9;One letter: if the answer contains the letter , the letter is replaces the all its occurences in the displayed answer.<br>"
			+" If the answer doesn't contain the letter entered by the player, the prisonner gets one step closer to death<br>If the player answers all the question of a category before the prisonner dies, the prisonner is set free and the game ends",JLabel.CENTER);
				text.setPreferredSize(new Dimension(450,250));
				new JOptionPane().showMessageDialog(this,text,"Rules of the game",JOptionPane.INFORMATION_MESSAGE, new ImageIcon(ImageIO.read(new File("images/icons/rules.png"))));
			} catch (HeadlessException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (elt.getSource()==stats) {
			dispose();
			new Statistique();
		}
	}
}
