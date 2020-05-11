package com.usthb.modeles;

import java.io.Serializable;

public class QuestionEnfant extends Question implements Serializable{
	protected static int nb=1; 
	protected int id,lvl;
	protected String question,number,answer,img;
	public QuestionEnfant() {}
	public QuestionEnfant(int lvl,String question,String number,String answer,String img) {
		this.id=nb;
		this.lvl=lvl;
		this.question=question;
		this.number=number;
		this.answer=answer;
		this.img=img;
		nb++;
	}
	public String getAnswer(){
		return answer;
	}
	public String getQuestion(){
		return question;
	}
	public String getNumber() {
		return number;
	}
	public String getImg() {
		return img;
	}
	public int getId(){
		return id;
	}
	public int getLvl() {
		return lvl;
	}
	public void setNumber(String number)
	{
		this.number=number;
	}
}
