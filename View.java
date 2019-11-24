import javax.xml.transform.SourceLocator;
import java.util.List;

public class View {
    public View(){

    }
    public void printPlayerTurn(Player player) {

        System.out.println("Now is Player " + player.getName() + " turn.");
        System.out.println("─────────────────────────────────");
    }

    public void printCardStats(Card card) {

        System.out.println();
        System.out.println("++++++++++++++++++++");
        System.out.println("+                  +");
        String[] stringsName = card.getName().split(" ");
            for (int i = 0; i < stringsName.length; i++) {
                if (i % 2 != 0 || i == stringsName.length - 1) {
                    System.out.println("  " + stringsName[i].toUpperCase());
                } else {
                    System.out.print("  " + stringsName[i].toUpperCase());
                }
            }
            System.out.println("+                  +");
            System.out.println("+  Strength: " + card.getAttack());
            System.out.println("+  Agility: " + card.getDefense());
            System.out.println("+  Intelligence: " + card.getMagic());
            System.out.println("+                  +");
            System.out.println("++++++++++++++++++++");
        }

    public void printPlayerWinTurn (Player player){
        System.out.println("Player --> " + player.getName() + " win this Turn!");
    }

    public void printPlayerWinGame(Player player){
        System.out.println("    Game has been won!\n");
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
