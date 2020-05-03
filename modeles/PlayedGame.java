package com.usthb.modeles;

public class PlayedGame {
	protected float score;
	protected int nbAnswered,wrongAnswers;
	protected ThemeJeu theme;
	protected boolean ended;// we use this boolean variable to knowif the game has ended or not
	protected StringBuffer answer;// we use this variable in case of a loading an exsiting game to show the player the answer he found "*ené **s*art*" for example
	//see GameLog for a beeter understanding 
	public PlayedGame(float score,int nbAnswered,ThemeJeu theme) {
		this.score=score;
		this.nbAnswered=nbAnswered;
		this.theme=theme;
		this.ended=true;
		this.wrongAnswers=8;
		this.answer=new StringBuffer(40);
	}
	public PlayedGame(float score,int nbAnswered,ThemeJeu theme,boolean ended,int wrongAnswers,StringBuffer answer) {
		this.score=score;
		this.nbAnswered=nbAnswered;
		this.theme=theme;
		this.ended=ended;
		this.wrongAnswers=wrongAnswers;
		this.answer=answer;
	}
	public float getScore() {
		return score;
	}
	public ThemeJeu getTheme() {
		return theme;
	}
	public int getNbAnswered() {
		return nbAnswered;
	}
	public int getWrongAnswers() {
		return wrongAnswers;
	}
	public Boolean getEnded() {
		return ended;
	}
	public String getAnswer() {
		return answer.substring(0);
	}
	
	
}
