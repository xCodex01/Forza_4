import java.io.File;

public class Mappa{

    private static String[][] map;
    
    public Mappa() {
        map = new String[6][7];
        for (int i = 0; i<6; i++){
            for (int j = 0; i<7; j++){
                map[i][j]="empty";
            }
        }   
    }

    public Mappa(int row, int column){
        map = new String[row][column];
        for (int i = 0; i<map.length; i++){
            for (int j = 0; j<map[i].length; j++){
                map[i][j]="empty";
            }
        } 
    }

    public static String getColour(int row, int column){
        return map[row][column];
    }

    public static void addColour(int row, int column, String colour){
        map[row][column] = colour;
    }

    public void resetGame(){
        for (int i = 0; i<map.length; i++){
            for (int j = 0; j<map[i].length; j++){
                map[i][j]="empty";
            }
        }
    }

    public static void showMatrix(){
        System.out.println(map);
    }

    public static int getMapLenght(){
        return map.length;
    }

    public static int getMapHeight(int column){
        return map[column].length;
    }

    public static void saveGame(){

        File GameSaved = new File("Game_Saved.txt");
        

    }



}



    

    



