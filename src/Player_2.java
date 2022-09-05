public class Player_2 {

    private String name;
    private String colour;
    private static boolean active;

    public Player_2(String aName) {
        name = aName;
        colour = "red";
        active = false;

    }

    public void addPedina(int row, int column) {
        if (Mappa.getColour(row, column)=="red" || Mappa.getColour(row, column)== "blue"){
            System.out.println("E' già presente una pedina");
        }
        else{
            Mappa.addColour(row, column, Player_2.this.colour);
        }
    }

    public String getName(){
        return name;
    }

    public String getColour(){
        return colour;
    }

    public static boolean getActive(){
        return active;
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
