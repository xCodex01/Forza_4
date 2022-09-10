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
    private static int first = 0; //variabile usata èer il print di una sola volta della matrice a inizio partita
   
    public static void main(String[] args){
        
        players = new ArrayList<Player>(); 

        //intero per scegliere l'opzione
        int s;

        /*
         * Modalità di scelta
         * delle opzioni
         */

        do{
            //variabile che seleziona una delle 3 scelte con il metodo Menu()
            s = Menu();

            switch(s){
                //inizia una nuova partita
                case 1:
                    newGame();
                    break;
                 //carica il gioco e continua la partita salvata precedentemente   
                case 2:
                    loadGame();
                    playGame();
                    break;
                //uscita dal gioco
                case 3:
                    System.out.println("Il gioco si sta chiudendo...");
                    return;
                //caso nel cui la variabile intera s non sia valida per nessuna delle precendenti opzioni
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

    /**
     * Metodo per giocare la partita
     */

    public static void playGame(){

        /**
         * Controlla se la variabile  è uguale a 0
         * per mostrare almeno una volta la matrice,
         * sia se è una nuova partita, se invece è
         * una partita caricata
         */
        if(first == 0){
            Mappa.showMatrix();
            System.out.println("\n");
            /**
             * Incrementa la variabile
             * per non mostrare piu la
             * griglia ogni volta che
             * il metodo viene eseguito
             */
            first++;
        }


        System.out.println(players.get(0).getName() +" inserire la colonna, tra 0 e 6, della pedina blu: ");
        System.out.println("\n");
        //Variabile che prende in input un intero per scegliere la colonna del giocatore 1
        int column_1 = scanInt();
        //controlla che la colonna sia nel range delle colonne create
        while(column_1>7 || column_1<0){
            System.out.println("La colonna selezionata non è valida"+"\nreinseire il numero della colonna tra 0 e 6");
            //riprende in input nuovamente la colonna del giocatore 1 se essa è fuori dal range del while
            column_1=scanInt();
        }
        //controlla che la colonna non sia piene
        while(players.get(0).addPedina(column_1,"blue ")==false){
            System.out.println("Selezionare un'altra colonna,"+"\nla seguente è piena");
            System.out.println("\n");
            //se piena fa scegliere un'altra colonna
            column_1 = scanInt();
        }
        //salva il gioco
        saveGame();
        //controlla la vittoria del giocatore 1
        Winner.checkWin();
        /**
         * Controla lo stato della variabile win della classe Winner,
         */
        if(Winner.getWinState()==true){
            //Mostra la matrice per far controllare all'utente la posizione della sequenza vincente
            Mappa.showMatrix();
            System.out.println("Il vincitore è: "+players.get(0).getName());
            return; //fa chiudere il gioco
        }
        
        //controlla la mappa
        Mappa.showMatrix();

        System.out.println(players.get(1).getName()+" inserire la colonna, tra 0 e 6, della pedina rossa: ");
        System.out.println("\n");
        
        //variabile che prende in input un intero della colonna del giocatore 2
        int column_2 = scanInt();
        //controlla che la colonna sia nel range delle colonne create
        while(column_2>7 || column_2<0){
            System.out.println("La colonna selezionata non è valida"+"\nreinseire il numero della colonna tra 0 e 6");
            column_2=scanInt();
        }
        while(players.get(0).addPedina(column_2, " red ")==false){
            System.out.println("Selezionare un'altra colonna,"+"\nla seguente è piena");
            System.out.println("\n");
            //riprende in input nuovamente la colonna del giocatore 2 se essa è fuori dal range del while
            column_2 = scanInt();
        }
        //salva il gioco
        saveGame();

        //controlla la vittoria del giocatore 2
        Winner.checkWin();

        /**
         * Controla lo stato della variabile win della classe Winner,
         */
        if(Winner.getWinState()==true){
            //Mostra la matrice per far controllare all'utente la posizione della sequenza vincente
            Mappa.showMatrix();
            System.out.println("Il vincitore è: "+players.get(1).getName());
            return;//fa chiudere il gioco
        }
        //Controlla se tutte le caselle sono piene per dichiare pareggio
        if(Winner.checkTie()==true){
            //mostra la mappa per far vedere l'impossibilità di eseguire mosse
            Mappa.showMatrix();
            System.out.println("La partita è finita in pareggio");
            System.out.println("\n");
            return;//fa chiudere il gioco
        }
        //mostra la mappa
        Mappa.showMatrix();
        System.out.println("\n");
        

    }

    /**
     * Metodo che inizia una nuova partita
     */
    private static void newGame(){
        //istanzia il costruttore della classe winner
        Winner win = new Winner();
        //Istanzia il costruttore della classe Mappa per creare la grigloa
        Mappa map = new Mappa();

        System.out.println("Inserire il nome del giocatore 1: ");
        System.out.println("\n");

        //prende in input un stringa con il nome del giocatore 1
        String player_1 = scanString();

        

        System.out.println("Inserire il nome del giocatore 2: ");
        System.out.println("\n");
        
        //prende in input una Stringa con il nome del giocatore 2
        String player_2 = scanString();

        //Istanzia due construttori della classe Player con il proprio nickname e 2 colori preimpostati
        players.add(new Player(player_1, "blue "));
        players.add(new Player(player_2 ," red  "));

        
    
        
        
        //esegue il metodo playGame() finchè la variabile win è falsa
        while(Winner.getWinState()==false){

            playGame();

        }

    }

    /**
     * Metodo che carica un precendente salvataggio
     */
    private static void loadGame(){

        //Carica in lettura il file di testo di salvataggio Game_Saved.txt
        try(BufferedReader br = new BufferedReader(new FileReader("Game_Saved.txt"))){
            //variabile intera che imposta il numero massimo di linee
            int linesNumbers= 3;
            //ciclo for per leggere tutte e 3 le righe
            for(int i = 0; i<linesNumbers;i++){
                //se i uguale a 0 carica istanzia il precedente giocatore 1
                if(i==0){
                    String player1Name = br.readLine();
                    Player p1 = new Player(player1Name, "blue ");
                    players.add(p1);
                }
                //se i uguale a 1 istanzia il precendente giocatore 2
                if(i==1){
                    String player2Name = br.readLine();
                    Player p2 = new Player(player2Name," red ");
                    players.add(p2);
                }
                //se i uguale a 2 legge la terza riga formata da una stringa di 0,1,2 usata per ricreare la matrice
                if(i==2){
                    String matrice = br.readLine();
                    //crea la matrice
                    createMatrix(matrice);
                }
                
            }




        }catch(IOException e){
            System.out.println("Non è stato trovato un file di salvataggio");
        }

        

    }

    /**
     * Metodo usato per ripristinare la matrice del salvataggio
     * @param matrix Stringa formata da 0,1,2
     */
    private static void createMatrix(String matrix){
        //istanzia la griglia
        Mappa map = new Mappa();
        //variabile usata per il conteggio del carattere da leggere
        int i = 0;
        //2 cicli for usati per scorrere la griglia
        for(int row = 0; row<Mappa.getMapLenght(); row++){
            for(int column = 0; column<Mappa.getMapHeight(row);column++){
                //variabile di tipo char che leggere il carattere della Stringa ad inidice i
                char c = matrix.charAt(i);
                //ripristina la cella vuota
                if(c=='0'){
                    Mappa.restoreColours(row, column, "empty");
                    i++;
                }
                //ripristina la cella blue
                if(c=='1'){
                   Mappa.restoreColours(row, column, "blue ");
                   i++;
                }
                //ripristina la cella rossa
                if(c=='2'){
                    Mappa.restoreColours(row, column, " red ");
                    i++;
                }
            }
        }
    }

    /**
     * Metodo usato per salvare il gioco
     */
    public static void saveGame(){
        //Stringa con il nome del giocatore 1
        String p1Name = players.get(0).getName();
        //Stringa con il nome del giocatore 2
        String p2Name = players.get(1).getName();
        //Stringa creata per salvare la griglia
        String grid = "";
        
        //2 cicli for per scorrere la griglia
        for (int i = 0; i<Mappa.getMapLenght();i++){
            for (int j = 0;j<Mappa.getMapHeight(i);j++){
                //se la cella è vuota aggiunge 0 alla Stringa
                if(Mappa.getColour(i, j)=="empty"){
                    grid = grid + "0";
                }
                //se la cella è blue aggiunge 1 alla Stringa
                if(Mappa.getColour(i, j) == "blue "){
                    grid = grid + "1";
                }
                //se la cella è rossa aggiunge 2 alla Stringa
                if(Mappa.getColour(i, j)==" red "){
                    grid = grid + "2";
                }
            }
        }

        //Instanza il costruttore della classe File per creare un nuovo file di salvataggio
        File file = new File("Game_Saved.txt");
        //controlla che il file non esista già
        if(file.exists()==false){
            //altrimenti lo crea
            createFileGame();
        }
        //salviamo le informazioni nel file di testo
        try{
            //Instanzia il costruttore della classe FileWriter per scrivere nel file
            FileWriter fw = new FileWriter(file.getName());
            //salva il nome del giocatore 1
            fw.write(p1Name+"\n");
            //salva il nome del giocatore 2
            fw.write(p2Name+"\n");
            //salva la griglia
            fw.write(grid+"\n");
            fw.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
        

        

    }

    
    /**
     * Metodo usato per creare un file di salvataggio txt
     */
    private static void createFileGame(){
        //Istanzia la il costruttore della classe file con il nome del file di salvataggio
        try{ File file = new File("Game_saved.txt");
            //crea il file
            file.createNewFile();
        }catch(Exception e){
            System.out.println("File già creato");
            e.printStackTrace();
        }
    }

    /**
     * ritorna un oggetto Player all'indice "index" nell'ArrayList<Player> players
     * @param index intero che indicia l'indice
     * @return oggetto player
     */

    public static Player getPlayer(int index){
        return players.get(index);
    }
    

}
