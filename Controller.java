import java.util.List;

public class Controller {

    public void Run(){

        CardDAO dao = new XMLParser("cardsStorage.xml");

        List<Card> cards = dao.getAllCards();
        View view = new View();
        int itemInLIst = cards.size();
        for (int i = 0; i < itemInLIst; i++){
            System.out.println("Card index = " + i );
            view.printCardStat(cards.get(i));


        }
    }

}
