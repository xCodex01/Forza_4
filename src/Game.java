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
    
    public static ArrayList<Player> players; //ArrayList di giocatori
    private static int first = 0;
   
    public static void main(String[] args){
        
        players = new ArrayList<Player>(); 

        //intero per scegliere l'opzione
        int s;

        /*
         * Modalità di scelta
         * delle opzioni
         */

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
                    System.out.println("Il gioco si sta chiudendo...");
                    return;

                default:
                    System.out.println("Inserire una opzione elencata");
            }
        }while(s<=0 && s>=4);
        
        
        
        


        
    }
    /*
     * Menu di gioco
     * ritorna un intero
     * che rappresenta una opzione
     */
    public static int Menu(){
        int choise;
        System.out.println("1:Nuova Partita");
        System.out.println("2:Carica Partita");
        System.out.println("3:Exit");

        choise = scanInt();
        return choise;

    }

    /**
     * Metodo per la creazione
     * automatica di un input intero
     * dal/dagli utenti
     * @return un intero preso in input
     */
    public static int scanInt(){
        Scanner scanInt = new Scanner(System.in);
        return scanInt.nextInt();
    }

    /**
     * Metodo per la creazione
     * automatica di un input Stringa
     * dal/dagli utenti
     * @return una Stringa presa in input
     */
    public static String scanString(){
        Scanner scanString = new Scanner(System.in);
        return scanString.next();
    }


    public static void playGame(){

        
        if(first == 0){
            Mappa.showMatrix();
            System.out.println("\n");
            first++;
        }


        System.out.println(players.get(0).getName() +" inserire la colonna della pedina blu: ");
        System.out.println("\n");
        int column_1 = scanInt();
        while(players.get(0).addPedina(column_1,"blue ")==false){
            System.out.println("Selezionare un'altra colonna,"+"\nla seguente è piena");
            System.out.println("\n");
            column_1 = scanInt();
        }
        saveGame();
        Winner.checkWin();
        if(Winner.getWinState()==true){
            System.out.println("Il vincitore è: "+players.get(0).getName());
            return;
        }

        Mappa.showMatrix();
        System.out.println("\n");

        System.out.println(players.get(1).getName()+" inserire la colonna della pedina rossa: ");
        System.out.println("\n");
        
        int column_2 = scanInt();
        while(players.get(0).addPedina(column_2, " red ")==false){
            System.out.println("Selezionare un'altra colonna,"+"\nla seguente è piena");
            System.out.println("\n");
            column_2 = scanInt();
        }
        saveGame();
        Winner.checkWin();
        if(Winner.checkTie()==true){
            System.out.println("La partita è finita in pareggio");
            System.out.println("\n");
            return;
        }
        Mappa.showMatrix();
        System.out.println("\n");
        

    }

    private static void newGame(){
        Winner win = new Winner();
        
        Mappa map = new Mappa();

        System.out.println("Inserire il nome del giocatore 1: ");
        System.out.println("\n");

        
        String player_1 = scanString();

        

        System.out.println("Inserire il nome del giocatore 2: ");
        System.out.println("\n");
        
        String player_2 = scanString();

        players.add(new Player(player_1, "blue "));
        players.add(new Player(player_2 ," red  "));

        
    
        
        

        while(Winner.getWinState()==false){

            playGame();

        }

        System.out.println("Il vincitore è: "+win.getWinner()+"al turno: ");

    }

    private static void loadGame(){

        try(BufferedReader br = new BufferedReader(new FileReader("Game_Saved.txt"))){

            int linesNumbers= 3;
            for(int i = 0; i<linesNumbers;i++){
                if(i==0){
                    String player1Name = br.readLine();
                    Player p1 = new Player(player1Name, "blue ");
                    players.add(p1);
                }
                if(i==1){
                    String player2Name = br.readLine();
                    Player p2 = new Player(player2Name," red ");
                    players.add(p2);
                }
                if(i==2){
                    String matrice = br.readLine();
                    createMatrix(matrice);
                }
                
            }




        }catch(IOException e){
            System.out.println("Non è stato trovato un file di salvataggio");
        }

        

    }

    private static void createMatrix(String matrix){
        Mappa map = new Mappa();
        int i = 0;
        for(int row = 0; row<Mappa.getMapLenght(); row++){
            for(int column = 0; column<Mappa.getMapHeight(row);column++){
                char c = matrix.charAt(i);
                if(c=='0'){
                    Mappa.restoreColours(row, column, "empty");
                    i++;
                }
                if(c=='1'){
                   Mappa.restoreColours(row, column, "blue ");
                   i++;
                }
                if(c=='2'){
                    Mappa.restoreColours(row, column, " red ");
                    i++;
                }
            }
        }
    }

    public static void saveGame(){

        String p1Name = players.get(0).getName();
        String p2Name = players.get(1).getName();
        String grid = "";
        
        for (int i = 0; i<Mappa.getMapLenght();i++){
            for (int j = 0;j<Mappa.getMapHeight(i);j++){
                if(Mappa.getColour(i, j)=="empty"){
                    grid = grid + "0";
                }
                if(Mappa.getColour(i, j) == "blue "){
                    grid = grid + "1";
                }
                if(Mappa.getColour(i, j)==" red "){
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
        try{ File file = new File("Game_saved.txt");
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
