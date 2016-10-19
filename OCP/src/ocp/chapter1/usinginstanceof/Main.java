package ocp.chapter1.usinginstanceof;



public class Main {

    public static void main(String[] args) {
        HeavyAnimal hippo = new Hippo();

        // First part of instanceof
        System.out.println(hippo instanceof Hippo);
        System.out.println(hippo instanceof HeavyAnimal);
        System.out.println(hippo instanceof Elephant);

        // Second part of instanceof
        System.out.println(hippo instanceof Object);

        Hippo nullHipo = null;
        System.out.println(nullHipo instanceof Object);

        Hippo anotherHippo = new Hippo();
       // System.out.println(anotherHippo instanceof Elephant);

        System.out.println(hippo instanceof Mother);
    }
}
