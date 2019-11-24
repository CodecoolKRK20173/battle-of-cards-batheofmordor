import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stock implements Interface {

    public List<Card> trashOfCards;
    public List<Card> listOfCards;

    public Stock() {
        this.listOfCards = new ArrayList<>();
        this.trashOfCards = new ArrayList<>();
    }

    @Override
    public void addToListOfCards(Card card) {
        listOfCards.add(card);
    }

    public void shuffle(){
        Collections.shuffle(this.listOfCards);
    }

    public int getListLength(){
        return listOfCards.size();
    }

    public Card getCard(int index){
        return listOfCards.get(index);
    }
}
