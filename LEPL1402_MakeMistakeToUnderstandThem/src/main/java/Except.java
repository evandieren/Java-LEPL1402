
import java.util.ArrayList;
import java.util.List;

public class Except{

    public static void main(String[] args) {
    outof();
    }
    public static void outof(){
        int[] a = {4,5,6};
        System.out.println(a[4]);
    }
    
    public static void concurr(){
        String[] myArrayList = {"Bruxelles","LLN","Anvers"};
        for (String str : myArrayList) {
            continue;
        }
    }
    
    public static void nullpointer(){
        Object empty = new Object();
        System.out.println(empty.toString());
    }
    
    
    
}