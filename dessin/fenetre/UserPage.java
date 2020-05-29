package com.usthb.dessin.fenetre;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JLabel;

import com.usthb.dessin.Button;
import com.usthb.dessin.Fond;
import com.usthb.modeles.Categories;
import com.usthb.modeles.Eureka;
import com.usthb.modeles.PlayedGame;
import com.usthb.modeles.Player;
import com.usthb.modeles.ThemeJeu;
public class UserPage extends Fenetre implements ActionListener{
	Fond content=new Fond(new FlowLayout(1,10,20));
	JLabel bienvenu=new JLabel("Hey ");
	Button newGame=new Button("Nouvelle Partie");
	Button continuer=new Button("Continuer");
	Button profil=new Button("Profil");
	Button deconnexion=new Button("Deconnexion");
	JComponent composants[]= {bienvenu,continuer,newGame,profil,deconnexion};
	Player p;
	ThemeJeu themes[]= {new ThemeJeu(Categories.Sante,1,3.5f),new ThemeJeu(Categories.CultureGenrale,1,1.5f),
			new ThemeJeu(Categories.Islam,1,2),new ThemeJeu(Categories.Histoire,1,2.5f),
			new ThemeJeu(Categories.Geographie,1,2.5f)};
	public UserPage(Player p) {
		super("User Page");
		this.p=p;
		Font f=new Font(Eureka.getFontName(),Font.PLAIN,28);
		Dimension dimension=new Dimension(360,50);
		bienvenu.setText(bienvenu.getText()+p.getUsername());
		bienvenu.setHorizontalAlignment(JLabel.CENTER);
		PlayedGame g=p.getLastPlayedGame();
		if(g==null || g.getEnded()) 
				continuer.setEnabled(false);
		else if(!g.getEnded()){
				p.addPlay(g);
				continuer.addActionListener(this);
			
		}
		for(JComponent composant:composants) {
			composant.setFont(f);
			composant.setPreferredSize(dimension);
			content.add(composant);
		}		
		newGame.addActionListener(this);
		profil.addActionListener(this);
		deconnexion.addActionListener(this);
		this.setContentPane(content);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newGame) {
			dispose();
			new FenetreSelection(p);
		}
		else if(e.getSource()==profil) {
			dispose();
			new Profil(p);
		}
		else if(e.getSource()==deconnexion) {
			dispose();
			new Login();
		}
		else if(e.getSource()==continuer) {
			dispose();
			new GameWindow(p.getLastPlayedGame(),p);
		}
	}
}
