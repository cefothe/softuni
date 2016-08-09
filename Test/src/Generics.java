import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * Created by stefanangelov on 8/1/16.
 */
public class Generics {

    public static <T extends Number> void printArray(List<T> inputArray){
        // Display array elements
        for ( T element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static <T extends Number> List<T> createList(T item, int count) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(item);
        }

        return list;
    }

    public static void main(String[] args) {

    }
}
