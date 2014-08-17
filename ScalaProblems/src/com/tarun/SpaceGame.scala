package com.tarun

import java.awt._
import javax.swing.{JFrame,JPanel}
import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.geom.AffineTransform
import com.tarun._
import java.awt.event._
import java.lang._
import scala.collection._

object SpaceGame {

  
  // An immutable, copy-on-write description of the entire game state.
class GameState {
	val player:Player 
	val bullets:ImmutableSet[Bullet]
	val keyboard:KeyboardState

	def this(player1: Player , bullets1 : ImmutableSet[Bullet] ,
			keyboard1:KeyboardState ) {
		this.Player = player1
		//this.bullets = bullets1;
		//this.keyboard = keyboard1;
	}

	GameState() {
		this(new Player(), new ImmutableSet<Bullet>(), new KeyboardState());
	}

	GameState setPlayer(Player newPlayer) {
		return new GameState(newPlayer, bullets, keyboard);
	}

	GameState setBullets(ImmutableSet<Bullet> newBullets) {
		return new GameState(player, newBullets, keyboard);
	}

	GameState setKeyboard(KeyboardState newKeyboard) {
		return new GameState(player, bullets, newKeyboard);
	}

	// Update the game state (repeatedly called for each game tick).
	GameState update() {
		GameState current = this;
		current = current.player.update(current);
		for (Bullet b : current.bullets)
			current = b.update(current);
		return current;
	}

	// Update the game state in response to a key press.
	GameState keyPressed(int key) {
		GameState current = this;
		current = keyboard.keyPressed(current, key);
		current = player.keyPressed(current, key);
		return current;
	}

	// Update the game state in response to a key release.
	GameState keyReleased(int key) {
		GameState current = this;
		current = keyboard.keyReleased(current, key);
		return current;
	}

	ImmutableImage render() {
		ImmutableImage img = new ImmutableImage(SpaceInvaders.W,
				SpaceInvaders.H);
		img = img.clear(Color.BLUE);
		img = player.render(img);
		for (Bullet b : bullets)
			img = b.render(img);
		return img;
	}
}

  
  
  class GameConstants{
	  val H = 640
	  val W = 480
	}
  
    def main(args: Array[String]): Unit = {
    
      //var sI = new SpaceInvaders
      var currentState : GameState = new GameState();
      var gc = new GameConstants()
       val f = new JFrame
       f.setBackground(Color.BLUE)
       f.setSize(gc.H , gc.W )
       f.setTitle("Play SpaceInvader by Tarun")
       f.setContentPane(new JPanel(){
         
         override def paintComponent(g : Graphics) ={
           val img : BufferedImage  = SpaceInvaders.currentState.render().backingImage;
           //val img : BufferedImage  = new BufferedImage(gc.W, gc.H, BufferedImage.TYPE_INT_RGB);
           (g.asInstanceOf[Graphics2D]).drawRenderedImage(img,new AffineTransform());
			//((Graphics2D) g).drawRenderedImage(img, new AffineTransform());
         }
       })
       
       f.addKeyListener(new KeyAdapter(){
			override def keyPressed(e : KeyEvent ) {
				println("tarun"+ e.getKeyCode())
				currentState = currentState.keyPressed(e.getKeyCode())
			}
			
			override def keyReleased(e : KeyEvent ) {
			  println("tarun key released"+ e.getKeyCode())
				currentState = currentState.keyReleased(e.getKeyCode())
			}
       })
       f.setLocationByPlatform(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
       f.setVisible(true)
       
       while(true){
    	   	currentState = currentState.update();
			f.repaint();
			try {
				Thread.sleep(20);
			} catch {
			  case e: InterruptedException => {} 
			}
       }
      
       
    }
    
    
}