import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.io.PrintWriter;

public class Mappa{

    private static String[][] map; //matrice che genera la mappa di gioco
    
    /**
     * Costruttore della mappa
     * che genera una griglia
     * di 6 righe e 7 colonne
     */
    public Mappa() {
        
        map = new String[6][7];
        for (int row = 0; row<map.length; row++){
            for (int column = 0; column<map[row].length; column++){
                map[row][column]="empty";
            }
        }   
    }

    /**
     * ritorna il colore di
     * coordinate x,y nella griglia
     * @param row riga della griglia
     * @param column colonna della griglia
     * @return il colore
     */
    public static String getColour(int row, int column){
        return map[row][column];
    }

    /**
     * Metodo che aggiunge una pedina
     * del colore del giocatore tramite
     * il metodo addPedina della classe Player
     * @param column colonna della pedina
     * @param colour colore della pedina
     */
    public static void addColour( int column, String colour){
        //variabile che indica la riga di partenza
        int row = 5;
        //ciclo while che esegue un controllo sulla presenza di altre pedina nella stessa coordinata
        while(map[row][column]=="blue " || map[row][column]==" red "){
            //se presenti la colonna rimane invariata e viene decrementata di uno la riga
            row=row-1;
        }
        map[row][column]= colour;
    }


    /**
     * Metodo usato per ricreare la mappa
     * dalla Stringa matrix ricavata dal file
     * di salvataggio Game_Saved.txt alla line 3
     * @param row indica la riga del colore
     * @param column indica la colonna del colore
     * @param colour indica che colore è
     */
    public static void restoreColours(int row, int column, String colour){
        map[row][column]=colour;
    }

    /**
     * Stampa a video la matrice
     * della mappa
     */
    public static void showMatrix(){
        for(int row = 0; row<map.length; row++){
            for(int column = 0; column<map[row].length; column++){
                System.out.print(map[row][column]+" " + "| ");
            }
            System.out.println();
        }
    }
    /**
     * ritorna il numero delle righe della mappa
     * @return intero delle righe della mappa
     */
    public static int getMapLenght(){
        return map.length;
    }

    /**
     * ritorna il numedo di colonne della mappa
     * @param row riga usata per il calcolo
     * @return intero del numedo delle colonne
     */
    public static int getMapHeight(int row){
        return map[row].length;
    }

    

    



}



    

    



