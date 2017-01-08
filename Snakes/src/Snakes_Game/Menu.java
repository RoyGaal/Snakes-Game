package Snakes_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Snakes_Game.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	private Random r = new Random();
	
	public Menu(Game game, Handler handler, HUD hud){
		this.game = game;
		this.hud = hud;
		this.handler = handler;
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		
		if(Game.gameState == STATE.Menu){
			
			//play button
		    if(mouseOver(mx, my, 210, 150, 200, 64)){
		    	Game.gameState = STATE.Select;
		    	return;
		    }
		
		    //help button
		    if(mouseOver(mx, my, 210, 250, 200, 64)){
			   Game.gameState = STATE.Help;
		    }
		
		    //quit button
		    if(mouseOver(mx, my, 210, 350, 200, 64)){
			   System.exit(1);
		    }
		}
		
		if(Game.gameState == STATE.Select){
			//normal button
		    if(mouseOver(mx, my, 210, 120, 200, 64)){
			    Game.gameState = STATE.Game;
			    handler.addObject(new Player(Game.WIDTH / 2-32, Game.HEIGHT / 2-32, ID.Player, handler));
			    handler.clearEnemys();
		        handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
		        
		        game.diff = 0;
		    }
		
		    //hard button
		    if(mouseOver(mx, my, 210, 250, 200, 64)){
		    	Game.gameState = STATE.Game;
			    handler.addObject(new Player(Game.WIDTH / 2-32, Game.HEIGHT / 2-32, ID.Player, handler));
			    handler.clearEnemys();
		        handler.addObject(new HardEnemy(r.nextInt(Game.WIDTH - 50), r.nextInt(Game.HEIGHT - 50), ID.BasicEnemy, handler));
		        
		        game.diff = 1;
		    }
		
		    //back button
		    if(mouseOver(mx, my, 210, 350, 200, 64)){
		    	if(mouseOver(mx, my, 210, 350, 200, 64)){
					Game.gameState = STATE.Menu;
					return;
				}
		    }
		}
		
		//back button for help
		if(Game.gameState == STATE.Help){
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				Game.gameState = STATE.Menu;
				return;
			}
		}
		//quit button
		if(Game.gameState == STATE.End){
			if(mouseOver(mx, my, 210, 350, 200, 64)){
				Game.gameState = STATE.Menu;
				hud.setLevel(1);
		    	hud.setScore(0);
				
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
		if(mx > x && mx < x + width){
			if(my > y && my < y + height){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		if(Game.gameState == STATE.Menu){
		    Font fnt = new Font("arial", 1, 50);
		    Font fnt2 = new Font("arial", 1, 30);
		
		    g.setFont(fnt);
		    g.setColor(Color.white);
		    g.drawString("Main Menu", 180, 70);
		
		    g.setFont(fnt2);
		    g.drawRect(210, 150, 200, 64);
		    g.drawRect(205, 145, 210, 74);
		    g.drawString("Play", 275, 190);
		
		    g.drawRect(210, 250, 200, 64);
		    g.drawRect(205, 245, 210, 74);
		    g.drawString("Help", 275, 290);
		
		    g.drawRect(210, 350, 200, 64);
		    g.drawRect(205, 345, 210, 74);
		    g.drawString("Quit", 275, 390);
		    
		}else if(Game.gameState == STATE.Help){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 15);
		
		    g.setFont(fnt);
		    g.setColor(Color.white);
		    g.drawString("Help", 240, 70);
		    
		    g.setFont(fnt2);
		    g.drawRect(210, 350, 200, 64);
		    g.drawRect(205, 345, 210, 74);
		    g.drawString("Back", 275, 390);
		    
		    g.setFont(fnt3);
		    g.drawString("Use up, down, left, and right keys to move the player and escape from enemies.", 50, 170);
		    g.drawString("Also, press on the SPACE key to upgrade your strength and speed.", 50, 200);
		    g.drawString("Use the P key to pause the game.", 50, 230);
			
		}else if(Game.gameState == STATE.End){
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 15);
		
		    g.setFont(fnt);
		    g.setColor(Color.white);
		    g.drawString("Game Over", 180, 70);
		    
		    g.setFont(fnt3);
		    g.setFont(new Font("arial", 0,30));
		    g.drawString("You lost with a score of: " + hud.getScore(), 120, 200);
			
		    g.setFont(fnt2);
		    g.drawRect(210, 350, 200, 64);
		    g.drawRect(205, 345, 210, 74);
		    g.drawString("Try Again", 245, 390);
		}else if(Game.gameState == STATE.Select){
		    Font fnt = new Font("arial", 1, 50);
		    Font fnt2 = new Font("arial", 1, 30);
		
		    g.setFont(fnt);
		    g.setColor(Color.white);
		    g.drawString("SELECT DIFFICULTY", 80, 70);
		
		    g.setFont(fnt2);
		    g.drawRect(210, 150, 200, 64);
		    g.drawRect(205, 145, 210, 74);
		    g.drawString("Normal", 255, 190);
		
		    g.drawRect(210, 250, 200, 64);
		    g.drawRect(205, 245, 210, 74);
		    g.drawString("Hard", 275, 290);
		
		    g.drawRect(210, 350, 200, 64);
		    g.drawRect(205, 345, 210, 74);
		    g.drawString("Back", 275, 390);
		    
		}	
	}
}
