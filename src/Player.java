public class Player {

    
    private static String name;
    private static String colour;
    private static boolean active;

    public Player(String aName, String aColour){
        name = aName;
        colour = aColour;
        active = true;    
    }

    public void addPedina(int row, int column){
        if (Mappa.getColour(row, column)=="red" || Mappa.getColour(row, column)== "blue"){
            System.out.println("E' già presente una pedina");
        }
        else{
            Mappa.addColour(row, column, colour);
        }
    }

    public static String getName(){
        return name;
    }

    public String getColour(){
        return colour;
    }

    public static void changeActive(){
        if(active==false){
            active = true;
        }
        else{
            active = false;
        }
    } 
}
