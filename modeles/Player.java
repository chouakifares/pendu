package com.usthb.modeles;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Player implements Serializable{
	private static int nb=0;
	private int id,lastLevel;
	private String username,firstName,lastName,password;
	private Date birthday;
	private List<PlayedGame> played;
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
	public List<PlayedGame> getHistory() {
		return played;
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
}

