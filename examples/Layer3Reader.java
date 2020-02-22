package examples;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Layer3Reader {
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
        	File fXmlFile = new File("layer3.conf");
        	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        	Document doc = dBuilder.parse(fXmlFile);

        	//optional, but recommended
        	doc.getDocumentElement().normalize();

        	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
        	
        	NodeList nList = doc.getElementsByTagName("ClassSubstitutionDetails");
        	System.out.println("----------------------------");
        	
        	for (int temp = 0; temp < nList.getLength(); temp++) {

        		org.w3c.dom.Node nNode =  nList.item(temp);
        		Element eElement = (Element) nNode;
        		System.out.println("\nCurrent Element :" + ((org.w3c.dom.Node) nNode).getNodeName());
        		System.out.println(eElement.getElementsByTagName("SourceClass"));
        		System.out.println(eElement.getElementsByTagName("TargetClass"));
        		

        		
        	}
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
        	
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}