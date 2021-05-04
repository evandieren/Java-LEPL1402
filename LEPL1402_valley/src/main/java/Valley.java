import java.util.Arrays;

public class Valley{

    public static void main(String[] args) {
        int[] example = new int[]{1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1};
        int[] result = Valley.valley(example);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Compute the deepest valley and highest mountain
     *
     * @param slope A non-empty array of slope
     * @return An array of two element. The first is the
     *         depth of the deepest valley and the second
     *         the height of the highest mountain
     */
    public static int[] valley (int[] slopes){
        int currentMoutain = 0; int bestMoutain = 0; int currentValley = 0; int bestValley = 0;
        boolean up = true;

        if (slopes[0] == -1){up = false;}

        for (int i = 0; i < slopes.length; i++) {

            if (slopes[i] > 0 && up){
                currentMoutain++;
            }else if(up && slopes[i] < 0){
                up = false;
                currentValley = 1;
            }else if(!up && slopes[i] < 0){
                currentValley++;
            }else{
                up = true;
                currentMoutain = 1;
            }

            int minCurrent = Math.min(currentMoutain,currentValley);
            if (bestValley < minCurrent && up){
                bestValley = minCurrent;
            }else if (bestMoutain < minCurrent && !up){
                bestMoutain = minCurrent;
            }
        }
        return new int[] {bestValley,bestMoutain};
    }
}
