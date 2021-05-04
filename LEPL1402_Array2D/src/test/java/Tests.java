import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class Tests {

    @Test
    public void testBuildFrom() {
        int [][] matrix = {
            {1, 2, 3},
            {10, 11}
        };
        String repr = "1 2 3\n10 11";
        assertEquals(matrix, Matrix.buildFrom(repr));
    }

    @Test
    public void testSum() {
        int [][] matrix = {
            {1, 2, 3},
            {10, 11}
        };
        assertEquals(27, Matrix.sum(matrix));
    }

    @Test
    public void testTranspose() {
        int [][] matrix = {
            {1, 2, 3},
            {10, 11}
        };
        int [][] transposed = {
            {1, 10},
           {2, 11},
            {3}
        };
        assertArrayEquals(transposed, Matrix.transpose(matrix));
    }

    @Test
    public void testProduct() {
        int [][] matrix = {
            {1, 2, 3},
            {10, 11, 12}
        };
        int [][] mult = {
            {4, 13},
            {5, 14},
            {6, 15}
        };

        int [][] product = {
            {32, 86},
            {167, 464}
        };
        assertArrayEquals(product, Matrix.product(matrix,mult));
    }
}
