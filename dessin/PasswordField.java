package com.usthb.dessin;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
//we use this class instead of the JPassword to improve the UX and that by putting a visible Lablel "Password" on this field when it's empty
// and masking the letters in case of an input 
// we do this by using a focus listner and the methods setEchoChar and getEchoChar
public class PasswordField extends JPasswordField{
	protected String name;
	public PasswordField(String name) {
		super(name);
		this.name=name;
		this.setForeground(Color.GRAY);
		this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		// we store the default carachter used in passwords in this variable
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
				// getting the innertext of the label to a string so we can use it
				if(getPassword().length!=0) {
					for(char i:getPassword())
						p+=i;
				}
				if(p.equals("")){
					// in case of any empty string we put the caracters of the inner text of this label to visible chars
					JPasswordField password=(JPasswordField)arg0.getComponent();
					password.setEchoChar((char)0);
					//then we put in the innertext the label "Password" again
					setText(name);
					// and change the color to gray to have a beautiful but noticable change 
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
