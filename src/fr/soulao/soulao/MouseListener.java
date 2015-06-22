package fr.soulao.soulao;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener{
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("hello");
		if(e.getSource() == Fenetre.bouton){
			if(e.getButton() == 1){
				Fenetre.Clean();
			}
		}
		else{
		if(e.getButton() == 1){
			Fenetre.Change();
		}
		else if(e.getButton() == 2){
			if(Fenetre.DrawMode == true){
				System.out.println("drawMode = false");
			Fenetre.DrawMode = false;
			}
			else if(Fenetre.DrawMode == false){
				System.out.println("drawMode = true");
				Fenetre.DrawMode = true;
			}
		}
		else if(e.getButton() == 3){
			if(Fenetre.precision){
				Fenetre.precision = false;
			}
			else if(!Fenetre.precision){
				Fenetre.precision =true;
			}
		}
		}	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}
