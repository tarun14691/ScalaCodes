package com.tarun.scala

object ScalaCode {

  //Problem S-01 
  def last[Int](l: List[Int]) : Int = {
    //different ways to calculate 
    //way1
    //val x = l.last
    
    //way2
    val x = l.reverse.head
    
    //return value
    x
  }
  
  //Problem S-02
  def penultimate[Int](l: List[Int]) : Int = {
    val x = l.init.last
    
    //return value
    x
  }
  
  def main(args: Array[String]): Unit = {
		  
	//For problem S01
    val lst  = List(1,2,3,4,2,8)
	println("Solution of problem one : "+ last(lst))
	println("Solution of problem two : "+ penultimate(lst))
    
  }

}