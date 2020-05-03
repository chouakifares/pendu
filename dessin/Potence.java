package com.usthb.dessin;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Potence extends JPanel {
	int state;
	protected JLabel remaining=new JLabel();
	Potence(){}
	Potence(int state){
		remaining.setText("Il vous reste "+(8- state)+" coup a jouer");
		this.state=state;
		this.setPreferredSize(new Dimension(380,320));
		remaining.setFont(new Font("arial",Font.PLAIN,18));
		remaining.setBackground(new Color(0,0,0,0));
		this.add(remaining);
	}
	public void setRemaining() {
		if(state==7) {
			remaining.setText("C'est ton dernier coup a jouer");
		}
		else {
			remaining.setText("Il vous reste "+(8-state)+" coup a jouer");
		}
	}
	public void paint(Graphics g) {
		super.paint(g);
		if (this.state>0)
			g.drawLine(50, 290, 330, 290);
		if (this.state>1)
			g.drawLine(50, 290, 50, 80);
		if (this.state>2)
			g.drawLine(90, 290, 50, 250);
		if (this.state>3)
			g.drawLine(50, 80, 300, 80);
		if (this.state>4)
			g.drawLine(50,120 , 90, 80);
		if (this.state>5)
			g.drawLine(270,80,270,120);
		if (this.state>6)
			g.drawOval(260, 120, 20, 20);
		if (this.state>7) {
			g.drawLine(270, 140, 270,190 );
			g.drawLine(270, 150, 290, 170);
			g.drawLine(270, 150, 250, 170);
			g.drawLine(270, 190, 290, 210);
			g.drawLine(270, 190, 250, 210);
		}
	}
	public void setState(int i) {
		this.state=i;
	}
}
