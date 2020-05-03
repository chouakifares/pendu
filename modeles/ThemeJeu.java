package com.usthb.modeles;
import java.util.LinkedList;
import java.util.List;

public class ThemeJeu {
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
		if(type==Categories.CultureGenrale) {
			addQuestion(new Question(1,"Quel est le mois qui as la plus longue journée de l'an ?","","juin","juin.jpg"));
			addQuestion(new Question(3,"Dans quelle ville se trouve le siege des nations unies ?","","New York","NYC.jpg"));
			addQuestion(new Question(3,"Qui est l'auteur du livre \"1984\" ?","","George Orwell","Orwell.jpg"));
			addQuestion(new Question(4,"Qui a dit \"Cogito ergo sum\" ?","","René Descarte","Descartes.jpg"));
			addQuestion(new Question(5,"Qui est l'inventeur du téléphone ?","","Alexander Graham Bell","bell.jpg"));
		}
		else if(type==Categories.Histoire) {
			addQuestion(new Question(1,"Qui etait le chancelier de l'allemagne nazi","","Adolf Hitler","hitler.jpg"));
			addQuestion(new Question(2,"Qui etait le premier leader de l'union Sovietique","","Vladimir Lenin","lenin.jpg"));
			addQuestion(new Question(3,"Qui etait connu sous le nom de \" Dame de Fer\" ?","","Margaret Thatcher","iron.png"));
			addQuestion(new Question(4,"Qui etait le fondateur de l'empire otomand","","Osman Gazi","Osman.png"));
			addQuestion(new Question(5,"Quel etait le vrai nom de Pol Pot","","Saloth Sar","polpot.jpg"));
		}
		else if(type==Categories.Geographie) {
			addQuestion(new Question(1,"Dans quel continent se trouve le desert du Sahara ?","","Afrique","sahara.jpg"));
			addQuestion(new Question(2,"Quel est le plus long  fleuve du monde ?","","Nil","nil.jpg"));
			addQuestion(new Question(3,"Quel canal lie la mer mediteranné a la mer rouge ?","","Canal De Suez","suez.jpg"));
			addQuestion(new Question(4,"Quel est le nom du plus haut mont d'Afrique ?","","Kilimandjaro","kilimondjaro.jpg"));
			addQuestion(new Question(5,"Dans quel pays se trouve les chuttes du Niagara","","Canada","canada.jpg"));
		}
		else if(type==Categories.Islam) {
			addQuestion(new Question(1,"Quel est le livre saint des musulmants","","Coran","coran.jpg"));
			addQuestion(new Question(2,"Quel est le troisieme pillier de l'islam ?","","Charité Obligatoire","zakat.jpg"));
			addQuestion(new Question(1,"Quel est le plus pire péché dans l'islam ?","","Apostasie","hitler.jpg"));
			addQuestion(new Question(4,"Qui est l'auteur du plus pertinent Sahih","","Al Boukhari","Saheeh.png"));
			addQuestion(new Question(1,"Comment s'appelle l'ange de la mort ?","","Azrael","3ezrayen.jpg"));
		}
		else {
			addQuestion(new Question(1,"Qui a decouvert la penicilline ?","","Alexander Fleming","fleming.jpg"));
			addQuestion(new Question(2,"Quel est l'organe responsable de la filtration du sang ?","","Rein","rein.jpg"));
			addQuestion(new Question(3,"Quelle est la plus grosse artère du corps humain ?","","Aotre","artere.png"));
			addQuestion(new Question(3,"Quelle hormone est secrétée lorsqu'on ressent du plaisir ?","","Endorphine","endorphine.png"));
			addQuestion(new Question(5,"Quel est le seul organe intra-péritonéale?","","Ovaires","fleming.jpg"));
		}
	}
	//getters
	public void setType(Categories type) {
		this.type=type;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setCoeff(float f) {
		this.coeff=f;
	}
	// setters
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
	public int getNbQuestion() {
		return questions.size();
	}
}
