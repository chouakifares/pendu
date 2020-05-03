package com.usthb.dessin;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class ErrorMessage extends JLabel {
	public ErrorMessage(String message) {
		super(message);
		this.setFont(new Font("arial",Font.BOLD,16));
		this.setForeground(Color.RED);
		this.setVisible(false);
	}
}
