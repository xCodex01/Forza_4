import java.util.Scanner;

public class Game {

    public static void main(String[] args){
        Winner win = new Winner();

        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);

        System.out.println("Inserire la grnadezza della mappa,\n sennò la grandezza di default sarà: 6x7");
        
        String row = in.next();
        String column = in1.next();

        if(row == "" && column == ""){
            Mappa Mappa = new Mappa();
        }
        else if(row == ""){
            Mappa Mappa = new Mappa(0, Integer.parseInt(column));
        }
        else if(column == ""){
            Mappa mappa = new Mappa(Integer.parseInt(row), 0);

        }
        else{
            Mappa Mappa = new Mappa(Integer.parseInt(row), Integer.parseInt(column));
        }

        Scanner player1 =  new Scanner(System.in);

        System.out.println("Inserire il nome del giocatore 1: ");

        
        while(!player1.hasNext()){
            System.out.println("Inserire il nome del giocatore 1:");
        }

        String player_1 = player1.next();
        Player_1 p1 = new Player_1(player_1);

        Scanner player2 = new Scanner(System.in);

        System.out.println("Inserire il nome del giocatore 1: ");

        while(!player2.hasNext()){
            System.out.println("Inserire il nome del giocatore 2:");
        }

        String player_2 = player2.next();
        Player_2 p2 = new Player_2(player_2);

        while(win.getWinState()==false){
        }

        System.out.println("Il vincitore è: "+win.getWinner());

        


        
    }
    
}
