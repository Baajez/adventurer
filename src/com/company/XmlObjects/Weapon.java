package com.company.XmlObjects;

public class Weapon extends XmlObject {
    private static final String fileName = "weapons.xml";
    private static final String tagName = "weapon";
    private static final String attributeName = "id";

    public Weapon(String id) {
        super(id, fileName, tagName, attributeName);
    }

    @Override
    public String toString(String prefix) {
        return prefix + "Weapon: " + super.toString(prefix);
    }
}
