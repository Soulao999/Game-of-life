package fr.soulao.soulao;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	public static Panneau pan = new Panneau();
	private MouseListener ml = new MouseListener();
	private MouseWheelListener mwl = new MouseWheelListener();
	private KeyListener k = new KeyListener();
	private Thread t;
	public static int FrameRate = 25;
	public static boolean Game[][] = new boolean[140][200];
	public static boolean GameTampon[][] = new boolean[140][200];
	public static boolean DrawMode = true;
	public static int speed = 10;
	public static int generation = 0;
	private int buff = 0;
	public static boolean precision = false;
	public static Bouton bouton = new Bouton("Clean",800, 45, 80, 40);
	
	public Fenetre(){
		
	 	this.setTitle("Game of life");
	    this.setSize(1006, 729);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	    this.setContentPane(pan);
	    this.addKeyListener(k);
	    this.addMouseListener(ml);
	    this.addMouseWheelListener(mwl);
	    this.getContentPane().setLayout(null);;
	    pan.add(bouton);
	    Game[30][30] = true;
	    Game[31][31] = true;
	    Game[32][31] = true;
	    Game[30][32] = true;
	    Game[31][32] = true;
	    this.setVisible(true);
	    GameTrame();
	    
	  
}
	public void GameTrame(){
        while(true){
        	if(DrawMode == true){
        		DrawTrame();
        	}
                int Buffer = TimerThread.TIME;
                
                buff++;
                if(buff >= speed){
                	buff = 0;
                	Generate();
                }
                pan.repaint();
                
                
                if((TimerThread.TIME-Buffer) < FrameRate){
                        try {Thread.sleep(FrameRate-(TimerThread.TIME-Buffer));}
                        catch (InterruptedException e) {e.printStackTrace();}
                }
        }
	}
	public void DrawTrame(){
		while(true){
            int Buffer = TimerThread.TIME;
            
            pan.repaint();
            if(DrawMode == false){
				GameTrame();
			}
            
            if((TimerThread.TIME-Buffer) < FrameRate){
                    try {Thread.sleep(FrameRate-(TimerThread.TIME-Buffer));}
                    catch (InterruptedException e) {e.printStackTrace();}
            }
    }
	}
	public static void Change(){
		if(DrawMode == true){
			int x = Panneau.MousePosX/5;
			int y = Panneau.MousePosY/5;
			System.out.println();
			if(Game[y][x] == true){
				Game[y][x] = false;
			}
			else if(Game[y][x] == false){
				Game[y][x] = true;
			}
		}

	}
	public static void Generate(){		
		for(int j = 0; j<Game.length;j++){
	    	for(int i = 0; i<Game[j].length;i++){
	    		GameTampon[j][i]= Game[j][i];
	    	}
	    }
		
		
		for(int j = 0; j<Game.length;j++){
	    	for(int i = 0; i<Game[j].length;i++){
	    		int a = 0;
	    		
	    		//les daux coins du haut
	    		if(j == 0){
	    			if(i == 0){
	    				if(GameTampon[j][i+1] == true){a++;}
	    				if(GameTampon[j+1][i] == true){a++;}
		    			if(GameTampon[j+1][i+1] == true){a++;}
	    			}
	    			else if(i == 199){
	    				if(GameTampon[j][i-1] == true){a++;}
	    				if(GameTampon[j+1][i-1] == true){a++;}
		    			if(GameTampon[j+1][i] == true){a++;}
	    			}
	    			else{
	    				if(GameTampon[j][i-1] == true){a++;}
		    			if(GameTampon[j][i+1] == true){a++;}
		    			if(GameTampon[j+1][i-1] == true){a++;}
		    			if(GameTampon[j+1][i] == true){a++;}
		    			if(GameTampon[j+1][i+1] == true){a++;}
	    			}
	    		}
	    		// les deux coins du bas
	    		else if(j == 139){
	    			if(i == 0){
	    				if(GameTampon[j-1][i] == true){a++;}
		    			if(GameTampon[j-1][i+1] == true){a++;}
		    			if(GameTampon[j][i+1] == true){a++;}
	    			}
	    			else if(i == 199){
	    				if(GameTampon[j-1][i-1] == true){a++;}
		    			if(GameTampon[j-1][i] == true){a++;}
		    			if(GameTampon[j][i-1] == true){a++;}
	    			}
	    			else{
	    				if(GameTampon[j-1][i-1] == true){a++;}
		    			if(GameTampon[j-1][i] == true){a++;}
		    			if(GameTampon[j-1][i+1] == true){a++;}
		    			if(GameTampon[j][i-1] == true){a++;}
		    			if(GameTampon[j][i+1] == true){a++;}
	    			}
	    		}
	    		else{
	    			if(i == 0){
	    				if(GameTampon[j-1][i] == true){a++;}
	    				if(GameTampon[j-1][i+1] == true){a++;}
	    				if(GameTampon[j][i+1] == true){a++;}
	    				if(GameTampon[j+1][i] == true){a++;}
	    				if(GameTampon[j+1][i+1] == true){a++;}
	    			}
	    			else if(i == 199){
	    				if(GameTampon[j-1][i-1] == true){a++;}
	    				if(GameTampon[j-1][i] == true){a++;}
	    				if(GameTampon[j][i-1] == true){a++;}
	    				if(GameTampon[j+1][i-1] == true){a++;}
	    				if(GameTampon[j+1][i] == true){a++;}
	    			}
	    			else{
	    				if(GameTampon[j-1][i-1] == true){a++;}
	    				if(GameTampon[j-1][i] == true){a++;}
	    				if(GameTampon[j-1][i+1] == true){a++;}
	    				if(GameTampon[j][i-1] == true){a++;}
	    				if(GameTampon[j][i+1] == true){a++;}
	    				if(GameTampon[j+1][i-1] == true){a++;}
	    				if(GameTampon[j+1][i] == true){a++;}
	    				if(GameTampon[j+1][i+1] == true){a++;}
	    			}
	    		}
	    		
	    		if(a == 3 && GameTampon[j][i] == false){
	    			Game[j][i] = true;
	    		}
	    		if(a != 3 && a != 2 && GameTampon[j][i] == true){
	    			Game[j][i] = false;
	    		}
	    		
	    	}
	    }
		

		generation ++;
	}
	public static void Clean(){
		for(int j = 0; j<Game.length;j++){
	    	for(int i = 0; i<Game[j].length;i++){
	    		Game[j][i] = false;
	    	}
	    }
		generation = 0;
		DrawMode = true;
	}
}
