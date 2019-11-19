public class Player {

    private String name;
    private Stock cardsToUse;
    private int score;
    private int turnValue;

    public Player(String name){
        this.name = name;
        this.cardsToUse = new Stock();
        this.score = 0;
        this.turnValue = 0;
    }

    public void addScore(){
        this.score = (score + 1);
    }

    public void setTurnValue(int turnValue) {
        this.turnValue = turnValue;
    }

    public String getName() {
        return name;
    }

    public Stock getCardsToUse() {
        return cardsToUse;
    }

    public int getScore() {
        return score;
    }

    public int getTurnValue() {
        return turnValue;
    }
}
