import java.util.ArrayList;

/**
 * Created by Андрей on 31.05.2017.
 */
public class Solution {
    final private static int ERROR_CODE_PROCESSING_STRING = -1;
    final private static int MAX_VALUE_OF_12B = 4096;
    final private static int MAX_LENGTH_STRING = 200000;



    public static int solution (String S){
        int lengthS = S.length();

        if  (S == null) {
            return ERROR_CODE_PROCESSING_STRING;
        }
        if (lengthS >= 2 && lengthS < MAX_LENGTH_STRING) {
            ArrayList<Integer> stack = new ArrayList<Integer>();


            for (int i=0; i < lengthS; i++) {
                char symbol = S.charAt(i);
                int lastElement = stack.size()-1;

                if (symbol >= '0' && symbol <= '9'){
                    int numeric = (int)symbol-48;
                    stack.add(numeric);

                } else if (symbol == '+'){
                    if (stack.size() >= 2) {
                        int sum = stack.get(lastElement - 1) + stack.get(lastElement);
                        if (sum < MAX_VALUE_OF_12B) {
                            stack.set(lastElement-1, sum);
                            stack.remove(lastElement);
                        } else {
                          return ERROR_CODE_PROCESSING_STRING;
                        }

                    } else {
                        return ERROR_CODE_PROCESSING_STRING;
                    }
                } else if (symbol == '*'){
                    if (stack.size() >= 2) {
                        int multi = stack.get(lastElement - 1) * stack.get(lastElement);
                        if (multi < MAX_VALUE_OF_12B) {
                            stack.set(lastElement-1, multi);
                            stack.remove(lastElement);
                        } else {
                            return ERROR_CODE_PROCESSING_STRING;
                        }
                    } else {
                        return ERROR_CODE_PROCESSING_STRING;
                    }

                } else {
                    return ERROR_CODE_PROCESSING_STRING;
                }
            }
            return stack.get(stack.size()-1);

        } else {
            return ERROR_CODE_PROCESSING_STRING;
        }


    }
    public static void main(String[] args) {
        String string = "99999999**";
        int result = solution(string);
        switch (result) {
            case ERROR_CODE_PROCESSING_STRING:
                System.out.println("Во время обработки заданной строки произошла ошибка. Проверьте строку!");
                break;
             default:
                    System.out.println("Результат - " + result);
        }
    }
}
