package com.usthb.modeles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class Player implements Serializable{
	protected static int nb=0;
	protected int id,lastLevel;
	protected String username,firstName,lastName,password;
	protected Date birthday;
	protected List<PlayedGame> played;
	public Player(){}
	public Player(String username ,String firstName, String lastName, String password,Date birthday)
	{
		nb++;
		this.id=nb;
		this.username=username;
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.birthday=birthday;
		this.played=new LinkedList<PlayedGame>();
	}
	//getters
	public int getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCorrectPassword() {
		return password;
	}
	public List<PlayedGame> getHistory() {
		return played;
	}
	//setters
	public void setPassword(String password) {
		this.password=password;
	}
	public void setLastLevel(int lastLevel)
	{
		this.lastLevel=lastLevel;
	}
	public void addPlay(PlayedGame p)
	{
		this.played.add(p);
	}
	public PlayedGame getLastPlayedGame() {
		//here we remove the last played game because it will be reentered during the end of the game or just after the userPage cade that uses it finishes with it  
		//see gameLog and userPage for a better understanding
		PlayedGame g;
		try {
			g=played.get(played.size()-1);
			played.remove(g);
		}catch(IndexOutOfBoundsException e) {
			g=null;
		}
		return g;
	}
	public abstract ArrayList<? extends Question> getQuestions(String theme);
}

