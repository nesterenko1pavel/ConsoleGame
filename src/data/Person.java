package data;

public class Person extends Movement {
    private final String name;
    private int age;

    private int health = 60;
    private int mana = 20;
    private int money = 120;

    private int superstar = 0;

    public Person(String name, int age) {
        super(-1, -1);
        this.name = name;
        this.age = age;
    }

    public Person() {
        super(-1, -1);
        this.name = "Player";
        this.age = 18;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSuperstar() {
        return superstar;
    }

    public void setSuperstar(int superstar) {
        this.superstar = superstar;
    }

    public void stats() {
        System.out.println("Name: " + name + ", age: " + age + ", health: " + health + ", mana: " + mana + ", money: " + money + ", superstar: " + superstar);
    }
}
