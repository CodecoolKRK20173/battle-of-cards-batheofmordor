import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Service {

    private List<Player> players;
    XMLParser xmlParser;
    private Stock stock;

    public Service() {
        this.players = new ArrayList<>();
        this.xmlParser = new XMLParser("cardsStorage.xml");
        this.stock = new Stock();
        stock.shuffle();
    }

    public void addListOfCardsToStock(List<Card> cardsInStock) {
        for (Card card : cardsInStock) {
            stock.addToListOfCards(card);
        }
    }

    public void createDeck() {
        int cardsIterator = 0;
        for (Player player : players) {
            int numOfCardsForPlayer = 6;
            for (int i = 0; i < numOfCardsForPlayer; i++) {
                player.getCardsToUse().addToListOfCards(stock.getCard(cardsIterator));
                cardsIterator++;
            }
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayers(Player player) {
        this.players.add(player);
    }

    public String diceOfParameter(){
        String parameter;
        String[] stringParam = {"Attack","Defence","Magic"};
        List<String> parameters = new ArrayList<>(Arrays.asList(stringParam));
        Collections.shuffle(parameters);
        parameter = parameters.get(0);
        return parameter;
    }
}
