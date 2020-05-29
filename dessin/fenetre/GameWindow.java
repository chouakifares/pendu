package com.usthb.dessin.fenetre;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.usthb.dessin.Button;
import com.usthb.dessin.Fond;
import com.usthb.dessin.Potence;
import com.usthb.dessin.PicturePanel;
import com.usthb.dessin.TextField;
import com.usthb.modeles.Eureka;
import com.usthb.modeles.PlayedGame;
import com.usthb.modeles.Player;
import com.usthb.modeles.Question;
import com.usthb.modeles.ThemeJeu;
//a class used to log all the games of each player 
//This log will consist in(we don't store the username or any personal data of the player since it will be stored in a player instance)
//1-the field the player picked 
//2-the number of questions answered
//3-the score of the player 
public class GameWindow extends Fenetre implements ActionListener,KeyListener,Runnable {
	protected Player joueur;
	protected ThemeJeu theme;
	protected int nbAnswered,wrongAnswers=0;
	protected float score;
	protected Fond content=new Fond(new FlowLayout(1,25,5));
	protected JPanel questionPanel=new JPanel(new FlowLayout(1,0,5));
	protected Potence p;
	protected JLabel question=new JLabel();
	protected JLabel currentAnswer=new JLabel();
	protected JLabel scoreLabel=new JLabel("Score:0");
	protected TextField answer=new TextField("answer here");
	protected Question currentQuestion=new Question();
	protected Button valider=new Button("valider");
	protected Color transparent=new Color(0,0,0,0);
	// this panel is used to draw the image related to the question on the screen 
	protected PicturePanel imgPanel=new PicturePanel();
	//default constructor
	public GameWindow() {};
	// constructor used in case a game is loaded through a saved game see UserPage
	public GameWindow(PlayedGame g,Player joueur) {
		super(800,500,"Eureka");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.theme=g.getTheme();
		this.score=g.getScore();
		this.nbAnswered=g.getNbAnswered();
		this.wrongAnswers=g.getWrongAnswers();
		this.joueur=joueur;
		this.p=new Potence(g.getWrongAnswers());
		addContent();
		newQuestion(g.getAnswer());
	}
	// constructor used when a new game is created see FenetreSelection
	public GameWindow(ThemeJeu theme,Player joueur)
	{
		super(800,500,"Eureka");
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.theme=theme;
		this.nbAnswered=0;
		this.score=0;
		this.joueur=joueur;
		this.p=new Potence(0);
		addContent();
		newQuestion();
	}
	// method used to add the content to our window
	
	//getters
	public float getScore() {
		return this.score;
	}
	public int getNbAnswered() {
		return this.nbAnswered;
	}
	//setters
	public void setScore(float newScore) {
		this.score=newScore;
	}
	public void setNbAnswered(int newNb) {
		this.score=newNb;
	}
	//methods
	protected void addContent() {
		this.addWindowListener( new WindowAdapter() {
			 public void windowOpened( WindowEvent e ){
			        valider.requestFocus();
			    }
			 public void windowClosing(WindowEvent e) {
				 if(wrongAnswers<8) {
					 int i=new JOptionPane().showConfirmDialog(e.getWindow(),"Voulez vous sauvegarder cette partie"
							 ,"Sauvegarder",JOptionPane.YES_NO_CANCEL_OPTION);
					 //quand le joueur nous demande de sauvegarder nous creeons un nouvel
					 //objet partieJoue en mettant le boolean a vrai
					 if(i==JOptionPane.YES_OPTION) {
						PlayedGame g=new PlayedGame(score,nbAnswered,theme,false,wrongAnswers,new StringBuffer(currentAnswer.getText()));
						joueur.addPlay(g);
						new UserPage(joueur);
						dispose();
					 }
					 else if(i==JOptionPane.NO_OPTION){
						 dispose();
					 }
					
				 }
			}
		});
		// initilizing the number of remaining chances that the player has 
		// all the instructions that are in this section are used to display a friendly window to the user I won't bother explaining the details 
		p.setBackground(Color.white);
		// this instruction is used for setting the background of a panel to transparent and that to allow the gradient to be displayed instead
		// this panel is used to display the question 
		question.setBackground(transparent);
		question.setHorizontalAlignment(JLabel.CENTER);
		question.setFont(new Font(Eureka.getFontName(),Font.PLAIN,20));
		currentAnswer.setFont(new Font(Eureka.getFontName(),Font.PLAIN,22));
		answer.setFont(new Font(Eureka.getFontName(),Font.PLAIN,20));
		currentAnswer.setBackground(transparent);
		currentAnswer.setHorizontalAlignment(JLabel.CENTER);
		question.setPreferredSize(new Dimension(380,65));
		currentAnswer.setPreferredSize(new Dimension(380,50));
		answer.addKeyListener(this);
		questionPanel.add(imgPanel);
		questionPanel.add(question);
		questionPanel.add(currentAnswer);
		questionPanel.setBackground(transparent);
		questionPanel.setPreferredSize(new Dimension(380,420));
		answer.setPreferredSize(new Dimension(250,40));
		valider.setPreferredSize(new Dimension(120,40));
		valider.setFont(new Font(Eureka.getFontName(),Font.PLAIN,22));
		content.add(questionPanel);
		JPanel potencePanel=new JPanel(new FlowLayout(1,5,15));
		JPanel zoneSaisie=new JPanel(new GridLayout(1,1,5,5));
		scoreLabel.setFont(new Font(Eureka.getFontName(),Font.PLAIN,20));
		potencePanel.add(scoreLabel);
		potencePanel.add(p);
		zoneSaisie.setBackground(transparent);
		zoneSaisie.add(valider);
		potencePanel.add(answer);
		potencePanel.setPreferredSize(new Dimension(300,420));
		potencePanel.setBackground(transparent);
		content.add(potencePanel);
		content.add(valider);
		valider.addActionListener(this);
		setContentPane(content);
	}
	public void newQuestion() {
		//to get a new question we use this method
		this.currentQuestion=joueur.getQuestions(theme.getType().toString()).get(nbAnswered);
		this.question.setText(this.currentQuestion.getQuestion());
		this.imgPanel.setImg(currentQuestion.getImg());
		this.currentAnswer.setText("");
		for(int i=0;i<this.currentQuestion.getAnswer().length();i++){
			if(this.currentQuestion.getAnswer().charAt(i)==' ')
				this.currentAnswer.setText(this.currentAnswer.getText()+" ");
			else
				this.currentAnswer.setText(this.currentAnswer.getText()+"*");
		}
		repaint();
	}
	//updating the question after finding the answer to the current one
	public void newQuestion(String ans) {
		this.currentQuestion=joueur.getQuestions(theme.getType().toString()).get(nbAnswered);
		this.question.setText(this.currentQuestion.getQuestion());
		this.imgPanel.setImg(currentQuestion.getImg());
		this.currentAnswer.setText("");
		currentAnswer.setText(ans);
		repaint();
	}
	//checking the answer of the player
	public void checkAnswer() {
		String rep=answer.getText().toLowerCase();
		if(rep.length()==1) {
			char caractere=rep.charAt(0);
			if(this.currentQuestion.getAnswer().toLowerCase().contains(rep)) {
				String a=this.currentQuestion.getAnswer();
				String currentAnswerRefreshed=new String("");
				for(int i=0;i<a.length();i++) {
					if(a.charAt(i)==caractere){
						currentAnswerRefreshed=currentAnswerRefreshed+caractere;
					}
					else if(a.toLowerCase().charAt(i)==caractere){
						String temp=""+caractere;
						currentAnswerRefreshed=currentAnswerRefreshed+temp.toUpperCase().charAt(0);
					}
					else {
						currentAnswerRefreshed=currentAnswerRefreshed+currentAnswer.getText().charAt(i);
					}
				}
				currentAnswer.setText(currentAnswerRefreshed);
				repaint();
				//correct answer
				if(!currentAnswer.getText().contains("*")) {
					nbAnswered++;
					score+=getCurrentScore(this.currentQuestion.getLvl());
					scoreLabel.setText("Score:"+score);
					// category not cleared
					if(nbAnswered<theme.getNbQuestion()) {						
						Thread t=new Thread(this);
						repaint();
						t.start();
					}
					// category cleared
					else {
						joueur.addPlay(new PlayedGame(score,nbAnswered,theme));
						joueur.setLastLevel(nbAnswered);
						repaint();
						int i=new JOptionPane().showConfirmDialog(this,"Felicitation!\n Vous avez repondu a toutes les "+ "question de ce theme\n Votre score est "+score,
						"Felicitation",JOptionPane.YES_NO_OPTION);
						if(i==0) {
							dispose();
							new UserPage(joueur);
							}
						else
							dispose();
						}
					repaint();
				}
			}
		// user entered a wrong answer
			else{
				processWrongAnswer();
			}
		}
		// user entered a string and not just a char
		else {
			if(this.currentQuestion.getAnswer().toLowerCase().equals(rep.toLowerCase())) {
				nbAnswered++;
				score+=getCurrentScore(this.currentQuestion.getLvl());
				scoreLabel.setText("Score:"+score);
				this.currentAnswer.setText(this.currentQuestion.getAnswer());
				score+=getCurrentScore(this.currentQuestion.getLvl());
				repaint();
				// category still not cleared
				if(nbAnswered<theme.getNbQuestion()) {
					Thread t=new Thread(this);
					t.start();
				}
				// category cleared
				else {
					joueur.addPlay(new PlayedGame(score,nbAnswered,theme));
					joueur.setLastLevel(nbAnswered);
					int i=new JOptionPane().showConfirmDialog(this,"Felicitation!\n Vous avez repondu a toutes les question de ce theme\n Votre score est "+score+
							"Voulez vous essayer une autre categorie ?"
							,"Felicitation",JOptionPane.YES_NO_OPTION);
					if(i==0) {
						dispose();
						new UserPage(joueur);
					}
					else
						dispose();
					}
			}
			else {
				processWrongAnswer();
			}
		}
	}
	// we use this method to treat the case of wrong answers
		public void processWrongAnswer() {
			wrongAnswers++;
			p.setState(wrongAnswers);
			p.setRemaining();
			repaint();
			if(wrongAnswers==8) {
				joueur.addPlay(new PlayedGame(score,nbAnswered,theme));
				joueur.setLastLevel(nbAnswered);
				new JOptionPane().showMessageDialog(this,"vous avez perdu\n La reponse etait "+currentQuestion.getAnswer()+"\n Votre score est "+score,
						"Game Over",JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new UserPage(joueur);
			}
		}
	//visual effects
	public void actionPerformed(ActionEvent e) {
		if(!answer.getText().equals("")) {
			checkAnswer();
		answer.setText("");
		}
		else {
			answer.setBorder(BorderFactory.createLineBorder(Color.RED));
		}
	}
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==10) {
			checkAnswer();
			answer.setText("");
		}
	}
	public void keyReleased(KeyEvent arg0) {}
	public void keyTyped(KeyEvent arg0) {}
	private float getCurrentScore(int lvl) {
		float nb = 0;
		switch (lvl) {
		case 1:
			nb=5*this.theme.getCoeff();
			break;
		case 2:
			nb=10*this.theme.getCoeff();
			break;
		case 3:
			nb=18*this.theme.getCoeff();
			break;
		case 4:
			nb=28*this.theme.getCoeff();
			break;
		case 5:
			nb=40*this.theme.getCoeff();
			break;
		}
		return nb;
	}
	@Override
	//waiting for 500ms after finding the answer and before updating the question
	public void run() {
		repaint();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newQuestion();
	}
}	