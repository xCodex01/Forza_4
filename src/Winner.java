public class Winner {
    public static boolean win;
    public static String winner;
    private int turn;

    public Winner(){
        win = false;
        winner = "";
        turn = 1;
    }

    public void winTrue(){
        win = true;
    }

    public void setWinner(String player){
        winner = player;
    }

    public void printWinner(){
        System.out.println("Il vincitore è: "+winner);
    }

    public boolean getWinState(){
        return win;
    }

    public String getWinner(){
        return winner;
    }

    public void checkWin(){
        for(int i = 0; i<Mappa.getMapLenght(); i++){
            for (int j = 0; j<Mappa.getMapHeight(j);j++){
                if(Mappa.getColour(i, j)=="blue") {
                    if(Mappa.getColour(i+1, j)=="blue" && Mappa.getColour(i+2, j)=="blue" && Mappa.getColour(i+3, j)=="blue"){
                        
                    }

                }
            }
        }


    }

    public void incrementTurn(){
        turn++;
    }

}
