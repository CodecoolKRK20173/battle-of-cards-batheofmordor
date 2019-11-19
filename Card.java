public class Card {

    private String name;
    private int attack;
    private int defense;
    private int magic;

    public Card(String name, int attack, int defense, int magic) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.magic = magic;
    }

    public String getName() {
        return name;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getMagic() {
        return magic;
    }
}
