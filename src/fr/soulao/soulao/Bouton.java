package fr.soulao.soulao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;

public class Bouton extends JButton{
	private String name;
	private Font font = new Font("Arial", 1, 20);
	private MouseListener ml = new MouseListener();
	
	public Bouton(String str,int x ,int y, int length, int heigth){
		super(str);
		this.name = str;
		this.setBorderPainted(false);
		this.setBounds(x, y, length, heigth);
		this.addMouseListener(ml);
	}
	public void paintComponent(Graphics g){
	    Graphics2D g2d = (Graphics2D)g;
	    g2d.setColor(new Color(255,255,255,1));
	    g2d.drawRect(0, 0, 2000, 2000);
	    g2d.setColor(new Color(255,255,255));
	    g2d.setFont(font);
	    g2d.drawString(this.name, 15,25);
	  }
}
