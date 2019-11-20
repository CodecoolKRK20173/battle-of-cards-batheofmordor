import javax.xml.transform.SourceLocator;

public class View {
    public View(){

    }

    public void printCardStat(Card card){
        System.out.println("Unit name: " + card.getName());
        System.out.println("Attack: " + card.getAttack());
        System.out.println("Defense: " + card.getDefense());
        System.out.println("Magic: " + card.getMagic());
    }





}
