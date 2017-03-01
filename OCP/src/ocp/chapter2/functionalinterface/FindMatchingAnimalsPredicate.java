package ocp.chapter2.functionalinterface;

import java.util.function.Predicate;

/**
 * Created by stefanangelov on 11/1/16.
 */
public class FindMatchingAnimalsPredicate {

    private static void print(Animal animal, Predicate<Animal> trait){
        if(trait.test(animal)){
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        print(new Animal("fish",false,true),animal -> animal.isCanHop());
        print(new Animal("kangaroo",true,false),animal -> animal.isCanHop());
    }
}
