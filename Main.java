import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
  private static Scanner sc = new Scanner(System.in);
  private static Person[] players;
  private static boolean repeat = true;
  
  public static void main(String[] args) {
    SlotMachine slots = new SlotMachine();
    //Begin the game
    System.out.print("How many players? ");
    while (!sc.hasNextInt()) {
      System.out.println("Invalid input. Put in an integer or I'll kill you.");
      sc.nextLine();
      System.out.print("How many players? ");
    }
    players = new Person[sc.nextInt()];
    sc.nextLine();
    //Create the people
    for(int i=0; i<players.length; i++) {
      System.out.print("What's player " + (i + 1) + "'s name? ");
      players[i] = new Person(sc.nextLine(), i+1);
    }
    //Ask for bet
    betting();
    while(repeat) {
      //Play the game
      slots.pull();
      System.out.println(slots);
      for(Person p : players) {
        p.addMoney((int) (slots.getWinnings() * p.getBet()));
        p.changeHappines(slots.getMatches());
        System.out.println(p.getName() + ", you won $" + (int) (slots.getWinnings() * p.getBet()) + ". Your current happiness is " + p.getHappiness() + ". ");
        System.out.print("You have $" + p.getMoney() + ". Would you like to sell something (y/n)? ");
        if(sc.nextLine().equals("y")) {
          p.sell();
        }
        p.economy();
      }
      betting();
    }
    slots.pull();
    System.out.println(slots);
    for(Person p : players) {
      p.addMoney((int) (slots.getWinnings() * p.getBet()));
      p.changeHappines(slots.getMatches());
      System.out.println(p.getName() + ", you won $" + (int) (slots.getWinnings() * p.getBet()));
    }
    //end the game
    sc.close();
    System.out.println("\033[1;31mGAME OVER!\033[0m");
    for(Person p : players) {
      System.out.println(p);
    }
  }

  public static void betting() {
    for(Person p : players) {
      System.out.print(p.getName() + ", you have $" + p.getMoney() + ". How you bettin' bbg? $");
      while (!sc.hasNextInt()) { //Makes sure that they entered an int
        System.out.println("Invalid input. Put in an integer or I'll kill you.");
        sc.nextLine();
        System.out.print("How you bettin' bbg? $");
      }
      p.setBet(sc.nextInt());
      sc.nextLine();
      while (p.getBet() > p.getMoney()) {
        System.out.print("You can't bet more money than you have. How you bettin' bbg? $");
        p.setBet(sc.nextInt());
        sc.nextLine();
      }
      if(p.getBet() <= 0 || p.getHappiness() <= 0) {
        repeat = false;
      } else {
        p.useBet();
      }
    }
  }
}