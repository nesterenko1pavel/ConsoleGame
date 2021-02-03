package main;

import data.Events;
import data.Person;
import mapGrid.MapGrid;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanCommand = new Scanner(System.in);
        Scanner scanCoordinates = new Scanner(System.in);
        Scanner scanDirection = new Scanner(System.in);
        Scanner scanNote = new Scanner(System.in);

        MapGrid objMap = new MapGrid(7, 5);           // map
        Person person = new Person("Player1", 18);          // player
        Events act = new Events();                              // actions with other objects on the map

        ArrayList<String> notes = new ArrayList<>();            // notes

        objMap.printGrid(person);

        String command;

        while (true) {
            System.out.println("you can use: exit, setXY, setDefaultXY, go, generateResources, stats, addNote, deleteNote, checkNotes");
            System.out.print(">> ");
            command = scanCommand.nextLine();

            switch (command) {
                case "exit":
                    System.out.println("See you later!");
                    return;
                case "setXY":                               // setting the position of a player on the map
                    if (!person.getIsOnMap()) {
                        System.out.print("x: ");
                        person.setX(scanCoordinates.nextInt());

                        System.out.print("y: ");
                        person.setY(scanCoordinates.nextInt());

                        int error = objMap.pos(person.getX(), person.getY());

                        if (error != 400 && error != 401) {                     // checking is the player really on the map
                            person.setIsOnMap(true);                            // 400 - shows that the player wanted to place himself on another object
                        }                                                       // 401 - shows that x and y are wrong
                        objMap.printGrid(person);
                    } else {
                        System.out.println("Player already on the map");
                    }

                    break;
                case "setDefaultXY":
                    if (!person.getIsOnMap()) {
                        person.setX((objMap.getSizeMiniMap() - 1) / 2);
                        person.setY((objMap.getSizeMiniMap() - 1) / 2);

                        objMap.pos(person.getX(), person.getY());   // setting the position of a player on the map
                        objMap.printGrid(person);

                        person.setIsOnMap(true);    // player on the map - flag
                    } else {
                        System.out.println("Player already on the map");
                    }

                    break;
                case "go":
                    if (person.getIsOnMap()) {
                        System.out.print("direction <top, bottom, left, right>:  ");
                        String direction = scanDirection.nextLine();

                        int event;

                        switch (direction) {
                            case "top":
                                if (objMap.getLastX() - 1 >= 0) {
                                    person.setX(person.getX() - 1);
                                    event = objMap.pos(person.getX(), person.getY());

                                    objMap.printGrid(person);
                                    person = act.actions(event, person);
                                } else {
                                    objMap.expandSize();

                                    person.setX(person.getX() - 1);

                                    event = objMap.pos(person.getX(), person.getY());

                                    objMap.printGrid(person);
                                    System.out.println("the boundaries of the world have been expanded!");
                                    person = act.actions(event, person);
                                }

                                break;
                            case "bottom":
                                if (objMap.getLastX() + 1 < objMap.getSize()) {
                                    person.setX(person.getX() + 1);
                                    event = objMap.pos(person.getX(), person.getY());

                                    objMap.printGrid(person);
                                    person = act.actions(event, person);
                                } else {
                                    objMap.expandSize();

                                    person.setX(person.getX() + 1);

                                    event = objMap.pos(person.getX(), person.getY());

                                    objMap.printGrid(person);
                                    System.out.println("the boundaries of the world have been expanded!");
                                    person = act.actions(event, person);
                                }

                                break;
                            case "left":
                                if (objMap.getLastY() - 1 >= 0) {
                                    person.setY(person.getY() - 1);
                                    event = objMap.pos(person.getX(), person.getY());

                                    objMap.printGrid(person);
                                    person = act.actions(event, person);
                                } else {
                                    objMap.expandSize();

                                    person.setY(person.getY() - 1);

                                    event = objMap.pos(person.getX(), person.getY());

                                    objMap.printGrid(person);
                                    System.out.println("the boundaries of the world have been expanded!");
                                    person = act.actions(event, person);
                                }

                                break;
                            case "right":
                                if (objMap.getLastY() + 1 < objMap.getSize()) {
                                    person.setY(person.getY() + 1);
                                    event = objMap.pos(person.getX(), person.getY());

                                    objMap.printGrid(person);
                                    person = act.actions(event, person);
                                } else {
                                    objMap.expandSize();

                                    person.setY(person.getY() + 1);

                                    event = objMap.pos(person.getX(), person.getY());

                                    objMap.printGrid(person);
                                    System.out.println("the boundaries of the world have been expanded!");
                                    person = act.actions(event, person);
                                }

                                break;
                            default:
                                System.out.println("incorrect direction");
                        }               // movement of the character

                        person.setAge(person.getAge() + 1);         // with each move the player is one point older
                    } else {
                        System.out.println("You should set coordinates of the player");
                    }

                    break;
                case "generateResources":
                    objMap.generateResources(objMap.getGrid(), objMap.getSize());
                    objMap.printGrid(person);

                    break;
                case "stats":
                    if (person.getIsOnMap()) {
                        person.stats();
                    } else {
                        System.out.println("You should set coordinates of the player");
                    }

                    break;
                case "addNote":
                    System.out.print("write what you want to write down in notes >> ");
                    notes.add(scanNote.nextLine());
                    break;
                case "deleteNote":
                    if (notes.size() != 0) {
                        System.out.print("write the number of the note you want to delete >> ");
                        int index = scanNote.nextInt() - 1;
                        if (index >= 0 && index < notes.size()) {
                            notes.remove(index);
                        } else {
                            System.out.println("there is no such number");
                        }
                    } else {
                        System.out.println("Your notes are empty");
                    }

                    break;
                case "checkNotes":
                    if (notes.size() != 0) {
                        for (int i = 0; i < notes.size(); i++) {
                            System.out.println((i + 1) + ": " + notes.get(i));
                        }
                    } else {
                        System.out.println("Your notes are empty");
                    }

                    break;
                default:
                    System.out.println("Incorrect command");

                    break;
            }

            if (person.getHealth() <= 0) {
                person.stats();
                System.out.println("You have lost all health points - game over");      // player died
                return;
            } else if (person.getAge() > 100) {                        // you have a limited number of steps
                person.stats();
                System.out.println("You died of old age - game over");      // player died
                return;
            } else if (person.getSuperstar() >= 3) {
                System.out.println(new Date(System.currentTimeMillis()));
                person.stats();
                System.out.println("You scored 3 superstars. This is victory!");            // you've won
                return;
            }
        }


    }


}
