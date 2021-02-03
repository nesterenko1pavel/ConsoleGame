package npc;

import data.Person;

import java.util.Scanner;

public class Healer {
    public Person sellHealth(Person person) {
        Scanner scanCommand = new Scanner(System.in);

        System.out.println("You meet a healer, he can exchange 20 mana points for 20 health points");
        System.out.print("print \"health\" to increase health >> ");

        String input = scanCommand.nextLine();

        switch (input) {
            case "health":
                if (person.getMana() >= 20) {
                    person.setMana(person.getMana() - 20);
                    person.setHealth(person.getHealth() + 20);
                    System.out.println("You got 20 health points!");
                } else {
                    System.out.println("Not enough mana points");
                }
                break;
            default:
                System.out.println("I don't understand your accent");
                return person;
        }

        return person;
    }
}
