import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AI extends Player{

    public ArrayList<String> stats = new ArrayList<String>(Arrays.asList("attack", "defence", "magic", "battleCry"));
    public AI(String name) {
        super(name);
    }

    public Card getRandomCard(){
        Random rand = new Random();
        int randomIndex = rand.nextInt(getCardsToUse().getListLength());
        return getCardsToUse().getCard(randomIndex);
    }

    public String getRandomStat(){
        Random rand = new Random();
        int randomNum = rand.nextInt(4);
        return stats.get(rand.nextInt(stats.size()));
    }
}
