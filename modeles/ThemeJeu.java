package com.usthb.modeles;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ThemeJeu implements Serializable {
	protected Categories type;
	protected int id;
	protected float coeff;
	protected List<Question> questions= new LinkedList<Question>();
	public ThemeJeu() {
		this.type=null;
		this.id=0;
		this.coeff=0;
	}
	public ThemeJeu(Categories type,int id,float coeff) {
		this.id=id;
		this.type=type;
		this.coeff=coeff;
		ObjectOutputStream questionWriter = null;
		ObjectInputStream questionReader;
		if(type==Categories.CultureGenrale) {
			try {
				questionReader=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Questions/Culture.txt"))));
				ArrayList questions=new ArrayList();
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				questionReader.close();
			}catch(IOException | ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		else if(type==Categories.Histoire) {
			try {
				questionReader=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Questions/History.txt"))));
				ArrayList questions=new ArrayList();
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				questionReader.close();
			}catch(IOException | ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		else if(type==Categories.Geographie) {
			try {
				questionReader=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Questions/Geography.txt"))));
				ArrayList questions=new ArrayList();
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				questionReader.close();
			}catch(IOException | ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		else if(type==Categories.Islam) {
			try {
				questionReader=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Questions/Islam.txt"))));
				ArrayList questions=new ArrayList();
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				questionReader.close();
			}catch(IOException | ClassNotFoundException e){
				e.printStackTrace();
			}
		}
		else {
			try {
				questionReader=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Questions/Sante.txt"))));
				ArrayList questions=new ArrayList();
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				addQuestion((Question)questionReader.readObject());
				questionReader.close();
			}catch(IOException | ClassNotFoundException e){
				e.printStackTrace();
			}
		}
	}
	//setters
	public void setType(Categories type) {
		this.type=type;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setCoeff(float f) {
		this.coeff=f;
	}
	// getters
	public Categories getType() {
		return type;
	}
	public int getId() {
		return id;
	}
	public float getCoeff() {
		return coeff;
	}
	public void addQuestion(Question q)
	{
		questions.add(q);
		q.setNumber(this.type.getLabel()+q.id);
	}
	public Question getQuestion(int index) {
		return this.questions.get(index);
	}
	public List<Question> getQuestionSet() {
		return this.questions;
	}
	public ArrayList<QuestionAdulte> getAdultQuestionSet(){
		ArrayList<QuestionAdulte> questions=new ArrayList<QuestionAdulte>();
		for(Question q:this.questions) {
			if((q.getClass()).getSimpleName().equals("QuestionAdulte")) questions.add((QuestionAdulte)q);
		}
		return questions;
	}
	public ArrayList<QuestionEnfant> getChildrenQuestionSet(){
		ArrayList<QuestionEnfant> questions=new ArrayList<QuestionEnfant>();
		for(Question q:this.questions) {
			if((q.getClass()).getSimpleName().equals("QuestionEnfant")) questions.add((QuestionEnfant)q);
		}
		return questions;
	}

	public int getNbQuestion() {
		return questions.size();
	}
}
