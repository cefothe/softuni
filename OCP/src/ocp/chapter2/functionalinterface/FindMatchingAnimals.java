package ocp.chapter2.functionalinterface;

/**
 * Created by stefanangelov on 11/1/16.
 */
public class FindMatchingAnimals {
    private static void print(Animal animal, Animal.CheckTrait trait){
        if(trait.test(animal)){
            System.out.println(animal);
        }
    }

    public static void main(String[] args) {
        print(new Animal("Stefan",false,false), a-> a.isCanHop());
    }
}

