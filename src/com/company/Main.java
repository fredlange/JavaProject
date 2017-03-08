package com.company;


import manage.character;

public class Main {

    public static void main(String[] args) {
	System.out.println("BATTLESIM - People will die \n");


	character char1 = new character("BigBoss");
	character char2 = new character("MegaLazer");

    System.out.println(char1.emote("greet"));
    System.out.println(char2.emote("greet"));


    // Pre battle status
    System.out.println(char1.name + " hp is " + char2.hp);
	System.out.println(char2.name + " hp is " + char2.hp);

	// Some mocking
    System.out.println(char1.emote("mock"));

    // Battle
    System.out.println("\n BATTLE");
	System.out.println(char1.name + " attacks " + char2.name);
	char1.attack(char2);

	System.out.println(char1.emote("drink"));

	System.out.println();

	// Post battle status
    System.out.println(char1.name + " hp is " + char1.hp);
    System.out.println(char2.name + " hp is " + char2.hp);


    System.out.println(char1.name + " location is " + char1.location[0]);
    System.out.println(char1.name + " location is " + char1.location[1]);
    char1.move(2,1);
    System.out.println(char1.name + " location is " + char1.location[0]);
    System.out.println(char1.name + " location is " + char1.location[1]);

    //char2.move(4,5);
    System.out.println(char1.name + " distance to " + char2.name + " is " +
        char1.scout(char2)
    );

    char1.attack(char2);


    }
}
