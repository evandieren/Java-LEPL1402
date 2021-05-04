public class FListMerge {

    /*
     * This method receives an FList and returns a new FList containing the same values but sorted in ascending order.
     *
     */

    public static void main(String[] args) {
        FList<Integer> fl = FList.nil(); //[700,145,253,592,329,133,249,199]
        fl = fl.cons(199);
        fl = fl.cons(249);
        fl = fl.cons(133);
        fl = fl.cons(329);
        fl = fl.cons(592);
        fl = fl.cons(253);
        fl = fl.cons(145);
        fl = fl.cons(700);

        int n = fl.length();

        FList<Integer> result = mergeSort(fl);

        for (int i = 0; i < n-1; i++) {
            System.out.println(result.head());
            result = result.tail();
        }

    }

    public static FList<Integer> mergeSort(FList<Integer> fList){
        int n = fList.length();
        if (n <= 1){return fList;}
        else{
            FList<Integer> firstHalf = FList.nil();
            for(int i = 0; i < n/2; ++i) {
                firstHalf = firstHalf.cons(fList.head());
                fList = fList.tail();
            }
            FList<Integer> firstHalfOne = FList.nil();
            for(int i = 0; i < n/2; ++i) {
                firstHalfOne = firstHalfOne.cons(firstHalf.head());
                firstHalf = firstHalf.tail();
            }
            return merge(mergeSort(firstHalfOne),mergeSort(fList));
        }
    }

    private static FList<Integer> merge(FList<Integer> first, FList<Integer> second) {
        FList<Integer> output = FList.nil();

        while (first.isNotEmpty() && second.isNotEmpty()){
            if (first.head() < second.head()){output = output.cons(first.head());first=first.tail();}
            else {output = output.cons(second.head());second=second.tail();}
        }
        while (second.isNotEmpty()){output = output.cons(second.head());second = second.tail();}
        while (first.isNotEmpty()){output = output.cons(first.head());first = first.tail();}
        FList<Integer> finalOutput = FList.nil();
        while (output.isNotEmpty()){
            finalOutput = finalOutput.cons(output.head());
            output = output.tail();
        }
        return finalOutput;
    }
}