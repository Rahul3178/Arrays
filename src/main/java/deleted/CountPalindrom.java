package deleted;

import java.util.Arrays;

public class CountPalindrom
{
    public static void main(String[] args) {
        String input = "madam racecar apple level noon civic";

      long count= Arrays.stream(input.split("\\s+")).filter(CountPalindrom::isPalindrom).count();

        System.err.println(count);

    }

    private static boolean isPalindrom(String word)
    {
        int i=0, j=word.length()-1;
        while (i<j)
        {
            if (word.charAt(i)!=word.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
