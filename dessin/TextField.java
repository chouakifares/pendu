package com.usthb.dessin;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
//this class is used instead of the JTextField to improve our UX
public class TextField extends JTextField{
	// this variable will serve as an indicatif placeholder
	// we will put the value of this variable as innertext in the field while the user did not enter any other input
	String name=null;
	public TextField(String name){
		super(name);
		this.name=name;
		this.setForeground(Color.GRAY);
		this.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		//we use the focus Listener to check each time this field gain/loses focus if the value of its innertext has changed
		this.addFocusListener(new FocusListener() {	
			public void focusGained(FocusEvent arg0) {
				//if the value of the innerText is the name of this field than we put its value to ""
				// so that the user doesn't have to erase it himself
				if(getText().equals(name)) {
					setText("");
				}
				setForeground(Color.BLACK);
			}
			public void focusLost(FocusEvent arg0) {
				// if the user didn't enter anything after the field loses focus(that means that the user jumped to another field 
				// place in the app) then we restore its initial state
				if(getText().equals("")) {
					setText(name);
					setForeground(Color.GRAY);
				}
			}
		});
	}
}
