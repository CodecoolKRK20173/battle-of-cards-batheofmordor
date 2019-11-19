import java.util.List;

public class Controller {

    public void Run(){

        CardDAO dao = new XMLParser("cardsStorage.xml");

        List<Card> cards = dao.getAllCards();
    }

}
