package com.usthb.dessin.fenetre;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.usthb.dessin.BackPanel;
import com.usthb.dessin.Fond;
import com.usthb.modeles.Eureka;
import com.usthb.modeles.Player;

public class Statistique extends Fenetre{
	private JTable table;
	private BackPanel back=new BackPanel();
	private JPanel content=new Fond(new FlowLayout(0,0,5));
	private String[][] data=new String[Eureka.getPlayers().size()][3];
	Color transparent=new Color(0,0,0,0);
	public Statistique() {
		back.getB().addActionListener(new BackButtonListener());
		int i=0;
		for(Player p : Eureka.getPlayers()) {
			String temp[] = new String[3];
			temp[1]=p.getUsername();
			temp[0]=Integer.toString(p.getId());
			System.out.println(temp[0]);
			temp[2]=p.getClass().getSimpleName();
			data[i]=temp;
			i++;
		}
		content.setBorder(BorderFactory.createEmptyBorder(0,20,10,10));
		String header[]= {"id","Name","Categorie"};
		table=new JTable(data,header);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(55);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		JScrollPane scroll=new JScrollPane(table);
		scroll.setBackground(transparent);
		scroll.setSize(350,250);
		content.add(back);
		content.add(scroll);
		this.add(content);
	}
	class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new HomePage();
		}	
	}
}
