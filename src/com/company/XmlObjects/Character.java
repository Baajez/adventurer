package com.company.XmlObjects;

public class Character extends XmlObject {
    private static final String fileName = "characters.xml";
    private static final String tagName = "character";
    private static final String attributeName = "id";
    public Armor armor;
    public Weapon weapon;

    public Character(String id) {
        super(id, fileName, tagName, attributeName);
        this.armor = new Armor(details.get("armor").get(0));
        this.weapon = new Weapon(details.get("weapon").get(0));
    }

    @Override
    public String toString() {
        return "Character: " + details.get("name").get(0) + "\n" + armor.toString("\t") + weapon.toString("\t");
    }
}
