import javax.xml.transform.SourceLocator;

public class View {
    public View(){

    }

    public void printCardStat(Card card){
        System.out.println();
        System.out.println("++++++++++++++++++++");
        System.out.println("+                  +");
        String[] stringsName = card.getName().split(" ");
        for (int i  = 0; i < stringsName.length; i++ ){
            if (i % 2 != 0 || i == stringsName.length-1) {
                System.out.println("  " + stringsName[i].toUpperCase());
            }
            else{
                System.out.print("  " + stringsName[i].toUpperCase());
            }


        }
        System.out.println("+                  +");
        System.out.println("+  Attack: " + card.getAttack());
        System.out.println("+  Defense: " + card.getDefense());
        System.out.println("+  Magic: " + card.getMagic() );
        System.out.println("+                  +");
        System.out.println("++++++++++++++++++++");


    }





}
