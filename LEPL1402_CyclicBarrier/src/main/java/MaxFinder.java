import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MaxFinder {

    private final int nThreads,length,width,depth;
    private final int[][][] data;
    private final CyclicBarrier barrier;
    private int[] sums;
    private int max;

    /*
     * Worker constructor takes only one parameter int r, which is his associated row number
     * A worker is responsible of the calculation of the sum of each 2D-Array with row == r + nThread * round; with round >= 0
     *
     * Run should compute the sum of a 2D-array and store the result in sums[] then wait for the cyclic barrier to get the result
     * And restart computing nThreads further
     */
    class Worker implements Runnable {
        int row;
        Worker (int row){ // On choppe la ligne à analyser
            this.row = row;
        }

        @Override
        public void run() {
            int r = this.row;
            while (data.length > r ){
                sums[this.row] = 0;
                for (int i = 0; i < data[r].length; i++) {
                    for (int j = 0; j < data[r][i].length; j++) {
                        sums[this.row] += data[row][i][j];
                    }
                }
                try{
                    barrier.await();
                }catch (InterruptedException | BrokenBarrierException e){return;}
                r += nThreads;
            }
        }
    }
	
    
    /*
     *
     * Initialize all the instance variable and start the right amount of Threads
     *
     */

    private MaxFinder(int[][][] matrix, int nThreads) throws InterruptedException{
        
        this.nThreads = nThreads;
        this.barrier = new CyclicBarrier(nThreads, () -> {
            for (int i = 0; i < sums.length; i++) {
                this.max = Math.max(this.max,sums[i]);
            }
        });
        this.data = matrix;
        this.length = this.data.length;
        this.width = this.data[0].length;
        this.depth = this.data[0][0].length;
        this.sums = new int[nThreads];

        Thread[] threads = new Thread[nThreads];
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new Thread(new Worker(i));
            threads[i].start();
        }

        // wait until done
        for (Thread thread : threads)
            thread.join();
    }
    /*
    * subSize is the length of the subarray
    * rowSize is the rowlength for all the array
    *
    */
    public static int getMaxSum(int[][][] matrix, int nThreads){
        try{
            MaxFinder mf = new MaxFinder(matrix, nThreads);
            return mf.max;
        }catch(InterruptedException e){
            return -1;
        }

    }
}
