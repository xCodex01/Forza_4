import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Game {
    
    private static ArrayList<Player> players = new ArrayList<>();

    public static void main(String[] args){
        
        int s;
        do{
            
            s = Menu();

            switch(s){

                case 1:
                    newGame();
                    break;
                    
                case 2:
                    loadGame();
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Inserire una opzione elencata");
            }
        }while(s<=0 && s>=4);
        
        
        
        


        
    }

    public static int Menu(){
        int choise;
        System.out.println("1:Nuova Partita");
        System.out.println("2:Carica Partita");
        System.out.println("3:Exit");

        choise = scanInt();
        return choise;

    }

    public static int scanInt(){
        Scanner scanInt = new Scanner(System.in);
        return scanInt.nextInt();
    }

    public static String scanString(){
        Scanner scanString = new Scanner(System.in);
        return scanString();
    }

    public static void playGame(){

        

        System.out.println(Player_1.getName() +" inserire le coordinate della pedina blu: ");
        int row_1 = scanInt();
        int column_1 = scanInt();
        players.get(0).addPedina(row_1, column_1);
        Winner.checkWin();
        if(Winner.getWinState()==true){
            
        }

        System.out.println(Player_2.getName()+" inserire le coordinate della pedina rossa: ");
        int row_2 = scanInt();
        int column_2 = scanInt();
        players.get(1).addPedina(row_2, column_2);
        Winner.checkWin();
        Mappa.showMatrix();
        Winner.incrementTurn();

    }

    private static void newGame(){
        Winner win = new Winner();
        
        System.out.println("Inserire la grnadezza della mappa,\naltrimenti la grandezza di default sarà: 6x7");
        
        String row = scanString();
        String column = scanString();

        if(row.isEmpty() && column.isEmpty()){
            Mappa Mappa = new Mappa();
        }
        else if(row.isEmpty() && !column.isEmpty()){
            Mappa Mappa = new Mappa(0, Integer.parseInt(column));
        }
        else if(column.isEmpty() && !row.isEmpty()){
            Mappa mappa = new Mappa(Integer.parseInt(row), 0);

        }
        else{
            Mappa Mappa = new Mappa(Integer.parseInt(row), Integer.parseInt(column));
        }

        System.out.println("Inserire il nome del giocatore 1: ");

        
        String player_1 = scanString();
        
        while(player_1.isEmpty()){
            System.out.println("Inserire il nome del giocatore 1:");
        }

        
        Player p1 = new Player(player_1,"blue");

        System.out.println("Inserire il nome del giocatore 1: ");
        
        String player_2 = scanString();
        
        while(player_2.isEmpty()){
            System.out.println("Inserire il nome del giocatore 2:");
        }

        
        Player p2 = new Player(player_2, "red");

        players.add(p1);
        players.add(p2);

        while(Winner.getWinState()==false){

            playGame();

        }

        System.out.println("Il vincitore è: "+win.getWinner()+"al turno: ");

    }

    private static void loadGame(){

        

    }

    public static void saveGame(String p1, String p2){

        String p1Name = p1;
        String p2Name = p2;
        String grid = "";
        for (int i = 0; i<Mappa.getMapLenght();i++){
            for (int j = 0;j<Mappa.getMapHeight(i);j++){
                if(Mappa.getColour(i, j)=="empty"){
                    grid = grid + "0";
                }
                if(Mappa.getColour(i, j) == "blue"){
                    grid = grid + "1";
                }
                if(Mappa.getColour(i, j)=="blue"){
                    grid = grid + "2";
                }
            }
        }

        File file = new File("Game_Saved.txt");
        if(file.exists()==false){
            createFileGame();
        }

        try{
            FileWriter fw = new FileWriter(file.getName());
            fw.write(p1Name+"\n");
            fw.write(p2Name+"\n");
            fw.write(grid+"\n");
            fw.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
        

        

    }
    
   
    private static void createFileGame(){
        try{ File file = new File("Game_saved");
            file.createNewFile();
        }catch(Exception e){
            System.out.println("File già creato");
            e.printStackTrace();
        }
    }

}
