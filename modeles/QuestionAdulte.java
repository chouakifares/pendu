package com.usthb.modeles;

import java.io.Serializable;

public class QuestionAdulte extends Question implements Serializable{
	public QuestionAdulte() {}
	public QuestionAdulte(int lvl,String question,String number,String answer,String img) {
		super(lvl,question,number,answer,img);
	}
}
