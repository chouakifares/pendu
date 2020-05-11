package com.usthb.modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Adulte extends Player implements Serializable{

	public Adulte() {}
	public Adulte(String username, String firstName, String lastName, String password, Date birthday) {
		super(username, firstName, lastName, password, birthday);
	}
	@Override
	public ArrayList<QuestionAdulte> getQuestions(String theme) {
		ArrayList<QuestionAdulte> questionList=new ArrayList<QuestionAdulte>();
		ThemeJeu t=Eureka.getTheme(Categories.valueOf(theme));
		return t.getAdultQuestionSet();
	}

}
