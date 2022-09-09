import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Game {
    
    public static ArrayList<Player> players = new ArrayList<Player>();
   
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
                    playGame();
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

        

        System.out.println(players.get(0).getName() +" inserire le coordinate della pedina blu: ");
        int row_1 = scanInt();
        int column_1 = scanInt();
        players.get(0).addPedina(row_1, column_1);
        Winner.checkWin();
        if(Winner.getWinState()==true){
            return;
        }

        System.out.println(players.get(1).getName()+" inserire le coordinate della pedina rossa: ");
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

        Mappa map = new Mappa();

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

        try(BufferedReader br = new BufferedReader(new FileReader("Gmae_Saved.txt"))){

            int linesNumbers= 4;
            for(int i = 0; i<linesNumbers;i++){
                if(i==0){
                    String player1Name = br.readLine();
                    Player p1 = new Player(player1Name, "blue");
                }
                if(i==1){
                    String player2Name = br.readLine();
                    Player p2 = new Player(player2Name,"red");
                }
                if(i==2){
                    String matrice = br.readLine();
                    creatMatrix(matrice);
                }
                if(i==3){
                    Winner.setRound(Integer.parseInt(br.readLine()));
                }
            }




        }catch(IOException e){
            System.out.println("Non è stato trovato un file di salvataggio");
        }

        

    }

    private static void creatMatrix(String matrix){
        Mappa map = new Mappa();
        for(int row = 0; row<Mappa.getMapLenght(); row++){
            for(int column = 0; column<Mappa.getMapHeight(row);column++){
                for(int i = 0; i<Mappa.getMapLenght()+Mappa.getMapHeight(row); i++){
                    char c = matrix.charAt(i);
                    if(c=='0'){
                        Mappa.addColour(row, column, "empty");
                    }
                    if(c=='1'){
                        Mappa.addColour(row, column, "blue");
                    }
                    if(c=='2'){
                        Mappa.addColour(row, column, "red");
                    }
                }
            }
        }
    }

    public static void saveGame(String p1, String p2){

        String p1Name = p1;
        String p2Name = p2;
        String grid = "";
        String round = Integer.toString(Winner.getRound());
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
            fw.write(round+"\n");
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

    public static Player getPlayer(int index){
        return players.get(index);
    }

}
