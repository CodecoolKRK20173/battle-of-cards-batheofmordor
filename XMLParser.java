import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLParser implements CardDAO, Interface {

    public List<Card> cardList = new ArrayList<>();
    public Document document;
    String pathName;

    public XMLParser(String pathName) {
        this.cardList = cardList;
        this.document = document;
        this.pathName = pathName;
        convertXML();
    }

     @Override
    public void addToListOfCards(Card card) {
        cardList = getCardList();
        cardList.add(card);
      //  pomCardList.add(card);
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public Document loadXmlDocument(String pathName) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            document = builder.parse(new FileInputStream(pathName));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public void convertXML() {
//        List<Card> cardsList = new ArrayList<>();
       // cardList.clear();
        Document document = loadXmlDocument(pathName);
        NodeList nodeCards = document.getElementsByTagName("Card");

        for (int i = 0; i < nodeCards.getLength(); i++) {
            Node nodeCard = nodeCards.item(i);
            Element card = (Element) nodeCard;

            String cardId = card.getAttribute("id");

            NodeList nodeStats = nodeCard.getChildNodes().item(1).getChildNodes();

            List<Integer> statsList = new ArrayList<>();
            for (int j = 1; j < nodeStats.getLength(); j = j + 2) {
                Node nodestat = nodeStats.item(j);
                Element stat = (Element) nodestat;

                String statId = stat.getAttribute("id");
                int statValue = Integer.parseInt(nodestat.getTextContent());
                statsList.add(statValue);
            }

            Card cardToAdd = new Card(cardId, statsList.get(0), statsList.get(1), statsList.get(2));
               addToListOfCards(cardToAdd);

          // cardList.add(cardToAdd);
        }
       // return cardList;
    }
    @Override
    public List<Card> getAllCards() {
        //List<Card> cards = new ArrayList<>();


        return cardList;

    }
}
