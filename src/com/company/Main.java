package com.company;

import com.company.XmlObjects.Armor;
import com.company.XmlObjects.Character;
import com.company.XmlObjects.Weapon;

public class Main {

    public static void main(String[] args) {
//        String dec = Encoder.encode("---p ->");
//        System.out.println(dec);
//        System.out.println(Encoder.decode(dec));
        Armor armor = new Armor("1");
        Character hero = new Character("hero");
        Weapon weapon = new Weapon("sword");
        System.out.println(armor);
        System.out.println(hero);
        System.out.println(weapon);
    }
}