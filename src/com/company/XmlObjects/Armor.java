package com.company.XmlObjects;

public class Armor extends XmlObject {
    private static final String fileName = "armor.xml";
    private static final String tagName = "armor";
    private static final String attributeName = "id";
    String armorName;

    public Armor(String name) {
        super(name, fileName, tagName, attributeName);
        this.armorName = name;
    }

    @Override
    public String toString() {
        return "Armor: " + armorName + super.toString();
    }
}
