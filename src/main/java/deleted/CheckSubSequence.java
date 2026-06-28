package deleted;

import java.util.stream.IntStream;

public class CheckSubSequence
{
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "axbycz";

        int i=0;
        int j=0;

        while(j<s2.length())
        {
            if (i<s1.length() && s1.charAt(i)== s2.charAt(j))
            {
                i++;
            }
            j++;
        }

        if (i==s1.length())
        {
            System.out.println("s1 is subsequence of s2");
        }else{
            System.out.println("s1 is not subsequence of s2");

        }


        var max= IntStream.range(0,Math.max(s1.length(),s2.length())).reduce(0,(l,m)->{

            if (l<Math.min(s1.length(),s2.length()) && s1.charAt(l) == s2.charAt(m)){
                return l+1;
            }
            return l;
        });
        if (max == Math.min(s1.length(),s2.length()))
        {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
