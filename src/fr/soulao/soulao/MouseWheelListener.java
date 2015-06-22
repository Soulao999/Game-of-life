package fr.soulao.soulao;

import java.awt.event.MouseWheelEvent;

public class MouseWheelListener implements java.awt.event.MouseWheelListener{

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(Fenetre.speed >= 1 && e.getWheelRotation() > 0 && Fenetre.speed < 100){
			Fenetre.speed = (int) (Fenetre.speed + e.getWheelRotation());
		}
		if(Fenetre.speed > 1 && e.getWheelRotation() < 0 && Fenetre.speed <= 100){
			Fenetre.speed = (int) (Fenetre.speed + e.getWheelRotation());
		}
		if(Fenetre.speed > 100){
			Fenetre.speed = 100;
		}
		if(Fenetre.speed < 1){
			Fenetre.speed = 1;
		}
	}

}
