package at.ac.fhw.sae.lesson3;

public class Dog extends Animal {

    private static final String CLASS_DESCRIPTION= "This is a dog-class";
    private static final String DEFAULT_DOG_NAME = "default dog name";

    private static int count = 0;
    private String id;

    /**
     * parameterless Constructor
     */
    public Dog(){
        this.name = DEFAULT_DOG_NAME;
        this.id = "D" + ++count;
    }

    /**
     *
     * @param name the name of the dog
     */
    public Dog(String name){
        this.name = name;
        this.id = "D" + ++count;
    }

    public String getId() {
        return id;
    }

    public void bark(){
        System.out.println("Wuff");
    }

    public static int getCount(){
        return count;
    }


}
