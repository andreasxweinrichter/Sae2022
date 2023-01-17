package at.ac.fhw.sae.homework3;

public class Pig extends Animal{
    private static final String CLASS_DESCRIPTION = "This is a pig class";
    private static int count = 0;
    public Pig(String name){
        this.name = name;
        this.id = "P" + ++count;
    }

    public String getId() {
        return id;
    }

    public static int getCount(){
        return count;
    }

}
