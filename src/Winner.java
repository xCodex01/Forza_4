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
            for (int j = Mappa.getMapHeight(i)-1; j>0;j--){
                if(Mappa.getColour(i, j)=="blue" && i+3<Mappa.getMapLenght()) {
                    if(Mappa.getColour(i+1, j)=="blue" && Mappa.getColour(i+2, j)=="blue" && Mappa.getColour(i+3, j)=="blue"){
                        this.setWinner(Player_1.getName());
                        this.winTrue();
                    }
                    if(j-3>=0){
                        if(Mappa.getColour(i, j-1)=="blue" && Mappa.getColour(i, j-2)=="blue" && Mappa.getColour(i, j-3)=="blue"){
                            this.setWinner(Player_1.getName());
                            this.winTrue();
                        }
                        if(Mappa.getColour(i+1, j-1)=="blue" && Mappa.getColour(i+2, j-2)=="blue"&& Mappa.getColour(i+3, j-3)=="blue"){
                            this.setWinner(Player_1.getName());
                            this.winTrue();
                        }
                    }
                    if(j+3<Mappa.getMapHeight(i)){
                        if(Mappa.getColour(i+1, j+1)=="blue" && Mappa.getColour(i+2, j+2)=="blue" && Mappa.getColour(i+3, j+3)=="blue"){
                            this.setWinner(Player_1.getName());
                            this.checkWin();
                        }

                    }
                }
                if(Mappa.getColour(i, j)=="red" && i+3<Mappa.getMapLenght()){
                    if(Mappa.getColour(i+1, j)=="red" && Mappa.getColour(i+2, j)=="red" && Mappa.getColour(i+3, j)=="red"){
                        this.setWinner(Player_1.getName());
                        this.winTrue();
                    }
                    if(j-3>=0){
                        if(Mappa.getColour(i, j-1)=="red" && Mappa.getColour(i, j-2)=="red" && Mappa.getColour(i, j-3)=="red"){
                            this.setWinner(Player_1.getName());
                            this.winTrue();
                        }
                        if(Mappa.getColour(i+1, j-1)=="red" && Mappa.getColour(i+2, j-2)=="red"&& Mappa.getColour(i+3, j-3)=="red"){
                            this.setWinner(Player_1.getName());
                            this.winTrue();
                        }
                    }
                    if(j+3<Mappa.getMapHeight(i)){
                        if(Mappa.getColour(i+1, j+1)=="red" && Mappa.getColour(i+2, j+2)=="red" && Mappa.getColour(i+3, j+3)=="red"){
                            this.setWinner(Player_1.getName());
                            this.checkWin();
                        }

                    }
                }
            }
        }


    }

    public void incrementTurn(){
        turn++;
    }

}
