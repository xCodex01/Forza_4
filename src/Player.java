public class Player {

    
    private static String name;  //String used for player's name
    private static String colour; // String used for the color name
    
    /**
     * Costruttore del giocatore
     * @param aName nome del giocatore
     * @param aColour colore del giocatore
     */
    public Player(String aName, String aColour){
        name = aName;
        colour = aColour;    
    }

    /**
     * Metodo che aggiunge una pedina alla griglia
     * usando il colore del giocatore usato
     * @param row riga della pedina
     * @param column colonna della pedina
     */
    public void addPedina(int row, int column){
        if (Mappa.getColour(row, column)=="red" || Mappa.getColour(row, column)== "blue"){
            System.out.println("E' già presente una pedina");
        }
        else{
            Mappa.addColour(row, column, colour);
        }
    }

    /**
     * Metodo che ritorna il nome del giocatore
     * @return il nome del giocatore
     */
    public static String getName(){
        return name;
    }

    /**
     * Metodo che ritrona il colore del giocatore
     * @return il colore del giocatore
     */
    public String getColour(){
        return colour;
    }


}
