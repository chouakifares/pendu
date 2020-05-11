package com.usthb.modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Enfant extends Player implements Serializable{

	public Enfant() {}
	public Enfant(String username, String firstName, String lastName, String password, Date birthday) {
		super(username, firstName, lastName, password, birthday);
	}
	@Override
	public ArrayList<QuestionEnfant> getQuestions(String theme) {
		ArrayList<QuestionEnfant> questionList=new ArrayList<QuestionEnfant>();
		ThemeJeu t=Eureka.getTheme(Categories.valueOf(theme));
		return t.getChildrenQuestionSet();
	}

}
