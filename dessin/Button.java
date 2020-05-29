package com.usthb.dessin;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
//button customisé avec des effets lors du survol du button
public class Button extends JButton implements MouseListener{
	
	private String title=null;
	private String image=null;
	private int h,w;
	public Button(String title,String image) {
		super(title);
		this.image=image;
		this.title=title;	
		this.addMouseListener(this);
	};
	public Button(String title) {
		super(title);
		this.title=title;
		this.addMouseListener(this);
	}
	public void setPreferredSize(Dimension d,int w,int h) {
		super.setPreferredSize(d);
		this.w=w;
		this.h=h;
	}
	public int getH() {
		return h;
	}
	public int getW() {
		return w;
	}
	public void setH(int h){
		this.h=h;
	}
	public void setW(int w) {
		this.w=w;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	//lorsqu'on survole le button on mets on applique un effet d'grandissement et italique
	public void mouseEntered(MouseEvent e) {
		Font f=this.getFont();
		this.setFont(new Font(f.getName(),f.ITALIC,f.getSize()+4));
		repaint();
	}
	//on remet le boutton a son etat initiale apres que la souris sort du boutton 
	@Override
	public void mouseExited(MouseEvent e) {
		Font f=this.getFont();
		this.setFont(new Font(f.getName(),f.PLAIN,f.getSize()-4));
		repaint();
	}
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
