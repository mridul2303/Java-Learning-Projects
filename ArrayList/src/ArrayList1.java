import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ArrayList1 {
    public static void main(String[] args) {
        //we store objects in arraylist
        ArrayList<Integer> list = new ArrayList<Integer>();

        //add element
        list.add(5);
        list.add(0);
        list.add(4);

        System.out.println(list);

        //getting element of particular index
        int element = list.get(1);
        System.out.println(element);


        //add element in between
list.add(1,1);
        System.out.println(list);

        //set element
        list.set(0,9);
        System.out.println(list);

        //delete element
        list.remove(3);
        System.out.println(list);

        //loops
        for (int i = 0 ; i < list.size() ; i++){
            System.out.println(list.get(i));
        }

        //sorting
        Collections.sort(list);
        System.out.println(list);

     }
}
