public class Winner {
    public static boolean win;
    public static String winner;

    public Winner(){
        win = false;
        winner = "";
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


}
