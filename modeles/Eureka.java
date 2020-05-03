package com.usthb.modeles;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import com.usthb.dessin.*;
public class Eureka {
	private static HashMap players=new HashMap<String,Player>();
	private static HashSet<ThemeJeu> themes=new HashSet<ThemeJeu>();
	private static void init() {
		String path="Questions";
		File questionDir=new File(path);
		if(!questionDir.isDirectory()) {
			System.out.println("done");
			questionDir.mkdir();
			Eureka.createQuestions();
		}
		themes.add(new ThemeJeu(Categories.Sante,1,3.5f));
		themes.add(new ThemeJeu(Categories.CultureGenrale,1,1.5f));
		themes.add(new ThemeJeu(Categories.Islam,1,2));
		themes.add(new ThemeJeu(Categories.Histoire,1,2.5f));
		themes.add(new ThemeJeu(Categories.Geographie,1,2.5f));
	}
	public static void main(String[] args){
		init();
		players.put("3aroudj", new Player("3aroudj","fares","chouaki","azerty",new Date(1,1,2000)));
		HomePage p=new HomePage();
	}
	public static Player getPlayer(String name) {
		Player p=null;		
		if(players.containsKey(name))
			p=(Player) players.get(name);
		return p;
	}
	public static void addPlayer(Player p) {
		players.put(p.getUsername(), p);
	}
	public static ThemeJeu getTheme(Categories c) {
		ThemeJeu theme=null;
		for(ThemeJeu i:themes) {
			if(i.type==c) {
				theme=i;
			}
		}
		return theme;
	}
	public static void createQuestions() {
		ObjectOutputStream questionWriter = null;
		// generale knowledge questions
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Culture.txt"))));
			ArrayList<Question> questions=new ArrayList<Question>();
			questions.add(new Question(1,"Quel est le mois qui as la plus longue journée de l'an ?","","juin","juin.jpg"));
			questions.add(new Question(2,"Dans quelle ville se trouve le siege des nations unies ?","","New York","NYC.jpg"));
			questions.add(new Question(3,"Qui est l'auteur du livre \"1984\" ?","","George Orwell","Orwell.jpg"));
			questions.add(new Question(4,"Qui a dit \"Cogito ergo sum\" ?","","René Descarte","Descartes.jpg"));
			questions.add(new Question(5,"Qui est l'inventeur du téléphone ?","","Alexander Graham Bell","bell.jpg"));
			for(Question q:questions) {
				try {
					questionWriter.writeObject(q);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				questionWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch (IOException e1) {
			e1.printStackTrace();
		}	
		//History questions
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/History.txt"))));
			ArrayList<Question> questions=new ArrayList<Question>();
			questions.add(new Question(1,"Qui etait le chancelier de l'allemagne nazi","","Adolf Hitler","hitler.jpg"));
			questions.add(new Question(2,"Qui etait le premier leader de l'union Sovietique","","Vladimir Lenin","lenin.jpg"));
			questions.add(new Question(3,"Qui etait connu sous le nom de \" Dame de Fer\" ?","","Margaret Thatcher","iron.png"));
			questions.add(new Question(4,"Qui etait le fondateur de l'empire otomand","","Osman Gazi","Osman.png"));
			questions.add(new Question(5,"Quel etait le vrai nom de Pol Pot","","Saloth Sar","polpot.jpg"));
			for(Question q:questions) {
				try {
					questionWriter.writeObject(q);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				questionWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch (IOException e1) {
				e1.printStackTrace();
		}	
		
		//geograhy questions
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Geography.txt"))));
			ArrayList <Question>questions=new ArrayList<Question>();
			questions.add(new Question(1,"Dans quel continent se trouve le desert du Sahara ?","","Afrique","sahara.jpg"));
			questions.add(new Question(2,"Quel est le plus long  fleuve du monde ?","","Nil","nil.jpg"));
			questions.add(new Question(3,"Quel canal lie la mer mediteranné a la mer rouge ?","","Canal De Suez","suez.jpg"));
			questions.add(new Question(4,"Quel est le nom du plus haut mont d'Afrique ?","","Kilimandjaro","kilimondjaro.jpg"));
			questions.add(new Question(5,"Dans quel pays se trouve les chuttes du Niagara","","Canada","canada.jpg"));
			for(Question q:questions) {
				try {
					questionWriter.writeObject(q);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				questionWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch (IOException e1) {
				e1.printStackTrace();
		}	
		
		//Islam questions
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Islam.txt"))));
			ArrayList<Question> questions=new ArrayList<Question>();
			questions.add(new Question(1,"Quel est le livre saint des musulmants","","Coran","coran.jpg"));
			questions.add(new Question(2,"Quel est le troisieme pillier de l'islam ?","","Charité Obligatoire","zakat.jpg"));
			questions.add(new Question(3,"Quel est le plus pire péché dans l'islam ?","","Apostasie","hitler.jpg"));
			questions.add(new Question(4,"Qui est l'auteur du plus pertinent Sahih","","Al Boukhari","Saheeh.png"));
			questions.add(new Question(5,"Comment s'appelle l'ange de la mort ?","","Azrael","3ezrayen.jpg"));
			for(Question q:questions) {
				try {
					questionWriter.writeObject(q);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				questionWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch (IOException e1) {
				e1.printStackTrace();
		}	
		//Health Questions
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Sante.txt"))));
			ArrayList<Question> questions=new ArrayList<Question>();
			questions.add(new Question(1,"Qui a decouvert la penicilline ?","","Alexander Fleming","fleming.jpg"));
			questions.add(new Question(2,"Quel est l'organe responsable de la filtration du sang ?","","Rein","rein.jpg"));
			questions.add(new Question(3,"Quelle est la plus grosse artère du corps humain ?","","Aotre","artere.png"));
			questions.add(new Question(4,"Quelle hormone est secrétée lorsqu'on ressent du plaisir ?","","Endorphine","endorphine.png"));
			questions.add(new Question(5,"Quel est le seul organe intra-péritonéale?","","Ovaires","fleming.jpg"));
			for(Question q:questions) {
				try {
					questionWriter.writeObject(q);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			try {
				questionWriter.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch (IOException e1) {
				e1.printStackTrace();
		}	
		
	}
}
