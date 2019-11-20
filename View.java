import javax.xml.transform.SourceLocator;
import java.util.List;

public class View {
    public View(){
    }

    public void printPlayerTurn(Player player) {

        System.out.println("Now is Player " + player.getName() + " turn.");
        System.out.println("----------------------------------");
    }

    public void printCardStats(Card card){
        System.out.println("Unit Name               ->" + card.getName());
        System.out.println("Attack Statistic        ->" + card.getAttack());
        System.out.println("Defense Statistic       ->" + card.getDefense());
        System.out.println("Magic Statistic         ->" + card.getMagic());
    }

    public void printPlayerWinTurn (Player player){
        System.out.println("Player --> " + player.getName() + " win this Turn!");
    }

    public void printPlayerWinGame(Player player){
        System.out.println("    Game have ended!\n");
        System.out.println("Player --> " + player.getName() + " win!!!");
    }

    public void printAllScores (List<Player> players){
        System.out.println("All players score :");
        for (Player player: players){
            System.out.println("Player -->" + player.getName() + " have " + player.getScore() + " points of Score.");
        }
    }
}

//    public void printCardStat(Card card){
//        System.out.println("Unit name: " + card.getName());
//        System.out.println("Attack: " + card.getAttack());
//        System.out.println("Defense: " + card.getDefense());
//        System.out.println("Magic: " + card.getMagic());
//    }
//}
