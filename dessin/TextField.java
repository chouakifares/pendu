package com.usthb.dessin;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class TextField extends JTextField{
	String name=null;
	TextField(String name){
		super(name);
		this.name=name;
		this.setForeground(Color.GRAY);
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.addFocusListener(new FocusListener() {
			
			public void focusGained(FocusEvent arg0) {
				if(getText().equals(name)) {
					setText("");
				}
				setForeground(Color.BLACK);
			}
			public void focusLost(FocusEvent arg0) {
				if(getText().equals("")) {
				setText(name);
				setForeground(Color.GRAY);
				}
			}
		});
	}
}
