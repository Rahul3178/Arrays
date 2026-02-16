package deleted;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String input= "pwwkew";

        int max=0;
        String longestSubstring="";

        // Sliding window

        int left=0;
        Set<Character> seen = new HashSet<>();
        for (int right=0;right<input.length();right++)
        {
            while (seen.contains(input.charAt(right)))
            {
                seen.remove(input.charAt(left));
                left++;
            }
            seen.add(input.charAt(right));

            if(right-left+1>max)
            {
                max=right-left+1;
                longestSubstring=input.substring(left,right+1);
            }
        }

        System.out.println("Longest non reperable string is \t"+longestSubstring);
    }
}
