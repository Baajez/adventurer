package com.company.XmlObjects;

import com.company.Helpers.XmlReader;
import org.w3c.dom.Element;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class XmlObject {
    // elements
    // values
    private static final String resDirPath = "res/xmls/";
    Map<String, Vector<String>> details = new LinkedHashMap<>();

    XmlObject(String name, String fileName, String tagName, String attributeName) {
        Element current = XmlReader.getElement(resDirPath + fileName, tagName, attributeName, name);
        for (String child : XmlReader.getElementChildren(current)) {
            details.put(child, XmlReader.getElementValue(current, child));
        }
    }

    public void add(String key, String value) {
        if (details.containsKey(key)) {
            details.get(key).add(value);
        } else {
            Vector<String> toBeAdded = new Vector<>();
            toBeAdded.add(value);
            details.put(key, toBeAdded);
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (String s : details.keySet()) {
            result += "\n\t" + s + ": " + details.get(s);
        }
        return result + '\n';
    }
}
