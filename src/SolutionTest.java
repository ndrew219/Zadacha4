
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Андрей on 03.06.2017.
 */
public class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void testExpectedValues(){
        assertEquals(3, solution.solution("12+"));
        assertEquals(5, solution.solution("123+"));
        assertEquals(35, solution.solution("5561+*"));
        assertEquals(5, solution.solution("12*5"));

    }

    @Test
    public void testInvalidString(){
        assertEquals(-1, solution.solution(" "));
        assertEquals(-1, solution.solution("1"));
        assertEquals(-1, solution.solution("1+"));
        assertEquals(-1, solution.solution("1*"));
        assertEquals(-1, solution.solution("12++"));
        assertEquals(-1, solution.solution("12+*"));
        assertEquals(-1, solution.solution("123$"));
        assertEquals(-1, solution.solution("123-"));
        String str = new String();
        assertEquals(-1, solution.solution(str));

    }

    @Test
    public void testTooLongString(){
        String string1 = "1";
        for (int i=0; i < 200000; i++) {
            string1 = string1 + "1";
        }
        assertEquals(-1, solution.solution(string1));


    }


}