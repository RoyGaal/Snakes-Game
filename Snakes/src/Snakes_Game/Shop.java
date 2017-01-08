package Snakes_Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter{
	
	Handler handler;
	HUD hud;
	
	private int B1 = 100; //Upgrade Health
	private int B2 = 200; //Upgrade Speed
	private int B3 = 250; //Refill Health
	
	public Shop(Handler handler, HUD hud){
		this.handler = handler;
		this.hud = hud;
	}
	
	public void render(Graphics g){
		g.setColor(Color.white);
		g.setFont(new Font("arial", 70, 38));
		g.drawString("WELCOME TO THE SHOP", 70, 50);
		g.drawString("---------------------------------------", 50, 68);
		
		//box 1
		g.setFont(new Font("arial", 0, 12));
		g.drawString("Upgrade Health", 60, 160);
		g.drawString("Cost: " + B1 + " points", 60, 180);
		g.drawRect(50, 130, 120, 80);
		g.drawRect(45, 125, 130, 90);
		
		//box 2
		g.drawString("Upgrade Speed", 260, 160);
		g.drawString("Cost: " + B2 + " points", 260, 180);
		g.drawRect(250, 130, 120, 80);
		g.drawRect(245, 125, 130, 90);
		
		//box 3
		g.drawString("Refill Health", 460, 160);
		g.drawString("Cost: " + B3 + " points", 460, 180);
		g.drawRect(450, 130, 120, 80);
		g.drawRect(445, 125, 130, 90);
		
		
		g.drawString("SCORE: " + hud.getScore() + " points", Game.WIDTH/2 - 65, 300);
		g.drawString("Press SPACE to go back to the game.", Game.WIDTH/2 - 120, 330);
	}
	
	public void mousePressed(MouseEvent e){
		int mx = e.getX();
		int my = e.getY();
		
		//box 1
		if(mx >= 100 && mx <= 200){
			if(my >= 100 && my <= 180){
				if(hud.getScore() >= B1){
					hud.setScore(hud.getScore() - B1);
					B1 += 100;
					hud.bounds += 20;
					hud.HEALTH = (100 + (hud.bounds/2));
				}
			}
		}
		
		//box 2
		if(mx >= 250 && mx <= 350){
			if(my >= 100 && my <= 180){						
				if(hud.getScore() >= B2){
					hud.setScore(hud.getScore() - B2);
					B2 += 100;
					handler.speed++;
				}
			}
		}
		
		//box 3
		if(mx >= 400 && mx <= 500){
			if(my >= 100 && my <= 180){
				if(hud.getScore() >= B3){
					hud.setScore(hud.getScore() - B3);
					hud.HEALTH = (100 + (hud.bounds/2));
				}
			}
		}
	}

}
