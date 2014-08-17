package com.scala

import java.awt._
import javax.swing.{JFrame,JPanel}
import java.awt.Color
import java.awt.image.BufferedImage
import java.awt.geom.AffineTransform

object game {

  class GameConstants{
	  val H = 640
	  val W = 480
	}
  
    def main(args: Array[String]): Unit = {
    
      //var sI = new SpaceInvaders
      var gc = new GameConstants()
       val f = new JFrame
       f.setBackground(Color.BLUE)
       f.setSize(gc.H , gc.W )
       f.setTitle("Play SpaceInvader by Tarun")
       f.setContentPane(new JPanel(){
         
         override def paintComponent(g : Graphics) ={
           val img : BufferedImage  = new BufferedImage(gc.W, gc.H, BufferedImage.TYPE_INT_RGB);
           (g.asInstanceOf[Graphics2D]).drawRenderedImage(img,new AffineTransform());
			//((Graphics2D) g).drawRenderedImage(img, new AffineTransform());
         }
       })
       f.setLocationByPlatform(true);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
       f.setVisible(true)
       
    }

}