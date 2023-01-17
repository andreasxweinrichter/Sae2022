package at.ac.fhw.sae.homework3;

public class Chicken extends Animal{
    private static final String CLASS_DESCRIPTION = "This is a chicken class";
    private static int count = 0;
    public Chicken(String name){
        this.name = name;
        this.id = "C" + ++count;
    }

    public String getId() {
        return id;
    }

    public static int getCount(){
        return count;
    }

}
