package com.company.Helpers;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

public class XmlReader {
    public static Vector<String> getElementValue(Element element, String tagName) {
        Vector<String> result = new Vector<>();
        Node node = element.getChildNodes().item(0);
        for (int i = 0; i < element.getChildNodes().getLength(); ++i) {
            String text = node.getTextContent();
            if (node.getNodeName().equals(tagName))
                result.add(text);
            node = node.getNextSibling();
        }
        return result;
    }

    public static Set<String> getElementChildren(Element element) {
        Set<String> result = new LinkedHashSet<>();
        for (int i = 0; i < element.getChildNodes().getLength(); ++i) {
            String str = element.getChildNodes().item(i).getNodeName();
            if (!str.equals("#text"))
                result.add(str);
        }
        return result;
    }

    /**
     * @param filePath  xml file path
     * @param tagName   desired element's tag name
     * @param attrName  attribute name which's name looking for
     * @param attrValue given attribute's value
     */
    public static Element getElement(String filePath, String tagName, String attrName, String attrValue) {
        Document doc = getDocument(filePath);
        NodeList nodeList = doc.getElementsByTagName(tagName);
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getAttribute(attrName).equals(attrValue)) {
                    return element;
                }
            }
        }
        return null;
    }

    @Nullable
    private static Document getDocument(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(path));
            document.getDocumentElement().normalize();
            return document;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
