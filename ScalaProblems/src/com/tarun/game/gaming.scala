package com.tarun.game

import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.geom.AffineTransform
import java.awt.image.BufferedImage
import javax.swing.{JFrame,JPanel}
import java.awt.Color

object gaming {
	
	class GameConstants{
	  val H = 640
	  val W = 480
	}
  
    def main(args: Array[String]): Unit = {
    
       var gc = new GameConstants()
       val f = new JFrame
       //f.setBackground(Color.BLUE)
       f.setSize(gc.H , gc.W )
       f.setTitle("Play SpaceInvader by Tarun")
       f.setContentPane(new JPanel(){
         
         override def paintComponent(g : Graphics) : Graphics{
           
         }
       })
       f.setLocationByPlatform(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
       f.setVisible(true)
       
    }

  

}