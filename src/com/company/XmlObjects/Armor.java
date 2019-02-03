package com.company.XmlObjects;

public class Armor extends XmlObject {
    private static final String fileName = "armors.xml";
    private static final String tagName = "armor";
    private static final String attributeName = "id";

    public Armor(String id) {
        super(id, fileName, tagName, attributeName);
    }

    @Override
    public String toString(String prefix) {
        return prefix + "Armor: " + super.toString(prefix);
    }
}
