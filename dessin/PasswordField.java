package com.usthb.dessin;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class PasswordField extends JPasswordField{
	protected String name;
	PasswordField(String name) {
		super(name);
		this.name=name;
		this.setForeground(Color.GRAY);
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		char defaultEchoChar=this.getEchoChar();
		setEchoChar((char) 0);
		this.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent arg0) {
				JPasswordField password=(JPasswordField)arg0.getComponent();
				setEchoChar(defaultEchoChar);
				String p ="";
				
				for(char i:getPassword())
					p+=i;
				if(p.equals(password.getName())) {
					setText("");
				}
				setForeground(Color.BLACK);
			}
			public void focusLost(FocusEvent arg0) {
				String p ="";
				if(getPassword().length!=0) {
					for(char i:getPassword())
						p+=i;
				}
				if(p.equals("")){
					JPasswordField password=(JPasswordField)arg0.getComponent();
					password.setEchoChar((char)0);
					setText(name);
					setForeground(Color.GRAY);
				}
			}
		});
	}
	public String getName() {
		return name;
	}
	public boolean checkPassword(String correctPassword) {
		String p="";
		if(getPassword().length!=0) {
			for(char i:getPassword())
				p+=i;
		}
		return p.equals(correctPassword);
	}
}
