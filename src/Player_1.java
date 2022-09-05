public class Player_1 {

    private String name;
    private static String colour;
    private static boolean active;

    public Player_1(String aName){
        name = aName;
        colour = "blue";
        active = true;    
    }

    public static void addPedina(int row, int column){
        if (Mappa.getColour(row, column)=="red" || Mappa.getColour(row, column)== "blue"){
            System.out.println("E' già presente una pedina");
        }
        else{
            Mappa.addColour(row, column, colour);
        }
    }

    public String getName(){
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
