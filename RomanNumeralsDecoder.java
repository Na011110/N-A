import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumeralsDecoder {

    private static final Map<Character, Integer> romanNumberMap = new HashMap<>();

    static {
        romanNumberMap.put('I', 1);
        romanNumberMap.put('V', 5);
        romanNumberMap.put('X', 10);
        romanNumberMap.put('L', 50);
        romanNumberMap.put('C', 100);
        romanNumberMap.put('D', 500);
        romanNumberMap.put('M', 1000);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().toUpperCase().trim();

        if (!isValidRoman(inputString)) {
            System.out.println("Invalid Roman numeral input.");
            return;
        }

        int result = 0;

        for (int i = 0; i < inputString.length(); i++) {
            int current = romanNumberMap.get(inputString.charAt(i));
            int next = (i < inputString.length() - 1) ? romanNumberMap.get(inputString.charAt(i + 1)) : 0;

            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }

        System.out.println(result);
    }

    private static boolean isValidRoman(String s) {
        for (char c : s.toCharArray()) {
            if (!romanNumberMap.containsKey(c)) {
                return false;
            }
        }
        return true;
    }
}
