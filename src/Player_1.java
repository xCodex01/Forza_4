public class Player_1 {

    private String name;
    private String colour;

    public Player_1(String aName){
        name = aName;
        colour = "blue";    
    }

    public void addPedina(int row, int column){
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

    public String color(){
        return colour;
    }



    
    
}
