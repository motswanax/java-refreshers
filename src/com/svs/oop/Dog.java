package com.svs.oop;

public class Dog extends Canine implements Pet {
    @Override
    public void beFriendly() {
        System.out.println("Be friendly Snoop!");
    }

    @Override
    public void play() {
        System.out.println("Play now.");
    }
}
