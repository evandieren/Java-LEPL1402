public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */

    public static void main(String[] args) {
        transpose(buildFrom("0 1 \n2 3 "));
    }

    public static int[][] buildFrom(String s) {
        String [] rows = s.split("\n");
        int [] [] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String [] splitted = rows[i].split(" ");
            int[] newelement = new int[splitted.length];
            for (int j = 0; j < splitted.length; j++){
                newelement[j] = Integer.parseInt(splitted[j]);
            }
            matrix[i] = newelement;
        }
        return matrix;
    }

    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result += matrix[i][j];
            }
        }
        return result;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int c = 0;
        for (int i = 0; i < matrix.length; i++) {
            c = Math.max(c,matrix[i].length);
        }
        int[][] transposed = new int[c][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }

        }
        return transposed;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                int c = 0;
                for (int k = 0; k < matrix1[i].length; k++) {
                    c += matrix1[i][k]*matrix2[k][j];
                }
                result[i][j] = c;
            }
        }
        return result;
    }


}
