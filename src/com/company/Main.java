package com.company;


import manage.character;
import manage.testClass;

public class Main {

    public static void main(String[] args) {
	System.out.println("BATTLESIM - People will die \n");
	testClass.printSomething("Manage your army and defeat others.");



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



    }
}
