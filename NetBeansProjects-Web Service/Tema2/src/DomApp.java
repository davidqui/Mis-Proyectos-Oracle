
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 *
 *Fecha     Sep 5, 2017
 * @author DAVID ANTONIO QUIJANO RAMOS
 */
public class DomApp {
    public static void main(String[] args) throws Exception{
        File fXmlFile = new File("c:/books.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);//se cargo y se valido
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());//trae el elemento raiz
        
        NodeList nList = doc.getElementsByTagName("book");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Autor :" + obtenerValorTag("author", eElement));
                
                 System.out.println("Precio :" + obtenerValorTag("price", eElement));
                
            }
            
        }
        
    }
    private static String obtenerValorTag(String sTag, Element eElement){
        NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node)nlList.item(0);
        return nValue.getNodeValue();
    }

}
