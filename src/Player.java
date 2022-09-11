/**
 * Classe che genera i giocatori
 * @author Francesco De Angelis
 */
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
     * @param column colonna della pedina
     * @param colour colore della pedima
     * @return true se il metodo addColour viene eseguito correttamente,
     *         false se nno viene eseguito
     */
    public boolean addPedina( int column,String colour){
        //controllo per evitare l'errore outofbound 
        if(column >= 0){
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
