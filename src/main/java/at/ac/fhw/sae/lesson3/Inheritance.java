package at.ac.fhw.sae.lesson3;

import at.ac.fhw.sae.lesson3.Dog;

import java.util.ArrayList;
import java.util.List;

public class Inheritance {

    public static void main(String[] args){
        Dog niceDog = new Dog("Rex");
        Dog noNameDog = new Dog();
        niceDog.setName("Hugo");

        System.out.println(niceDog.getName());
        System.out.println(noNameDog.getName());

        Cat cat = new Cat();
        System.out.println(cat.getName());
        niceDog.bark();
        System.out.println(niceDog.getCount() + " dogs created");

        List <Animal> list = new ArrayList<>();
        list.add(noNameDog);
        list.add(cat);
        list.add(niceDog);

        list.add(new Dog("Bello"));

//        for(int i = 0; i < list.size();i++){
//            System.out.println(list.get(i).name);
//        }

        for(Animal animal:list){
            System.out.println(animal.name);
            if(animal instanceof Dog){
                ((Dog) animal).bark();
            }
        }

//        System.out.println(list.get(2).name);


    }
}
