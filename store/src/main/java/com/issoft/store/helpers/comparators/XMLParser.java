package com.issoft.store.helpers.comparators;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParser {

    public static void main(String[] args) {
        try {
            XMLParser parser = new XMLParser();
            Map<String, String> allPropertiesToSort = parser.getAllPropertiesToSort();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    private String configFilePath = "store\\src\\main\\resources\\config.xml";

    public XMLParser() throws ParserConfigurationException, IOException, SAXException {
    }

    public Map<String, String> getAllPropertiesToSort() throws ParserConfigurationException, IOException, SAXException {

        String sortTag = "sort";
        Map<String, String> propertiesMap = new LinkedHashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(configFilePath);

        System.out.println(document);

        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);


            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                String key = elem.getTagName();
                String value = elem.getTextContent();
                propertiesMap.put(key, value);
            }

        }
        return propertiesMap;

    }
}
