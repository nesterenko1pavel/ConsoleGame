package npc;

import data.Person;

import java.util.Scanner;

public class Magician {
    public Person sellMana(Person person) {
        Scanner scanCommand = new Scanner(System.in);

        System.out.println("You meet a magician, he can exchange 20 money points for 20 mana points");
        System.out.print("print \"mana\" to increase mana >> ");

        String input = scanCommand.nextLine();

        switch (input) {
            case "mana":
                if (person.getMoney() >= 20) {
                    person.setMoney(person.getMoney() - 20);
                    person.setMana(person.getMana() + 20);
                    System.out.println("You got 20 mana points!");
                } else {
                    System.out.println("Not enough money points");
                }
                break;
            default:
                System.out.println("Hum?");
                return person;
        }

        return person;
    }
}
