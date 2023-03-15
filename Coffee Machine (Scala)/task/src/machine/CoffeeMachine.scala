package machine

object CoffeeMachine {
  //  println("Starting to make a coffee\n" +
  //    "Grinding coffee beans\n" +
  //    "Boiling water\n" +
  //    "Mixing boiled water with crushed coffee beans\n" +
  //    "Pouring coffee into the cup\n" +
  //    "Pouring some milk into the cup\n" +
  //    "Coffee is ready!")
  //  println("Write how many ml of water the coffee machine has:")
  //  private val amountWater : Int = scala.io.StdIn.readInt()
  //  println("Write how many ml of milk the coffee machine has:")
  //  private val amountMilk : Int = scala.io.StdIn.readInt()
  //  println("Write how many grams of coffee beans the coffee machine has:")
  //  private val amountCoffee : Int = scala.io.StdIn.readInt()
  //  println("Write how many cups of coffee you will need:")
  //  private val numberOfCoffeeCups : Int = scala.io.StdIn.readInt()
  private var amountWater: Int = 400
  private var amountCoffee: Int = 120
  private var amountMilk: Int = 540
  private var numberOfCoffeeCups: Int = 9
  private var amountOfMoney: Int = 550
  private var state: String = "ACTION"

  def printStatusMachine(): Unit = {
    println(
      s"""The coffee machine has:
         |$amountWater ml of water
         |$amountMilk ml of milk
         |$amountCoffee g of coffee beans
         |$numberOfCoffeeCups disposable cups
         |$$$amountOfMoney of money""".stripMargin)
  }

  def buyCoffee(option: String): Unit = {
    option match {
      case "1" =>
        if (checkCoffeeCups(250, 1, 16)) {
          this.amountWater -= 250
          this.amountCoffee -= 16
          this.amountOfMoney += 4
          this.numberOfCoffeeCups -= 1
        }
      case "2" =>
        if (checkCoffeeCups(350, 75, 20)) {
          this.amountWater -= 350
          this.amountMilk -= 75
          this.amountCoffee -= 20
          this.amountOfMoney += 7
          this.numberOfCoffeeCups -= 1
        }
      case "3" =>
        if (checkCoffeeCups(200, 100, 12)) {
          this.amountWater -= 200
          this.amountMilk -= 100
          this.amountCoffee -= 12
          this.amountOfMoney += 6
          this.numberOfCoffeeCups -= 1
        }
      case "back" =>
        println()
        promptAction()
    }
    this.state = "ACTION"
    println()
    promptAction()

  }

  def fillMachine(): Unit = {
    println("Write how many ml of water you want to add: ")
    this.amountWater += scala.io.StdIn.readInt()
    println("Write how many ml of milk you want to add: ")
    this.amountMilk += scala.io.StdIn.readInt()
    println("Write how many grams of coffee beans you want to add: ")
    this.amountCoffee += scala.io.StdIn.readInt()
    println("Write how many disposable cups you want to add: ")
    this.numberOfCoffeeCups += scala.io.StdIn.readInt()
  }


  def checkCoffeeCups(minWater: Int, minMilk: Int, minCoffee: Int): Boolean = {
    if (this.numberOfCoffeeCups == 0) {
      println("Sorry, not enough coffee cups!")
      return false
    }
    val cupsWater: Int = this.amountWater / minWater
    if (cupsWater == 0) {
      println("Sorry, not enough water!")
      return false
    }
    val cupsMilk: Int = this.amountMilk / minMilk
    if (cupsMilk == 0) {
      println("Sorry, not enough milk!")
      return false
    }
    val cupsCoffee: Int = this.amountCoffee / minCoffee
    if (cupsCoffee == 0) {
      println("Sorry, not enough coffee beans!")
      return false
    }
    println("I have enough resources, making you a coffee!")
    true
  }

  def handleInput(userInput: String): Unit = {
    this.state match {
      case "ACTION" =>
        println()
        userInput match {

          case "buy" =>
            this.state = "BUY"
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
          case "fill" =>
            fillMachine()
          case "take" =>
            println(s"I gave you $$${
              this.amountOfMoney
            }")
            this.amountOfMoney = 0
          case "remaining" =>
            printStatusMachine()
          case "exit" =>
            this.state = "EXIT"
        }
      case "BUY" =>
        buyCoffee(userInput)
    }
  }

  def promptAction(): Unit = {
    println("Write action (buy, fill, take, remaining, exit): ")

  }

  def main(args: Array[String]): Unit = {
    println("Write action (buy, fill, take, remaining, exit): ")
    while (this.state != "EXIT") {
      val userInput = scala.io.StdIn.readLine()
      handleInput(userInput)
    }


  }
}

//  println("Write action (buy, fill, take, remaining, exit): ")
//  var inputUser = scala.io.StdIn.readLine()
//  while (inputUser != "exit") {
//    println()
//    inputUser match {
//      case "buy" =>
//        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
//        val inputUser = scala.io.StdIn.readLine()
//        buyCoffee(inputUser)
//      case "fill" => fillMachine()
//      case "take" =>
//        println(s"I gave you $$${this.amountOfMoney}")
//        this.amountOfMoney = 0
//      case "remaining" =>
//        printStatusMachine()
//    }
//    println()
//    println("Write action (buy, fill, take, remaining, exit): ")
//    inputUser = scala.io.StdIn.readLine()


//  if (numberOfCoffeeCups > numberOfPossibleCups) {
//    println(s"No, I can make only $numberOfPossibleCups cup(s) of coffee")
//  } else if (numberOfPossibleCups > numberOfCoffeeCups) {
//    println(s"Yes, I can make that amount of coffee (and even ${numberOfPossibleCups - numberOfCoffeeCups}" +
//      s" more than that)")
//  } else {
//    println("Yes, I can make that amount of coffee ")
//  }


//  println(s"For $numberOfCoffeeCups cups of coffee you will need:")
//  println(s"${numberOfCoffeeCups * 200} ml of water")
//  println(s"${numberOfCoffeeCups * 50} ml of milk")
//  println(s"${numberOfCoffeeCups * 15} g of coffee beans")
