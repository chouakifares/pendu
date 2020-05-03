package com.usthb.dessin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fond extends JPanel{
	//we use this boolean to specify whether the logo will appear on the screen or not 
	boolean logo;
	public Fond(LayoutManager Layout,boolean logo) {
		this.setLayout(Layout);
		this.logo=logo;
	}
	public Fond(LayoutManager Layout) {
		this.setLayout(Layout);
		this.logo=false;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		GradientPaint fond=new GradientPaint(0,this.getHeight()/2,new Color(76,150,215),(this.getWidth()+300)/2,(this.getHeight())/2,new Color(232,13,82));
		g2d.setPaint(fond);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		if(this.logo) {
			try {
				Image img=ImageIO.read(new File("images/logo.png"));
				g.drawImage(img,(this.getWidth()-img.getWidth(this))/2,(this.getHeight()-img.getHeight(this))/2,this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
