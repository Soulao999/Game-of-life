package fr.soulao.soulao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	private Font font = new Font("Arial", 1, 20);
	public static int MousePosX;
	public static int MousePosY;
	public void paintComponent(Graphics g){  
		// x=1000 + 6
		// y=700  + 29
		MousePosX = MouseInfo.getPointerInfo().getLocation().x-getLocationOnScreen().x;
		MousePosY = MouseInfo.getPointerInfo().getLocation().y-getLocationOnScreen().y;
	    g.setColor(new Color(0,0,40));
	    g.fillRect(0, 0, this.getSize().width, this.getSize().height);
	    for(int j = 0; j<Fenetre.Game.length;j++){
	    	for(int i = 0; i<Fenetre.Game[j].length;i++){
	    		if(Fenetre.precision == false || Fenetre.generation == 0){
	    			g.setColor(new Color(0,0,0));
	    			if(Fenetre.Game[j][i]){
	    				g.setColor(new Color(255,255,255));
	    			}
	    			g.fillRect(1+i*5, 1+j*5, 4, 4);
	    		}
	    		if(Fenetre.precision == true && Fenetre.generation != 0){
	    			g.setColor(new Color(0,0,0));
	    			if(Fenetre.Game[j][i] == Fenetre.GameTampon[j][i] && Fenetre.Game[j][i] == true){g.setColor(new Color(255,255,255));}
	    			else if(Fenetre.Game[j][i] == true && Fenetre.GameTampon[j][i] == false){g.setColor(new Color(0,255,0));}
	    			else if(Fenetre.Game[j][i] == false && Fenetre.GameTampon[j][i] == true){g.setColor(new Color(120,0,0));}
	    			g.fillRect(1+i*5, 1+j*5, 4, 4);
	    		}
	    	}
	    }
	    g.setFont(font);
	    g.setColor(new Color(255,255,255));
	    g.drawString("Mode Dessin = "+ Fenetre.DrawMode, 15, 30);
	    g.drawString("Vitesse = "+ Fenetre.speed, 15, 60);
	    g.drawString("Présision = "+ Fenetre.precision, 15, 90);
	    g.drawString("Game of life", 450, 30);
	    g.drawString("Genération n°"+Fenetre.generation, 775, 30);
	    
	}
}
