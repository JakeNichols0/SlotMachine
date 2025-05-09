public class Person {
    public int happiness;
    public int money;
    private String name;
    public Person() {
        this.happiness = 0;
        this.money = 0;
        this.name = "";
    }
  public Person(String c) {
      this.happiness = 100;
      this.money = (int) ((Math.random() * (20000 - 1000)) + 1000);
      this.name = c;
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
}