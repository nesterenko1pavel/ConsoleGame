package npc;

import data.Person;

import java.util.Scanner;

public class Trader {
    public Person sellSuperstar(Person person) {
        Scanner scanCommand = new Scanner(System.in);
        Scanner scanOption = new Scanner(System.in);

        System.out.println("You meet a trader, he can exchange 100 money points for 1 superstar");
        System.out.print("print \"superstar\" to increase superstar >> ");

        String input = scanCommand.nextLine();

        if ("superstar".equals(input)) {
            if (person.getMoney() >= 100) {
                person.setMoney(person.getMoney() - 100);
                person.setSuperstar(person.getSuperstar() + 1);
                System.out.println("You got 1 superstar!");
            } else {
                System.out.println("Not enough money points, but you can dance tango and then I'll give you a superstar");
                System.out.print("yes/no >> ");
                if (scanOption.nextLine().equals("yes")) {
                    System.out.println("Because you danced tango, you got 50 years older, but also you got a super star");
                    person.setAge(person.getAge() + 50);
                    person.setSuperstar(person.getSuperstar() + 1);
                } else {
                    System.out.println("You have no idea what are you losing");
                }
            }
        } else {
            System.out.println("You have no idea what are you losing");
        }

        return person;
    }
}
