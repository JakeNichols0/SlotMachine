import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    public int happiness;
    public int money;
    private String name;
    private ArrayList<Item> items;
    
    public Person() {
        this.happiness = 0;
        this.money = 0;
        this.name = "";
        this.items = new ArrayList<Item>();
        assignItems();
    }
  public Person(String c) {
      this.happiness = 100;
      this.money = (int) ((Math.random() * (20000 - 1000)) + 1000);
      this.name = c;
      this.items = new ArrayList<Item>();
      assignItems();
  }

  public void assignItems() {
    //House
    if(Math.random() < 0.8) {
      items.add(new Item("House", (int) (Math.random() * 40000) + 30000));
    }
    //Car
    items.add(new Item("Car", (int) (Math.random() * 20000) + 10000));
    //Wife
    if(Math.random() < 0.6) {
      items.add(new Wife());
    }
    //Kids
    if(Math.random() < 0.4) {
      items.add(new Item("Kids", (int) (Math.random() * 4000) + 500));
    }
  }
  
  public void sell() {
    for(int i=0; i<items.size(); i++) {
      System.out.println(i + ". " + items.get(i));
    }
    Scanner sc = new Scanner(System.in);
    System.out.print("Which item would you like to sell? ");
    int n = sc.nextInt();
    money += items.remove(n).getValue();
  }
  
  public int getHappiness() {
    return this.happiness;
  }

  public int getMoney() {
    return this.money;
  }

  public String getName() {
    return this.name;
  }
  public int setHappiness(int h)
    {return this.happiness = h;}
  
  public int setMoney(int m)
    {return this.money = m;}
  
  public void useMoney(int m)
    {this.money -= m;} 
  public void addMoney(int m)
  {this.money += m;}

  public void changeHappines(int matches) {
    

      if(matches == 0) {
       happiness -= 5;
     } else if (matches == 3) {
       happiness += 10;
      }
    }

  
}