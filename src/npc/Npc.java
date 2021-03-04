package npc;

import data.Person;

public class Npc {
    public void interact(Person person) {
        int typeNPC = (int) (Math.random() * 101);       // there are 3 types of NPC (healer - 45% chance, magician - 45% chance, trader - 10% chance)

        if (typeNPC >= 1 && typeNPC <= 45) {            // an ordinary character (he gives health)
            Healer healer = new Healer();
            person = healer.sellHealth(person);
        } else if (typeNPC >= 46 && typeNPC <= 90) {     // an ordinary character (he gives mana)
            Magician magician = new Magician();
            person = magician.sellMana(person);
        } else if (typeNPC >= 91 && typeNPC <= 100) {    // rare character (he gives superstar)
            Trader trader = new Trader();
            person = trader.sellSuperstar(person);
        }
    }
}
