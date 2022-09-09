public class Player {

    
    private String name;  //String used for player's name
    private String colour; // String used for the color name
    
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
    public boolean addPedina( int column){
        
        if(column > 0){
            Mappa.addColour(column, colour);
            return true;
        }
        return false;

    }

    /**
     * Metodo che ritorna il nome del giocatore
     * @return il nome del giocatore
     */
    public String getName(){
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
