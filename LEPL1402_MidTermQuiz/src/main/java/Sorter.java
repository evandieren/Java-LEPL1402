public class Sorter {
    public static void main(String[] args) {
        LinkedList l = new LinkedList(new int[]{7, 8, 8, 22, 102, -1,90,12});
        sort(l);
        System.out.println(l);
    }
    /**
    * Sorts a list in increasing order
    *
    * We expect this function to behave in O(n^2), where n is the size of the list. 
    * Precisely, we expect that you make at MOST n^2 calls to list.pop() and at 
    * MOST n^2 calls to list.swap(). 
    * 
    * You will obtain the full score for a test case if
    *
    * - The list is sorted (2/4 points per test case)
    * - The list is sorted AND you make less than n^2 calls to swap (1/4 points)
    * - The list is sorted AND you make less than n^2 calls to pop (1/4 points)
    *
    * @param list: a list of integers to be sorted.
    */
    public static void sort(LinkedList list) {
        // Here is a small loop with an invariant that you should try to respect
        // although it's not mandatory. Try to respect it, it will help you ;-)

        for(int iter = 0; iter < list.getSize() - 1; iter++) {
            //invariant: the 'iter' biggest elements are at the end of the list and are sorted.
            //example, at iteration iter=3, the three lasts elements are the three biggest elements in the list, and
            //they are in the increasing order.
            // [4 1 9 10 11 13] at iter 3
            for(int k = 0; k < list.getSize() - 1; k++){
                if (list.getFirst() >= list.getSecond()){
                    list.swap();
                }
                list.pop();
            }
            list.pop();

        }
        System.out.println(list.getnPops());
        System.out.println(list.getnSwaps());

        // here, if you followed the invariant proposed above, the list should be sorted!
    }
}
