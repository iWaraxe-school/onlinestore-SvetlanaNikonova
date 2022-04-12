package com.issoft.store.helpers.comparators;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class XMLParser {

    private String configFilePath = "store\\src\\main\\resources\\config.xml";

    public XMLParser() throws ParserConfigurationException, IOException, SAXException {
    }

    public Map<String, String> getAllPropertiesToSort() throws ParserConfigurationException, IOException, SAXException {

        String sortTag = "sort";
        Map<String, String> propertiesMap = new LinkedHashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(configFilePath);



        return propertiesMap;
    }

}
