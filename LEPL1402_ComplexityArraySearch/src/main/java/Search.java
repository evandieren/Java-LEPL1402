
public class Search {

    /**
     *
     * @param tab is an ordered array of int.
     * @return index of elem or -1
     */
    public static int search(int[] tab, int elem){
        int low = 0;
        int high = tab.length-1;
        while (low <= high){
            int mid = low + (high-low)/2;
            int midVal = tab[mid];
            if (midVal < elem){
                low = mid+1;
            }
            else if (midVal > elem){
                high = mid-1;
            }else{
                return mid;
            }

        }
        return -1;
    }
}
