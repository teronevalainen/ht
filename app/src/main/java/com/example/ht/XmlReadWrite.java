package com.example.ht;

import android.content.Context;
import android.content.ContextWrapper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XmlReadWrite {
    ContextWrapper contextWrapper;

    private static XmlReadWrite instance = new XmlReadWrite();

    public static XmlReadWrite getInstance() {
        return instance;
    }


    public void readXML(Context context) {
        contextWrapper = new ContextWrapper(context);

        String filePath = contextWrapper.getFilesDir().toString();
        filePath = filePath + "/XmlEventApp.xml";
        File xmlFile = new File(filePath);
        EventList events = EventList.getInstance();
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodelist = doc.getDocumentElement().getElementsByTagName("Event");

            for (int i = 0; i < nodelist.getLength(); i++) {
                Node node = nodelist.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;
                    String ename = element.getElementsByTagName("name").item(0).getTextContent();
                    String estart = element.getElementsByTagName("start").item(0).getTextContent();
                    String eend = element.getElementsByTagName("end").item(0).getTextContent();
                    String eplace = element.getElementsByTagName("place").item(0).getTextContent();
                    String edate = element.getElementsByTagName("date").item(0).getTextContent();
                    String einfo = element.getElementsByTagName("info").item(0).getTextContent();
                    String eage = element.getElementsByTagName("age").item(0).getTextContent();
                    String evisitors = element.getElementsByTagName("visitors").item(0).getTextContent();

                    events.CreateEvent(ename, estart, eend, eplace, edate, einfo, eage, evisitors);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done reading from: " + filePath);
        }
    }

    /*
        https://examples.javacodegeeks.com/core-java/xml/parsers/documentbuilderfactory/create-xml-file-in-java-using-dom-parser-example/
    */
    public void writeXML(Context context) {
        contextWrapper = new ContextWrapper(context);
        String filePath = contextWrapper.getFilesDir().toString();
        filePath = filePath + "/XmlEventApp.xml";

        ArrayList<Event> events = EventList.getInstance().getEvents();

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            for (int i = 0; i < events.size(); i++) {
                Event event = events.get(i);

                Element root0 = document.createElement("Events");

                Element root = document.createElement("Event");
                root0.appendChild(root);

                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(event.getName()));
                root.appendChild(name);

                Element start = document.createElement("start");
                start.appendChild(document.createTextNode(event.getStart()));
                root.appendChild(start);

                Element end = document.createElement("end");
                end.appendChild(document.createTextNode(event.getEnd()));
                root.appendChild(end);

                Element place = document.createElement("place");
                place.appendChild(document.createTextNode(event.getPlace()));
                root.appendChild(place);

                Element date = document.createElement("date");
                date.appendChild(document.createTextNode(event.getDate()));
                root.appendChild(date);

                Element info = document.createElement("info");
                info.appendChild(document.createTextNode(event.getInfo()));
                root.appendChild(info);

                Element age = document.createElement("age");
                age.appendChild(document.createTextNode(event.getAge()));
                root.appendChild(age);

                Element visitors = document.createElement("visitors");
                visitors.appendChild(document.createTextNode(event.getVisitors()));
                root.appendChild(visitors);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filePath));

            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException te) {
            te.printStackTrace();
        } finally {
            System.out.println("Initialized xml file to: " + filePath);
        }

    }
}

