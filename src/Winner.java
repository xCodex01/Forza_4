public class Winner {
    public static boolean win;
    public static String winner;
    private static int round;

    public Winner(){
        win = false;
        winner = "";
        round = 1;
    }

    public static void winTrue(){
        win = true;
    }

    public static void setWinner(String player){
        winner = player;
    }

    public void printWinner(){
        System.out.println("Il vincitore è: "+winner);
    }

    public static boolean getWinState(){
        return win;
    }

    public String getWinner(){
        return winner;
    }

    public static void checkWin(){
        for(int i = 0; i<Mappa.getMapLenght(); i++){
            for (int j = Mappa.getMapHeight(i)-1; j>0;j--){
                if(Mappa.getColour(i, j)=="blue" && i+3<Mappa.getMapLenght()) {
                    if(Mappa.getColour(i+1, j)=="blue" && Mappa.getColour(i+2, j)=="blue" && Mappa.getColour(i+3, j)=="blue"){
                        Winner.setWinner(Player_1.getName());
                        Winner.winTrue();
                        break;
                    }
                    if(j-3>=0){
                        if(Mappa.getColour(i, j-1)=="blue" && Mappa.getColour(i, j-2)=="blue" && Mappa.getColour(i, j-3)=="blue"){
                            Winner.setWinner(Player_1.getName());
                            Winner.winTrue();
                            break;
                        }
                        if(Mappa.getColour(i+1, j-1)=="blue" && Mappa.getColour(i+2, j-2)=="blue"&& Mappa.getColour(i+3, j-3)=="blue"){
                            Winner.setWinner(Player_1.getName());
                            Winner.winTrue();
                            break;
                        }
                    }
                    if(j+3<Mappa.getMapHeight(i)){
                        if(Mappa.getColour(i+1, j+1)=="blue" && Mappa.getColour(i+2, j+2)=="blue" && Mappa.getColour(i+3, j+3)=="blue"){
                            Winner.setWinner(Player_1.getName());
                            Winner.winTrue();
                            break;
                        }

                    }
                }
                if(Mappa.getColour(i, j)=="red" && i+3<Mappa.getMapLenght()){
                    if(Mappa.getColour(i+1, j)=="red" && Mappa.getColour(i+2, j)=="red" && Mappa.getColour(i+3, j)=="red"){
                        Winner.setWinner(Player_2.getName());
                        Winner.winTrue();
                        break;
                    }
                    if(j-3>=0){
                        if(Mappa.getColour(i, j-1)=="red" && Mappa.getColour(i, j-2)=="red" && Mappa.getColour(i, j-3)=="red"){
                            Winner.setWinner(Player_2.getName());
                            Winner.winTrue();
                            break;
                        }
                        if(Mappa.getColour(i+1, j-1)=="red" && Mappa.getColour(i+2, j-2)=="red"&& Mappa.getColour(i+3, j-3)=="red"){
                            Winner.setWinner(Player_2.getName());
                            Winner.winTrue();
                            break;
                        }
                    }
                    if(j+3<Mappa.getMapHeight(i)){
                        if(Mappa.getColour(i+1, j+1)=="red" && Mappa.getColour(i+2, j+2)=="red" && Mappa.getColour(i+3, j+3)=="red"){
                            Winner.setWinner(Player_2.getName());
                            Winner.winTrue();
                            break;
                        }

                    }
                }
            }
        }


    }

    public static void incrementTurn(){
        round++;
    }

    public int getRound(){
        return round;
    }



}
