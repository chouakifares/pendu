package com.usthb.dessin;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
//panel utilisé pour implementé le bouton back sur les fentres de l'app
public class BackPanel extends JPanel{
	private JButton b;
	Color transparent=new Color(0,0,0,0);
	public BackPanel() {
		super(new FlowLayout(0));
		b= new JButton("<-");
		this.add(b);
		this.setBackground(transparent);
	}
	public JButton getB() {
		return b;
	}
}
