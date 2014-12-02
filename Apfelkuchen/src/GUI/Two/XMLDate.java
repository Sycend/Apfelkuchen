package GUI.Two;

import java.io.IOException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDate {
	private static Vector<String> date;
	private static Vector<String> prefixDate;
	private static Vector<String> measuresDate;

	public static Vector<String> informationBox(String nodeName) {
		date = new Vector<String>();
		prefixDate = new Vector<String>();
		measuresDate = new Vector<String>();
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
			//int lenght = tableNameNodeList.item(0).getChildNodes().getLength();

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

	public static Vector<String> informationBoxSI(String nodeName, String searchName) {

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
