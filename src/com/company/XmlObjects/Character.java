package com.company.XmlObjects;

public class Character extends XmlObject {
    private static final String fileName = "characters.xml";
    private static final String tagName = "character";
    private static final String attributeName = "name";
    String charName;

    public Character(String name) {
        super(name, fileName, tagName, attributeName);
        this.charName = name;
    }

    @Override
    public String toString() {
        return "Character: " + charName + super.toString();
    }
}
