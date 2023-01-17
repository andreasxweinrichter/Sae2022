package at.ac.fhw.sae.homework3;

public class Cow extends Animal{
    private static final String CLASS_DESCRIPTION = "This is a cow class";
    private static int count = 0;
    public Cow(String name){
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
