import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    System.out.println("This is a simulation of a slot machine using a computer.");
    System.out.println("Each time you 'pull' I will ask you if you wish to play again.");
    System.out.println("Just answer with a 'y' for yes or a 'n' for no.");
    System.out.println("The more you put in; the more you can get out. \n");

    SlotMachine slots = new SlotMachine();
    Scanner sc = new Scanner(System.in);
    boolean again = true;
    while(again) {
      slots.pull();
      System.out.print(slots + " - Again? ");
      String s = sc.next();
      sc.nextLine();
      again = s.equals("y");
    }
  }
  
}