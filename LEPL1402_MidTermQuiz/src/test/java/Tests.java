
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


public class Tests {
    @Test
    public void testExample(){
        LinkedList l = new LinkedList(new int[]{7, 8, 8, 22, 102, -1,90,12});
        Sorter.sort(l);
        assertTrue(l.isSorted());
    }
}
