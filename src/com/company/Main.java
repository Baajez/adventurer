package com.company;

import com.company.XmlObjects.Character;

public class Main {

    public static void main(String[] args) {
        Character hero = new Character("0");
        System.out.println(Encoder.encode(hero.toString()));
        System.out.println(Encoder.decode(Encoder.encode(hero.toString())));
    }
}