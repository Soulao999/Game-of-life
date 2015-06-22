package fr.soulao.soulao;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Le keyCode de la touche préssée est: "+e.getKeyCode());
		//barre espace
		if(e.getKeyCode() == 32){
		}
		//flèche haut
		else if(e.getKeyCode() == 38){
			
		}
		//flèche bas
		else if(e.getKeyCode() == 40){
			
		}
		//flèche droite
		else if(e.getKeyCode() == 39){
		}
		// flèche gauche
		else if(e.getKeyCode() == 37){
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
