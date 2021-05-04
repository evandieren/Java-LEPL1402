public class Fibonacci {
    public static void main (String args[])
    {
        int n = 9;
        int b = fiboRecursive(n);
        System.out.println(b);
        
    }


    public static int fiboRecursive(int index){
        if (index <= 1){
            return index;
        }
        return fiboRecursive(index-1) + fiboRecursive(index-2);

    }


    public static int fiboIterative(int index){
        if (index <= 1){
            return index;
        }
        int f0 = 0;
        int f1 = 1;
        int f2 = 0;
        for (int i = 2; i <= index;i++){
            f2 = f1 + f0;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }
}
