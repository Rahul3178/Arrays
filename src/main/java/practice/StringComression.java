package practice;
import java.lang.String;

public class StringComression
{
    /**
     * StringCompression
     *
     * This class demonstrates a simple string compression algorithm.
     * Consecutive repeating characters in the input string are replaced
     * by a single character followed by the count of repetitions.
     *
     * Example:
     * Input:  "aaabbc"
     * Output: "a3b2c"
     *
     * The approach is straightforward:
     * - Traverse the string character by character.
     * - Keep a counter for consecutive repeating characters.
     * - Append the character and its count (if >1) to the result.
     * - Reset the count when a new character is encountered.
     */

    public static void main(String[] args) {
        String input = "aaabbc";
        System.out.println("Original: " + input);
        System.out.println("Compressed: " + compress(input));
    }

    public static String compress(String input)
    {
        StringBuilder sb = new StringBuilder();
        int count=1;
        // If current character is same as previous, increment count
        for (int i = 1; i <= input.length(); i++) {
            if (i<input.length() && input.charAt(i)==input.charAt(i-1))
            {
                count++;
            }else {
                // append that previous character and count
                sb.append(input.charAt(i-1));
                sb.append(count);
                count=1; // reset the counter

            }
        }

        return sb.toString();
    }
}
