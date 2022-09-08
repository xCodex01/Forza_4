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
        for(int row = Mappa.getMapLenght()-4;row >=0; row--){
            for(int column = 0; column<Mappa.getMapHeight(row); column++){
                if(Mappa.getColour(row, column)=="blue"){
                    if(column+3<Mappa.getMapLenght()){
                        if(checkHorizzontal(row, column, "blue")==true){
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

    private static boolean checkHorizzontal(int row, int column, String colour){
        if(Mappa.getColour(row+1, column)==colour && Mappa.getColour(row+2, column)==colour && Mappa.getColour(row+3, column)==colour){
            if(colour == "blue"){
                Winner.setWinner(Game.getPlayer(0).getName());
            }
            if(colour == "red"){
                Winner.setWinner(Game.getPlayer(1).getName());
            }
            Winner.winTrue();
            return true;
        }

            return false;
    }

    private static boolean checkVertical(int row, int column, String colour){
        if(Mappa.getColour(row+1, column)==colour && Mappa.getColour(row+2, column)==colour && Mappa.getColour(row+3, column)==colour){
            if(colour == "blue"){
                Winner.setWinner(Game.getPlayer(0).getName());
            }
            if(colour == "red"){
                Winner.setWinner(Game.getPlayer(1).getName());
            }
            Winner.winTrue();
            return true;
        }
        
        return false;
    }

    private static boolean checkDiagonalRight(int row, int column, String colour){
        if(Mappa.getColour(row+1, column+1)==colour && Mappa.getColour(row+2, column+2)==colour && Mappa.getColour(row+3, column+3)==colour){
            if(colour == "blue"){
                Winner.setWinner(Game.getPlayer(0).getName());
            }
            if(colour == "red"){
                Winner.setWinner(Game.getPlayer(1).getName());
            }
            Winner.winTrue();
            return true;
        }

        return false;
    }

    private static boolean checkDiagonalLeft(int row, int column, String colour){
        if(Mappa.getColour(row+1, column-1)==colour && Mappa.getColour(row+2, column-2)==colour && Mappa.getColour(row+3, column-3)==colour){
            if(colour == "blue"){
                Winner.setWinner(Game.getPlayer(0).getName());
            }
            if(colour == "red"){
                Winner.setWinner(Game.getPlayer(1).getName());
            }
            Winner.winTrue();
            return true;
        }

        return false;
    }

    private static boolean checkDiagonal(int row, int column, String colour){
        if(column-3<0){
            if(checkDiagonalLeft(row, column, colour)==true){
                return true;
            }
        }
        if(column+3<Mappa.getMapHeight(row)){
            if(checkDiagonalRight(row, column, colour)==true){
                return true;
            }
        }
        
        return false;
    }

    



}
