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

public class QuestionPanel extends JPanel {
	private String img=null;
	QuestionPanel(){
		this.setPreferredSize(new Dimension(450,300));
		this.setLayout(new FlowLayout(0,0,0));
		this.setBackground(new Color(0,0,0,0));
	}
	QuestionPanel(String img){
		this.img="images/"+img;
		this.setPreferredSize(new Dimension(450,300));
		this.setLayout(new FlowLayout(1,0,0));
		this.setBackground(new Color(0,0,0,0));
	}
	public void setImg(String img) {
		this.img="images/img_questions/"+img;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		try {
			Image imgtest=ImageIO.read(new File(img));
			g.drawImage(imgtest, this.getWidth()/2-imgtest.getWidth(this)/2, 0, this);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
