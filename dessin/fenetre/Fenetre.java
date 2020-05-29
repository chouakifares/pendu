	package com.usthb.dessin.fenetre;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.usthb.modeles.Eureka;

public class Fenetre extends JFrame{
	public Fenetre() {
		super();
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		//don't touch this
		this.setResizable(false);
		this.setVisible(true);
		preventEnd();
	}
	public Fenetre(String title) {
		super(title);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		//don't touch this
		this.setResizable(false);
		this.setVisible(true);
		//we use the prevent end method in this constructor only because we want to save the data that were added/modified 
		//and only the windows that used this constructor in their super call modify data
		preventEnd();
	}
	public Fenetre(int x,int y,String title) {
		super(title);
		this.setSize(x,y);
		this.setLocationRelativeTo(null);
		//don't touch this
		this.setResizable(false);
		this.setVisible(true);
	}
	public void addFont() {
		// a method used to add a font 
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("SFAtarianSystem.ttf")));
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
	}
	public void preventEnd() {
		// method used to save our data before existing
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			 public void windowClosing(WindowEvent e) { 
				 Eureka.endGame();
				 dispose();
			}
		});
	}
}
