package deleted;

import java.util.Arrays;

public class LongestCommonPrefix
{
    public static void main(String[] args) {
        String[] input ={"flower","flow","flight"};

        String prefix=input[0];
        for (int right=1;right<input.length;right++)
        {
            while (input[right].indexOf(prefix)!=0)
            {
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }

        System.out.println(prefix);


        // stream api

    String result=Arrays.stream(input).reduce((s1,s2)->{
            int i=0;
            int length=Math.min(s1.length(),s2.length());
            while (i<length  && s1.charAt(i) == s2.charAt(i))
            {
                i++;
            }

            return s1.substring(0,i);
        }).orElse("no Sub string found");

        System.err.println("Stream api result\t"+result);
    }
}
