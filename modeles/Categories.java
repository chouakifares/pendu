package com.usthb.modeles;
import java.util.Scanner;

public enum Categories {
	Histoire("HIS"),
	Geographie("GEO"),
	Sante("SAN"),
	CultureGenrale("CUL"),
	Islam("ISL");
	private String label;
	Categories(String label) {
		this.label=label;
	}
	public String getLabel() {
		return this.label;
	}
}
