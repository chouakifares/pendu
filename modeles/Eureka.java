package com.usthb.modeles;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import com.usthb.dessin.*;
public class Eureka {
	private static HashMap players=new HashMap<String,Player>();
	private static HashSet<ThemeJeu> themes=new HashSet<ThemeJeu>();
	private static void init() {
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
}
