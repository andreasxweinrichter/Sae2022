package at.ac.fhw.sae.lesson3;

public abstract class Animal {
    protected static final String DEFAULT_ID = "0";
    protected String name;

//    public Animal(String name){
//        this.name = name;
//    }

    public abstract String getId();
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
