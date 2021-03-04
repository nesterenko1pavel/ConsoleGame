package data;

import npc.Npc;

public class Events {
    public void actions(int event, Person person) {
        switch (event) {
            case 0:
                break;
            case 2:
                int countMoney = (int) (1 + Math.random() * 50);
                System.out.println("You found " + countMoney + " points of money!");
                person.setMoney(person.getMoney() + countMoney);
                break;
            case 3:
                int countHealth = (int) (1 + Math.random() * 20);
                System.out.println("You met an enemy and lost " + countHealth + " health points!");
                person.setHealth(person.getHealth() - countHealth);
                break;
            case 4:
                int countMana = (int) (1 + Math.random() * 20);
                System.out.println("You found " + countMana + " mana points!");
                person.setMana(person.getMana() + countMana);
                break;
            case 5:
                Npc npc = new Npc();
                npc.interact(person);
                break;
            case 6:
                System.out.println("You've found a superstar!");
                person.setSuperstar(person.getSuperstar() + 1);
                break;
        }
    }
}
