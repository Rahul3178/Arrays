package deleted;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String input="pwwkee";

        Set<Character> seen = new HashSet<>();
        int left=0;

        int maxLength=0;
        String longestSubString="";

        for (int right = 0; right < input.length(); right++) {
            char ch=input.charAt(right);
            while (seen.contains(ch)){
                seen.remove(input.charAt(left));
                left++;
            }

            seen.add(input.charAt(right));

            if (right-left+1>maxLength)
            {
                maxLength=right-left+1;
                longestSubString=input.substring(left,right+1);
            }
        }
        System.out.println("longest common substring without repeating characters is \t"+longestSubString+"" +
                           "\t with length is \t"+maxLength);


    String val=    IntStream.range(0,input.length()).mapToObj(start->{
            Set<Character> see = new HashSet<>();
            StringBuilder sb= new StringBuilder();
            for (int i=start;i<input.length();i++)
            {
                if (see.contains(input.charAt(i)))
                {
                    break;
                }
                see.add(input.charAt(i));
                sb.append(input.charAt(i));
            }

            return sb.toString();
        }).max(Comparator.comparing(String::length)).get();

        System.out.println(val);
    }
}
