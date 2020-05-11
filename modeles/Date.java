package com.usthb.modeles;
import java.io.Serializable;

public class Date implements Serializable{
	private int day,month,year;
	public Date() {}
	public Date(int day,int month,int year){		
		this.day=day;
		this.month=month;
		this.year=year;
	}
	public static boolean anneeBissextile(int year) {
		boolean b=false;
		if(year%400==0||(year%4==0 && year%100!=0))
			b=true;
		return b;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
