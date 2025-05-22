import java.util.ArrayList;
import java.util.Scanner;

public class Person {
  private int happiness;
  private int money;
  private int startingM;
  private int bet;
  private int position;
  private String name;
  private ArrayList<Item> items;

  public Person() {
    this.happiness = 0;
    this.money = 0;
    this.startingM = 0;
    this.position = 0;
    this.name = "";
    this.items = new ArrayList<Item>();
    assignItems();
  }

  public Person(String c, int p) {
    this.happiness = 100;
    this.money = (int) ((Math.random() * (20000 - 1000)) + 1000);
    this.startingM = money;
    this.position = p;
    this.name = c;
    this.items = new ArrayList<Item>();
    assignItems();
  }

  public void assignItems() {
    // House
    if (Math.random() < 0.8) {
      items.add(new Item("House", (int) (Math.random() * 40000) + 30000));
    }
    // Car
    items.add(new Item("Car", (int) (Math.random() * 20000) + 10000));
    // Wife
    if (Math.random() < 0.6) {
      items.add(new Wife());
    }
    // Kids
    if (Math.random() < 0.4) {
      items.add(new Item("Kids", (int) (Math.random() * 4000) + 500));
    }
  }

  public void sell() {
    if (items.size() == 0) {
      System.out.println("You don't have anything left to sell. \033[1;31mHA! HA! You're poor!\033[0m");
      return;
    }
    for (int i = 0; i < items.size(); i++) {
      System.out.println(i + 1 + ". " + items.get(i));
    }
    Scanner sc = new Scanner(System.in);
    System.out.print("Which object would you like to sell? (enter the number) ");
    while (!sc.hasNextInt()) {
      System.out.println("Invalid input. Put in an integer or I'll kill you.");
      sc.nextLine();
      System.out.print("Which object would you like to sell? ");
    }
    int n = sc.nextInt();
    if (n > 0 && n <= items.size()) {
      money += items.remove(n - 1).getValue();
    }
  }

  public void economy() {
    for (Item i : items) {
      i.changeValue((money * 1.0) / startingM);
    }
  }

  public int getHappiness() {
    return this.happiness;
  }

  public int getMoney() {
    return this.money;
  }

  public int getBet() {
    return this.bet;
  }

  public String getName() {
    if (0 < position && position < 7) {
      return "\033[0;3" + position + "m" + this.name + "\033[0m";
    }
    return this.name;
  }

  public void setHappiness(int h) {
    this.happiness = h;
  }

  public void setMoney(int m) {
    this.money = m;
  }

  public void setBet(int b) {
    this.bet = b;
  }

  public void useBet() {
    this.money -= bet;
  }

  public void useMoney(int m) {
    this.money -= m;
  }

  public void addMoney(int m) {
    this.money += m;
  }

  public void changeHappines(int matches) {
    if (matches == 0) {
      happiness -= (int) (5 * ((bet * 1.0) / (bet + money)));
    } else if (matches == 3) {
      happiness += (int) (10 * ((bet * 1.0) / (bet + money)));
    }
  }

  public String toString() {
    String str = getName() + " had $" + money + " and their happiness was " + happiness + "%. They owned ";
    for (int i = 0; i < items.size() - 1; i++) {
      str += items.get(i).normalize() + ", ";
    }
    if (items.size() > 1) {
      str += "and " + items.get(items.size() - 1).normalize();
    } else if (items.size() == 0) {
      str += "nothing";
    } else {
      str += items.get(0).normalize();
    }
    return str + ".";
  }
}