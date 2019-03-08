package com.svs.oop;

/**
 * @author baike
 */
public class InterfaceTest {
    public static void main(String[] args) {
        Dog myDog = new Dog();

        myDog.setName("Snoop Dogg");
        System.out.println(myDog.getName());

        myDog.beFriendly();
    }
}
