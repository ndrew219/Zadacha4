package home.ndrew4;


import org.junit.Test;

import static home.ndrew4.Solution.ERROR_CODE_PROCESSING_STRING;
import static org.junit.Assert.assertEquals;

/**
 * Created by Андрей on 03.06.2017.
 * update 04.06.2017
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
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution(" "));
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution("1"));
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution("1+"));
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution("1*"));
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution("12++"));
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution("12+*"));
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution("123$"));
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution("123-"));
        String str = new String();
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution(str));

    }

    @Test
    public void testValueIn12BitRange(){
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution("99999***"));
    }

    @Test
    public void testTooLongString(){
        String string2;
        StringBuilder string1 = new StringBuilder("");
        for (int i = 0; i < 199999; i++) {
            string1.append("1");
        }
        string2 = string1.toString(); //проверяем 199 999
        assertEquals(1, solution.solution(string2));

        string1.append("1"); //добиваем до 200к
        string2=string1.toString();
        assertEquals(ERROR_CODE_PROCESSING_STRING, solution.solution(string2));
    }


}