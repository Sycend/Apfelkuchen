package GUI.Two;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDate {
	private static Vector date;
	private static Vector prefixDate;
	private static Vector measuresDate;

	public static Vector informationBox(String nodeName) {
		date = new Vector();
		prefixDate = new Vector();
		measuresDate = new Vector();
		final String XMLfileName = "tableConfig.xml";

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(XMLfileName);

			NodeList tableNameNodeList = document
					.getElementsByTagName(nodeName);

			int lenght = tableNameNodeList.item(0).getChildNodes().getLength();

			for (int i = 1; i < lenght; i = i + 2) {
				String familyAnnualAmount = tableNameNodeList.item(0)
						.getChildNodes().item(i).getTextContent();
				prefixDate.add(tableNameNodeList.item(0).getChildNodes()
						.item(i).getNodeName());
				date.add(familyAnnualAmount);

			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return date;

	}

	public static String dateLabels(String nodeName) {
		String date = null;
		final String XMLfileName = "labels.xml";

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(XMLfileName);
			NodeList tableNameNodeList = document
					.getElementsByTagName(nodeName);
			int lenght = tableNameNodeList.item(0).getChildNodes().getLength();

			date = tableNameNodeList.item(0).getChildNodes().item(0)
					.getTextContent();

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return date;

	}

	public static Vector informationBoxSI(String nodeName, String searchName) {

		final String XMLfileName = "nameMeasures.xml";
		int searchIndex = date.indexOf(searchName);
		String name = prefixDate.get(searchIndex).toString();
		

		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(XMLfileName);

			NodeList tableNameNodeList = document.getElementsByTagName(name);

			int lenght = tableNameNodeList.item(0).getChildNodes().getLength();

			for (int i = 0; i < lenght; i = i + 1) {
				String familyAnnualAmount = tableNameNodeList.item(0)
						.getChildNodes().item(i).getTextContent();

				measuresDate.add(familyAnnualAmount);
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return measuresDate;

	}

}
