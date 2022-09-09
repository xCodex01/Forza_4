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
     * @param row riga della pedina
     * @param column colonna della pedina
     * @param colour colore della pedina
     */
    public static void addColour(int row, int column, String colour){
        map[row][column] = colour;
    }

    /**
     * Resetta la mappa del gioco
     */
     
    public void resetGame(){
        for (int i = 0; i<map.length; i++){
            for (int j = 0; j<map[i].length; j++){
                map[i][j]="empty";
            }
        }
    }

    /**
     * Stampa a video la matrice
     * della mappa
     */
    public static void showMatrix(){
        for(int row = 0; row<map.length; row++){
            for(int column = 0; column<map[row].length; column++){
                if(column == 0){
                    if(column<map[row].length-1){
                        System.out.print(map[row][column]+"|"+" ");
                    }
                    if(column==map[row].length-1){
                        System.out.print(map[row][column]+"|"+"\n");
                    }
            
                }
            }
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



    

    



