package com.usthb.dessin;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	public Fenetre() {
		super();
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		//don't touch this
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Fenetre(String title) {
		super(title);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		//don't touch this
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public Fenetre(int x,int y,String title) {
		super(title);
		this.setSize(x,y);
		this.setLocationRelativeTo(null);
		//don't touch this
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
