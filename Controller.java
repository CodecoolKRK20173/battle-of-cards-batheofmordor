import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Controller {

    private Service service;
    private View view;
    private Player playerTurn;

//    CardDAO dao = new XMLParser("cardsStorage.xml");
//    List<Card> cards = dao.getAllCards();

    public Controller() {
        this.service = new Service();
        this.view = new View();
    }

    public void run() {
        menu();
    }

    private void setPlayers() {
        Scanner scan = new Scanner(System.in);
        String textInput = scan.nextLine();
        Player player = new Player(textInput);
        service.addPlayers(player);
    }

    private void menu() {
        System.out.println("Choose option: \n1.Set Players \n2.Quit game");
        Scanner scan = new Scanner(System.in);
        String textInput = scan.nextLine();

        switch (textInput) {
            case "1":
                System.out.println("How many players: ");
                int count = scan.nextInt();
                for (int i = 0; i < count; i++) {
                    System.out.println("Player" + (i + 1) + " Please input your name: ");
                    setPlayers();
                }
                game();
            case "2":
                break;
        }
    }

    private void game() {
        service.createDeck();
        Random rand = new Random();
        int randomNum = rand.nextInt(service.getPlayers().size());
        playerTurn = service.getPlayers().get(randomNum);

        while (checkIfGameNotEnd(playerTurn)) {
            view.printPlayerTurn(playerTurn);
            String parameterInTurn = service.diceOfParameter();
            System.out.println("Now you will battle with " + parameterInTurn + " stat.");
            Card card = chooseCard(playerTurn);
            turnValueSeter(playerTurn, card, parameterInTurn);
            view.printCardStats(card);
            moveCardToTrash(playerTurn, card);

            for (Player player : service.getPlayers()) {
                if (player != playerTurn) {
                    view.printPlayerTurn(player);
                    System.out.println("Now you will battle with " + parameterInTurn + " stat.");
                    card = chooseCard(player);
                    turnValueSeter(player, card, parameterInTurn);
                    view.printCardStats(card);
                    moveCardToTrash(player, card);
                    System.out.print("\033[H\033[2J");
                }
            }

            playerTurn = whoWonTurn();
            view.printPlayerWinTurn(playerTurn);
            playerTurn.addScore();
        }

        playerTurn = whoWonGame();
        view.printPlayerWinGame(playerTurn);
        view.printAllScores(service.getPlayers());
    }

    private void showPlayerCards(Player player) {
        int i = 1;
        for (Card card : player.getCardsToUse().listOfCards) {
            System.out.println("Card number: " + i);
            view.printCardStats(card);
            i++;
        }
    }

    private Card chooseCard(Player player){
        Scanner scan = new Scanner(System.in);
        showPlayerCards(player);
        System.out.println("Choose card you want to fight with:");

        int endRange = player.getCardsToUse().listOfCards.size();
        int input = scan.nextInt();
        while (input < 1 || input > endRange){
            System.out.println("You don't have that card\nchoose another card");
            input = scan.nextInt();
        }
        input = input-1;
        return player.getCardsToUse().getCard(input);
    }

    public boolean checkIfGameNotEnd(Player player){
        if (player.getCardsToUse().listOfCards.size() > 0){
            return true;
        }
        return false;
    }

    public void moveCardToTrash (Player player, Card card) {
        player.getCardsToUse().trashOfCards.add(card);
        player.getCardsToUse().listOfCards.remove(card);
    }

    public void turnValueSeter(Player player, Card card, String stat){
        if (stat. equals("Attack")) {
            player.setTurnValue(card.getAttack());
        } else if (stat.equals("Defence")){
            player.setTurnValue(card.getDefense());
        } else {
            player.setTurnValue(card.getMagic());
        }
    }

    public Player whoWonTurn() {
        int value = 0;
        Player winningPlayer = new Player("Test");
        for (Player player: service.getPlayers()){
            if (player.getTurnValue() > value){
                winningPlayer = player;
                value = player.getTurnValue();
            }
        }
        return winningPlayer;
    }

    public Player whoWonGame(){
        int value = 0;
        Player winningPlayer = new Player("Test");
        for (Player player: service.getPlayers()){
            if (player.getScore() > value){
                winningPlayer = player;
                value = player.getScore();
            }
        }
        return winningPlayer;
    }
}


//    public void Run(){
//
//        CardDAO dao = new XMLParser("cardsStorage.xml");
//
//        List<Card> cards = dao.getAllCards();
//        View view = new View();
//        int itemInLIst = cards.size();
//        for (int i = 0; i < itemInLIst; i++){
//            System.out.println("Card index = " + i );
//            view.printCardStat(cards.get(i));
//
//
//        }
//    }
//
//}
