import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;

// TODO: Replace examples and use TDD development by writing your own tests

public class SolutionTest {
    
    @Test
    public void sampleTests() {
        
        List<Integer> arr1 = Arrays.asList(7,9,6,10,5,11,10,12,13,4,2,5,1,6,4,8),
                      exp1 = Arrays.asList(7,9,6,10,5,11,10,12),
                      
                      arr2 = Arrays.asList(7,7,7,7,7),
                      exp2 = Arrays.asList(7),
                      
                      arr3 = Arrays.asList(1,2,3,4,5,6),
                      exp3 = Arrays.asList(1,2);
                      
        assertEquals(exp1, Bouncy.longestBouncyList(arr1));
        assertEquals(exp2, Bouncy.longestBouncyList(arr2));
        assertEquals(exp3, Bouncy.longestBouncyList(arr3));
    }
}
