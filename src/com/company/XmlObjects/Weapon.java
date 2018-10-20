package com.company.XmlObjects;

public class Weapon extends XmlObject {
    private static final String fileName = "weapons.xml";
    private static final String tagName = "weapon";
    private static final String attributeName = "name";
    String weaponName;

    public Weapon(String name) {
        super(name, fileName, tagName, attributeName);
        this.weaponName = name;
    }

    @Override
    public String toString() {
        return "Weapon: " + weaponName + super.toString();
    }
}
