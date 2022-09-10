public class Winner {
    public static boolean win; //variabile booleana che indica lo stato di vittoria del gioco
    public static String winner; //Stringa col nome del vincitore
    

    /**
     * Costruttore della classe winner,
     * inizializza lo stato di vittoria a false,
     * la Stringa del giocatore vincente, imposta a 1 il numero dei round
     */
    public Winner(){
        win = false;
        winner = "";
        
    }

    /**
     * Cambia a true lo stato della
     * varabile booleana win, e indica
     * che è stato trovato un vincitore
     */
    public static void winTrue(){
        win = true;
    }

    /**
     * Salva il vincitore
     * della partita
     * @param player Giocatore che ha vinto
     */
    public static void setWinner(String player){
        winner = player;
    }

    /**
     * Stampa a video il giocatore che ha vinto
     */
    public void printWinner(){
        System.out.println("Il vincitore è: "+winner);
    }

    /**
     * ritorna lo stato della
     * variabile win
     * @return la variabile win
     */

    public static boolean getWinState(){
        return win;
    }
    
    /**
     * ritorna il nome del vincitore
     * @return il la Stringa winner
     */
    public String getWinner(){
        return winner;
    }

    /**
     * Metodo che controlla la sequenza
     * delle pedine nella mappa
     */
    public static void checkWin(){
        for(int row = Mappa.getMapLenght()-1;row >=0; row--){
            for(int column = 0; column<Mappa.getMapHeight(row); column++){
                
                //Controlla le pedine blue e assegna la vittoria al giocatore blu
                if(Mappa.getColour(row, column)=="blue "){
                    if(checkDiagonal(row, column, "blue ")==true){
                        break;
                    }
                    if(checkHorizzontal(row, column, "blue ")==true){
                        break;
                    }
                    if(checkVertical(row, column, "blue ")==true){
                        break;
                    }
                }

                //Controlla le pedine rosse e assegna la vittoria al giocatore rosso
                if(Mappa.getColour(row, column)==" red "){
                    if(checkDiagonal(row, column, " red ")==true){
                        break;
                    }
                    if(checkHorizzontal(row, column, " red ")==true){
                        break;
                    }
                    if(checkVertical(row, column, " red ")==true){
                        break;
                    }
                }
            }

        }
    }

   

    
    

    

    /**
     * Controlla se un giocatore ha vinto
     * con una sequenza di 4 pedine orizzontali
     * partendo da una pedina di un colore
     * @param row riga di partenza del controllo
     * @param column colonna di partenza del controllo
     * @param colour colore da controllare
     * @return true se la sequenza è stata trovata, false se non è presente
     */
    private static boolean checkHorizzontal(int row, int column, String colour){
        //salta il controllo se non trova spazio scorrendo verso destra
        if(column<4){    
            if(Mappa.getColour(row, column+1)==colour && Mappa.getColour(row, column+2)==colour && Mappa.getColour(row, column+3)==colour){
                if(colour == "blue "){
                    Winner.setWinner(Game.getPlayer(0).getName());
                    Winner.winTrue();
                    return true;
                }
                if(colour == " red "){
                    Winner.setWinner(Game.getPlayer(1).getName());
                    Winner.winTrue();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Controlla se un giocatore ha vinto
     * se è presenta una sequenza di 4 pedine
     * dello stesso colore scorrendo verso il basso
     * parentdo da una pedina
     * @param row riga di inizio del controllo
     * @param column colonna di inizio del controllo
     * @param colour colore del controllo
     * @return true se la sequenza è stata trovata, false se non è presente
     */
    private static boolean checkVertical(int row, int column, String colour){
        if(row<3){
            if(Mappa.getColour(row+1, column)==colour && Mappa.getColour(row+2, column)==colour && Mappa.getColour(row+3, column)==colour){
                if(colour == "blue "){
                    Winner.setWinner(Game.getPlayer(0).getName());
                    Winner.winTrue();
                    return true;
                }
                if(colour == " red "){
                    Winner.setWinner(Game.getPlayer(1).getName());
                    Winner.winTrue();
                    return true;
                }
                
                
            }
        }
        
        return false;
    }

    private static boolean checkDiagonalRight(int row, int column, String colour){
        if(Mappa.getColour(row+1, column+1)==colour && Mappa.getColour(row+2, column+2)==colour && Mappa.getColour(row+3, column+3)==colour){
            if(colour == "blue "){
                Winner.setWinner(Game.getPlayer(0).getName());
                Winner.winTrue();
                return true;
            }
            if(colour == " red "){
                Winner.setWinner(Game.getPlayer(1).getName());
                Winner.winTrue();
                return true;
            }
            Winner.winTrue();
            return true;
        }

        return false;
    }

    private static boolean checkDiagonalLeft(int row, int column, String colour){
        if(Mappa.getColour(row+1, column-1)==colour && Mappa.getColour(row+2, column-2)==colour && Mappa.getColour(row+3, column-3)==colour){
            if(colour == "blue "){
                Winner.setWinner(Game.getPlayer(0).getName());
                Winner.winTrue();
                return true;
            }
            if(colour == " red "){
                Winner.setWinner(Game.getPlayer(1).getName());
                Winner.winTrue();
                return true;
            }
        }

        return false;
    }

    private static boolean checkDiagonal(int row, int column, String colour){
        if(column>2 && row<3){
            if(checkDiagonalLeft(row, column, colour)==true){
                return true;
            }
        }
        if(column<4 && row<3){
            if(checkDiagonalRight(row, column, colour)==true){
                return true;
            }
        }
        
        return false;
    }

    public static boolean checkTie(){
        int count = 0;
        for(int row = 0; row<Mappa.getMapLenght(); row++){
            for(int column = 0; column<Mappa.getMapHeight(row); column++){
                if(Mappa.getColour(row, column)=="blue " || Mappa.getColour(row, column)==" red "){
                    count++;
                }
                if(count==42){
                    return true;
                }
            }
        }
        return false;
    }
    



}
