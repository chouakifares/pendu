package com.usthb.dessin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PicturePanel extends JPanel {
	private String img=null;
	public PicturePanel(){
		this.setPreferredSize(new Dimension(450,300));
		this.setLayout(new FlowLayout(0,0,0));
		this.setBackground(new Color(0,0,0,0));
	}
	PicturePanel(String img){
		//path of the file
		this.img="images/"+img;
		this.setPreferredSize(new Dimension(450,300));
		this.setLayout(new FlowLayout(1,0,0));
		//setting the bg color to none so that it doesn't get in the way of our backgroud gradient
		//this line of code is used throughout the app and will only be commented here 
		this.setBackground(new Color(0,0,0,0));
	}
	public void setImg(String img) {
		this.img="images/img_questions/"+img;
	}
	// redefinition de la methode paint compoenent pour afficher l'image a chaque fois que le composant est affiché ou mis a jour
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			// reading the file and drawing the component
			Image imgtest=ImageIO.read(new File(img));
			g.drawImage(imgtest, this.getWidth()/2-imgtest.getWidth(this)/2, 0, this);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
