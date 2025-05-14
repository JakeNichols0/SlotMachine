import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    SlotMachine slots = new SlotMachine();
    Scanner sc = new Scanner(System.in);
    //Create the person
    System.out.print("What's your name? ");
    Person p = new Person(sc.nextLine());
    System.out.println("You have $" + p.getMoney());
    //Ask for bet
    System.out.print("How much money? $");
    int bet = sc.nextInt();
    sc.nextLine();
    p.useMoney(bet);
    while(bet > 0) {
      //Play the game
      slots.pull(bet);
      System.out.println(slots);
      p.addMoney(slots.getWinnings());
      System.out.println("Your current happiness is " + p.getHappiness());
      System.out.print("You have $" + p.getMoney() + " How you bettin' bbg? $");
      bet = sc.nextInt();
      sc.nextLine();
      while (bet > p.getMoney()) {
        System.out.print("You can't bet more money than you have. How you bettin' bbg? $");
        bet = sc.nextInt();
        sc.nextLine();
      }
      p.useMoney(bet);
    }
    System.out.println("\033[0;31mGAME OVER!\033[0;37m - you had $" + p.getMoney() + " Your happiness was " + p.getHappiness());
  }
  
}