import java.util.Arrays;

public class MergeSort {


    /**
     * Pre-conditions: a[lo..mid] and a[mid+1..hi] are sorted
     * Post-conditions: a[lo..hi] is sorted  [a,b,c,d,e,f] -- lo = 0 (b) - mid = 2 (c) - hi = 5 (f)
     */
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        int[] A = new int[mid + 1 - lo]; // Premier array
        int[] B = new int[hi - mid]; // Deuxième array
        // Remplissage des deux arrays
        for (int i = 0; i < A.length; i++) {
            A[i] = a[lo+i];
        }
        for (int i = 0; i < B.length; i++) {
            B[i] = a[mid + 1 + i];
        }

        int indA = 0; int indB = 0; int inda = 0;

        while ((indA != A.length) || (indB != B.length)){

            if ((indB == B.length) || ((indA != A.length) && A[indA] < B[indB])){
                a[lo+inda] = A[indA];
                indA++;
            }else{
                a[lo+inda] = B[indB];
            }
            inda++;
        }




    }

    /**
     * Rearranges the array in ascending order, using the natural order
     */
    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        int lastSize = 0;
        for (int size = 2; size <= a.length; size = 2*size){
            for (int lo = 0; lo < a.length; lo += size){
                int hi = Math.min(lo+size-1,a.length - 1);
                int mid = Math.min(lo + (size/2) - 1,a.length-1);
                merge(a,aux,lo,mid,hi);
                lastSize = size;
            }
        }
        merge(a,aux,0, lastSize - 1,a.length-1); // Dernier merge pour finaliser

    }

}

