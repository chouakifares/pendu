package com.usthb.modeles;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import com.usthb.dessin.fenetre.HomePage;
public class Eureka {
	private static HashMap<String, Player> players=new HashMap<String,Player>();
	private static HashSet<ThemeJeu> themes=new HashSet<ThemeJeu>();
	private static String fontName;//variable utilisé pour changé la police ,on charge celle-ci dans la methode init 
	private static void init() {
		//modification de la police
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
		     ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/primer print.ttf")));
		     fontName=ge.getAllFonts()[506].getName();
		} catch (IOException|FontFormatException e) {
		     //Handle exception
		}
		//chargement des images et des questions
		String path="Questions",playersPath="Players.txt";
		File questionDir=new File(path);
		File players=new File(playersPath);
		if(!questionDir.isDirectory()) {
			questionDir.mkdir();
			File adulteQuestion=new File(path+"/Adulte");
			File enfantQuestion=new File(path+"/Enfant");
			adulteQuestion.mkdir();
			enfantQuestion.mkdir();	
			Eureka.createQuestions();
		}
		//loading players
		if(players.isFile()) {
			try {
				ObjectInputStream playerLoader=new ObjectInputStream(new BufferedInputStream(new FileInputStream(players)));
				Eureka.players=(HashMap<String, Player>) playerLoader.readObject();
				playerLoader.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		themes.add(new ThemeJeu(Categories.Sante,1,3.5f));
		themes.add(new ThemeJeu(Categories.CultureGenrale,1,1.5f));
		themes.add(new ThemeJeu(Categories.Islam,1,2));
		themes.add(new ThemeJeu(Categories.Histoire,1,2.5f));
		themes.add(new ThemeJeu(Categories.Geographie,1,2.5f));
	}
	public static String getFontName() {
		return fontName;
	}
	public static Player getPlayer(String name) {
		Player p=null;		
		if(players.containsKey(name))
			p=players.get(name);
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
	public static void endGame() {
		ObjectOutputStream playerWriter;
		try {
			playerWriter = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Players.txt"))));
			playerWriter.writeObject(Eureka.players);
			playerWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void createQuestions() {
		//creating adult questions
		ObjectOutputStream questionWriter = null;
		// generale knowledge questions
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Adulte/Culture.txt"))));
			ArrayList<QuestionAdulte> questions=new ArrayList<QuestionAdulte>();
			questions.add(new QuestionAdulte(1,"<HTML>Quel est le mois qui as la plus longue<br/> journée de l'an ?</HTML>","","juin","juin.jpg"));
			questions.add(new QuestionAdulte(2,"Dans quelle ville se trouve le siege des nations unies ?","","New York","NYC.jpg"));
			questions.add(new QuestionAdulte(3,"Qui est l'auteur du livre \"1984\" ?","","George Orwell","Orwell.jpg"));
			questions.add(new QuestionAdulte(4,"Qui a dit \"Cogito ergo sum\" ?","","René Descarte","Descartes.jpg"));
			questions.add(new QuestionAdulte(5,"Qui est l'inventeur du téléphone ?","","Alexander Graham Bell","bell.jpg"));
			for(QuestionAdulte q:questions) {
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
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Adulte/History.txt"))));
			ArrayList<QuestionAdulte> questions=new ArrayList<QuestionAdulte>();
			questions.add(new QuestionAdulte(1,"Qui etait le chancelier de l'allemagne nazi","","Adolf Hitler","hitler.jpg"));
			questions.add(new QuestionAdulte(2,"Qui etait le premier leader de l'union Sovietique","","Vladimir Lenin","lenin.jpg"));
			questions.add(new QuestionAdulte(3,"Qui etait connu sous le nom de \" Dame de Fer\" ?","","Margaret Thatcher","iron.png"));
			questions.add(new QuestionAdulte(4,"Qui etait le fondateur de l'empire otomand","","Osman Gazi","Osman.png"));
			questions.add(new QuestionAdulte(5,"Quel etait le vrai nom de Pol Pot","","Saloth Sar","polpot.jpg"));
			for(QuestionAdulte q:questions) {
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
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Adulte/Geography.txt"))));
			ArrayList <QuestionAdulte>questions=new ArrayList<QuestionAdulte>();
			questions.add(new QuestionAdulte(1,"Dans quel continent se trouve le desert du Sahara ?","","Afrique","sahara.jpg"));
			questions.add(new QuestionAdulte(2,"Quel est le plus long  fleuve du monde ?","","Nil","nil.jpg"));
			questions.add(new QuestionAdulte(3,"Quel canal lie la mer mediteranné a la mer rouge ?","","Canal De Suez","suez.jpg"));
			questions.add(new QuestionAdulte(4,"Quel est le nom du plus haut mont d'Afrique ?","","Kilimandjaro","kilimondjaro.jpg"));
			questions.add(new QuestionAdulte(5,"Dans quel pays se trouve les chuttes du Niagara","","Canada","canada.jpg"));
			for(QuestionAdulte q:questions) {
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
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Adulte/Islam.txt"))));
			ArrayList<QuestionAdulte> questions=new ArrayList<QuestionAdulte>();
			questions.add(new QuestionAdulte(1,"Quel est le livre saint des musulmants","","Coran","coran.jpg"));
			questions.add(new QuestionAdulte(2,"Quel est le troisieme pillier de l'islam ?","","Charité Obligatoire","zakat.jpg"));
			questions.add(new QuestionAdulte(3,"Quel est le plus pire péché dans l'islam ?","","Apostasie","Mecca.jpg"));
			questions.add(new QuestionAdulte(4,"Qui est l'auteur du plus pertinent Sahih","","Al Boukhari","Saheeh.png"));
			questions.add(new QuestionAdulte(5,"Comment s'appelle l'ange de la mort ?","","Azrael","3ezrayen.jpg"));
			for(QuestionAdulte q:questions) {
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
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Adulte/Sante.txt"))));
			ArrayList<QuestionAdulte> questions=new ArrayList<QuestionAdulte>();
			questions.add(new QuestionAdulte(1,"Qui a decouvert la penicilline ?","","Alexander Fleming","fleming.jpg"));
			questions.add(new QuestionAdulte(2,"Quel est l'organe responsable de la filtration du sang ?","","Rein","rein.jpg"));
			questions.add(new QuestionAdulte(3,"Quelle est la plus grosse artère du corps humain ?","","Aotre","artere.png"));
			questions.add(new QuestionAdulte(4,"Quelle hormone est secrétée lorsqu'on ressent du plaisir ?","","Endorphine","endorphine.png"));
			questions.add(new QuestionAdulte(5,"Quel est le seul organe intra-péritonéale?","","Ovaires","ovaire.jpg"));
			for(QuestionAdulte q:questions) {
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
		//creating children question
		//health
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Enfant/Sante.txt"))));
			ArrayList<QuestionEnfant> questions=new ArrayList<QuestionEnfant>();
			questions.add(new QuestionEnfant(1,"Combien de fruits et légumes doit-on manger par jour ?","","Cinq","fruits.jpg"));
			questions.add(new QuestionEnfant(2,"quel est l’aliment le plus riche en Calcium  ?","","Lait","calcium.jpg"));
			questions.add(new QuestionEnfant(3,"Le nom du plus petit doigt de la main?","","Auriculaire","auriculaire.png"));
			questions.add(new QuestionEnfant(4,"Quel est l'organ le plus grand dans le corp humain","","Peau","skin.png"));
			questions.add(new QuestionEnfant(5,"Combiens de dents une personne adulte ?","","trente deux","dents.jpg"));
			for(QuestionEnfant q:questions) {
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
		//islam
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Enfant/Islam.txt"))));
			ArrayList<QuestionEnfant> questions=new ArrayList<QuestionEnfant>();
			questions.add(new QuestionEnfant(1,"Quelle est la première sourate révélée au Messager Mohammed  ?","","Al aalaq","sourate.jpg"));
			questions.add(new QuestionEnfant(2,"Quel est le nom de la première femme du prophète Mohammed ?","","Khadidja","khadidja.jpg"));
			questions.add(new QuestionEnfant(3,"Quel est le nom du 3eme Calife bien guidé ?","","Othman ibn Affan","Uthman.png"));
			questions.add(new QuestionEnfant(4,"Quelle est la plus courte surate du coran ?","","Al kawthar","khawthar.jpg"));
			questions.add(new QuestionEnfant(5,"Qui etait la fille prefere du prophète Mohammed ?","","Fatima","Fatima.jpg"));
			for(QuestionEnfant q:questions) {
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
		//Geography
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Enfant/Geography.txt"))));
			ArrayList<QuestionEnfant> questions=new ArrayList<QuestionEnfant>();
			questions.add(new QuestionEnfant(1,"Le nombre des continens ?","","Cinq","monde.jpg"));
			questions.add(new QuestionEnfant(2,"Dans quel continent se situe l’Algérie  ?","","Afrique","algerie.jpg"));
			questions.add(new QuestionEnfant(3,"La capitale du Marroc ?","","Rabat","maroc.png"));
			questions.add(new QuestionEnfant(4,"Ou se situe le sommet  de Everest ?","","Nepal","everset.jpg"));
			questions.add(new QuestionEnfant(5,"Dans quel contient se situe l'Inde ?","","Asie","inde.jpg"));
			for(QuestionEnfant q:questions) {
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
		//knowledge
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Enfant/Culture.txt"))));
			ArrayList<QuestionEnfant> questions=new ArrayList<QuestionEnfant>();
			questions.add(new QuestionEnfant(1,"Le plus grand animal ?","","Baleine","baleine.jpg"));
			questions.add(new QuestionEnfant(2,"Quel est la planète la plus proche du soleil ?","","Mercure","mercure.jpg"));
			questions.add(new QuestionEnfant(3,"Quel est le nom de notre galaxie ?","","Voie Lactée","galaxie.png"));
			questions.add(new QuestionEnfant(4,"Quel est le plus  grand fleuve au monde ?","","Nil","Nil.jpg"));
			questions.add(new QuestionEnfant(5,"Le plus petit continent ?","","Oceanie","oceanie.jpg"));
			for(QuestionEnfant q:questions) {
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
		//history
		try {
			questionWriter=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Questions/Enfant/History.txt"))));
			ArrayList<QuestionEnfant> questions=new ArrayList<QuestionEnfant>();
			questions.add(new QuestionEnfant(1,"Qui est le premier president de l'Algerie ?","","Ahmed Ben Bella","benbella.jpg"));
			questions.add(new QuestionEnfant(2,"Qui etait le premier homme a aller dans l'espace ?","","Youri Gagarine","yuri.jpg"));
			questions.add(new QuestionEnfant(3,"Qui etait le premier president noir des etats unis ?","","Barack Obama","obama.png"));
			questions.add(new QuestionEnfant(4,"<HTML>Quel est le premier pays africain<br> a avoir obetnu l'independance ?</HTML>","","Liberia","liberia.jpg"));
			questions.add(new QuestionEnfant(5,"Quel pays a perdu la 1ere guerre mondial ?","","Allemagne","germany.jpg"));
			for(QuestionEnfant q:questions) {
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
	public static void main(String[] args){
		init();
		new HomePage();
	}
	public static Collection<Player>  getPlayers() {
		return players.values();
	}
	
}
